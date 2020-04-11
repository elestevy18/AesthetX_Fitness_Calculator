package com.example.scifit.MuscleGroupInfo;

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

import com.example.scifit.DashBoardTabs.Dashboards;
import com.example.scifit.R;


public class Abs extends AppCompatActivity {
    public static final String ABSPROGRESS = "ABSPROGRESS";
    public static final String ABSMAX = "ABSMAX";
    public static final String PREFS = "PREFS";
    Button absReset;
    int absProgress;
    String absProgressTxt;
    Button setabsMax;
    Button resetabsMax;
    int absMax;
    String absMaxTxt;
    TextView currentabsVolume;
    TextView currentabsMax;
    EditText absMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        absMRV = findViewById(R.id.setmaxet);
        currentabsMax = findViewById(R.id.current_max);
        currentabsVolume = findViewById(R.id.current_volume);
        absProgressTxt = Integer.toString(sp.getInt(ABSPROGRESS, 0) / 10);
        absMaxTxt = Integer.toString(sp.getInt(ABSMAX, 160) / 10);
        currentabsMax.append(absMaxTxt);
        currentabsVolume.append(absProgressTxt);


        absReset = findViewById(R.id.absresetvolume);
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

        resetabsMax = findViewById(R.id.absresetmax);
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

        setabsMax = findViewById(R.id.setabsmax);
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


    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}