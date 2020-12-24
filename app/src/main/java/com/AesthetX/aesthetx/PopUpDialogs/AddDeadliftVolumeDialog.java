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
import com.example.scifit.R;

import java.util.Objects;

import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;

public class AddDeadliftVolumeDialog extends AppCompatDialogFragment {
    private static final String PREFS = Constants.PREFS;
    private static final String UPPERTRAP_TALLY = "com.example.application.scifit.UPPERTRAP_TALLY";
    private static final String LATS_TALLY = "com.example.application.scifit.LATS_TALLY";
    private static final String GLUTES_TALLY = "com.example.application.scifit.GLUTES_TALLY";
    private static final String HAMSTRINGS_TALLY = "com.example.application.scifit.HAMSTRINGS_TALLY";
    private static final String LOWERTRAP_TALLY = "com.example.application.scifit.LOWERTRAP_TALLY";
    private static final String ERECTORS_TALLY = "com.example.application.scifit.ERECTORS_TALLY";
    private static final String TRANSVERSE_TALLY = "com.example.application.scifit.TRANSVERSE_TALLY";
    private final Context mContext;
    private EditText mvolume;

    //private EditText mvolume;
    public AddDeadliftVolumeDialog(Context mContext) {
        this.mContext = mContext;
    }

    private final TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                SharedPreferences sp = mContext.getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);

                String sets = mvolume.getText().toString();
                int upperTrapTally = Integer.parseInt(sets);
                upperTrapTally = upperTrapTally * 10;
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(UPPERTRAP_TALLY, upperTrapTally);
                editor.apply();

                Intent intent = new Intent(mContext, Dashboards.class);
                //intent.putExtra(UPPERTRAP_TALLY, upperTrapTally);

                startActivity(intent);

                return true;
            }
            return false;
        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogeTheme);

        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        final View view = inflater.inflate(R.layout.add_uppertrap_volume_dialog, null);
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
                        int upperTrapTally = Integer.parseInt(sets);
                        upperTrapTally = upperTrapTally * 10;
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt(UPPERTRAP_TALLY, upperTrapTally);
                        int latsTally = Integer.parseInt(sets);
                        latsTally = latsTally * 10;
                        latsTally = latsTally / 2;
                        editor.putInt(LATS_TALLY, latsTally);
                        int glutesTally = Integer.parseInt(sets);
                        glutesTally = glutesTally * 10;
                        glutesTally = glutesTally / 2;
                        editor.putInt(GLUTES_TALLY, glutesTally);
                        int lowerTrapTally = Integer.parseInt(sets);
                        lowerTrapTally = lowerTrapTally * 10;
                        lowerTrapTally = lowerTrapTally / 2;
                        editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                        editor.apply();
                        int hamstringsTally = Integer.parseInt(sets);
                        hamstringsTally = hamstringsTally * 10;
                        editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                        int erectorsTally = Integer.parseInt(sets);
                        erectorsTally = erectorsTally * 10;
                        editor.putInt(ERECTORS_TALLY, erectorsTally);
                        int TransverseTally = Integer.parseInt(sets);
                        TransverseTally = TransverseTally * 10;
                        TransverseTally = TransverseTally / 2;
                        editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                        editor.apply();
                        Intent intent = new Intent(mContext, Dashboards.class);
                        //  intent.putExtra(UPPERTRAP_TALLY, upperTrapTally);
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