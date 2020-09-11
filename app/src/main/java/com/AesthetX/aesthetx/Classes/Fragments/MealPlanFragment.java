package com.AesthetX.aesthetx.Classes.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.scifit.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Arrays;

import static android.content.Context.MODE_PRIVATE;


public class MealPlanFragment extends Fragment {
    private static final String EXTRA_BODYWEIGHT = "com.example.application.scifit.EXTRA_ BODYWEIGHT";
    private static final String EXTRA_COMPOSITION = "com.example.application.scifit.COMPOSITION";
    private static final String ACTIVITYMULTIPLIER = "ACTIVITYMULTIPLIER";
    private static final String FAT = "FAT";
    private static final String CARBS = "CARBS";
    private static final String PROTEIN = "PROTEIN";
    private static final String SBPROGRESS = "SBPROGRESS";
    private static final String PROSBPROGRESS = "SBPROGRESS";
    private static final String CALSBPROGRESS = "SBPROGRESS";
    private static final String DEFICIT = "DEFICIT";

    private static final String MALE = "male";
    private static final String FEMALE = "female";
    private static final String CALORIES = "calories";
    private static final String INTAKE = "intake";
    public static final String TDEE = "tdee";
    private static final String SHOWADS = "com.example.application.scifit.showads";
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String MAXLOSSRATE = "MAXLOSSRATE";
    private static final String MINLOSSRATE = "MINLOSSRATE";
    private final String[] xData = {"Protein", "Fat", "Carbs"};
    private PieChart piechart;
    private float[] yData = {1, 1, 1};
    private float bodyweight;
    private float tdee;
    private float fat;
    private float carbs;
    private float protein;
    private float maxFatIntake;
    private float fatDistance;
    private float fatf;
    private float fatscale;
    private float minRateLossCals;
    private float intake;
    private int seekBarPosition;
    private int proSeekBarPosition;


    public MealPlanFragment() {
        // Required empty public constructor
    }

