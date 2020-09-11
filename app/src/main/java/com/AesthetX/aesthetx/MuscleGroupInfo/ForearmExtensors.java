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

import com.example.scifit.R;

import com.AesthetX.aesthetx.Classes.Adapters.extensorImageAdapter;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;


public class ForearmExtensors extends AppCompatActivity {
    private static final String FOREARMEXTENSORSPROGRESS = "FOREARMEXTENSORSPROGRESS";
    private static final String FOREARMEXTENSORMAX = "FOREARMEXTENSORMAX";
    private static final String PREFS = "PREFS";
    private int forearmExtensorProgress;
    private int forearmExtensorMax;
    private EditText forearmExtensorMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forearm_extensors);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        forearmExtensorMRV = findViewById(R.id.setmaxet);
        TextView currentforearmExtensorMax = findViewById(R.id.current_max);
        TextView currentforearmExtensorVolume = findViewById(R.id.current_volume);
        String forearmExtensorProgressTxt = Integer.toString(sp.getInt(FOREARMEXTENSORSPROGRESS, 0) / 10);
        String forearmExtensorMaxTxt = Integer.toString(sp.getInt(FOREARMEXTENSORMAX, 100) / 10);
        currentforearmExtensorMax.append(forearmExtensorMaxTxt);
        currentforearmExtensorVolume.append(forearmExtensorProgressTxt);


        Button forearmExtensorReset = findViewById(R.id.extensorresetvolume);
        forearmExtensorReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forearmExtensorProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(FOREARMEXTENSORSPROGRESS, forearmExtensorProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetforearmExtensorMax = findViewById(R.id.extensorresetmax);
        resetforearmExtensorMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                forearmExtensorMax = 100;
                editor.putInt(FOREARMEXTENSORMAX, forearmExtensorMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setforearmExtensorMax = findViewById(R.id.setextensormax);
        setforearmExtensorMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(forearmExtensorMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setforearmExtensorMax = findViewById(R.id.setmaxet);
                    forearmExtensorMax = Integer.parseInt(setforearmExtensorMax.getText().toString());
                    forearmExtensorMax = forearmExtensorMax * 10;
                    editor.putInt(FOREARMEXTENSORMAX, forearmExtensorMax);
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