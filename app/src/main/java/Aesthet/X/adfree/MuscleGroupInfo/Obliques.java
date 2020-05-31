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

import Aesthet.X.adfree.Classes.Adapters.obliquesImageAdapter;
import Aesthet.X.adfree.DashBoardTabs.Dashboards;

import static com.example.scifit.R.layout.activity_obliques;


public class Obliques extends AppCompatActivity {
    private static final String OBLIQUESPROGRESS = "OBLIQUESPROGRESS";
    private static final String OBLIQUESMAX = "OBLIQUESMAX";
    private static final String PREFS = "PREFS";
    private int obliquesProgress;
    private int obliquesMax;
    private EditText obliquesMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_obliques);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        obliquesMRV = findViewById(R.id.setmaxet);
        TextView currentobliquesMax = findViewById(R.id.current_max);
        TextView currentobliquesVolume = findViewById(R.id.current_volume);
        String obliquesProgressTxt = Integer.toString(sp.getInt(OBLIQUESPROGRESS, 0) / 10);
        String obliquesMaxTxt = Integer.toString(sp.getInt(OBLIQUESMAX, 160) / 10);
        currentobliquesMax.append(obliquesMaxTxt);
        currentobliquesVolume.append(obliquesProgressTxt);


        Button obliquesReset = findViewById(R.id.obliquesresetvolume);
        obliquesReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obliquesProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(OBLIQUESPROGRESS, obliquesProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resetobliquesMax = findViewById(R.id.obliquesresetmax);
        resetobliquesMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                obliquesMax = 160;
                editor.putInt(OBLIQUESMAX, obliquesMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button setobliquesMax = findViewById(R.id.setobliquesmax);
        setobliquesMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(obliquesMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText setobliquesMax = findViewById(R.id.setmaxet);
                    obliquesMax = Integer.parseInt(setobliquesMax.getText().toString());
                    obliquesMax = obliquesMax * 10;
                    editor.putInt(OBLIQUESMAX, obliquesMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        obliquesImageAdapter adapter = new obliquesImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}