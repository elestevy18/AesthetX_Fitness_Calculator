package com.example.scifit.DashBoardTabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.scifit.R;

import java.text.DecimalFormat;

public class UpdateData extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private static DecimalFormat df = new DecimalFormat("0.00");
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String EXTRA_BODYWEIGHT = "com.example.application.scifit.EXTRA_ BODYWEIGHT";
    public static final String EXTRA_HEIGHT_FEET= "com.example.application.scifit.EXTRA_ FEET";
    public static final String EXTRA_HEIGHT_INCHES = "com.example.application.scifit.EXTRA_ INCHES";
    public static final String EXTRA_COMPOSITION = "com.example.application.scifit.COMPOSITION";
    public static final String EXTRA_EXPERIENCE = "com.example.application.scifit";
    public static final String ACTIVITYMULTIPLIER = "ACTIVITYMULTIPLIER";
    public static final String AGE = "age";
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    EditText bodyweightin, heightfeet, heightinches, experiencein, compositionin, agein;
    Spinner spinner1;
    RadioButton maleradio, femaleradio;
    Button back, save;
    String bodyweighttxt, heightFeettxt, heightInchestxt, experiencetxt, compositiontxt, agetxt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final float bodyweight = sharedPreferences.getFloat(EXTRA_BODYWEIGHT, 0);
        final float heightFeet = sharedPreferences.getFloat(EXTRA_HEIGHT_FEET, 0);
        final float heightInches = sharedPreferences.getFloat(EXTRA_HEIGHT_INCHES, 0);
        final float experience = sharedPreferences.getFloat(EXTRA_EXPERIENCE, 0);
        final float composition = sharedPreferences.getFloat(EXTRA_COMPOSITION, 0);
        final float age = sharedPreferences.getFloat(AGE, 0);
        final float activityMultiplier = sharedPreferences.getFloat(ACTIVITYMULTIPLIER, 0);
        final boolean male = sharedPreferences.getBoolean(MALE, false);
        final boolean female = sharedPreferences.getBoolean(FEMALE, false);

        if(male) {

        }else {

        }
        bodyweightin = findViewById(R.id.bodyweightin);
        heightfeet = findViewById(R.id.heightfeet);
        heightinches = findViewById(R.id.heightinches);
        experiencein = findViewById(R.id.experiencein);
        compositionin = findViewById(R.id.compositionin);
        agein = findViewById(R.id.agein);

        bodyweighttxt =  Float.toString(bodyweight);
        heightFeettxt =  Float.toString(heightFeet);
        heightInchestxt =  Float.toString(heightInches);
        experiencetxt =  Float.toString(experience);
        compositiontxt =  Float.toString(composition);
        agetxt =  Float.toString(age);

        bodyweightin.setText(bodyweighttxt);
        heightfeet.setText(heightFeettxt);
        heightinches.setText(heightInchestxt);
        experiencein.setText(experiencetxt);
        compositionin.setText(compositiontxt);
        agein.setText(agetxt);

// VIEW LOGIC
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
