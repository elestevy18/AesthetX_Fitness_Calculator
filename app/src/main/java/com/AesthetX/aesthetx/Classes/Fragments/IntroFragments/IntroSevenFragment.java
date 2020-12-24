package com.AesthetX.aesthetx.Classes.Fragments.IntroFragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.scifit.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroSevenFragment extends Fragment {
    private EditText age;
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String AGE = "age";

    public IntroSevenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_intro_seven, container, false);
        age = v.findViewById(R.id.age_input);
        age.setOnEditorActionListener(editorListener);
        age.setFocusableInTouchMode(true);


        return v;
    }

    private final TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                final EditText ageInput = getActivity().findViewById(R.id.age_input);
                final float age = Float.parseFloat(ageInput.getText().toString());

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putFloat(AGE, age);
                editor.apply();


                ViewPager viewPager = getActivity().findViewById(R.id.container2);
                viewPager.setCurrentItem(6, true);
                return true;
            }
            return false;
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        age.requestFocus();

    }
}
