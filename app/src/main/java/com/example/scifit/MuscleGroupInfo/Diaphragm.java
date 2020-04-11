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


public class Diaphragm extends AppCompatActivity {
    public static final String DIAPHRAGMPROGRESS = "DIAPHRAGMPROGRESS";
    public static final String DIAPHRAGMMAX = "DIAPHRAGMMAX";
    public static final String PREFS = "PREFS";
    Button diaphragmReset;
    int diaphragmProgress;
    String diaphragmProgressTxt;
    Button setdiaphragmMax;
    Button resetdiaphragmMax;
    int diaphragmMax;
    String diaphragmMaxTxt;
    TextView currentdiaphragmVolume;
    TextView currentdiaphragmMax;
    EditText diaphragmMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaphragm);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        diaphragmMRV = findViewById(R.id.setmaxet);
        currentdiaphragmMax = findViewById(R.id.current_max);
        currentdiaphragmVolume = findViewById(R.id.current_volume);
        diaphragmProgressTxt = Integer.toString(sp.getInt(DIAPHRAGMPROGRESS, 0) / 10);
        diaphragmMaxTxt = Integer.toString(sp.getInt(DIAPHRAGMMAX, 160) / 10);
        currentdiaphragmMax.append(diaphragmMaxTxt);
        currentdiaphragmVolume.append(diaphragmProgressTxt);


        diaphragmReset = findViewById(R.id.diaphragmresetvolume);
        diaphragmReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaphragmProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(DIAPHRAGMPROGRESS, diaphragmProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetdiaphragmMax = findViewById(R.id.diaphragmresetmax);
        resetdiaphragmMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                diaphragmMax = 160;
                editor.putInt(DIAPHRAGMMAX, diaphragmMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setdiaphragmMax = findViewById(R.id.setdiaphragmmax);
        setdiaphragmMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(diaphragmMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setdiaphragmMax = findViewById(R.id.setmaxet);
                    diaphragmMax = Integer.parseInt(setdiaphragmMax.getText().toString());
                    diaphragmMax = diaphragmMax * 10;
                    editor.putInt(DIAPHRAGMMAX, diaphragmMax);
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