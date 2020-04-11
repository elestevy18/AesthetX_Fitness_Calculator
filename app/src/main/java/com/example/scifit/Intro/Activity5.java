package com.example.scifit.Intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

public class Activity5 extends AppCompatActivity {

    public static final String EXTRA_EXPERIENCE = "com.example.application.scifit.EXPERIENCE";
    public static final String EXTRA_BODYWEIGHT_3 = "com.example.application.scifit.EXTRA_BODYWEIGHT_3";
    public static final String EXTRA_HEIGHT_FEET_2= "com.example.application.scifit.EXTRA_ FEET_2";
    public static final String EXTRA_HEIGHT_INCHES_2 = "com.example.application.scifit.EXTRA_ INCHES_2";
    private EditText experience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_five);

        //DAta prayers
        Intent intent = getIntent();
        final float bodyweight = intent.getFloatExtra(Activity4.EXTRA_BODYWEIGHT_2, 0);
        final float heightFeet = intent.getFloatExtra(Activity4.EXTRA_HEIGHT_FEET, 0);
        final float heightInches = intent.getFloatExtra(Activity4.EXTRA_HEIGHT_INCHES, 0);


        //initialize Edit Text and button
        experience = findViewById(R.id.ExperienceInput);
        final Button nextbutton5 = findViewById(R.id.nextbutton5);
        experience.setOnEditorActionListener(editorListener);


        nextbutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(experience.getText())){
                    displayToast();
                } else{
                    openActivity6(bodyweight, heightFeet, heightInches);
                }
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        experience.requestFocus();

        experience.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                InputMethodManager keyboard = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(experience, 0);
            }
        },300); //use 300 to make it run when coming back from lock screen

    }
    //Method to next activity

    private void displayToast(){
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

    private void openActivity6(float  bodyweight, float heightFeet, float heightInches){

        EditText heightInputFeet = (EditText) findViewById(R.id.ExperienceInput);
        float experience = Float.parseFloat(heightInputFeet.getText().toString());


        Intent intent = new Intent(this, Activity6.class);

        intent.putExtra(EXTRA_EXPERIENCE, experience);
        intent.putExtra(EXTRA_BODYWEIGHT_3, bodyweight);
        intent.putExtra(EXTRA_HEIGHT_FEET_2, heightFeet);
        intent.putExtra(EXTRA_HEIGHT_INCHES_2, heightInches);
        startActivity(intent);
    }
    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) { ;
                Button nextbutton5 = findViewById(R.id.nextbutton5);
                nextbutton5.performClick();
                nextbutton5.setPressed(true);
                nextbutton5.invalidate();
                nextbutton5.setPressed(false);
                nextbutton5.invalidate();
                return true;
            }
            return false;
        }
    };




}