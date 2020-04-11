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


public class AnteriorDeltoid extends AppCompatActivity {
    public static final String ANTERIORDELTOIDPROGRESS = "ANTERIORDELTOIDPROGRESS";
    public static final String ANTERIORDELTOIDMAX = "ANTERIORDELTOIDMAX";
    public static final String PREFS = "PREFS";
    Button anteriorDeltoidReset;
    int anteriorDeltoidProgress;
    String anteriorDeltoidProgressTxt;
    Button setanteriorDeltoidMax;
    Button resetanteriorDeltoidMax;
    int anteriorDeltoidMax;
    String anteriorDeltoidMaxTxt;
    TextView currentanteriorDeltoidVolume;
    TextView currentanteriorDeltoidMax;
    EditText anteriorDeltoidMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anterior_deltoid);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        anteriorDeltoidMRV = findViewById(R.id.setmaxet);
        currentanteriorDeltoidMax = findViewById(R.id.current_max);
        currentanteriorDeltoidVolume = findViewById(R.id.current_volume);
        anteriorDeltoidProgressTxt = Integer.toString(sp.getInt(ANTERIORDELTOIDPROGRESS, 0) / 10);
        anteriorDeltoidMaxTxt = Integer.toString(sp.getInt(ANTERIORDELTOIDMAX, 160) / 10);
        currentanteriorDeltoidMax.append(anteriorDeltoidMaxTxt);
        currentanteriorDeltoidVolume.append(anteriorDeltoidProgressTxt);


        anteriorDeltoidReset = findViewById(R.id.anteriorDeltoidresetvolume);
        anteriorDeltoidReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anteriorDeltoidProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(ANTERIORDELTOIDPROGRESS, anteriorDeltoidProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetanteriorDeltoidMax = findViewById(R.id.anteriorDeltoidresetmax);
        resetanteriorDeltoidMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                anteriorDeltoidMax = 60;
                editor.putInt(ANTERIORDELTOIDMAX, anteriorDeltoidMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setanteriorDeltoidMax = findViewById(R.id.setanteriorDeltoidmax);
        setanteriorDeltoidMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(anteriorDeltoidMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setanteriorDeltoidMax = findViewById(R.id.setmaxet);
                    anteriorDeltoidMax = Integer.parseInt(setanteriorDeltoidMax.getText().toString());
                    anteriorDeltoidMax = anteriorDeltoidMax * 10;
                    editor.putInt(ANTERIORDELTOIDMAX, anteriorDeltoidMax);
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