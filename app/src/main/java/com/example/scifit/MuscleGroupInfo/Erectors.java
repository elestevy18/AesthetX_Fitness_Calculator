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


public class Erectors extends AppCompatActivity {
    public static final String ERECTORSPROGRESS = "ERECTORSPROGRESS";
    public static final String ERECTORSMAX = "ERECTORSMAX";
    public static final String PREFS = "PREFS";
    Button erectorsReset;
    int erectorsProgress;
    String erectorsProgressTxt;
    Button seterectorsMax;
    Button reseterectorsMax;
    int erectorsMax;
    String erectorsMaxTxt;
    TextView currenterectorsVolume;
    TextView currenterectorsMax;
    EditText erectorsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erectors);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        erectorsMRV = findViewById(R.id.setmaxet);
        currenterectorsMax = findViewById(R.id.current_max);
        currenterectorsVolume = findViewById(R.id.current_volume);
        erectorsProgressTxt = Integer.toString(sp.getInt(ERECTORSPROGRESS, 0) / 10);
        erectorsMaxTxt = Integer.toString(sp.getInt(ERECTORSMAX, 100) / 10);
        currenterectorsMax.append(erectorsMaxTxt);
        currenterectorsVolume.append(erectorsProgressTxt);


        erectorsReset = findViewById(R.id.erectorsresetvolume);
        erectorsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                erectorsProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(ERECTORSPROGRESS, erectorsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        reseterectorsMax = findViewById(R.id.erectorsresetmax);
        reseterectorsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                erectorsMax = 100;
                editor.putInt(ERECTORSMAX, erectorsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        seterectorsMax = findViewById(R.id.seterectorsmax);
        seterectorsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(erectorsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText seterectorsMax = findViewById(R.id.setmaxet);
                    erectorsMax = Integer.parseInt(seterectorsMax.getText().toString());
                    erectorsMax = erectorsMax * 10;
                    editor.putInt(ERECTORSMAX, erectorsMax);
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