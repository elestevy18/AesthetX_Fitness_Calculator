package com.AesthetX.aesthetx.PopUpDialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.AesthetX.aesthetx.Classes.Constants;
import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;
import com.example.scifit.R;

import java.util.Objects;

public class LowerTrapPostDeltErectorDialog extends AppCompatDialogFragment {
    private static final String PREFS = Constants.PREFS;

    private static final String LOWERTRAP_TALLY = "com.example.application.scifit.LOWERTRAP_TALLY";
    private static final String POSTERIORDELTOID_TALLY = "com.example.application.scifit.POSTERIORDELTOID_TALLY";
    private static final String ERECTORS_TALLY = "com.example.application.scifit.ERECTORS_TALLY";

    private final Context mContext;
    private EditText mvolume;
    private final TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                SharedPreferences sp = mContext.getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                String sets = mvolume.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                int lowerTrapTally = Integer.parseInt(sets);
                lowerTrapTally = lowerTrapTally * 10;
                editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                int posteriorDeltoidTally = Integer.parseInt(sets);
                posteriorDeltoidTally = posteriorDeltoidTally * 10;
                editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                int erectorsTally = Integer.parseInt(sets);
                erectorsTally = erectorsTally * 10;
                editor.putInt(ERECTORS_TALLY, erectorsTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                //  intent.putExtra(ROTATORCUFF_TALLY, rotatorCuffTally);
                startActivity(intent);

                return true;
            }
            return false;
        }
    };

    //private EditText mvolume;
    public LowerTrapPostDeltErectorDialog(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogeTheme);

        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        final View view = inflater.inflate(R.layout.add_lowertrappostdelterector, null);
        mvolume = view.findViewById(R.id.add_volume);
        mvolume.setOnEditorActionListener(editorListener);
        mvolume.setFocusableInTouchMode(true);


        builder.setView(view)
                .setTitle("Add Volume")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InputMethodManager keyboard = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                        keyboard.hideSoftInputFromWindow(view.getWindowToken(), 0);

                    }
                })
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences sp = mContext.getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                        String sets = mvolume.getText().toString();
                        SharedPreferences.Editor editor = sp.edit();
                        int lowerTrapTally = Integer.parseInt(sets);
                        lowerTrapTally = lowerTrapTally * 10;
                        editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                        int posteriorDeltoidTally = Integer.parseInt(sets);
                        posteriorDeltoidTally = posteriorDeltoidTally * 10;
                        editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                        int erectorsTally = Integer.parseInt(sets);
                        erectorsTally = erectorsTally * 10;
                        editor.putInt(ERECTORS_TALLY, erectorsTally);
                        editor.apply();
                        Intent intent = new Intent(mContext, Dashboards.class);
                        //  intent.putExtra(ROTATORCUFF_TALLY, rotatorCuffTally);
                        startActivity(intent);

                    }
                });
        mvolume.requestFocus();

        mvolume.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                InputMethodManager keyboard = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(mvolume, 0);
            }
        }, 300);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            ExampleDialogListener listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener {
        void addVolume();

    }

}
