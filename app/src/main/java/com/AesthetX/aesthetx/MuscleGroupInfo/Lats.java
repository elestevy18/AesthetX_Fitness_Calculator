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

import com.AesthetX.aesthetx.Classes.Adapters.latsImageAdapter;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;


public class Lats extends AppCompatActivity {
    private static final String LATSPROGRESS = "LATSPROGRESS";
    private static final String LATSMAX = "LATSMAX";
    private static final String PREFS = "PREFS";
    private int latsProgress;
    private int latsMax;
    private EditText latsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lats);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        latsMRV = findViewById(R.id.setmaxet);
        TextView currentlatsMax = findViewById(R.id.current_max);
        TextView currentlatsVolume = findViewById(R.id.current_volume);
        String latsProgressTxt = Integer.toString(sp.getInt(LATSPROGRESS, 0) / 10);
        String latsMaxTxt = Integer.toString(sp.getInt(LATSMAX, 120) / 10);
        currentlatsMax.append(latsMaxTxt);
        currentlatsVolume.append(latsProgressTxt);


        Button latsReset = findViewById(R.id.latsresetvolume);
        latsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                latsProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(LATSPROGRESS, latsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetlatsMax = findViewById(R.id.latsresetmax);
        resetlatsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                latsMax = 120;
                editor.putInt(LATSMAX, latsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setlatsMax = findViewById(R.id.setlatsmax);
        setlatsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(latsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setlatsMax = findViewById(R.id.setmaxet);
                    latsMax = Integer.parseInt(setlatsMax.getText().toString());
                    latsMax = latsMax * 10;
                    editor.putInt(LATSMAX, latsMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        latsImageAdapter adapter = new latsImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}