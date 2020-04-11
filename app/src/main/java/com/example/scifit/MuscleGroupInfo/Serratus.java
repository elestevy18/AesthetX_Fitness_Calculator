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


public class Serratus extends AppCompatActivity {
    public static final String SERRATUSPROGRESS = "SERRATUSPROGRESS";
    public static final String SERRATUSMAX = "SERRATUSMAX";
    public static final String PREFS = "PREFS";
    Button serratusReset;
    int serratusProgress;
    String serratusProgressTxt;
    Button setserratusMax;
    Button resetserratusMax;
    int serratusMax;
    String serratusMaxTxt;
    TextView currentserratusVolume;
    TextView currentserratusMax;
    EditText serratusMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serratus);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        serratusMRV = findViewById(R.id.setmaxet);
        currentserratusMax = findViewById(R.id.current_max);
        currentserratusVolume = findViewById(R.id.current_volume);
        serratusProgressTxt = Integer.toString(sp.getInt(SERRATUSPROGRESS, 0) / 10);
        serratusMaxTxt = Integer.toString(sp.getInt(SERRATUSMAX, 160) / 10);
        currentserratusMax.append(serratusMaxTxt);
        currentserratusVolume.append(serratusProgressTxt);


        serratusReset = findViewById(R.id.serratusresetvolume);
        serratusReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serratusProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(SERRATUSPROGRESS, serratusProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetserratusMax = findViewById(R.id.serratusresetmax);
        resetserratusMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                serratusMax = 160;
                editor.putInt(SERRATUSMAX, serratusMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setserratusMax = findViewById(R.id.setserratusmax);
        setserratusMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(serratusMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setserratusMax = findViewById(R.id.setmaxet);
                    serratusMax = Integer.parseInt(setserratusMax.getText().toString());
                    serratusMax = serratusMax * 10;
                    editor.putInt(SERRATUSMAX, serratusMax);
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