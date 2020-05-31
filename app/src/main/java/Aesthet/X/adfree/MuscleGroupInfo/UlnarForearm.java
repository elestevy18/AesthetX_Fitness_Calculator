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

import Aesthet.X.adfree.Classes.Adapters.ulnarImageAdapter;
import Aesthet.X.adfree.DashBoardTabs.Dashboards;


public class UlnarForearm extends AppCompatActivity {
    private static final String ULNARFOREARMPROGRESS = "ULNARFOREARMPROGRESS";
    private static final String ULNARFOREARMMAX = "ULNARFOREARMMAX";
    private static final String PREFS = "PREFS";
    private int ulnarForearmProgress;
    private int ulnarForearmMax;
    private EditText ulnarForearmMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulnarforearms);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        ulnarForearmMRV = findViewById(R.id.setmaxet);
        TextView currentulnarForearmMax = findViewById(R.id.current_max);
        TextView currentulnarForearmVolume = findViewById(R.id.current_volume);
        String ulnarForearmProgressTxt = Integer.toString(sp.getInt(ULNARFOREARMPROGRESS, 0) / 10);
        String ulnarForearmMaxTxt = Integer.toString(sp.getInt(ULNARFOREARMMAX, 100) / 10);
        currentulnarForearmMax.append(ulnarForearmMaxTxt);
        currentulnarForearmVolume.append(ulnarForearmProgressTxt);


        Button ulnarForearmReset = findViewById(R.id.ulnarforearmresetvolume);
        ulnarForearmReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ulnarForearmProgress = 0;
                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(ULNARFOREARMPROGRESS, ulnarForearmProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetulnarForearmMax = findViewById(R.id.ulnarforearmresetmax);
        resetulnarForearmMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                ulnarForearmMax = 60;
                editor.putInt(ULNARFOREARMMAX, ulnarForearmMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setulnarForearmMax = findViewById(R.id.setulnarforearmmax);
        setulnarForearmMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(ulnarForearmMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setulnarForearmMax = findViewById(R.id.setmaxet);
                    ulnarForearmMax = Integer.parseInt(setulnarForearmMax.getText().toString());
                    ulnarForearmMax = ulnarForearmMax * 10;
                    editor.putInt(ULNARFOREARMMAX, ulnarForearmMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        ulnarImageAdapter adapter = new ulnarImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}