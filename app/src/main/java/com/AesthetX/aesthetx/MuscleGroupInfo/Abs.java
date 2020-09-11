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

import com.AesthetX.aesthetx.Classes.Adapters.absImageAdapter;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;


public class Abs extends AppCompatActivity {
    private static final String ABSPROGRESS = "ABSPROGRESS";
    private static final String ABSMAX = "ABSMAX";
    private static final String PREFS = "PREFS";
    private int absProgress;
    private int absMax;
    private EditText absMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        absMRV = findViewById(R.id.setmaxet);
        TextView currentabsMax = findViewById(R.id.current_max);
        TextView currentabsVolume = findViewById(R.id.current_volume);
        String absProgressTxt = Integer.toString(sp.getInt(ABSPROGRESS, 0) / 10);
        String absMaxTxt = Integer.toString(sp.getInt(ABSMAX, 160) / 10);
        currentabsMax.append(absMaxTxt);
        currentabsVolume.append(absProgressTxt);


        Button absReset = findViewById(R.id.absresetvolume);
        absReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                absProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(ABSPROGRESS, absProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetabsMax = findViewById(R.id.absresetmax);
        resetabsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                absMax = 160;
                editor.putInt(ABSMAX, absMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setabsMax = findViewById(R.id.setabsmax);
        setabsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(absMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setabsMax = findViewById(R.id.setmaxet);
                    absMax = Integer.parseInt(setabsMax.getText().toString());
                    absMax = absMax * 10;
                    editor.putInt(ABSMAX, absMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        absImageAdapter adapter = new absImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}