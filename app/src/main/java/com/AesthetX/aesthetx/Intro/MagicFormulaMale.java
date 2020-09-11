package com.AesthetX.aesthetx.Intro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

import java.text.DecimalFormat;

import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;

public class MagicFormulaMale extends AppCompatActivity {

    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String IDEAL_BODYWEIGHT = "ideal bodyweight";
    private static final String FATLOSS = "fatloss";
    private static final String CURRENT_GROWTH = "current growth";
    private static final String POTENTIAL_GROWTH = "potential growth";
    private static final String GROWTH_RATE = "growth rate";
    private static final String CALORIES = "calories";
    private static final String PMG = "muscle";
    private static final String MALE = "male";
    private static final String EXTRA_BODYWEIGHT = "com.example.application.scifit.EXTRA_ BODYWEIGHT";
    private static final String EXTRA_HEIGHT_FEET = "com.example.application.scifit.EXTRA_ FEET";
    private static final String EXTRA_HEIGHT_INCHES = "com.example.application.scifit.EXTRA_ INCHES";
    private static final String EXTRA_COMPOSITION = "com.example.application.scifit.COMPOSITION";
    private static final String EXTRA_EXPERIENCE = "com.example.application.scifit.EXPERIENCE";


    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_formula_male);

        Intent intent = getIntent();

//get data
        /*
        final float bodyweight = intent.getFloatExtra(Activity7.EXTRA_BODYWEIGHT_5, 0);
        final float heightFeet = intent.getFloatExtra(Activity7.EXTRA_HEIGHT_FEET_4, 0);
        final float heightInches = intent.getFloatExtra(Activity7.EXTRA_HEIGHT_INCHES_4, 0);
        final float experience = intent.getFloatExtra(Activity7.EXTRA_EXPERIENCE_3, 0);
        final float composition = intent.getFloatExtra(Activity7.EXTRA_COMPOSITION_2, 0);*/

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final float bodyweight = sharedPreferences.getFloat(EXTRA_BODYWEIGHT, 0);
        final float heightFeet = sharedPreferences.getFloat(EXTRA_HEIGHT_FEET, 0);
        final float heightInches = sharedPreferences.getFloat(EXTRA_HEIGHT_INCHES, 0);
        final float experience = sharedPreferences.getFloat(EXTRA_EXPERIENCE, 0);
        final float composition = sharedPreferences.getFloat(EXTRA_COMPOSITION, 0);

        //This took 4 years of your life fucker make it count

        float currentMuscleGrowth = 0;
        float dailyCaloricDeviance = 0;
        double currentMuscleGrowthD = 0;
        float heightInch = heightInches + (heightFeet * 12);
        double height = (heightInch * 2.54);
        double baseLeanMass = (1930121 + (44.90097 - 1930121) / (1 + (Math.pow(height / 4275.865, 3.168493)))) * .93;
        float muscleGrowthRate = (float) (((3 * (Math.sqrt(37037))) / (200 * (Math.sqrt(experience + 1)))));
        final float totalMuscleGrowth = (float) 40;
        float developedLeanMass = (float) (baseLeanMass + totalMuscleGrowth);
        final float idealBodyWeight = (float) (developedLeanMass * 1.12);
        final float fatLoss = (float) ((bodyweight * (composition * .01)) - (bodyweight * .12));
        float mgConstant = (float) (1 + (experience / 31.72432));
        if (experience == 0) {
            currentMuscleGrowth = 0;
            muscleGrowthRate = (float) 2.2;
        } else if (experience <= 6 && experience > 0) {
            currentMuscleGrowthD = (float) ((69.98 + (-0.00531397 - 67.38605) / Math.pow(mgConstant, 0.8790314))) - 2.2;
            currentMuscleGrowth = (float) currentMuscleGrowthD;
        } else if (experience > 6 && experience < 12) {
            currentMuscleGrowthD = (float) ((69.98 + (-0.00531397 - 67.38605) / Math.pow(mgConstant, 0.8790314))) - 1.1;
            currentMuscleGrowth = (float) currentMuscleGrowthD;
        } else if (experience >= 12) {
            currentMuscleGrowthD = (float) ((69.98 + (-0.00531397 - 67.38605) / Math.pow(mgConstant, 0.8790314)));
            currentMuscleGrowth = (float) currentMuscleGrowthD;
        }
        if (composition == 12) {
            dailyCaloricDeviance = (muscleGrowthRate * 2500) / 31;
        } else {
            dailyCaloricDeviance = ((((idealBodyWeight - bodyweight) / (48 - experience)) * 3500) / 31);

        }
        final float potentialMuscleGrowth = (totalMuscleGrowth - currentMuscleGrowth);


        TextView idealBodyweight = findViewById(R.id.textViewIdealBodyweight);
        idealBodyweight.append(df.format(idealBodyWeight));


        TextView fatloss = findViewById(R.id.textViewFatLoss);
        fatloss.append(df.format(fatLoss));

        TextView currentmusclegrowth = findViewById(R.id.textViewCurrentMuscleGrowth);
        currentmusclegrowth.append(df.format(currentMuscleGrowth));

        final TextView potentialgrowth = findViewById(R.id.textViewPotentialMuscleGrowth);
        potentialgrowth.append(df.format(potentialMuscleGrowth));

        TextView growthrate = findViewById(R.id.textViewMuscleGrowthRate);
        growthrate.append(df.format(muscleGrowthRate));


        final Button dashboardmale = findViewById(R.id.dashboardmale);
        final float finalCurrentMuscleGrowth = currentMuscleGrowth;
        final float finalMuscleGrowthRate = muscleGrowthRate;
        final float finalDailyCaloricDeviance = dailyCaloricDeviance;
        dashboardmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDashboard(idealBodyWeight, fatLoss, finalCurrentMuscleGrowth,
                        potentialMuscleGrowth, finalMuscleGrowthRate, finalDailyCaloricDeviance);
            }

        });
    }

    private void openDashboard(float idealBodyWeight, float fatLoss, float currentMuscleGrowth,
                               float potentialgrowth, float muscleGrowthRate, float dailyCaloricDeviance) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat(PMG, (float) 40.0);
        editor.putFloat(IDEAL_BODYWEIGHT, idealBodyWeight);
        editor.putFloat(FATLOSS, fatLoss);
        editor.putFloat(CURRENT_GROWTH, currentMuscleGrowth);
        editor.putFloat(POTENTIAL_GROWTH, potentialgrowth);
        editor.putFloat(GROWTH_RATE, muscleGrowthRate);
        editor.putFloat(CALORIES, dailyCaloricDeviance);
        editor.putBoolean(MALE, true);
        editor.apply();

        Intent intent = new Intent(this, Dashboards.class);
        startActivity(intent);

    }
}
