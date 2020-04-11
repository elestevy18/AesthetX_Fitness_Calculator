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


public class GluteMedius extends AppCompatActivity {
    public static final String GLUTEMEDIUSPROGRESS = "GLUTEMEDIUSPROGRESS";
    public static final String GLUTEMEDIUSMAX = "GLUTEMEDIUSMAX";
    public static final String PREFS = "PREFS";
    Button gluteMediusReset;
    int gluteMediusProgress;
    String gluteMediusProgressTxt;
    Button setgluteMediusMax;
    Button resetgluteMediusMax;
    int gluteMediusMax;
    String gluteMediusMaxTxt;
    TextView currentgluteMediusVolume;
    TextView currentgluteMediusMax;
    EditText gluteMediusMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glute_medius);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        gluteMediusMRV = findViewById(R.id.setmaxet);
        currentgluteMediusMax = findViewById(R.id.current_max);
        currentgluteMediusVolume = findViewById(R.id.current_volume);
        gluteMediusProgressTxt = Integer.toString(sp.getInt(GLUTEMEDIUSPROGRESS, 0) / 10);
        gluteMediusMaxTxt = Integer.toString(sp.getInt(GLUTEMEDIUSMAX, 120) / 10);
        currentgluteMediusMax.append(gluteMediusMaxTxt);
        currentgluteMediusVolume.append(gluteMediusProgressTxt);


        gluteMediusReset = findViewById(R.id.glutemediusresetvolume);
        gluteMediusReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gluteMediusProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(GLUTEMEDIUSPROGRESS, gluteMediusProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetgluteMediusMax = findViewById(R.id.glutemediusresetmax);
        resetgluteMediusMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                gluteMediusMax = 120;
                editor.putInt(GLUTEMEDIUSMAX, gluteMediusMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setgluteMediusMax = findViewById(R.id.setglutemediusmax);
        setgluteMediusMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(gluteMediusMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setgluteMediusMax = findViewById(R.id.setmaxet);
                    gluteMediusMax = Integer.parseInt(setgluteMediusMax.getText().toString());
                    gluteMediusMax = gluteMediusMax * 10;
                    editor.putInt(GLUTEMEDIUSMAX, gluteMediusMax);
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