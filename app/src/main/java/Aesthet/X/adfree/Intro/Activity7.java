package Aesthet.X.adfree.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;


public class Activity7 extends AppCompatActivity {

    //Create constants for passing data to next activity SEPERATE from importing data below

    private static final String EXTRA_MALE = "com.example.application.scifit.MALE";
    private static final String EXTRA_FEMALE = "com.example.application.scifit.FEMALE";
    private static final String EXTRA_EXPERIENCE_3 = "com.example.application.scifit.EXPERIENCE_3";
    private static final String EXTRA_BODYWEIGHT_5 = "com.example.application.scifit.EXTRA_BODYWEIGHT_5";
    private static final String EXTRA_HEIGHT_FEET_4 = "com.example.application.scifit.EXTRA_ FEET_4";
    private static final String EXTRA_HEIGHT_INCHES_4 = "com.example.application.scifit.EXTRA_ INCHES_4";
    private static final String EXTRA_COMPOSITION_2 = "com.example.application.scifit.COMPOSITION_2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_seven);


        //Retrieve data from previous activity
        Intent intent = getIntent();
        final float bodyweight = intent.getFloatExtra(Activity6.EXTRA_BODYWEIGHT_4, 0);
        final float heightFeet = intent.getFloatExtra(Activity6.EXTRA_HEIGHT_FEET_3, 0);
        final float heightInches = intent.getFloatExtra(Activity6.EXTRA_HEIGHT_INCHES_3, 0);
        final float experience = intent.getFloatExtra(Activity6.EXTRA_EXPERIENCE_2, 0);
        final float composition = intent.getFloatExtra(Activity6.EXTRA_COMPOSITION, 0);


        //Button declerations and assignment of onClickListener
        Button malebutton = findViewById(R.id.malebutton);
        Button femalebutton = findViewById(R.id.femalebutton);


        malebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMagicFormulaMale(bodyweight, heightFeet, heightInches, experience, composition);
            }
        });

        femalebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMagicFormulaFemale(bodyweight, heightFeet, heightInches, experience, composition);
            }
        });

    }

    private void openMagicFormulaMale(float bodyweight, float heightFeet, float heightInches, float experience, float composition) {
        String male = "male";
        Intent intent = new Intent(this, MagicFormulaMale.class);

        intent.putExtra(EXTRA_EXPERIENCE_3, experience);
        intent.putExtra(EXTRA_BODYWEIGHT_5, bodyweight);
        intent.putExtra(EXTRA_HEIGHT_FEET_4, heightFeet);
        intent.putExtra(EXTRA_HEIGHT_INCHES_4, heightInches);
        intent.putExtra(EXTRA_COMPOSITION_2, composition);
        intent.putExtra(EXTRA_MALE, male);
        startActivity(intent);
    }

    private void openMagicFormulaFemale(float bodyweight, float heightFeet, float heightInches, float experience, float composition) {
        String female = "female";
        Intent intent = new Intent(this, MagicFormulaFemale.class);

        intent.putExtra(EXTRA_EXPERIENCE_3, experience);
        intent.putExtra(EXTRA_BODYWEIGHT_5, bodyweight);
        intent.putExtra(EXTRA_HEIGHT_FEET_4, heightFeet);
        intent.putExtra(EXTRA_HEIGHT_INCHES_4, heightInches);
        intent.putExtra(EXTRA_COMPOSITION_2, composition);
        intent.putExtra(EXTRA_FEMALE, female);
        startActivity(intent);
    }
}
