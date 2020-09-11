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

import com.AesthetX.aesthetx.Classes.Adapters.radialImageAdapter;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;


public class RadialForearm extends AppCompatActivity {
    private static final String RADIALPROGRESS = "RADIALPROGRESS";
    private static final String RADIALMAX = "RADIALMAX";
    private static final String PREFS = "PREFS";
    private int radialProgress;
    private int radialMax;
    private EditText radialMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radialforearms);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        radialMRV = findViewById(R.id.setmaxet);
        TextView currentradialMax = findViewById(R.id.current_max);
        TextView currentradialVolume = findViewById(R.id.current_volume);
        String radialProgressTxt = Integer.toString(sp.getInt(RADIALPROGRESS, 0) / 10);
        String radialMaxTxt = Integer.toString(sp.getInt(RADIALMAX, 100) / 10);
        currentradialMax.append(radialMaxTxt);
        currentradialVolume.append(radialProgressTxt);


        Button radialReset = findViewById(R.id.radialresetvolume);
        radialReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radialProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(RADIALPROGRESS, radialProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetradialMax = findViewById(R.id.radialresetmax);
        resetradialMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                radialMax = 100;
                editor.putInt(RADIALMAX, radialMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setradialMax = findViewById(R.id.setradialmax);
        setradialMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(radialMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setradialMax = findViewById(R.id.setmaxet);
                    radialMax = Integer.parseInt(setradialMax.getText().toString());
                    radialMax = radialMax * 10;
                    editor.putInt(RADIALMAX, radialMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        radialImageAdapter adapter = new radialImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}