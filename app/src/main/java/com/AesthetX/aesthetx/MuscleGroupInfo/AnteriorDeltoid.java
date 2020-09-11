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

import com.AesthetX.aesthetx.Classes.Adapters.anteriorDeltoidImageAdapter;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;


public class AnteriorDeltoid extends AppCompatActivity {
    private static final String ANTERIORDELTOIDPROGRESS = "ANTERIORDELTOIDPROGRESS";
    private static final String ANTERIORDELTOIDMAX = "ANTERIORDELTOIDMAX";
    private static final String PREFS = "PREFS";
    private int anteriorDeltoidProgress;
    private int anteriorDeltoidMax;
    private EditText anteriorDeltoidMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anterior_deltoid);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        anteriorDeltoidMRV = findViewById(R.id.setmaxet);
        TextView currentanteriorDeltoidMax = findViewById(R.id.current_max);
        TextView currentanteriorDeltoidVolume = findViewById(R.id.current_volume);
        String anteriorDeltoidProgressTxt = Integer.toString(sp.getInt(ANTERIORDELTOIDPROGRESS, 0) / 10);
        String anteriorDeltoidMaxTxt = Integer.toString(sp.getInt(ANTERIORDELTOIDMAX, 160) / 10);
        currentanteriorDeltoidMax.append(anteriorDeltoidMaxTxt);
        currentanteriorDeltoidVolume.append(anteriorDeltoidProgressTxt);


        Button anteriorDeltoidReset = findViewById(R.id.anteriorDeltoidresetvolume);
        anteriorDeltoidReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anteriorDeltoidProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(ANTERIORDELTOIDPROGRESS, anteriorDeltoidProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetanteriorDeltoidMax = findViewById(R.id.anteriorDeltoidresetmax);
        resetanteriorDeltoidMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                anteriorDeltoidMax = 60;
                editor.putInt(ANTERIORDELTOIDMAX, anteriorDeltoidMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setanteriorDeltoidMax = findViewById(R.id.setanteriorDeltoidmax);
        setanteriorDeltoidMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(anteriorDeltoidMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setanteriorDeltoidMax = findViewById(R.id.setmaxet);
                    anteriorDeltoidMax = Integer.parseInt(setanteriorDeltoidMax.getText().toString());
                    anteriorDeltoidMax = anteriorDeltoidMax * 10;
                    editor.putInt(ANTERIORDELTOIDMAX, anteriorDeltoidMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        anteriorDeltoidImageAdapter adapter = new anteriorDeltoidImageAdapter(this);
        viewPager.setAdapter(adapter);

    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}