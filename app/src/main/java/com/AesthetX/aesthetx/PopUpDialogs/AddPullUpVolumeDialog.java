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

public class AddPullUpVolumeDialog extends AppCompatDialogFragment {
    private static final String PREFS = Constants.PREFS;
    private static final String LATS_TALLY = "com.example.application.scifit.LATS_TALLY";
    public static final String LOWERTRAP_TALLY = "com.example.application.scifit.LOWERTRAP_TALLY";
    private static final String BICEPS_TALLY = "com.example.application.scifit.BICEPS_TALLY";
    private static final String FOREARMFLEXORS_TALLY = "com.example.application.scifit.FOREARMFLEXORS_TALLY";
    private static final String POSTERIORDELTOID_TALLY = "com.example.application.scifit.POSTERIORDELTOID_TALLY";
    private final Context mContext;
    private EditText mvolume;

    //private EditText mvolume;
    public AddPullUpVolumeDialog(Context mContext) {
        this.mContext = mContext;
    }

    private final TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                SharedPreferences sp = mContext.getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);

                String sets = mvolume.getText().toString();
                int latsTally = Integer.parseInt(sets);
                latsTally = latsTally * 10;
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(LATS_TALLY, latsTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
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
        final View view = inflater.inflate(R.layout.add_lats_volume_dialog, null);
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
                        int latsTally = Integer.parseInt(sets);
                        latsTally = latsTally * 10;
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt(LATS_TALLY, latsTally);
                        int bicepsTally = Integer.parseInt(sets);
                        bicepsTally = bicepsTally * 10;
                        bicepsTally = bicepsTally / 2;
                        editor.putInt(BICEPS_TALLY, bicepsTally);
                        int forearmFlexorTally = Integer.parseInt(sets);
                        forearmFlexorTally = forearmFlexorTally * 10;
                        forearmFlexorTally = forearmFlexorTally / 2;
                        editor.putInt(FOREARMFLEXORS_TALLY, forearmFlexorTally);
                        int posteriorDeltoidTally = Integer.parseInt(sets);
                        posteriorDeltoidTally = posteriorDeltoidTally * 10;
                        posteriorDeltoidTally = posteriorDeltoidTally / 2;
                        editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                        int lowerTrapTally = Integer.parseInt(sets);
                        lowerTrapTally = lowerTrapTally * 10;
                        editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                        editor.apply();
                        Intent intent = new Intent(mContext, Dashboards.class);
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