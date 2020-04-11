package com.example.scifit.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.scifit.Classes.Fragments.DashboardFragment;
import com.example.scifit.Classes.Fragments.IntroFragments.IntroEightFragment;
import com.example.scifit.Classes.Fragments.IntroFragments.IntroFiveFragment;
import com.example.scifit.Classes.Fragments.IntroFragments.IntroFourFragment;
import com.example.scifit.Classes.Fragments.IntroFragments.IntroNineFragment;
import com.example.scifit.Classes.Fragments.IntroFragments.IntroOneFragment;
import com.example.scifit.Classes.Fragments.IntroFragments.IntroSevenFragment;
import com.example.scifit.Classes.Fragments.IntroFragments.IntroSixFragment;
import com.example.scifit.Classes.Fragments.IntroFragments.IntroThreeFragment;
import com.example.scifit.Classes.Fragments.LockableViewPager;
import com.example.scifit.Classes.Fragments.MealPlanFragment;
import com.example.scifit.Classes.Fragments.ResourcesFragment;
import com.example.scifit.Classes.Fragments.SectionsPageAdapter;
import com.example.scifit.Classes.Fragments.VolumeTrackerFragment;
import com.example.scifit.R;
import com.google.android.material.tabs.TabLayout;

public class Intro extends AppCompatActivity {
    private static final String TAG = "INTRO";
    private SectionsPageAdapter mSectionsPageAdapter;
    private LockableViewPager mViewPager;
    SharedPreferences prefs = null;
    EditText bodyweight;
    Button next;
    TextView indicatorOne;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE);
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager =  findViewById(R.id.container2);
        setupViewPager(mViewPager);
        int color = Color.parseColor("#f5f5f5");
        int color2 = Color.parseColor("#BAF833");
        next = findViewById(R.id.nextbutton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager viewPager = findViewById(R.id.container2);
                viewPager.setCurrentItem(1,true);
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