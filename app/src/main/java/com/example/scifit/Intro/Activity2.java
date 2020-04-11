package com.example.scifit.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

public class Activity2 extends AppCompatActivity {

    //global variables go here

    private View decorView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_two);

        //initialize button and activate OnclickListener for clock action
        Button button = (Button) this.findViewById(R.id.nextbutton2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick( View v){
                openActivity3();
            }
        });
    }


    public void openActivity3(){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}
