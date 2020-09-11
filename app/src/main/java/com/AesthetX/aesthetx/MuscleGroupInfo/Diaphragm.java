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

import com.AesthetX.aesthetx.Classes.Adapters.diaphragmImageAdapter;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;


public class Diaphragm extends AppCompatActivity {
    private static final String TransversePROGRESS = "TransversePROGRESS";
    private static final String TransverseMAX = "TransverseMAX";
    private static final String PREFS = "PREFS";
    private int TransverseProgress;
    private int TransverseMax;
    private EditText TransverseMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaphragm);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        TransverseMRV = findViewById(R.id.setmaxet);
        TextView currentTransverseMax = findViewById(R.id.current_max);
        TextView currentTransverseVolume = findViewById(R.id.current_volume);
        String TransverseProgressTxt = Integer.toString(sp.getInt(TransversePROGRESS, 0) / 10);
        String TransverseMaxTxt = Integer.toString(sp.getInt(TransverseMAX, 160) / 10);
        currentTransverseMax.append(TransverseMaxTxt);
        currentTransverseVolume.append(TransverseProgressTxt);


        Button TransverseReset = findViewById(R.id.Transverseresetvolume);
        TransverseReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransverseProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(TransversePROGRESS, TransverseProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetTransverseMax = findViewById(R.id.Transverseresetmax);
        resetTransverseMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                TransverseMax = 160;
                editor.putInt(TransverseMAX, TransverseMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setTransverseMax = findViewById(R.id.setTransversemax);
        setTransverseMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(TransverseMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setTransverseMax = findViewById(R.id.setmaxet);
                    TransverseMax = Integer.parseInt(setTransverseMax.getText().toString());
                    TransverseMax = TransverseMax * 10;
                    editor.putInt(TransverseMAX, TransverseMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        diaphragmImageAdapter adapter = new diaphragmImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}