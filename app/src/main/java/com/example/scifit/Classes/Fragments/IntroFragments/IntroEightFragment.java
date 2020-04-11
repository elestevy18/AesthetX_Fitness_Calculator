package com.example.scifit.Classes.Fragments.IntroFragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.example.scifit.DashBoardTabs.Dashboards;
import com.example.scifit.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroEightFragment extends Fragment {

    Button sedentarybutton, lightbutton, moderatebutton, heavybutton, athleticbutton;
    float activityMultiplier;
    public static final String ACTIVITYMULTIPLIER = "ACTIVITYMULTIPLIER";
    public static final String SHARED_PREFS = "sharedPrefs";

    public IntroEightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_intro_eight, container, false);

        sedentarybutton = v.findViewById(R.id.sedentarybutton);
        lightbutton = v.findViewById(R.id.lightbutton);
        moderatebutton = v.findViewById(R.id.moderatebutton);
        heavybutton = v.findViewById(R.id.heavybutton);
        athleticbutton = v.findViewById(R.id.athleticbutton);

        sedentarybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMultiplier = (float) 1.2;
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat(ACTIVITYMULTIPLIER, activityMultiplier);
                ViewPager viewPager = getActivity().findViewById(R.id.container2);
                viewPager.setCurrentItem(7,true);
                editor.apply();

            }
        });

        lightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMultiplier = (float) 1.375;
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat(ACTIVITYMULTIPLIER, activityMultiplier);
                ViewPager viewPager = getActivity().findViewById(R.id.container2);
                viewPager.setCurrentItem(7,true);
                editor.apply();

            }
        });

        moderatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMultiplier = (float) 1.550;
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat(ACTIVITYMULTIPLIER, activityMultiplier);
                ViewPager viewPager = getActivity().findViewById(R.id.container2);
                viewPager.setCurrentItem(7,true);
                editor.apply();

            }
        });

        heavybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMultiplier = (float) 1.725;
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat(ACTIVITYMULTIPLIER, activityMultiplier);
                ViewPager viewPager = getActivity().findViewById(R.id.container2);
                viewPager.setCurrentItem(7,true);
                editor.apply();

            }
        });

        athleticbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityMultiplier = (float) 1.95;
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat(ACTIVITYMULTIPLIER, activityMultiplier);
                ViewPager viewPager = getActivity().findViewById(R.id.container2);
                viewPager.setCurrentItem(7,true);
                editor.apply();

            }
        });
        return v;
    }
}
