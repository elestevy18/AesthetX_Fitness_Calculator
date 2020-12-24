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

import com.AesthetX.aesthetx.Classes.Adapters.neckImageAdapter;
import com.AesthetX.aesthetx.Classes.Constants;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;
import com.example.scifit.R;

public class Neck extends AppCompatActivity {
    private static final String NECKPROGRESS = "NECKPROGRESS";
    private static final String NECKMAX = "NECKMAX";
    private static final String PREFS = Constants.PREFS;
    private int neckProgress;
    private int neckMax;
    private EditText neckMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neck);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        neckMRV = findViewById(R.id.setmaxet);
        TextView currentneckMax = findViewById(R.id.current_max);
        TextView currentneckVolume = findViewById(R.id.current_volume);
        String neckProgressTxt = Integer.toString(sp.getInt(NECKPROGRESS, 0) / 10);
        String neckMaxTxt = Integer.toString(sp.getInt(NECKMAX, 100) / 10);
        currentneckMax.append(neckMaxTxt);
        currentneckVolume.append(neckProgressTxt);


        Button neckReset = findViewById(R.id.neckresetvolume);
        neckReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                neckProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(NECKPROGRESS, neckProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetneckMax = findViewById(R.id.neckresetmax);
        resetneckMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                neckMax = 100;
                editor.putInt(NECKMAX, neckMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setneckMax = findViewById(R.id.setneckmax);
        setneckMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(neckMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setneckMax = findViewById(R.id.setmaxet);
                    neckMax = Integer.parseInt(setneckMax.getText().toString());
                    neckMax = neckMax * 10;
                    editor.putInt(NECKMAX, neckMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });
        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        neckImageAdapter adapter = new neckImageAdapter(this);
        viewPager.setAdapter(adapter);

    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}
