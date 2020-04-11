package com.example.scifit.Classes.Fragments.IntroFragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.scifit.Intro.Activity4;
import com.example.scifit.Intro.Intro;
import com.example.scifit.Intro.MagicFormulaFemale;
import com.example.scifit.Intro.MagicFormulaMale;
import com.example.scifit.Intro.MainActivity;
import com.example.scifit.R;

import static android.content.Context.MODE_PRIVATE;
import static androidx.core.content.ContextCompat.getSystemService;

public class IntroThreeFragment extends Fragment {
    public static final String EXTRA_BODYWEIGHT = "com.example.application.scifit.EXTRA_ BODYWEIGHT";
    private EditText bodyweight;
    private Button nextbutton3;
    public static final String SHARED_PREFS = "sharedPrefs";

    public IntroThreeFragment() {
        // Required empty public constructor
    }

    public static IntroThreeFragment newInstance(String param1, String param2) {
        IntroThreeFragment fragment = new IntroThreeFragment();
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
        View v = inflater.inflate(R.layout.fragment_intro_three, container2, false);
        bodyweight = v.findViewById(R.id.bodyweight_input);
        nextbutton3 = v.findViewById(R.id.nextbutton3);
        bodyweight.setOnEditorActionListener(editorListener);
        bodyweight.setFocusableInTouchMode(true);

        return v;
    }
    @Override
    public void onResume(){
        super.onResume();
        bodyweight.requestFocus();

    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                final EditText bodyweightInput = getActivity().findViewById(R.id.bodyweight_input);
                final float bodyweight = Float.parseFloat(bodyweightInput.getText().toString());

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putFloat(EXTRA_BODYWEIGHT, bodyweight);
                editor.apply();
              /*  Intent intentm = new Intent(getContext(), MagicFormulaMale.class);
                intentm.putExtra(EXTRA_BODYWEIGHT, bodyweight);

                Intent intentf = new Intent(getContext(), MagicFormulaFemale.class);
                intentf.putExtra(EXTRA_BODYWEIGHT, bodyweight);*/


                ViewPager viewPager = getActivity().findViewById(R.id.container2);
                viewPager.setCurrentItem(2,true);
                return true;
            }
            return false;
        }
    };
}
