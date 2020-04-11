package com.example.scifit.Classes.Fragments.IntroFragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.example.scifit.DashBoardTabs.Dashboards;
import com.example.scifit.Intro.MagicFormulaFemale;
import com.example.scifit.Intro.MagicFormulaMale;
import com.example.scifit.R;

import static android.content.Context.MODE_PRIVATE;

public class IntroNineFragment extends Fragment {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    Button malebutton;
    Button femalebutton;

    public IntroNineFragment() {
        // Required empty public constructor
    }

    public static IntroNineFragment newInstance(String param1, String param2) {
        IntroNineFragment fragment = new IntroNineFragment();
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
        View v = inflater.inflate(R.layout.fragment_intro_seven, container, false);
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Dashboards.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        malebutton = v.findViewById(R.id.malebutton);
        femalebutton = v.findViewById(R.id.femalebutton);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();


        malebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMagicFormulaMale(editor);
            }
        });

        femalebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMagicFormulaFemale(editor);
            }
        });
return v;
    }

    private void openMagicFormulaMale(SharedPreferences.Editor editor){
        Intent intent = new Intent(getActivity(), MagicFormulaMale.class);
        editor.putBoolean(MALE, true);
        editor.apply();
        startActivity(intent);
    }

    private void openMagicFormulaFemale(SharedPreferences.Editor editor){

        Intent intent = new Intent(getActivity(), MagicFormulaFemale.class);
        editor.putBoolean(FEMALE, true);
        editor.apply();

        startActivity(intent);
    }
}
