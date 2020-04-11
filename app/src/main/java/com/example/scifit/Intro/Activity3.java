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

import static com.example.scifit.R.layout.slide_three;

public class Activity3 extends AppCompatActivity {

    //global variables go here
    public static final String EXTRA_BODYWEIGHT = "com.example.application.scifit.EXTRA_ BODYWEIGHT";
    private EditText bodyweight;
    private Button nextbutton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(slide_three);
        //initialize Edit Text and button

        bodyweight = findViewById(R.id.bodyweight_input);
        nextbutton3 = findViewById(R.id.nextbutton3);
        bodyweight.setOnEditorActionListener(editorListener);
        bodyweight.setFocusableInTouchMode(true);
        nextbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(bodyweight.getText())){
                    displayToast();

                }else{
                    openActivity4();
                }
        }

        });

    }
    @Override
    public void onResume(){
        super.onResume();
        bodyweight.requestFocus();

        bodyweight.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                InputMethodManager keyboard = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(bodyweight, 0);
            }
        },300); //use 300 to make it run when coming back from lock screen

    }

    private void displayToast(){
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }

    public void openActivity4() {

        final EditText bodyweightInput = (EditText) findViewById(R.id.bodyweight_input);
        final float bodyweight = Float.parseFloat(bodyweightInput.getText().toString());

        Intent intent = new Intent(this, Activity4.class);
        intent.putExtra(EXTRA_BODYWEIGHT, bodyweight);
        startActivity(intent);
    }
    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) { ;
                openActivity4();
                return true;
            }
            return false;
        }
    };

}




