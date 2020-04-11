package com.example.scifit.Classes.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scifit.Intro.Activity6;
import com.example.scifit.Intro.MainActivity;
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
    private static String TAG = "MainActivity";
    public static final String EXTRA_BODYWEIGHT = "com.example.application.scifit.EXTRA_ BODYWEIGHT";
    public static final String EXTRA_COMPOSITION = "com.example.application.scifit.COMPOSITION";
    public static final String ACTIVITYMULTIPLIER = "ACTIVITYMULTIPLIER";
    public static final String FAT = "FAT";
    public static final String CARBS = "CARBS";
    public static final String PROTEIN = "PROTEIN";
    public static final String SBPROGRESS = "SBPROGRESS";
    public static final String PROSBPROGRESS = "SBPROGRESS";
    public static final String CALSBPROGRESS = "SBPROGRESS";
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    public static final String CALORIES = "calories";
    public static final String INTAKE = "intake";
    public static final String TDEE = "tdee";

    public static final String SHARED_PREFS = "sharedPrefs";
    PieChart piechart;
   private float[] yData = {1,1,1};
    private String[] xData = {"Protein", "Fat" , "Carbs"};
    float bodyweight, composition, activityMultiplier, tdee, fat, carbs, protein, maxFatIntake, fatDistance, fatf, fatscale, minRateLossCals, intake;
    int seekBarPosition, proSeekBarPosition, calSeekBarPosition;
    //Int[]

    public MealPlanFragment() {
        // Required empty public constructor
    }

    public static MealPlanFragment newInstance(String param1, String param2) {
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
        // Inflate the layout for this fragment
        final View v =  inflater.inflate(R.layout.fragment_meal_plan, container, false);
        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        composition = sharedPreferences.getFloat(EXTRA_COMPOSITION, 0);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        activityMultiplier = sharedPreferences.getFloat(ACTIVITYMULTIPLIER, 0);
        bodyweight = sharedPreferences.getFloat(EXTRA_BODYWEIGHT, 0);

        protein = bodyweight;
        protein = sharedPreferences.getFloat(PROTEIN, protein);
        double massd =  bodyweight / 2.20462;
        float mass = (float) massd;
        double lbm = mass - (((composition * mass)/100));
        double bmrDouble = (370+(21.6*lbm));
        double tdeeDouble = bmrDouble*activityMultiplier;
        tdee = (float)tdeeDouble;
        minRateLossCals = sharedPreferences.getFloat(CALORIES, 0);
        if(minRateLossCals > 10000000 || minRateLossCals<-10000000){
            minRateLossCals = 0;
        }
        intake = tdee + minRateLossCals;
        intake = sharedPreferences.getFloat(INTAKE, intake);
        final TextView intaketxt = v.findViewById(R.id.calorieintake);
        intaketxt.setText(Float.toString(intake));



        double fatd = (lbm * 2.20462) * .33;
        fatf = (float) fatd;
        fat = sharedPreferences.getFloat(FAT, fatf);
        float carbsf = (float)(tdee - ((protein * 4)+(fat * 9)))/4;
        carbs = sharedPreferences.getFloat(CARBS, carbsf);
        piechart = v.findViewById(R.id.idPieChart);
        maxFatIntake = (tdee - 200 - (protein *4))/9;
        fatDistance = maxFatIntake -fatf;
        TextView fatloss = (TextView) v.findViewById(R.id.expenditure);
        fatloss.append(Float.toString(tdee));

        piechart.setRotationEnabled(false);
        piechart.setHoleRadius(0f);
        piechart.setTransparentCircleAlpha(0);
        piechart.setCenterTextColor(Color.parseColor("#000000"));
        piechart.setEntryLabelColor(Color.parseColor("#000000"));

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
        SeekBar fatseekBar =  v.findViewById(R.id.seekBar);
        seekBarPosition = sharedPreferences.getInt(SBPROGRESS, 0);
        fatseekBar.setProgress(seekBarPosition);
        fatseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            fatscale = fatDistance/100;
            fat = fatf + (progress * fatscale);
            carbs = (intake - (fat * 9)-(protein*4))/4;
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
               // yData[0] = protein;
               // yData[1] = fat;
               // yData[2] = carbs;
                //addDataSet(protein, fat, carbs);
                //piechart.invalidate();
            }
        });
        SeekBar proteinSeekBar =  v.findViewById(R.id.proteinSeekBar);
        proSeekBarPosition = sharedPreferences.getInt(PROSBPROGRESS, 0);
        proteinSeekBar.setProgress(proSeekBarPosition);
        proteinSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                float minProtein = bodyweight;
                double maxProteinD = bodyweight * 1.15;
                float maxProtein = (float) maxProteinD;
                float proetinDistance = maxProtein-minProtein;
                float proteinScale = proetinDistance/100;
                protein = (proteinScale * progress) + bodyweight;


                carbs = (intake - (fat * 9)-(protein*4))/4;
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
               // yData[0] = protein;
               // yData[1] = fat;
               // yData[2] = carbs;
               // addDataSet(protein, fat, carbs);
               // piechart.invalidate();
            }
        });
        boolean male = sharedPreferences.getBoolean(MALE, false);
        boolean female = sharedPreferences.getBoolean(FEMALE, false);
        SeekBar calSeekBar =  v.findViewById(R.id.calorieSeekBar);
        calSeekBarPosition = sharedPreferences.getInt(CALSBPROGRESS, 0);
        calSeekBar.setProgress(calSeekBarPosition);
        if (male && composition <= 12 || female && composition <= 20){
            calSeekBar.setVisibility(View.INVISIBLE);
            TextView caloriebar = v.findViewById(R.id.tdeetv);
            TextView slowchange = v.findViewById(R.id.slowchange);
            TextView fastchange = v.findViewById(R.id.slowchangetxt);
            caloriebar.setText(R.string.caloriebar);
            slowchange.setVisibility(View.INVISIBLE);
            fastchange.setVisibility(View.INVISIBLE);



        }else {
            calSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    double maxLossRateCalsD = ((bodyweight * .01)*3500)/7;
                    float maxLossRate = (float) maxLossRateCalsD;

                    float deficitRange = maxLossRate - minRateLossCals;
                    float deficitScale = deficitRange/100;
                    float deficit = (progress * deficitScale);
                    intake = tdee-deficit;


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
                    // yData[0] = protein;
                    // yData[1] = fat;
                    // yData[2] = carbs;
                    // addDataSet(protein, fat, carbs);
                    // piechart.invalidate();
                }
            });
        }


        return v;
}
    private void addDataSet(float protein, float fat, float carbs) {
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

        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#BAF833"));
        colors.add(Color.parseColor("#FFA500"));
        colors.add(Color.parseColor("#33BAF8"));
        pieDataSet.setColors(colors);

        Legend legend = piechart.getLegend();
        legend.setEnabled(false);
        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        piechart.setData(pieData);
        piechart.invalidate();
    }
}
