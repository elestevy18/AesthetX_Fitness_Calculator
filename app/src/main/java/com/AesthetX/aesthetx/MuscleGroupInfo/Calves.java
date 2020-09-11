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

import com.AesthetX.aesthetx.Classes.Adapters.calvesImageAdapter;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;


public class Calves extends AppCompatActivity {
    private static final String CALVESPROGRESS = "CALVESPROGRESS";
    private static final String CALVESMAX = "CALVESMAX";
    private static final String PREFS = "PREFS";
    private int calvesProgress;
    private int calvesMax;
    private EditText calvesMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calves);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        calvesMRV = findViewById(R.id.setmaxet);
        TextView currentcalvesMax = findViewById(R.id.current_max);
        TextView currentcalvesVolume = findViewById(R.id.current_volume);
        String calvesProgressTxt = Integer.toString(sp.getInt(CALVESPROGRESS, 0) / 10);
        String calvesMaxTxt = Integer.toString(sp.getInt(CALVESMAX, 120) / 10);
        currentcalvesMax.append(calvesMaxTxt);
        currentcalvesVolume.append(calvesProgressTxt);


        Button calvesReset = findViewById(R.id.calvesresetvolume);
        calvesReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calvesProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(CALVESPROGRESS, calvesProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetcalvesMax = findViewById(R.id.calvesresetmax);
        resetcalvesMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                calvesMax = 120;
                editor.putInt(CALVESMAX, calvesMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setcalvesMax = findViewById(R.id.setcalvesmax);
        setcalvesMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(calvesMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setcalvesMax = findViewById(R.id.setmaxet);
                    calvesMax = Integer.parseInt(setcalvesMax.getText().toString());
                    calvesMax = calvesMax * 10;
                    editor.putInt(CALVESMAX, calvesMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        calvesImageAdapter adapter = new calvesImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}