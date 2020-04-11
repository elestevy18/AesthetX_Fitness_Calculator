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


public class RadialForearm extends AppCompatActivity {
    public static final String RADIALFOREARMPROGRESS = "RADIALFOREARMPROGRESS";
    public static final String RADIALFOREARMMAX = "RADIALFOREARMMAX";
    public static final String PREFS = "PREFS";
    Button radialforearmReset;
    int radialforearmProgress;
    String radialforearmProgressTxt;
    Button setradialforearmMax;
    Button resetradialforearmMax;
    int radialforearmMax;
    String radialforearmMaxTxt;
    TextView currentradialforearmVolume;
    TextView currentradialforearmMax;
    EditText radialforearmMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radialforearms);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        radialforearmMRV = findViewById(R.id.setmaxet);
        currentradialforearmMax = findViewById(R.id.current_max);
        currentradialforearmVolume = findViewById(R.id.current_volume);
        radialforearmProgressTxt = Integer.toString(sp.getInt(RADIALFOREARMPROGRESS, 0) / 10);
        radialforearmMaxTxt = Integer.toString(sp.getInt(RADIALFOREARMMAX, 100) / 10);
        currentradialforearmMax.append(radialforearmMaxTxt);
        currentradialforearmVolume.append(radialforearmProgressTxt);


        radialforearmReset = findViewById(R.id.radialforearmresetvolume);
        radialforearmReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radialforearmProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(RADIALFOREARMPROGRESS, radialforearmProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetradialforearmMax = findViewById(R.id.radialforearmresetmax);
        resetradialforearmMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                radialforearmMax = 100;
                editor.putInt(RADIALFOREARMMAX, radialforearmMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setradialforearmMax = findViewById(R.id.setradialforearmmax);
        setradialforearmMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(radialforearmMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setradialforearmMax = findViewById(R.id.setmaxet);
                    radialforearmMax = Integer.parseInt(setradialforearmMax.getText().toString());
                    radialforearmMax = radialforearmMax * 10;
                    editor.putInt(RADIALFOREARMMAX, radialforearmMax);
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