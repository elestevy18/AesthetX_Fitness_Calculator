package Aesthet.X.adfree.PopUpDialogs;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

public class FAQFourYears extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_years);

        TextView foury = findViewById(R.id.foury);
        String four = getString(R.string.fouryears);

        SpannableString s1 = new SpannableString(four);

        ClickableSpan clkspan1 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                lawOfDR();
            }
        };

        ClickableSpan clkspan2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                hypertrophy();
            }
        };

        s1.setSpan(clkspan1, 4, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s1.setSpan(clkspan2, 63, 74, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        foury.setText(s1);
        foury.setMovementMethod(LinkMovementMethod.getInstance());


    }

    private void lawOfDR() {
        DefLawofDR dialog = new DefLawofDR();
        dialog.show((getSupportFragmentManager()), "substance free");
    }

    private void hypertrophy() {
        DefHypertrophy dialog = new DefHypertrophy();
        dialog.show((getSupportFragmentManager()), "substance free");
    }
}
