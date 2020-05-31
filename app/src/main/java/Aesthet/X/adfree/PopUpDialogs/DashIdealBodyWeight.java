package Aesthet.X.adfree.PopUpDialogs;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

public class DashIdealBodyWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_body_weight);

        TextView ibw = findViewById(R.id.ibw);
        String ibwtxt = getString(R.string.ibw);

        TextView ibw2 = findViewById(R.id.ibw2);
        String ibw2txt = getString(R.string.ibw2);

        SpannableString s1 = new SpannableString(ibwtxt);
        SpannableString s2 = new SpannableString(ibw2txt);

        ClickableSpan clkspan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                openFourYears();
            }
        };

        ClickableSpan clkspan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                substanceFree();
            }
        };
        s1.setSpan(clkspan1, 63, 70, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ibw.setText(s1);
        ibw.setMovementMethod(LinkMovementMethod.getInstance());

        s2.setSpan(clkspan2, 75, 89, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ibw2.setText(s2);
        ibw2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void openFourYears() {

        Intent intent = new Intent(this, FAQFourYears.class);
        startActivity(intent);

    }

    private void substanceFree() {
        DefSubstanceFree dialog = new DefSubstanceFree();
        dialog.show((getSupportFragmentManager()), "substance free");
    }
}
