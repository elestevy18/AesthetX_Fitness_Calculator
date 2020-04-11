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


public class UlnarForearm extends AppCompatActivity {
    public static final String ULNARFOREARMPROGRESS = "ULNARFOREARMPROGRESS";
    public static final String ULNARFOREARMMAX = "ULNARFOREARMMAX";
    public static final String PREFS = "PREFS";
    Button ulnarForearmReset;
    int ulnarForearmProgress;
    String ulnarForearmProgressTxt;
    Button setulnarForearmMax;
    Button resetulnarForearmMax;
    int ulnarForearmMax;
    String ulnarForearmMaxTxt;
    TextView currentulnarForearmVolume;
    TextView currentulnarForearmMax;
    EditText ulnarForearmMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulnarforearms);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        ulnarForearmMRV = findViewById(R.id.setmaxet);
        currentulnarForearmMax = findViewById(R.id.current_max);
        currentulnarForearmVolume = findViewById(R.id.current_volume);
        ulnarForearmProgressTxt = Integer.toString(sp.getInt(ULNARFOREARMPROGRESS, 0) / 10);
        ulnarForearmMaxTxt = Integer.toString(sp.getInt(ULNARFOREARMMAX, 100) / 10);
        currentulnarForearmMax.append(ulnarForearmMaxTxt);
        currentulnarForearmVolume.append(ulnarForearmProgressTxt);


        ulnarForearmReset = findViewById(R.id.ulnarForearmresetvolume);
        ulnarForearmReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulnarForearmProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(ULNARFOREARMPROGRESS, ulnarForearmProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetulnarForearmMax = findViewById(R.id.ulnarForearmresetmax);
        resetulnarForearmMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                ulnarForearmMax = 60;
                editor.putInt(ULNARFOREARMMAX, ulnarForearmMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setulnarForearmMax = findViewById(R.id.setulnarForearmmax);
        setulnarForearmMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(ulnarForearmMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setulnarForearmMax = findViewById(R.id.setmaxet);
                    ulnarForearmMax = Integer.parseInt(setulnarForearmMax.getText().toString());
                    ulnarForearmMax = ulnarForearmMax * 10;
                    editor.putInt(ULNARFOREARMMAX, ulnarForearmMax);
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