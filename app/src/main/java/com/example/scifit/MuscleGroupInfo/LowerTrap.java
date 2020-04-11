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


public class LowerTrap extends AppCompatActivity {
    public static final String LOWERTRAPPROGRESS = "LOWERTRAPPROGRESS";
    public static final String LOWERTRAPMAX = "LOWERTRAPMAX";
    public static final String PREFS = "PREFS";
    Button lowerTrapReset;
    int lowerTrapProgress;
    String lowerTrapProgressTxt;
    Button setlowerTrapMax;
    Button resetlowerTrapMax;
    int lowerTrapMax;
    String lowerTrapMaxTxt;
    TextView currentlowerTrapVolume;
    TextView currentlowerTrapMax;
    EditText lowerTrapMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_trap);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        lowerTrapMRV = findViewById(R.id.setmaxet);
        currentlowerTrapMax = findViewById(R.id.current_max);
        currentlowerTrapVolume = findViewById(R.id.current_volume);
        lowerTrapProgressTxt =  Integer.toString(sp.getInt(LOWERTRAPPROGRESS, 0)/10);
        lowerTrapMaxTxt = Integer.toString(sp.getInt(LOWERTRAPMAX, 120)/10);
        currentlowerTrapMax.append(lowerTrapMaxTxt);
        currentlowerTrapVolume.append(lowerTrapProgressTxt);


        lowerTrapReset = findViewById(R.id.lowertrapresetvolume);
        lowerTrapReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowerTrapProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(LOWERTRAPPROGRESS, lowerTrapProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetlowerTrapMax = findViewById(R.id.lowertrapresetmax);
        resetlowerTrapMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                lowerTrapMax = 120;
                editor.putInt(LOWERTRAPMAX, lowerTrapMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setlowerTrapMax= findViewById(R.id.setlowertrapmax);
        setlowerTrapMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(lowerTrapMRV.getText())){
                    displayToast();

                }else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setlowerTrapMax = findViewById(R.id.setmaxet);
                    lowerTrapMax = Integer.parseInt(setlowerTrapMax.getText().toString());
                    lowerTrapMax = lowerTrapMax * 10;
                    editor.putInt(LOWERTRAPMAX, lowerTrapMax);
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
