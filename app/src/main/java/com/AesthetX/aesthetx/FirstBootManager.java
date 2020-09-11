package com.AesthetX.aesthetx;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.scifit.R;

import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;
import com.AesthetX.aesthetx.Intro.Intro;

public class FirstBootManager extends Activity {
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String FIRSTRUN = "firstrun";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_boot_manager);


        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (sharedPreferences.getBoolean(FIRSTRUN, true)) {

            startActivity(new Intent(this, Intro.class));
            finish();
        } else {
            startActivity(new Intent(this, Dashboards.class));
            finish();
        }
    }
}
