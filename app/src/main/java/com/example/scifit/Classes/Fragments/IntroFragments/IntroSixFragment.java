package com.example.scifit.Classes.Fragments.IntroFragments;

import android.content.Intent;
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

import com.example.scifit.PopUpDialogs.BodyFatChart;
import com.example.scifit.R;

import static android.content.Context.MODE_PRIVATE;


public class IntroSixFragment extends Fragment {
    public static final String EXTRA_COMPOSITION = "com.example.application.scifit.COMPOSITION";
    public static final String SHARED_PREFS = "sharedPrefs";
    EditText composition;
    TextView clickhere;
 

    public IntroSixFragment() {
        // Required empty public constructor
    }
    
    public static IntroSixFragment newInstance(String param1, String param2) {
        IntroSixFragment fragment = new IntroSixFragment();
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
        View v = inflater.inflate(R.layout.fragment_intro_six, container, false);
        composition = v.findViewById(R.id.CompositionInput);
        composition.setOnEditorActionListener(editorListener);
        composition.setFocusableInTouchMode(true);
        clickhere = v.findViewById(R.id.clickhere);
        clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBFC();
            }
        });
        return  v;
    }
    @Override
    public void onResume(){
        super.onResume();
        composition.requestFocus();

    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                final EditText compositionInput = getActivity().findViewById(R.id.CompositionInput);
                final float composition = Float.parseFloat(compositionInput.getText().toString());

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putFloat(EXTRA_COMPOSITION, composition);
                editor.apply();
              /*  Intent intentm = new Intent(getContext(), MagicFormulaMale.class);
                intentm.putExtra(EXTRA_COMPOSITION, composition);

                Intent intentf = new Intent(getContext(), MagicFormulaFemale.class);
                intentf.putExtra(EXTRA_COMPOSITION, composition);*/


                ViewPager viewPager = getActivity().findViewById(R.id.container2);
                viewPager.setCurrentItem(5,true);
                return true;
            }
            return false;
        }
    };

    public void openBFC() {

        Intent intent = new Intent(getActivity(), BodyFatChart.class);
        startActivity(intent);

    }
}


