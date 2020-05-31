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

import Aesthet.X.adfree.Classes.Adapters.bicepsImageAdapter;
import Aesthet.X.adfree.DashBoardTabs.Dashboards;


public class Biceps extends AppCompatActivity {
    private static final String BICEPSPROGRESS = "BICEPSPROGRESS";
    private static final String BICEPSMAX = "BICEPSMAX";
    private static final String PREFS = "PREFS";
    private int bicepsProgress;
    private int bicepsMax;
    private EditText bicepsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        bicepsMRV = findViewById(R.id.setmaxet);
        TextView currentbicepsMax = findViewById(R.id.current_max);
        TextView currentbicepsVolume = findViewById(R.id.current_volume);
        String bicepsProgressTxt = Integer.toString(sp.getInt(BICEPSPROGRESS, 0) / 10);
        String bicepsMaxTxt = Integer.toString(sp.getInt(BICEPSMAX, 140) / 10);
        currentbicepsMax.append(bicepsMaxTxt);
        currentbicepsVolume.append(bicepsProgressTxt);


        Button bicepsReset = findViewById(R.id.bicepsresetvolume);
        bicepsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bicepsProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(BICEPSPROGRESS, bicepsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetbicepsMax = findViewById(R.id.bicepsresetmax);
        resetbicepsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                bicepsMax = 140;
                editor.putInt(BICEPSMAX, bicepsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setbicepsMax = findViewById(R.id.setbicepsmax);
        setbicepsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(bicepsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setbicepsMax = findViewById(R.id.setmaxet);
                    bicepsMax = Integer.parseInt(setbicepsMax.getText().toString());
                    bicepsMax = bicepsMax * 10;
                    editor.putInt(BICEPSMAX, bicepsMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        bicepsImageAdapter adapter = new bicepsImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}