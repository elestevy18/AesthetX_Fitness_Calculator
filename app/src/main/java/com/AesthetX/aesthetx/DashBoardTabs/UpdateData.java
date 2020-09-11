package com.AesthetX.aesthetx.DashBoardTabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

import java.text.DecimalFormat;

import com.AesthetX.aesthetx.Classes.AdManager;

public class UpdateData extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String EXTRA_BODYWEIGHT = "com.example.application.scifit.EXTRA_ BODYWEIGHT";
    private static final String EXTRA_HEIGHT_FEET = "com.example.application.scifit.EXTRA_ FEET";
    private static final String EXTRA_HEIGHT_INCHES = "com.example.application.scifit.EXTRA_ INCHES";
    private static final String EXTRA_COMPOSITION = "com.example.application.scifit.COMPOSITION";
    private static final String EXTRA_EXPERIENCE = "com.example.application.scifit";
    private static final String ACTIVITYMULTIPLIER = "ACTIVITYMULTIPLIER";
    private static final String AGE = "age";
    private static final String MALE = "male";
    private static final String FEMALE = "female";
    private static DecimalFormat df = new DecimalFormat("0.00");
    Spinner spinner1;
    RadioButton radioSelecteda;
    boolean maletrue;
    boolean femaletrue;
    private EditText bodyweightin;
    private EditText heightfeet;
    private EditText heightinches;
    private EditText experiencein;
    private EditText compositionin;
    private EditText agein;
    private float activityMultiplier;
    private boolean male;
    private boolean female;
    private float bodyweight;
    private float heightFeet;
    private float heightInches;
    private float experience;
    private float composition;
    private float age;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);


        //Declarations
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        bodyweight = sharedPreferences.getFloat(EXTRA_BODYWEIGHT, 0);
        heightFeet = sharedPreferences.getFloat(EXTRA_HEIGHT_FEET, 0);
        heightInches = sharedPreferences.getFloat(EXTRA_HEIGHT_INCHES, 0);
        experience = sharedPreferences.getFloat(EXTRA_EXPERIENCE, 0);
        composition = sharedPreferences.getFloat(EXTRA_COMPOSITION, 0);
        age = sharedPreferences.getFloat(AGE, 0);
        activityMultiplier = sharedPreferences.getFloat(ACTIVITYMULTIPLIER, 0);
        male = sharedPreferences.getBoolean(MALE, false);
        female = sharedPreferences.getBoolean(FEMALE, false);

        if (female) {
            male = false;
        }

        bodyweightin = findViewById(R.id.bodyweightin);
        heightfeet = findViewById(R.id.heightfeet);
        heightinches = findViewById(R.id.heightinches);
        experiencein = findViewById(R.id.experiencein);
        compositionin = findViewById(R.id.compositionin);
        agein = findViewById(R.id.agein);

        String bodyweighttxt = Float.toString(bodyweight);
        String heightFeettxt = Float.toString(heightFeet);
        String heightInchestxt = Float.toString(heightInches);
        String experiencetxt = Float.toString(experience);
        String compositiontxt = Float.toString(composition);
        String agetxt = Float.toString(age);

        bodyweightin.setHint(bodyweighttxt);
        heightfeet.setHint(heightFeettxt);
        heightinches.setHint(heightInchestxt);
        experiencein.setHint(experiencetxt);
        compositionin.setHint(compositiontxt);
        agein.setHint(agetxt);
// VIEW LOGIC
        Spinner spinner = findViewById(R.id.spinner1);
        Integer selection;
        if (activityMultiplier >= 1.2 && activityMultiplier < 1.375) {
            selection = 0;
        } else if (activityMultiplier >= 1.375 && activityMultiplier < 1.55) {
            selection = 1;
        } else if (activityMultiplier >= 1.55 && activityMultiplier < 1.725) {
            selection = 2;
        } else if (activityMultiplier >= 1.725 && activityMultiplier < 1.95) {
            selection = 3;
        } else if (activityMultiplier >= 1.95) {
            selection = 4;
        } else {
            selection = 0;
        }

        //OPEN SPINNER TO USER SELECTION
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activity, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        String text = Integer.toString(selection);

        spinner.setSelection(selection);

        //RADIO BUTTON LOGIC
        RadioGroup gender = findViewById(R.id.gender);
        RadioButton maleradio = findViewById(R.id.radio_male);
        RadioButton femaleradio = findViewById(R.id.radio_female);
        if (male) {
            maleradio.setChecked(true);
        } else {
            femaleradio.setChecked(true);
        }


        //BUTTONS
        Button back = findViewById(R.id.back);
        Button save = findViewById(R.id.save);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Dashboards.class);
                startActivity(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String bw = bodyweightin.getText().toString();
                if (!bw.equals("")) {
                    bodyweight = Float.parseFloat(bw);
                    editor.putFloat(EXTRA_BODYWEIGHT, bodyweight);
                }
                String hf = heightfeet.getText().toString();
                if (!hf.equals("")) {
                    heightFeet = Float.parseFloat(hf);
                    editor.putFloat(EXTRA_HEIGHT_FEET, heightFeet);
                }
                String hi = heightinches.getText().toString();
                if (!hi.equals("")) {
                    heightInches = Float.parseFloat(hi);
                    editor.putFloat(EXTRA_HEIGHT_INCHES, heightInches);
                }
                String exp = experiencein.getText().toString();
                if (!exp.equals("")) {
                    experience = Float.parseFloat(exp);
                    editor.putFloat(EXTRA_EXPERIENCE, experience);
                }
                String comp = compositionin.getText().toString();
                if (!comp.equals("")) {
                    composition = Float.parseFloat(comp);
                    editor.putFloat(EXTRA_COMPOSITION, composition);
                }
                String eige = agein.getText().toString();
                if (!eige.equals("")) {
                    age = Float.parseFloat(eige);
                    editor.putFloat(AGE, age);
                }

                editor.putFloat(ACTIVITYMULTIPLIER, activityMultiplier);
                editor.putBoolean(FEMALE, female);
                editor.putBoolean(MALE, male);
                editor.apply();
                if (male) {
                    Intent intent = new Intent(getBaseContext(), UpdateMaleMagicFormula.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getBaseContext(), UpdateFemaleMagicFormula.class);
                    startActivity(intent);
                }


            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                activityMultiplier = (float) 1.2;
                break;
            case 1:
                activityMultiplier = (float) 1.375;
                break;
            case 2:
                activityMultiplier = (float) 1.550;
                break;
            case 3:
                activityMultiplier = (float) 1.725;
                break;
            case 4:
                activityMultiplier = (float) 1.95;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_female:
                if (checked)
                    female = true;
                male = false;
                break;
            case R.id.radio_male:
                if (checked)
                    male = true;
                female = false;
                break;
        }
    }


}
