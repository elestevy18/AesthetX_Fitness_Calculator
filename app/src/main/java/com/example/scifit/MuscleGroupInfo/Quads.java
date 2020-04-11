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


public class
Quads extends AppCompatActivity {
    public static final String QUADSPROGRESS = "QUADSPROGRESS";
    public static final String QUADSMAX = "QUADSMAX";
    public static final String PREFS = "PREFS";
    Button quadsReset;
    int quadsProgress;
    String quadsProgressTxt;
    Button setquadsMax;
    Button resetquadsMax;
    int quadsMax;
    String quadsMaxTxt;
    TextView currentquadsVolume;
    TextView currentquadsMax;
    EditText quadsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quads);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        quadsMRV = findViewById(R.id.setmaxet);
        currentquadsMax = findViewById(R.id.current_max);
        currentquadsVolume = findViewById(R.id.current_volume);
        quadsProgressTxt = Integer.toString(sp.getInt(QUADSPROGRESS, 0) / 10);
        quadsMaxTxt = Integer.toString(sp.getInt(QUADSMAX, 120) / 10);
        currentquadsMax.append(quadsMaxTxt);
        currentquadsVolume.append(quadsProgressTxt);


        quadsReset = findViewById(R.id.quadsresetvolume);
        quadsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quadsProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(QUADSPROGRESS, quadsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetquadsMax = findViewById(R.id.quadsresetmax);
        resetquadsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                quadsMax = 120;
                editor.putInt(QUADSMAX, quadsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setquadsMax = findViewById(R.id.setquadsmax);
        setquadsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(quadsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setquadsMax = findViewById(R.id.setmaxet);
                    quadsMax = Integer.parseInt(setquadsMax.getText().toString());
                    quadsMax = quadsMax * 10;
                    editor.putInt(QUADSMAX, quadsMax);
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