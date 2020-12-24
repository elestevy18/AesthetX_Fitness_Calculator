package com.AesthetX.aesthetx.Classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;
import com.example.scifit.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StudentPromo extends AppCompatActivity {
    RadioGroup year;
    Button submit;
    private RadioButton freshman, sophomore, junior, senior;
    String yearText;

    SharedPreferences.Editor editor;
    SharedPreferences preferences;
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String EXP_DATE = "com.example.application.scifit.expdate";
    private static final String HSPROMO = "com.example.application.scifit.hspromo";
    Date expDate;
    EditText promocodein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_promo);
        //Radiogroup and butto
        //year = findViewById(R.id.year);
        submit = findViewById(R.id.submit);
        //radio buttons
        freshman =findViewById(R.id.freshman);
        sophomore =findViewById(R.id.sophomore);
        junior =findViewById(R.id.junior);
        senior =findViewById(R.id.senior);
        promocodein = findViewById(R.id.promocodein);

        preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        editor = preferences.edit();


        //Time of input


        String currentTime = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        Log.d("timeStamp", currentTime);

     //Logic when a radio is clicked: deselect the rest
        freshman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                final Calendar cal = Calendar.getInstance();
                Date today = cal.getTime();
                    cal.add(Calendar.YEAR, 4); // to get previous year add -1
                    Date expDate = cal.getTime();
                    editor.putLong(EXP_DATE, expDate.getTime());
                editor.apply();
                    sophomore.setChecked(false);
                    junior.setChecked(false);
                    senior.setChecked(false);
                    yearText="freshman";

            }
        });

        sophomore.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                final Calendar cal = Calendar.getInstance();
                Date today = cal.getTime();
                    cal.add(Calendar.YEAR, 3); // to get previous year add -1
                    expDate = cal.getTime();
                    editor.putLong(EXP_DATE, expDate.getTime());
                editor.apply();
                    freshman.setChecked(false);
                    junior.setChecked(false);
                    senior.setChecked(false);
                    yearText="sophomore";



            }
        });

        junior.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                final Calendar cal = Calendar.getInstance();
                Date today = cal.getTime();
                    cal.add(Calendar.YEAR, 2); // to get previous year add -1
                    Date expDate = cal.getTime();
                    editor.putLong(EXP_DATE, expDate.getTime());
                editor.apply();
                    sophomore.setChecked(false);
                    freshman.setChecked(false);
                    senior.setChecked(false);
                    yearText="junior";


            }
        });

        senior.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                final Calendar cal = Calendar.getInstance();

                    cal.add(Calendar.YEAR, 1); // to get previous year add -1
                    Date expDate = cal.getTime();
                    editor.putLong(EXP_DATE, expDate.getTime());
                editor.apply();
                    sophomore.setChecked(false);
                    junior.setChecked(false);
                    freshman.setChecked(false);
                    yearText="senior";


            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String promocode = promocodein.getText().toString();
                if (promocode.contains("ax20")){
                    if (freshman.isChecked()|| sophomore.isChecked() || junior.isChecked() || senior.isChecked()){
                        long millis = preferences.getLong(EXP_DATE, 0L);
                        Date theDate = new Date(millis);
                        Toast.makeText(getBaseContext(), String.valueOf(theDate),Toast.LENGTH_SHORT).show();
                        editor.putBoolean(HSPROMO, true).apply();
                        Intent intent = new Intent(getBaseContext(), Dashboards.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getBaseContext(), "Please select your year",Toast.LENGTH_SHORT).show();
                    }

                } else{
                    Toast.makeText(getBaseContext(), "Enter valid promo code",Toast.LENGTH_SHORT).show();
                }



            //    int selectedId = year.getCheckedRadioButtonId();
//                radioYearButton = findViewById(selectedId);
//                yearText = (radioYearButton.getText()).toString();
//                Toast.makeText(getBaseContext(), radioYearButton.getText(),Toast.LENGTH_SHORT).show();
//                try {
//                    if (yearText.equals("Freshman")){
//
//                    }else if (yearText.equals("Sophomore")){
//
//                    } else if (yearText.equals("Junior")){
//
//                    } else if (yearText.equals("Senior")){
//
//                    } else{
//                        Toast.makeText(getBaseContext(), "Please select your year",Toast.LENGTH_SHORT).show();
//                    }
//                } catch (Exception e) {
//
//                    Toast.makeText(getBaseContext(), "Please select your year",Toast.LENGTH_SHORT).show();
//                }

            }
        });
    }
}