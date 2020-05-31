package Aesthet.X.adfree.MuscleGroupInfo;

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

import Aesthet.X.adfree.Classes.Adapters.tricepsImageAdapter;
import Aesthet.X.adfree.DashBoardTabs.Dashboards;


public class Triceps extends AppCompatActivity {
    private static final String TricepsPROGRESS = "TricepsPROGRESS";
    private static final String TricepsMAX = "TricepsMAX";
    private static final String PREFS = "PREFS";
    private int TricepsProgress;
    private int TricepsMax;
    private EditText TricepsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triceps);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        TricepsMRV = findViewById(R.id.setmaxet);
        TextView currentTricepsMax = findViewById(R.id.current_max);
        TextView currentTricepsVolume = findViewById(R.id.current_volume);
        String TricepsProgressTxt = Integer.toString(sp.getInt(TricepsPROGRESS, 0) / 10);
        String TricepsMaxTxt = Integer.toString(sp.getInt(TricepsMAX, 100) / 10);
        currentTricepsMax.append(TricepsMaxTxt);
        currentTricepsVolume.append(TricepsProgressTxt);


        Button TricepsReset = findViewById(R.id.tricepsresetvolume);
        TricepsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TricepsProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(TricepsPROGRESS, TricepsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetTricepsMax = findViewById(R.id.tricepsresetmax);
        resetTricepsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                TricepsMax = 100;
                editor.putInt(TricepsMAX, TricepsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setTricepsMax = findViewById(R.id.settricepsmax);
        setTricepsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(TricepsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setTricepsMax = findViewById(R.id.setmaxet);
                    TricepsMax = Integer.parseInt(setTricepsMax.getText().toString());
                    TricepsMax = TricepsMax * 10;
                    editor.putInt(TricepsMAX, TricepsMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        tricepsImageAdapter adapter = new tricepsImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}