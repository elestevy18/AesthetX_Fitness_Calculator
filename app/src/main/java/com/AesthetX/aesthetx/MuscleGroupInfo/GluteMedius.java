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

import com.AesthetX.aesthetx.Classes.Adapters.glutesMediusImageAdapter;
import com.AesthetX.aesthetx.Classes.Constants;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;
import com.example.scifit.R;


public class GluteMedius extends AppCompatActivity {
    private static final String GLUTEMEDIUSPROGRESS = "GLUTEMEDIUSPROGRESS";
    private static final String GLUTEMEDIUSMAX = "GLUTEMEDIUSMAX";
    private static final String PREFS = Constants.PREFS;
    private int gluteMediusProgress;
    private int gluteMediusMax;
    private EditText gluteMediusMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glute_medius);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        gluteMediusMRV = findViewById(R.id.setmaxet);
        TextView currentgluteMediusMax = findViewById(R.id.current_max);
        TextView currentgluteMediusVolume = findViewById(R.id.current_volume);
        String gluteMediusProgressTxt = Integer.toString(sp.getInt(GLUTEMEDIUSPROGRESS, 0) / 10);
        String gluteMediusMaxTxt = Integer.toString(sp.getInt(GLUTEMEDIUSMAX, 120) / 10);
        currentgluteMediusMax.append(gluteMediusMaxTxt);
        currentgluteMediusVolume.append(gluteMediusProgressTxt);


        Button gluteMediusReset = findViewById(R.id.glutesMediusresetvolume);
        gluteMediusReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gluteMediusProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(GLUTEMEDIUSPROGRESS, gluteMediusProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetgluteMediusMax = findViewById(R.id.glutesMediusresetmax);
        resetgluteMediusMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                gluteMediusMax = 120;
                editor.putInt(GLUTEMEDIUSMAX, gluteMediusMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setgluteMediusMax = findViewById(R.id.setglutesMediusmax);
        setgluteMediusMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(gluteMediusMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setgluteMediusMax = findViewById(R.id.setmaxet);
                    gluteMediusMax = Integer.parseInt(setgluteMediusMax.getText().toString());
                    gluteMediusMax = gluteMediusMax * 10;
                    editor.putInt(GLUTEMEDIUSMAX, gluteMediusMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        glutesMediusImageAdapter adapter = new glutesMediusImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}