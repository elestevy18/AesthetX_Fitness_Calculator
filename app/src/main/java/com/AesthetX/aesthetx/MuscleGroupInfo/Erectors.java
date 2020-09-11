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

import com.AesthetX.aesthetx.Classes.Adapters.erectorsImageAdapter;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;


public class Erectors extends AppCompatActivity {
    private static final String ERECTORSPROGRESS = "ERECTORSPROGRESS";
    private static final String ERECTORSMAX = "ERECTORSMAX";
    private static final String PREFS = "PREFS";
    private int erectorsProgress;
    private int erectorsMax;
    private EditText erectorsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erectors);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        erectorsMRV = findViewById(R.id.setmaxet);
        TextView currenterectorsMax = findViewById(R.id.current_max);
        TextView currenterectorsVolume = findViewById(R.id.current_volume);
        String erectorsProgressTxt = Integer.toString(sp.getInt(ERECTORSPROGRESS, 0) / 10);
        String erectorsMaxTxt = Integer.toString(sp.getInt(ERECTORSMAX, 100) / 10);
        currenterectorsMax.append(erectorsMaxTxt);
        currenterectorsVolume.append(erectorsProgressTxt);


        Button erectorsReset = findViewById(R.id.erectorsresetvolume);
        erectorsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                erectorsProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(ERECTORSPROGRESS, erectorsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button reseterectorsMax = findViewById(R.id.erectorsresetmax);
        reseterectorsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                erectorsMax = 100;
                editor.putInt(ERECTORSMAX, erectorsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button seterectorsMax = findViewById(R.id.seterectorsmax);
        seterectorsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(erectorsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText seterectorsMax = findViewById(R.id.setmaxet);
                    erectorsMax = Integer.parseInt(seterectorsMax.getText().toString());
                    erectorsMax = erectorsMax * 10;
                    editor.putInt(ERECTORSMAX, erectorsMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        erectorsImageAdapter adapter = new erectorsImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}