package Aesthet.X.adfree.Classes.Fragments.IntroFragments;

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

public class IntroFiveFragment extends Fragment {

    private static final String EXTRA_EXPERIENCE = "com.example.application.scifit.EXPERIENCE";
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private final TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
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
                viewPager.setCurrentItem(4, true);
                return true;
            }
            return false;
        }
    };

    public IntroFiveFragment() {
        // Required empty public constructor
    }

    private EditText experience;

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

    public static IntroFiveFragment newInstance() {
        IntroFiveFragment fragment = new IntroFiveFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        experience.requestFocus();

    }

}
