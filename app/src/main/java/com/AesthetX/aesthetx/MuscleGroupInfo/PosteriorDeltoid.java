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

import com.AesthetX.aesthetx.Classes.Adapters.posteriorDeltoidImageAdapter;
import com.AesthetX.aesthetx.Classes.Constants;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;
import com.example.scifit.R;

public class PosteriorDeltoid extends AppCompatActivity {
    private static final String POSTERIORDELTOIDPROGRESS = "POSTERIORDELTOIDPROGRESS";
    private static final String POSTERIORDELTOIDMAX = "POSTERIORDELTOIDMAX";
    private static final String PREFS = Constants.PREFS;
    private int posteriorDeltoidProgress;
    private int posteriorDeltoidMax;
    private EditText posteriorDeltoidMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posterior_deltoid);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        posteriorDeltoidMRV = findViewById(R.id.setmaxet);
        TextView currentposteriorDeltoidMax = findViewById(R.id.current_max);
        TextView currentposteriorDeltoidVolume = findViewById(R.id.current_volume);
        String posteriorDeltoidProgressTxt = Integer.toString(sp.getInt(POSTERIORDELTOIDPROGRESS, 0) / 10);
        String posteriorDeltoidMaxTxt = Integer.toString(sp.getInt(POSTERIORDELTOIDMAX, 160) / 10);
        currentposteriorDeltoidMax.append(posteriorDeltoidMaxTxt);
        currentposteriorDeltoidVolume.append(posteriorDeltoidProgressTxt);


        Button posteriorDeltoidReset = findViewById(R.id.posteriorDeltoidresetvolume);
        posteriorDeltoidReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posteriorDeltoidProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(POSTERIORDELTOIDPROGRESS, posteriorDeltoidProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetposteriorDeltoidMax = findViewById(R.id.posteriorDeltoidresetmax);
        resetposteriorDeltoidMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                posteriorDeltoidMax = 160;
                editor.putInt(POSTERIORDELTOIDMAX, posteriorDeltoidMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setposteriorDeltoidMax = findViewById(R.id.setposteriorDeltoidmax);
        setposteriorDeltoidMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(posteriorDeltoidMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setposteriorDeltoidMax = findViewById(R.id.setmaxet);
                    posteriorDeltoidMax = Integer.parseInt(setposteriorDeltoidMax.getText().toString());
                    posteriorDeltoidMax = posteriorDeltoidMax * 10;
                    editor.putInt(POSTERIORDELTOIDMAX, posteriorDeltoidMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        posteriorDeltoidImageAdapter adapter = new posteriorDeltoidImageAdapter(this);
        viewPager.setAdapter(adapter);

    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}
