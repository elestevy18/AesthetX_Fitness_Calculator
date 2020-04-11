package com.example.scifit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.scifit.DashBoardTabs.Dashboards;
import com.example.scifit.Intro.Intro;

public class FirstBootManager extends Activity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String FIRSTRUN = "firstrun";
    SharedPreferences sharedPreferences = null;

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
            // Do first run stuff here then set 'firstrun' as false
            // start  DataActivity because its your app first run
            // using the following line to edit/commit sharedPreferences

            startActivity(new Intent(this , Intro.class));
            finish();
        }
        else {
            startActivity(new Intent(this , Dashboards.class));
            finish();
        }
    }
}
