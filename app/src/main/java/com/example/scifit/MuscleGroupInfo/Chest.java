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


public class Chest extends AppCompatActivity {
    public static final String CHESTPROGRESS = "CHESTPROGRESS";
    public static final String CHESTMAX = "CHESTMAX";
    public static final String PREFS = "PREFS";
    Button chestReset;
    int chestProgress;
    String chestProgressTxt;
    Button setchestMax;
    Button resetchestMax;
    int chestMax;
    String chestMaxTxt;
    TextView currentchestVolume;
    TextView currentchestMax;
    EditText chestMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        chestMRV = findViewById(R.id.setmaxet);
        currentchestMax = findViewById(R.id.current_max);
        currentchestVolume = findViewById(R.id.current_volume);
        chestProgressTxt = Integer.toString(sp.getInt(CHESTPROGRESS, 0) / 10);
        chestMaxTxt = Integer.toString(sp.getInt(CHESTMAX, 120) / 10);
        currentchestMax.append(chestMaxTxt);
        currentchestVolume.append(chestProgressTxt);


        chestReset = findViewById(R.id.chestresetvolume);
        chestReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chestProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(CHESTPROGRESS, chestProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        resetchestMax = findViewById(R.id.chestresetmax);
        resetchestMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                chestMax = 120;
                editor.putInt(CHESTMAX, chestMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        setchestMax = findViewById(R.id.setchestmax);
        setchestMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(chestMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setchestMax = findViewById(R.id.setmaxet);
                    chestMax = Integer.parseInt(setchestMax.getText().toString());
                    chestMax = chestMax * 10;
                    editor.putInt(CHESTMAX, chestMax);
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