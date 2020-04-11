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


public class Lats extends AppCompatActivity {
    public static final String LATSPROGRESS = "LATSPROGRESS";
    public static final String LATSMAX = "LATSMAX";
    public static final String PREFS = "PREFS";
    Button latsReset;
    int latsProgress;
    String latsProgressTxt;
    Button setlatsMax;
    Button resetlatsMax;
    int latsMax;
    String latsMaxTxt;
    TextView currentlatsVolume;
    TextView currentlatsMax;
    EditText latsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lats);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        latsMRV = findViewById(R.id.setmaxet);
        currentlatsMax = findViewById(R.id.current_max);
        currentlatsVolume = findViewById(R.id.current_volume);
        latsProgressTxt = Integer.toString(sp.getInt(LATSPROGRESS, 0) / 10);
        latsMaxTxt = Integer.toString(sp.getInt(LATSMAX, 120) / 10);
        currentlatsMax.append(latsMaxTxt);
        currentlatsVolume.append(latsProgressTxt);


        latsReset = findViewById(R.id.latsresetvolume);
        latsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                latsProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(LATSPROGRESS, latsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetlatsMax = findViewById(R.id.latsresetmax);
        resetlatsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                latsMax = 120;
                editor.putInt(LATSMAX, latsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setlatsMax = findViewById(R.id.setlatsmax);
        setlatsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(latsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setlatsMax = findViewById(R.id.setmaxet);
                    latsMax = Integer.parseInt(setlatsMax.getText().toString());
                    latsMax = latsMax * 10;
                    editor.putInt(LATSMAX, latsMax);
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