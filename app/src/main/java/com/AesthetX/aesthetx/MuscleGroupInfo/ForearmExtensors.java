package com.AesthetX.aesthetx.MuscleGroupInfo;

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
import androidx.viewpager.widget.ViewPager;

import com.AesthetX.aesthetx.Classes.Adapters.extensorImageAdapter;
import com.AesthetX.aesthetx.Classes.Constants;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;
import com.example.scifit.R;


public class ForearmExtensors extends AppCompatActivity {
    private static final String FOREARMEXTENSORSPROGRESS = "FOREARMEXTENSORSPROGRESS";
    private static final String FOREARMEXTENSORSMAX = "FOREARMEXTENSORSMAX";
    private static final String PREFS = Constants.PREFS;
    private int forearmExtensorsProgress;
    private int forearmExtensorsMax;
    private EditText forearmExtensorsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forearm_extensors);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        forearmExtensorsMRV = findViewById(R.id.setmaxet);
        TextView currentforearmExtensorsMax = findViewById(R.id.current_max);
        TextView currentforearmExtensorsVolume = findViewById(R.id.current_volume);
        String forearmExtensorsProgressTxt = Integer.toString(sp.getInt(FOREARMEXTENSORSPROGRESS, 0) / 10);
        String forearmExtensorsMaxTxt = Integer.toString(sp.getInt(FOREARMEXTENSORSMAX, 100) / 10);
        currentforearmExtensorsMax.append(forearmExtensorsMaxTxt);
        currentforearmExtensorsVolume.append(forearmExtensorsProgressTxt);


        Button forearmExtensorsReset = findViewById(R.id.Extensorsresetvolume);
        forearmExtensorsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forearmExtensorsProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(FOREARMEXTENSORSPROGRESS, forearmExtensorsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetforearmExtensorsMax = findViewById(R.id.Extensorsresetmax);
        resetforearmExtensorsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                forearmExtensorsMax = 100;
                editor.putInt(FOREARMEXTENSORSMAX, forearmExtensorsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setforearmExtensorsMax = findViewById(R.id.setExtensorsmax);
        setforearmExtensorsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(forearmExtensorsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setforearmExtensorsMax = findViewById(R.id.setmaxet);
                    forearmExtensorsMax = Integer.parseInt(setforearmExtensorsMax.getText().toString());
                    forearmExtensorsMax = forearmExtensorsMax * 10;
                    editor.putInt(FOREARMEXTENSORSMAX, forearmExtensorsMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        extensorImageAdapter adapter = new extensorImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}