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

import com.AesthetX.aesthetx.Classes.Adapters.medialDeltoidImageAdapter;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;

public class MedialDeltoid extends AppCompatActivity {
    private static final String MEDIALDELTOIDPROGRESS = "MEDIALDELTOIDPROGRESS";
    private static final String MEDIALDELTOIDMAX = "MEDIALDELTOIDMAX";
    private static final String PREFS = "PREFS";
    private int medialDeltoidProgress;
    private int medialDeltoidMax;
    private EditText medialDeltoidMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medial_deltoid);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        medialDeltoidMRV = findViewById(R.id.setmaxet);
        TextView currentmedialDeltoidMax = findViewById(R.id.current_max);
        TextView currentmedialDeltoidVolume = findViewById(R.id.current_volume);
        String medialDeltoidProgressTxt = Integer.toString(sp.getInt(MEDIALDELTOIDPROGRESS, 0) / 10);
        String medialDeltoidMaxTxt = Integer.toString(sp.getInt(MEDIALDELTOIDMAX, 160) / 10);
        currentmedialDeltoidMax.append(medialDeltoidMaxTxt);
        currentmedialDeltoidVolume.append(medialDeltoidProgressTxt);


        Button medialDeltoidReset = findViewById(R.id.medialDeltoidresetvolume);
        medialDeltoidReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medialDeltoidProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(MEDIALDELTOIDPROGRESS, medialDeltoidProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetmedialDeltoidMax = findViewById(R.id.medialDeltoidresetmax);
        resetmedialDeltoidMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                medialDeltoidMax = 100;
                editor.putInt(MEDIALDELTOIDMAX, medialDeltoidMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setmedialDeltoidMax = findViewById(R.id.setmedialDeltoidmax);
        setmedialDeltoidMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(medialDeltoidMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setmedialDeltoidMax = findViewById(R.id.setmaxet);
                    medialDeltoidMax = Integer.parseInt(setmedialDeltoidMax.getText().toString());
                    medialDeltoidMax = medialDeltoidMax * 10;
                    editor.putInt(MEDIALDELTOIDMAX, medialDeltoidMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        medialDeltoidImageAdapter adapter = new medialDeltoidImageAdapter(this);
        viewPager.setAdapter(adapter);


    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}
