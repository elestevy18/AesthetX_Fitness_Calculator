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


public class Triceps extends AppCompatActivity {
    public static final String TRICEPPROGRESS = "TRICEPPROGRESS";
    public static final String TRICEPMAX = "TRICEPMAX";
    public static final String PREFS = "PREFS";
    Button tricepReset;
    int tricepProgress;
    String tricepProgressTxt;
    Button settricepMax;
    Button resettricepMax;
    int tricepMax;
    String tricepMaxTxt;
    TextView currenttricepVolume;
    TextView currenttricepMax;
    EditText tricepMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triceps);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        tricepMRV = findViewById(R.id.setmaxet);
        currenttricepMax = findViewById(R.id.current_max);
        currenttricepVolume = findViewById(R.id.current_volume);
        tricepProgressTxt = Integer.toString(sp.getInt(TRICEPPROGRESS, 0) / 10);
        tricepMaxTxt = Integer.toString(sp.getInt(TRICEPMAX, 100) / 10);
        currenttricepMax.append(tricepMaxTxt);
        currenttricepVolume.append(tricepProgressTxt);


        tricepReset = findViewById(R.id.tricepresetvolume);
        tricepReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tricepProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(TRICEPPROGRESS, tricepProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resettricepMax = findViewById(R.id.tricepresetmax);
        resettricepMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                tricepMax = 100;
                editor.putInt(TRICEPMAX, tricepMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        settricepMax = findViewById(R.id.settricepmax);
        settricepMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(tricepMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText settricepMax = findViewById(R.id.setmaxet);
                    tricepMax = Integer.parseInt(settricepMax.getText().toString());
                    tricepMax = tricepMax * 10;
                    editor.putInt(TRICEPMAX, tricepMax);
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