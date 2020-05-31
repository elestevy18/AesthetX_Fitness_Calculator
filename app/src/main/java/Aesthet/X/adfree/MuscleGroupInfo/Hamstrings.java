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

import Aesthet.X.adfree.Classes.Adapters.hamstringsImageAdapter;
import Aesthet.X.adfree.DashBoardTabs.Dashboards;


public class Hamstrings extends AppCompatActivity {
    private static final String HAMSTRINGSPROGRESS = "HAMSTRINGSPROGRESS";
    private static final String HAMSTRINGSMAX = "HAMSTRINGSMAX";
    private static final String PREFS = "PREFS";
    private int hamstringsProgress;
    private int hamstringsMax;
    private EditText hamstringsMRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamstrings);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        hamstringsMRV = findViewById(R.id.setmaxet);
        TextView currenthamstringsMax = findViewById(R.id.current_max);
        TextView currenthamstringsVolume = findViewById(R.id.current_volume);
        String hamstringsProgressTxt = Integer.toString(sp.getInt(HAMSTRINGSPROGRESS, 0) / 10);
        String hamstringsMaxTxt = Integer.toString(sp.getInt(HAMSTRINGSMAX, 100) / 10);
        currenthamstringsMax.append(hamstringsMaxTxt);
        currenthamstringsVolume.append(hamstringsProgressTxt);


        Button hamstringsReset = findViewById(R.id.hamstringsresetvolume);
        hamstringsReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hamstringsProgress = 0;

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(HAMSTRINGSPROGRESS, hamstringsProgress);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });

        Button resethamstringsMax = findViewById(R.id.hamstringsresetmax);
        resethamstringsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                hamstringsMax = 100;
                editor.putInt(HAMSTRINGSMAX, hamstringsMax);
                editor.apply();
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }


        });

        Button sethamstringsMax = findViewById(R.id.sethamstringsmax);
        sethamstringsMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(hamstringsMRV.getText())) {
                    displayToast();

                } else {
                    SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    final EditText sethamstringsMax = findViewById(R.id.setmaxet);
                    hamstringsMax = Integer.parseInt(sethamstringsMax.getText().toString());
                    hamstringsMax = hamstringsMax * 10;
                    editor.putInt(HAMSTRINGSMAX, hamstringsMax);
                    editor.apply();
                    Intent intent = new Intent(v.getContext(), Dashboards.class);
                    startActivity(intent);
                }

            }
        });

        //IMAGES
        ViewPager viewPager = findViewById(R.id.viewPager);
        hamstringsImageAdapter adapter = new hamstringsImageAdapter(this);
        viewPager.setAdapter(adapter);
    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

}