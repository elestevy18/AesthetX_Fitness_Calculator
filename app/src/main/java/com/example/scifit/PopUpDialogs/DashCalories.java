package com.example.scifit.PopUpDialogs;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

public class DashCalories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        TextView cal = findViewById(R.id.cal);
        String cals = getString(R.string.cal);

        SpannableString s1 = new SpannableString(cals);

        ClickableSpan clkspan1 = new ClickableSpan() {
            @Override
            public void onClick( View view) {
                calMaint();
            }
        };

        ClickableSpan clkspan2 = new ClickableSpan() {
            @Override
            public void onClick( View view) {
                calInt();
            }
        };

        s1.setSpan(clkspan1, 91,110, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s1.setSpan(clkspan2, 123,137, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        cal.setText(s1);
        cal.setMovementMethod(LinkMovementMethod.getInstance());

    }
    public void calMaint(){
        DefCaloricMaintenance dialog = new DefCaloricMaintenance();
        dialog.show((getSupportFragmentManager()), "substance free");
    }
    public void calInt(){
        DefCaloricIntake dialog = new DefCaloricIntake();
        dialog.show((getSupportFragmentManager()), "substance free");
    }
}
