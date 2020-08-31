package Aesthet.X.adfree.Intro;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.scifit.R;

import Aesthet.X.adfree.Classes.Fragments.IntroFragments.IntroEightFragment;
import Aesthet.X.adfree.Classes.Fragments.IntroFragments.IntroFiveFragment;
import Aesthet.X.adfree.Classes.Fragments.IntroFragments.IntroFourFragment;
import Aesthet.X.adfree.Classes.Fragments.IntroFragments.IntroNineFragment;
import Aesthet.X.adfree.Classes.Fragments.IntroFragments.IntroOneFragment;
import Aesthet.X.adfree.Classes.Fragments.IntroFragments.IntroSevenFragment;
import Aesthet.X.adfree.Classes.Fragments.IntroFragments.IntroSixFragment;
import Aesthet.X.adfree.Classes.Fragments.IntroFragments.IntroThreeFragment;
import Aesthet.X.adfree.Classes.Fragments.LockableViewPager;
import Aesthet.X.adfree.Classes.Fragments.SectionsPageAdapter;

public class Intro extends AppCompatActivity {
    private static final String TAG = "INTRO";
    private LockableViewPager mViewPager;
    EditText bodyweight;
    TextView indicatorOne;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        SharedPreferences prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE);
        SectionsPageAdapter mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container2);
        setupViewPager(mViewPager);
        int color = Color.parseColor("#f5f5f5");
        int color2 = Color.parseColor("#BAF833");
        Button next = findViewById(R.id.nextbutton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewPager = findViewById(R.id.container2);
                viewPager.setCurrentItem(1, true);
            }
        });
        mViewPager.addOnPageChangeListener();

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.showSoftInput(getWindow().getCurrentFocus(), 0);
                        mViewPager.setSwipeLocked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    //  InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    // keyboard.showSoftInput(bodyweight, 0);

    //Puzzle to get to the next viewpager page
       /* nextbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(bodyweight.getText())){
                    displayToast();

                }else{
                    V.setCurrentItem( num ):
                }
            }

        });*/


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new IntroOneFragment(), "Dashboard");
        adapter.addFragment(new IntroThreeFragment(), "Volume\nTracker");
        adapter.addFragment(new IntroFourFragment(), "Meal\nPlan");
        adapter.addFragment(new IntroFiveFragment(), "Resources");
        adapter.addFragment(new IntroSixFragment(), "Resources");
        adapter.addFragment(new IntroSevenFragment(), "Resources");
        adapter.addFragment(new IntroEightFragment(), "Resources");
        adapter.addFragment(new IntroNineFragment(), "Resources");
        viewPager.setAdapter(adapter);

    }

}