package Aesthet.X.adfree.Classes.Fragments.IntroFragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.scifit.R;

import Aesthet.X.adfree.DashBoardTabs.Dashboards;
import Aesthet.X.adfree.Intro.MagicFormulaFemale;
import Aesthet.X.adfree.Intro.MagicFormulaMale;

import static android.content.Context.MODE_PRIVATE;

public class IntroNineFragment extends Fragment {
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String MALE = "male";
    private static final String FEMALE = "female";

    public IntroNineFragment() {
        // Required empty public constructor
    }

    public static IntroNineFragment newInstance() {
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
        Button malebutton = v.findViewById(R.id.malebutton);
        Button femalebutton = v.findViewById(R.id.femalebutton);
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

    private void openMagicFormulaMale(SharedPreferences.Editor editor) {
        Intent intent = new Intent(getActivity(), MagicFormulaMale.class);
        editor.putBoolean(MALE, true);
        editor.apply();
        startActivity(intent);
    }

    private void openMagicFormulaFemale(SharedPreferences.Editor editor) {

        Intent intent = new Intent(getActivity(), MagicFormulaFemale.class);
        editor.putBoolean(FEMALE, true);
        editor.apply();

        startActivity(intent);
    }
}
