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

public class PosteriorDeltoid extends AppCompatActivity {
    public static final String POSTERIORDELTOIDPROGRESS = "POSTERIORDELTOIDPROGRESS";
    public static final String POSTERIORDELTOIDMAX = "POSTERIORDELTOIDMAX";
    public static final String PREFS = "PREFS";
    Button posteriorDeltoidReset;
    int posteriorDeltoidProgress;
    String posteriorDeltoidProgressTxt;
    Button setposteriorDeltoidMax;
    Button resetposteriorDeltoidMax;
    int posteriorDeltoidMax;
    String posteriorDeltoidMaxTxt;
    TextView currentposteriorDeltoidVolume;
    TextView currentposteriorDeltoidMax;
    EditText posteriorDeltoidMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posterior_deltoid);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        posteriorDeltoidMRV = findViewById(R.id.setmaxet);
        currentposteriorDeltoidMax = findViewById(R.id.current_max);
        currentposteriorDeltoidVolume = findViewById(R.id.current_volume);
        posteriorDeltoidProgressTxt =  Integer.toString(sp.getInt(POSTERIORDELTOIDPROGRESS, 0)/10);
        posteriorDeltoidMaxTxt = Integer.toString(sp.getInt(POSTERIORDELTOIDMAX, 160)/10);
        currentposteriorDeltoidMax.append(posteriorDeltoidMaxTxt);
        currentposteriorDeltoidVolume.append(posteriorDeltoidProgressTxt);


        posteriorDeltoidReset = findViewById(R.id.posteriorDeltoidresetvolume);
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

        resetposteriorDeltoidMax = findViewById(R.id.posteriorDeltoidresetmax);
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

        setposteriorDeltoidMax= findViewById(R.id.setposteriorDeltoidmax);
        setposteriorDeltoidMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(posteriorDeltoidMRV.getText())){
                    displayToast();

                }else {
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



    }
    private void displayToast(){
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}