    public static MealPlanFragment newInstance() {
        MealPlanFragment fragment = new MealPlanFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment and download data for the math about to go down
        final View v = inflater.inflate(R.layout.fragment_meal_plan, container, false);
        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        float composition = sharedPreferences.getFloat(EXTRA_COMPOSITION, 0);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        float activityMultiplier = sharedPreferences.getFloat(ACTIVITYMULTIPLIER, 0);
        bodyweight = sharedPreferences.getFloat(EXTRA_BODYWEIGHT, 0);
        Boolean showAds = sharedPreferences.getBoolean(SHOWADS, false);

        //Math for the meal plan pie chart
        protein = bodyweight;
        protein = sharedPreferences.getFloat(PROTEIN, protein);
        double massd = bodyweight / 2.20462;
        float mass = (float) massd;
        double lbm = mass - (((composition * mass) / 100));
        double bmrDouble = (370 + (21.6 * lbm));
        double tdeeDouble = bmrDouble * activityMultiplier;
        tdee = (float) tdeeDouble;
        minRateLossCals = sharedPreferences.getFloat(CALORIES, 0);
        if (minRateLossCals > 10000000 || minRateLossCals < -10000000) {
            minRateLossCals = 0;
        }
        intake = tdee + minRateLossCals;
        intake = sharedPreferences.getFloat(INTAKE, intake);
        final TextView intaketxt = v.findViewById(R.id.calorieintake);
        intaketxt.setText(Float.toString(intake));


        double fatd = (lbm * 2.20462) * .33;
        fatf = (float) fatd;
        fat = sharedPreferences.getFloat(FAT, fatf);
        float carbsf = (tdee - ((protein * 4) + (fat * 9))) / 4;
        carbs = sharedPreferences.getFloat(CARBS, carbsf);
        piechart = v.findViewById(R.id.idPieChart);
        maxFatIntake = (tdee - 200 - (protein * 4)) / 9;
        fatDistance = maxFatIntake - fatf;

        //Set value to views: text and chart
        TextView fatloss = v.findViewById(R.id.expenditure);
        fatloss.append(Float.toString(tdee));

        //Chart code
        piechart.setRotationEnabled(false);
        piechart.setHoleRadius(0f);
        piechart.setTransparentCircleAlpha(0);
        piechart.setCenterTextColor(Color.parseColor("#000000"));
        piechart.setEntryLabelColor(Color.parseColor("#000000"));
        piechart.getDrawAngles();

        addDataSet(protein, fat, carbs);
        piechart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                // Toast.makeText(getContext().this, "Employee " + employee + "\n" + "Sales: $" + sales + "K", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        //MEAL SLIDERS
        SeekBar fatseekBar = v.findViewById(R.id.seekBar);
        seekBarPosition = sharedPreferences.getInt(SBPROGRESS, 0);
        fatseekBar.setProgress(seekBarPosition);
        fatseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                fatscale = fatDistance / 100;
                fat = fatf + (progress * fatscale);
                carbs = (intake - (fat * 9) - (protein * 4)) / 4;
                seekBarPosition = progress;
                editor.putInt(SBPROGRESS, seekBarPosition);
                editor.putFloat(FAT, fat);
                editor.putFloat(CARBS, carbs);

                editor.apply();
                addDataSet(protein, fat, carbs);
                piechart.invalidate();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SeekBar proteinSeekBar = v.findViewById(R.id.proteinSeekBar);
        proSeekBarPosition = sharedPreferences.getInt(PROSBPROGRESS, 0);
        proteinSeekBar.setProgress(proSeekBarPosition);
        proteinSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                float minProtein = bodyweight;
                double maxProteinD = bodyweight * 1.15;
                float maxProtein = (float) maxProteinD;
                float proetinDistance = maxProtein - minProtein;
                float proteinScale = proetinDistance / 100;
                protein = (proteinScale * progress) + bodyweight;


                carbs = (intake - (fat * 9) - (protein * 4)) / 4;
                proSeekBarPosition = progress;
                editor.putInt(PROSBPROGRESS, proSeekBarPosition);
                editor.putFloat(FAT, fat);
                editor.putFloat(CARBS, carbs);
                editor.putFloat(PROTEIN, protein);

                editor.apply();
                addDataSet(protein, fat, carbs);
                piechart.invalidate();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        boolean male = sharedPreferences.getBoolean(MALE, false);
        boolean female = sharedPreferences.getBoolean(FEMALE, false);

        //CALORIES
        SeekBar calSeekBar = v.findViewById(R.id.calorieSeekBar);
        int calSeekBarPosition = sharedPreferences.getInt(CALSBPROGRESS, 0);
        calSeekBar.setProgress(calSeekBarPosition);
        if (male && composition <= 12 || female && composition <= 20) {
            calSeekBar.setVisibility(View.INVISIBLE);
            TextView caloriebar = v.findViewById(R.id.tdeetv);
            TextView slowchange = v.findViewById(R.id.slowchange);
            TextView fastchange = v.findViewById(R.id.slowchangetxt);
            caloriebar.setText(R.string.caloriebar);
            slowchange.setVisibility(View.INVISIBLE);
            fastchange.setVisibility(View.INVISIBLE);


        } else {
            calSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    double maxLossRateCalsD = ((bodyweight * .01) * 3500) / 7;
                    float maxLossRate = (float) maxLossRateCalsD;

                    //Data storage for fatloss chart
                    editor.putFloat(MAXLOSSRATE, maxLossRate);
                    editor.putFloat(MINLOSSRATE, minRateLossCals);

                                                                                                                                    
                    float deficitRange = maxLossRate - minRateLossCals;
                    float deficitScale = deficitRange / 100;
                    float deficit = (progress * deficitScale);
                    float deficit7 = deficit / 7;
                    editor.putFloat(DEFICIT, deficit7);

                    intake = tdee - deficit;


                    maxFatIntake = (intake - 200 - (protein * 4)) / 9;
                    fatDistance = maxFatIntake - fatf;
                    fatscale = fatDistance / 100;
                    fat = fatf;
                    carbs = (intake - (fat * 9)) / 4;
                    proSeekBarPosition = progress;
                    editor.putInt(CALSBPROGRESS, proSeekBarPosition);
                    editor.putFloat(FAT, fat);
                    editor.putFloat(CARBS, carbs);
                    editor.putFloat(INTAKE, intake);

                    editor.apply();
                    addDataSet(protein, fat, carbs);
                    piechart.invalidate();
                    intaketxt.setText(Float.toString(intake));


                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }

        ImageView cronometer = v.findViewById(R.id.cronometer);
        cronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.cronometer.com"));
                getActivity().startActivity(i);
            }
        });

 //BUTTON to learn nutrition

        Button learnNutrition = v.findViewById((R.id.learnNutrition));
        learnNutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.youtube.com/watch?v=wxzc_2c6GMg&list=PLdsCUIkYpuc6mPZwCQv-AaNjEg3YXCxL7"));
                getActivity().startActivity(i);
            }
        });



        return v;
    }



    private void addDataSet(float protein, float fat, float carbs) {
        String TAG = "MainActivity";
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(protein, "Protein"));
        entries.add(new PieEntry(carbs, "Carbs"));
        entries.add(new PieEntry(fat, "Fat"));

        ArrayList<String> xEntrys = new ArrayList<>(Arrays.asList(xData).subList(1, xData.length));

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(entries, "Macros");
        pieDataSet.setSliceSpace(0);
        pieDataSet.setValueTextSize(12);
        pieDataSet.setValueLineColor(Color.parseColor("#F5F5F5"));
        pieDataSet.setUsingSliceColorAsValueLineColor(true);

        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#BAF833"));
        colors.add(Color.parseColor("#33BAF8"));
        colors.add(Color.parseColor("#ffbf00"));
        pieDataSet.setColors(colors);

        Legend legend = piechart.getLegend();
        legend.setEnabled(false);
        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        piechart.setData(pieData);
        piechart.invalidate();
    }
}
