package com.example.scifit.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

public class MainActivity extends AppCompatActivity {

    //global variables go here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //initialize button and activate OnclickListener for clock action
        Button button = (Button) this.findViewById(R.id.nextbutton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            //method implementation to open with the onclick
            public void onClick( View v){
                openActivity2();
            }
        });
    }

    //Creating method to open second activity
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
