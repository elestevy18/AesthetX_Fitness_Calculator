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

import com.AesthetX.aesthetx.Classes.Adapters.upperTrapImageAdapter;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;


public class UpperTrap extends AppCompatActivity {
    private static final String UPPERTRAPPROGRESS = "UPPERTRAPPROGRESS";
    private static final String UPPERTRAPMAX = "UPPERTRAPMAX";
    private static final String PREFS = "PREFS";
    private int upperTrapProgress;
    private int upperTrapMax;
    private EditText upperTrapMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_trap);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        upperTrapMRV = findViewById(R.id.setmaxet);
        TextView currentupperTrapMax = findViewById(R.id.current_max);
        TextView currentupperTrapVolume = findViewById(R.id.current_volume);
        String upperTrapProgressTxt = Integer.toString(sp.getInt(UPPERTRAPPROGRESS, 0) / 10);
        String upperTrapMaxTxt = Integer.toString(sp.getInt(UPPERTRAPMAX, 120) / 10);
        currentupperTrapMax.append(upperTrapMaxTxt);
        currentupperTrapVolume.append(upperTrapProgressTxt);


        Button upperTrapReset = findViewById(R.id.uppertrapresetvolume);
        upperTrapReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upperTrapProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(UPPERTRAPPROGRESS, upperTrapProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetupperTrapMax = findViewById(R.id.uppertrapresetmax);
        resetupperTrapMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                upperTrapMax = 120;
                editor.putInt(UPPERTRAPMAX, upperTrapMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setupperTrapMax = findViewById(R.id.setuppertrapmax);
        setupperTrapMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(upperTrapMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setupperTrapMax = findViewById(R.id.setmaxet);
                    upperTrapMax = Integer.parseInt(setupperTrapMax.getText().toString());
                    upperTrapMax = upperTrapMax * 10;
                    editor.putInt(UPPERTRAPMAX, upperTrapMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });
        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        upperTrapImageAdapter adapter = new upperTrapImageAdapter(this);
        viewPager.setAdapter(adapter);


    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}
