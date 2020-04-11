package com.example.scifit.MuscleGroupInfo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.DashBoardTabs.Dashboards;
import com.example.scifit.R;


public class ForearmFlexors extends AppCompatActivity {
    public static final String FOREARMFLEXORSPROGRESS = "FOREARMFLEXORSPROGRESS";
    public static final String FOREARMFLEXORSMAX = "FOREARMFLEXORSMAX";
    public static final String PREFS = "PREFS";
    Button forearmFlexorReset;
    int forearmFlexorProgress;
    String forearmFlexorProgressTxt;
    Button setforearmFlexorMax;
    Button resetforearmFlexorMax;
    int forearmFlexorMax;
    String forearmFlexorMaxTxt;
    TextView currentforearmFlexorVolume;
    TextView currentforearmFlexorMax;
    EditText forearmFlexorMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forearm_flexors);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        forearmFlexorMRV = findViewById(R.id.setmaxet);
        currentforearmFlexorMax = findViewById(R.id.current_max);
        currentforearmFlexorVolume = findViewById(R.id.current_volume);
        forearmFlexorProgressTxt = Integer.toString(sp.getInt(FOREARMFLEXORSPROGRESS, 0) / 10);
        forearmFlexorMaxTxt = Integer.toString(sp.getInt(FOREARMFLEXORSMAX, 100) / 10);
        currentforearmFlexorMax.append(forearmFlexorMaxTxt);
        currentforearmFlexorVolume.append(forearmFlexorProgressTxt);


        forearmFlexorReset = findViewById(R.id.forearmflexorresetvolume);
        forearmFlexorReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forearmFlexorProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(FOREARMFLEXORSPROGRESS, forearmFlexorProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetforearmFlexorMax = findViewById(R.id.forearmflexorresetmax);
        resetforearmFlexorMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                forearmFlexorMax = 100;
                editor.putInt(FOREARMFLEXORSMAX, forearmFlexorMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setforearmFlexorMax = findViewById(R.id.setforearmflexormax);
        setforearmFlexorMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(forearmFlexorMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setforearmFlexorMax = findViewById(R.id.setmaxet);
                    forearmFlexorMax = Integer.parseInt(setforearmFlexorMax.getText().toString());
                    forearmFlexorMax = forearmFlexorMax * 10;
                    editor.putInt(FOREARMFLEXORSMAX, forearmFlexorMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });


    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}