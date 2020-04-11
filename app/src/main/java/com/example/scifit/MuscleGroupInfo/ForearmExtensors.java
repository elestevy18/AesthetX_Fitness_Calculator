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


public class ForearmExtensors extends AppCompatActivity {
    public static final String FOREARMEXTENSORSPROGRESS = "FOREARMEXTENSORSPROGRESS";
    public static final String FOREARMEXTENSORMAX = "FOREARMEXTENSORMAX";
    public static final String PREFS = "PREFS";
    Button forearmExtensorReset;
    int forearmExtensorProgress;
    String forearmExtensorProgressTxt;
    Button setforearmExtensorMax;
    Button resetforearmExtensorMax;
    int forearmExtensorMax;
    String forearmExtensorMaxTxt;
    TextView currentforearmExtensorVolume;
    TextView currentforearmExtensorMax;
    EditText forearmExtensorMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forearm_extensors);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        forearmExtensorMRV = findViewById(R.id.setmaxet);
        currentforearmExtensorMax = findViewById(R.id.current_max);
        currentforearmExtensorVolume = findViewById(R.id.current_volume);
        forearmExtensorProgressTxt = Integer.toString(sp.getInt(FOREARMEXTENSORSPROGRESS, 0) / 10);
        forearmExtensorMaxTxt = Integer.toString(sp.getInt(FOREARMEXTENSORMAX, 100) / 10);
        currentforearmExtensorMax.append(forearmExtensorMaxTxt);
        currentforearmExtensorVolume.append(forearmExtensorProgressTxt);


        forearmExtensorReset = findViewById(R.id.forearmextensorresetvolume);
        forearmExtensorReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forearmExtensorProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(FOREARMEXTENSORSPROGRESS, forearmExtensorProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetforearmExtensorMax = findViewById(R.id.forearmextensorresetmax);
        resetforearmExtensorMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                forearmExtensorMax = 100;
                editor.putInt(FOREARMEXTENSORMAX, forearmExtensorMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setforearmExtensorMax = findViewById(R.id.setforearmextensormax);
        setforearmExtensorMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(forearmExtensorMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setforearmExtensorMax = findViewById(R.id.setmaxet);
                    forearmExtensorMax = Integer.parseInt(setforearmExtensorMax.getText().toString());
                    forearmExtensorMax = forearmExtensorMax * 10;
                    editor.putInt(FOREARMEXTENSORMAX, forearmExtensorMax);
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