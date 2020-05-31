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

import Aesthet.X.adfree.Classes.Adapters.quadsImageAdapter;
import Aesthet.X.adfree.DashBoardTabs.Dashboards;


public class
Quads extends AppCompatActivity {
    private static final String QUADSPROGRESS = "QUADSPROGRESS";
    private static final String QUADSMAX = "QUADSMAX";
    private static final String PREFS = "PREFS";
    private int quadsProgress;
    private int quadsMax;
    private EditText quadsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quads);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        quadsMRV = findViewById(R.id.setmaxet);
        TextView currentquadsMax = findViewById(R.id.current_max);
        TextView currentquadsVolume = findViewById(R.id.current_volume);
        String quadsProgressTxt = Integer.toString(sp.getInt(QUADSPROGRESS, 0) / 10);
        String quadsMaxTxt = Integer.toString(sp.getInt(QUADSMAX, 120) / 10);
        currentquadsMax.append(quadsMaxTxt);
        currentquadsVolume.append(quadsProgressTxt);


        Button quadsReset = findViewById(R.id.quadsresetvolume);
        quadsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quadsProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(QUADSPROGRESS, quadsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetquadsMax = findViewById(R.id.quadsresetmax);
        resetquadsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                quadsMax = 120;
                editor.putInt(QUADSMAX, quadsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setquadsMax = findViewById(R.id.setquadsmax);
        setquadsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(quadsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setquadsMax = findViewById(R.id.setmaxet);
                    quadsMax = Integer.parseInt(setquadsMax.getText().toString());
                    quadsMax = quadsMax * 10;
                    editor.putInt(QUADSMAX, quadsMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        quadsImageAdapter adapter = new quadsImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}