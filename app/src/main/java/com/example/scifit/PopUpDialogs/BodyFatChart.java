package com.example.scifit.PopUpDialogs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

public class BodyFatChart extends AppCompatActivity {

    Button male, female;
    ViewSwitcher view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_fat_chart);

        male = (Button) findViewById(R.id.male);
        female = (Button) findViewById(R.id.female);

        view = (ViewSwitcher) findViewById(R.id.viewSwitcher1);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        male.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Show Previous View
                view.showPrevious();

            }
        });
        female.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Show Next View
                view.showNext();
            }
        });


    }
}
