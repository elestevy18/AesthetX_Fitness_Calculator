package com.example.scifit.MuscleGroupInfo;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.scifit.DashBoardTabs.Dashboards;
import com.example.scifit.R;


public class UpperTrap extends AppCompatActivity {
    public static final String UPPERTRAPPROGRESS = "UPPERTRAPPROGRESS";
    public static final String UPPERTRAPMAX = "UPPERTRAPMAX";
    public static final String PREFS = "PREFS";
    Button upperTrapReset;
    int upperTrapProgress;
    String upperTrapProgressTxt;
    Button setupperTrapMax;
    Button resetupperTrapMax;
    int upperTrapMax;
    String upperTrapMaxTxt;
    TextView currentupperTrapVolume;
    TextView currentupperTrapMax;
    EditText upperTrapMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_trap);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        upperTrapMRV = findViewById(R.id.setmaxet);
        currentupperTrapMax = findViewById(R.id.current_max);
        currentupperTrapVolume = findViewById(R.id.current_volume);
        upperTrapProgressTxt =  Integer.toString(sp.getInt(UPPERTRAPPROGRESS, 0)/10);
        upperTrapMaxTxt = Integer.toString(sp.getInt(UPPERTRAPMAX, 120)/10);
        currentupperTrapMax.append(upperTrapMaxTxt);
        currentupperTrapVolume.append(upperTrapProgressTxt);


        upperTrapReset = findViewById(R.id.uppertrapresetvolume);
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

        resetupperTrapMax = findViewById(R.id.uppertrapresetmax);
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

        setupperTrapMax= findViewById(R.id.setuppertrapmax);
        setupperTrapMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(upperTrapMRV.getText())){
                    displayToast();

                }else {
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



    }
    private void displayToast(){
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}
