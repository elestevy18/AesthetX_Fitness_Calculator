package com.AesthetX.aesthetx.Intro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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

public class Activity4 extends AppCompatActivity {

    public static final String EXTRA_HEIGHT_FEET = "com.example.application.scifit.EXTRA_ FEET";
    public static final String EXTRA_HEIGHT_INCHES = "com.example.application.scifit.EXTRA_ INCHES";
    public static final String EXTRA_BODYWEIGHT_2 = "com.example.application.scifit.EXTRA_BODYWEIGHT_2";
    private EditText heightFeet;
    private EditText heightInches;
    private final TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                Button nextbutton3 = findViewById(R.id.nextbutton4);
                nextbutton3.performClick();
                nextbutton3.setPressed(true);
                nextbutton3.invalidate();
                nextbutton3.setPressed(false);
                nextbutton3.invalidate();
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_four);

        //Data Passing prayers
        Intent intent = getIntent();
        final float bodyweight = intent.getFloatExtra(Activity3.EXTRA_BODYWEIGHT, 0);

        //initialize Edit Text and button
        heightFeet = findViewById(R.id.editFeetHeight);
        heightInches = findViewById(R.id.editInchesHeight);
        final Button nextbutton3 = findViewById(R.id.nextbutton4);
        heightInches.setOnEditorActionListener(editorListener);

        nextbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(heightFeet.getText()) || TextUtils.isEmpty(heightInches.getText())) {
                    displayToast();
                } else {
                    openActivity5(bodyweight);
                }
            }
        });

        heightFeet.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                int textlength1 = heightFeet.getText().length();
                if (textlength1 >= 1) {
                    heightInches.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });

        heightInches.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Integer textlength2 = heightFeet.getText().length();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });
    }
    //Method to next activity

    @Override
    public void onResume() {
        super.onResume();
        heightFeet.requestFocus();

        heightFeet.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                InputMethodManager keyboard = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(heightFeet, 0);
            }
        }, 300); //use 300 to make it run when coming back from lock screen

    }

    private void displayToast() {
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

    private void openActivity5(float bodyweight) {
        EditText heightInputFeet = findViewById(R.id.editFeetHeight);
        float heightFeet = Float.parseFloat(heightInputFeet.getText().toString());

        EditText heightInputInches = findViewById(R.id.editInchesHeight);
        float heightInches = Float.parseFloat(heightInputInches.getText().toString());

        Intent intent = new Intent(this, Activity5.class);
        intent.putExtra(EXTRA_HEIGHT_FEET, heightFeet);
        intent.putExtra(EXTRA_HEIGHT_INCHES, heightInches);
        intent.putExtra(EXTRA_BODYWEIGHT_2, bodyweight);
        startActivity(intent);
    }
}
