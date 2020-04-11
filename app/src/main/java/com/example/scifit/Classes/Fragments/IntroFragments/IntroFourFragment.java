package com.example.scifit.Classes.Fragments.IntroFragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.scifit.R;

import static android.content.Context.MODE_PRIVATE;


public class IntroFourFragment extends Fragment {
    public static final String EXTRA_HEIGHT_FEET = "com.example.application.scifit.EXTRA_ FEET";
    public static final String EXTRA_HEIGHT_INCHES = "com.example.application.scifit.EXTRA_ INCHES";
    private EditText heightFeet;
    private EditText heightInches;
    public static final String SHARED_PREFS = "sharedPrefs";



    public IntroFourFragment() {
        // Required empty public constructor
    }

    public static IntroFourFragment newInstance(String param1, String param2) {
        IntroFourFragment fragment = new IntroFourFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container2,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_intro_four, container2, false);
        heightFeet = v.findViewById(R.id.editFeetHeight);
        heightInches = v.findViewById(R.id.editInchesHeight);

        heightInches.setOnEditorActionListener(editorListener);

        heightFeet.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                Integer textlength1 = heightFeet.getText().length();
                if (textlength1 >= 1) {
                    heightInches.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });

        heightInches.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Integer textlength2 = heightFeet.getText().length();
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
        });
        return v;
    }

    @Override
    public void onResume(){
        super.onResume();
        heightFeet.requestFocus();

    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                EditText heightInputFeet =  getActivity().findViewById(R.id.editFeetHeight);
                float heightFeet = Float.parseFloat(heightInputFeet.getText().toString());

                EditText heightInputInches =  getActivity().findViewById(R.id.editInchesHeight);
                float heightInches = Float.parseFloat(heightInputInches.getText().toString());

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putFloat(EXTRA_HEIGHT_FEET, heightFeet);
                editor.putFloat(EXTRA_HEIGHT_INCHES, heightInches);
                editor.apply();
              /*  Intent intentm = new Intent(getContext(), MagicFormulaMale.class);
                intentm.putExtra(EXTRA_BODYWEIGHT, bodyweight);

                Intent intentf = new Intent(getContext(), MagicFormulaFemale.class);
                intentf.putExtra(EXTRA_BODYWEIGHT, bodyweight);*/


                ViewPager viewPager = getActivity().findViewById(R.id.container2);
                viewPager.setCurrentItem(3,true);
                return true;
            }
            return false;
        }
    };
}

