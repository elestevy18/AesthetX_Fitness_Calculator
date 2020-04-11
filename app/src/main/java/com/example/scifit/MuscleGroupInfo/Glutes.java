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


public class Glutes extends AppCompatActivity {
    public static final String GLUTESPROGRESS = "GLUTESPROGRESS";
    public static final String GLUTESMAX = "GLUTESMAX";
    public static final String PREFS = "PREFS";
    Button glutesReset;
    int glutesProgress;
    String glutesProgressTxt;
    Button setglutesMax;
    Button resetglutesMax;
    int glutesMax;
    String glutesMaxTxt;
    TextView currentglutesVolume;
    TextView currentglutesMax;
    EditText glutesMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glutes);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        glutesMRV = findViewById(R.id.setmaxet);
        currentglutesMax = findViewById(R.id.current_max);
        currentglutesVolume = findViewById(R.id.current_volume);
        glutesProgressTxt = Integer.toString(sp.getInt(GLUTESPROGRESS, 0) / 10);
        glutesMaxTxt = Integer.toString(sp.getInt(GLUTESMAX, 40) / 10);
        currentglutesMax.append(glutesMaxTxt);
        currentglutesVolume.append(glutesProgressTxt);


        glutesReset = findViewById(R.id.glutesresetvolume);
        glutesReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glutesProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(GLUTESPROGRESS, glutesProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetglutesMax = findViewById(R.id.glutesresetmax);
        resetglutesMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                glutesMax = 40;
                editor.putInt(GLUTESMAX, glutesMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setglutesMax = findViewById(R.id.setglutesmax);
        setglutesMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(glutesMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setglutesMax = findViewById(R.id.setmaxet);
                    glutesMax = Integer.parseInt(setglutesMax.getText().toString());
                    glutesMax = glutesMax * 10;
                    editor.putInt(GLUTESMAX, glutesMax);
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