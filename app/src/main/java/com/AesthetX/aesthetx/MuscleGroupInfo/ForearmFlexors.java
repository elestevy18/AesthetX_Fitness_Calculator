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

import com.AesthetX.aesthetx.Classes.Adapters.flexorImageAdapter;
import com.AesthetX.aesthetx.Classes.Constants;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;
import com.example.scifit.R;


public class ForearmFlexors extends AppCompatActivity {
    private static final String FOREARMFLEXORSPROGRESS = "FOREARMFLEXORSPROGRESS";
    private static final String FOREARMFLEXORSMAX = "FOREARMFLEXORSMAX";
    private static final String PREFS = Constants.PREFS;
    private int forearmFlexorProgress;
    private int forearmFlexorMax;
    private EditText forearmFlexorMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forearm_flexors);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        forearmFlexorMRV = findViewById(R.id.setmaxet);
        TextView currentforearmFlexorMax = findViewById(R.id.current_max);
        TextView currentforearmFlexorVolume = findViewById(R.id.current_volume);
        String forearmFlexorProgressTxt = Integer.toString(sp.getInt(FOREARMFLEXORSPROGRESS, 0) / 10);
        String forearmFlexorMaxTxt = Integer.toString(sp.getInt(FOREARMFLEXORSMAX, 100) / 10);
        currentforearmFlexorMax.append(forearmFlexorMaxTxt);
        currentforearmFlexorVolume.append(forearmFlexorProgressTxt);


        Button forearmFlexorReset = findViewById(R.id.flexorresetvolume);
        forearmFlexorReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forearmFlexorProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(FOREARMFLEXORSPROGRESS, forearmFlexorProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetforearmFlexorMax = findViewById(R.id.flexorresetmax);
        resetforearmFlexorMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                forearmFlexorMax = 100;
                editor.putInt(FOREARMFLEXORSMAX, forearmFlexorMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setforearmFlexorMax = findViewById(R.id.setflexormax);
        setforearmFlexorMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(forearmFlexorMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setforearmFlexorMax = findViewById(R.id.setmaxet);
                    forearmFlexorMax = Integer.parseInt(setforearmFlexorMax.getText().toString());
                    forearmFlexorMax = forearmFlexorMax * 10;
                    editor.putInt(FOREARMFLEXORSMAX, forearmFlexorMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        flexorImageAdapter adapter = new flexorImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}