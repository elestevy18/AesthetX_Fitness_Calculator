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

public class RotatorCuff extends AppCompatActivity {
    public static final String ROTATORCUFFPROGRESS = "ROTATORCUFFPROGRESS";
    public static final String ROTATORCUFFMAX = "ROTATORCUFFMAX";
    public static final String PREFS = "PREFS";
    Button rotatorCuffReset;
    int rotatorCuffProgress;
    String rotatorCuffProgressTxt;
    Button setRotatorCuffMax;
    Button resetRotatorCuffMax;
    int rotatorCuffMax;
    String rotatorCuffMaxTxt;
    TextView currentRotatorCuffVolume;
    TextView currentRotatorCuffMax;
    EditText rotatorCuffMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotatorcuff);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        rotatorCuffMRV = findViewById(R.id.setmaxet);
        currentRotatorCuffMax = findViewById(R.id.current_max);
        currentRotatorCuffVolume = findViewById(R.id.current_volume);
        rotatorCuffProgressTxt =  Integer.toString(sp.getInt(ROTATORCUFFPROGRESS, 0)/10);
        rotatorCuffMaxTxt = Integer.toString(sp.getInt(ROTATORCUFFMAX, 120)/10);
        currentRotatorCuffMax.append(rotatorCuffMaxTxt);
        currentRotatorCuffVolume.append(rotatorCuffProgressTxt);


        rotatorCuffReset = findViewById(R.id.rotatorCuffresetvolume);
        rotatorCuffReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotatorCuffProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(ROTATORCUFFPROGRESS, rotatorCuffProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetRotatorCuffMax = findViewById(R.id.rotatorCuffresetmax);
        resetRotatorCuffMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                rotatorCuffMax = 120;
                editor.putInt(ROTATORCUFFMAX, rotatorCuffMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setRotatorCuffMax= findViewById(R.id.setrotatorCuffmax);
        setRotatorCuffMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(rotatorCuffMRV.getText())){
                    displayToast();

                }else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setRotatorCuffMax = findViewById(R.id.setmaxet);
                    rotatorCuffMax = Integer.parseInt(setRotatorCuffMax.getText().toString());
                    rotatorCuffMax = rotatorCuffMax * 10;
                    editor.putInt(ROTATORCUFFMAX, rotatorCuffMax);
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
