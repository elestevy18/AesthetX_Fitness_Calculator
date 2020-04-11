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


public class Biceps extends AppCompatActivity {
    public static final String BICEPSPROGRESS = "BICEPSPROGRESS";
    public static final String BICEPSMAX = "BICEPSMAX";
    public static final String PREFS = "PREFS";
    Button bicepsReset;
    int bicepsProgress;
    String bicepsProgressTxt;
    Button setbicepsMax;
    Button resetbicepsMax;
    int bicepsMax;
    String bicepsMaxTxt;
    TextView currentbicepsVolume;
    TextView currentbicepsMax;
    EditText bicepsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        bicepsMRV = findViewById(R.id.setmaxet);
        currentbicepsMax = findViewById(R.id.current_max);
        currentbicepsVolume = findViewById(R.id.current_volume);
        bicepsProgressTxt = Integer.toString(sp.getInt(BICEPSPROGRESS, 0) / 10);
        bicepsMaxTxt = Integer.toString(sp.getInt(BICEPSMAX, 140) / 10);
        currentbicepsMax.append(bicepsMaxTxt);
        currentbicepsVolume.append(bicepsProgressTxt);


        bicepsReset = findViewById(R.id.bicepsresetvolume);
        bicepsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bicepsProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(BICEPSPROGRESS, bicepsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetbicepsMax = findViewById(R.id.bicepsresetmax);
        resetbicepsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                bicepsMax = 140;
                editor.putInt(BICEPSMAX, bicepsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setbicepsMax = findViewById(R.id.setbicepsmax);
        setbicepsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(bicepsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setbicepsMax = findViewById(R.id.setmaxet);
                    bicepsMax = Integer.parseInt(setbicepsMax.getText().toString());
                    bicepsMax = bicepsMax * 10;
                    editor.putInt(BICEPSMAX, bicepsMax);
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