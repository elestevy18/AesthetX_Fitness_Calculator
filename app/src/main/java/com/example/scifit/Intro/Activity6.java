package com.example.scifit.Intro;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
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

import com.example.scifit.PopUpDialogs.BodyFatChart;
import com.example.scifit.R;

public class Activity6 extends AppCompatActivity {

    //Create constants for passing data to next activity SEPERATE from importing data below

    public static final String EXTRA_EXPERIENCE_2 = "com.example.application.scifit.EXPERIENCE_2";
    public static final String EXTRA_BODYWEIGHT_4 = "com.example.application.scifit.EXTRA_BODYWEIGHT_4";
    public static final String EXTRA_HEIGHT_FEET_3= "com.example.application.scifit.EXTRA_ FEET_3";
    public static final String EXTRA_HEIGHT_INCHES_3 = "com.example.application.scifit.EXTRA_ INCHES_3";
    public static final String EXTRA_COMPOSITION = "com.example.application.scifit.COMPOSITION";
    private EditText composition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_six);

        //Retrieve data from previous activity
        Intent intent = getIntent();
        final float bodyweight = intent.getFloatExtra(Activity5.EXTRA_BODYWEIGHT_3, 0);
        final float heightFeet = intent.getFloatExtra(Activity5.EXTRA_HEIGHT_FEET_2, 0);
        final float heightInches = intent.getFloatExtra(Activity5.EXTRA_HEIGHT_INCHES_2, 0);
        final float experience = intent.getFloatExtra(Activity5.EXTRA_EXPERIENCE, 0);


        //initialize Edit Text and button

        TextView clickhere = findViewById(R.id.clickhere);
        String nots = getString(R.string.clickehere);

        //SpannableString s1 = new SpannableString(nots);

        composition = findViewById(R.id.CompositionInput);
        final Button nextbutton6 = findViewById(R.id.nextbutton6);
        composition.setOnEditorActionListener(editorListener);


        clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBFC();
            }
        });



      /*  ClickableSpan clkspan1 = new ClickableSpan() {
            @Override
            public void onClick( View view) {
                openBFC();
            }
        };

        s1.setSpan(clkspan1, 0,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        clickhere.setText(s1);
        clickhere.setMovementMethod(LinkMovementMethod.getInstance());
        clickhere.setTextColor(Color.parseColor("#BAF833"));

*/
        nextbutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(composition.getText())){
                    displayToast();
                } else{
                    openActivity7(bodyweight, heightFeet, heightInches, experience);

                }

            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        composition.requestFocus();

        composition.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                InputMethodManager keyboard = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(composition, 0);
            }
        },300); //use 300 to make it run when coming back from lock screen

    }

    private void displayToast(){
        Toast toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
        toast.show();
    }
    private void openActivity7(float  bodyweight, float heightFeet, float heightInches, float experience){

        EditText heightInputFeet = (EditText) findViewById(R.id.CompositionInput);
        float composition = Float.parseFloat(heightInputFeet.getText().toString());


        Intent intent = new Intent(this, Activity7.class);

        intent.putExtra(EXTRA_EXPERIENCE_2, experience);
        intent.putExtra(EXTRA_BODYWEIGHT_4, bodyweight);
        intent.putExtra(EXTRA_HEIGHT_FEET_3, heightFeet);
        intent.putExtra(EXTRA_HEIGHT_INCHES_3, heightInches);
        intent.putExtra(EXTRA_COMPOSITION, composition);
        startActivity(intent);
    }

    public void openBFC() {

        Intent intent = new Intent(this, BodyFatChart.class);
        startActivity(intent);

}
    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) { ;
                Button nextbutton6 = findViewById(R.id.nextbutton6);
                nextbutton6.performClick();
                nextbutton6.setPressed(true);
                nextbutton6.invalidate();
                nextbutton6.setPressed(false);
                nextbutton6.invalidate();
                return true;
            }
            return false;
        }
    };
}

