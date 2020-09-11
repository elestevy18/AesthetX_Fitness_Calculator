package com.AesthetX.aesthetx.DashBoardTabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;
import com.google.android.gms.ads.InterstitialAd;

import com.AesthetX.aesthetx.Classes.AdManager;

public class UpdateFemaleMagicFormula extends AppCompatActivity {
    public static final String ACTIVITYMULTIPLIER = "ACTIVITYMULTIPLIER";
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String IDEAL_BODYWEIGHT = "ideal bodyweight";
    private static final String FATLOSS = "fatloss";
    private static final String CURRENT_GROWTH = "current growth";
    private static final String POTENTIAL_GROWTH = "potential growth";
    private static final String GROWTH_RATE = "growth rate";
    private static final String CALORIES = "calories";
    private static final String PMG = "muscle";
    private static final String MALE = "male";
    private static final String FEMALE = "female";
    private static final String EXTRA_BODYWEIGHT = "com.example.application.scifit.EXTRA_ BODYWEIGHT";
    private static final String EXTRA_HEIGHT_FEET = "com.example.application.scifit.EXTRA_ FEET";
    private static final String EXTRA_HEIGHT_INCHES = "com.example.application.scifit.EXTRA_ INCHES";
    private static final String EXTRA_COMPOSITION = "com.example.application.scifit.COMPOSITION";
    private static final String EXTRA_EXPERIENCE = "com.example.application.scifit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_female_magic_formula);
        int delay = 500;


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        float bodyweight = sharedPreferences.getFloat(EXTRA_BODYWEIGHT, 0);
        float heightFeet = sharedPreferences.getFloat(EXTRA_HEIGHT_FEET, 0);
        float heightInches = sharedPreferences.getFloat(EXTRA_HEIGHT_INCHES, 0);
        float experience = sharedPreferences.getFloat(EXTRA_EXPERIENCE, 0);
        float composition = sharedPreferences.getFloat(EXTRA_COMPOSITION, 0);
        boolean female = sharedPreferences.getBoolean(FEMALE, false);
        boolean male = false;

        float currentMuscleGrowth = 0;
        float dailyCaloricDeviance = 0;
        double currentMuscleGrowthD = 0;
        float heightInch = heightInches + (heightFeet * 12);
        double height = (heightInch * 2.54);
        double baseLeanMass = (1930121 + (44.90097 - 1930121) / (1 + (Math.pow(height / 4275.865, 3.168493)))) * .93;
        float muscleGrowthRate = (float) (((3 * (Math.sqrt(37037))) / (200 * (Math.sqrt(experience + 1)))) / 2);
        float totalMuscleGrowth = (float) 20;
        float developedLeanMass = (float) (baseLeanMass + totalMuscleGrowth);
        float idealBodyWeight = (float) (developedLeanMass * 1.2);
        float fatLoss = (float) ((bodyweight * (composition * .01)) - (bodyweight * .20));
        float mgConstant = (float) (1 + (experience / 31.72432));
        if (experience == 0) {
            currentMuscleGrowth = 0;
            muscleGrowthRate = (float) 1.1;
        } else if (experience <= 6 && experience > 0) {
            currentMuscleGrowthD = (float) ((69.98 + (-0.00531397 - 67.38605) / Math.pow(mgConstant, 0.8790314))) - 1.1;
            currentMuscleGrowth = (float) currentMuscleGrowthD;
        } else if (experience > 6 && experience < 12) {
            currentMuscleGrowthD = (float) ((69.98 + (-0.00531397 - 67.38605) / Math.pow(mgConstant, 0.8790314))) - .55;
            currentMuscleGrowth = (float) currentMuscleGrowthD;
        } else if (experience >= 12) {
            currentMuscleGrowthD = (float) ((69.98 + (-0.00531397 - 67.38605) / Math.pow(mgConstant, 0.8790314)));
            currentMuscleGrowth = (float) currentMuscleGrowthD;
        }
        if (composition <= 20) {
            dailyCaloricDeviance = (muscleGrowthRate * 2500) / 31;
        } else {
            dailyCaloricDeviance = ((((idealBodyWeight - bodyweight) / (48 - experience)) * 3500) / 31);

        }
        float potentialMuscleGrowth = (totalMuscleGrowth - currentMuscleGrowth);

        editor.putFloat(PMG, totalMuscleGrowth);
        editor.putFloat(IDEAL_BODYWEIGHT, idealBodyWeight);
        editor.putFloat(FATLOSS, fatLoss);
        editor.putFloat(CURRENT_GROWTH, currentMuscleGrowth);
        editor.putFloat(POTENTIAL_GROWTH, potentialMuscleGrowth);
        editor.putFloat(GROWTH_RATE, muscleGrowthRate);
        editor.putFloat(CALORIES, dailyCaloricDeviance);
        editor.putBoolean(MALE, false);
        editor.putFloat(PMG, totalMuscleGrowth);
        editor.putFloat(IDEAL_BODYWEIGHT, idealBodyWeight);

        //EDIT TEXT DATA

//        editor.putFloat(EXTRA_BODYWEIGHT, 0);
//        editor.putFloat(EXTRA_HEIGHT_FEET, 0);
//        editor.putFloat(EXTRA_HEIGHT_INCHES, 0);
//        editor.putFloat(EXTRA_EXPERIENCE, 0);
//        editor.putFloat(EXTRA_COMPOSITION, 0);

        editor.apply();


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Dashboards.class);
                startActivity(intent);
            }
        }, delay);
    }
}
