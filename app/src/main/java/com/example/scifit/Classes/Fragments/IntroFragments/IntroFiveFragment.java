package com.example.scifit.Classes.Fragments.IntroFragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.scifit.R;

import static android.content.Context.MODE_PRIVATE;

public class IntroFiveFragment extends Fragment {

    public static final String EXTRA_EXPERIENCE = "com.example.application.scifit.EXPERIENCE";
    public static final String SHARED_PREFS = "sharedPrefs";
    EditText experience;

    public IntroFiveFragment() {
        // Required empty public constructor
    }

    public static IntroFiveFragment newInstance(String param1, String param2) {
        IntroFiveFragment fragment = new IntroFiveFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_intro_five, container, false);
        experience = v.findViewById(R.id.ExperienceInput);
        experience.setOnEditorActionListener(editorListener);
        experience.setFocusableInTouchMode(true);
        return v;
    }
    @Override
    public void onResume(){
        super.onResume();
        experience.requestFocus();

    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                final EditText experienceInput = getActivity().findViewById(R.id.ExperienceInput);
                final float experience = Float.parseFloat(experienceInput.getText().toString());

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putFloat(EXTRA_EXPERIENCE, experience);
                editor.apply();
              /*  Intent intentm = new Intent(getContext(), MagicFormulaMale.class);
                intentm.putExtra(EXTRA_EXPERIENCE, experience);

                Intent intentf = new Intent(getContext(), MagicFormulaFemale.class);
                intentf.putExtra(EXTRA_EXPERIENCE, experience);*/


                ViewPager viewPager = getActivity().findViewById(R.id.container2);
                viewPager.setCurrentItem(4,true);
                return true;
            }
            return false;
        }
    };

}
