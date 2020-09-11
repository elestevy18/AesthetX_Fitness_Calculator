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

import com.example.scifit.R;

import java.util.Objects;

import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;

public class AddGluteHamDialog extends AppCompatDialogFragment {
    private static final String PREFS = "PREFS";
    private static final String GLUTES_TALLY = "com.example.application.scifit.GLUTES_TALLY";
    private static final String HAMSTRINGS_TALLY = "com.example.application.scifit.HAMSTRINGS_TALLY";
    private static final String ERECTORS_TALLY = "com.example.application.scifit.ERECTORS_TALLY";

    private final Context mContext;
    private EditText mvolume;

    //private EditText mvolume;
    public AddGluteHamDialog(Context mContext) {
        this.mContext = mContext;
    }

    private final TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                SharedPreferences sp = mContext.getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);

                String sets = mvolume.getText().toString();
                int glutesTally = Integer.parseInt(sets);
                glutesTally = glutesTally * 10;
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(GLUTES_TALLY, glutesTally);
                int hamstringsTally = Integer.parseInt(sets);
                hamstringsTally = hamstringsTally * 10;
                hamstringsTally = hamstringsTally / 2;
                editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                int erectorsTally = Integer.parseInt(sets);
                erectorsTally = erectorsTally * 10;
                erectorsTally = erectorsTally / 2;
                editor.putInt(ERECTORS_TALLY, erectorsTally);
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
        final View view = inflater.inflate(R.layout.add_glutes_volume_dialog, null);
        mvolume = view.findViewById(R.id.add_volume);
        mvolume.setOnEditorActionListener(editorListener);
        mvolume.setFocusableInTouchMode(true);


        builder.setView(view)
                .setTitle("Add Volume")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InputMethodManager keyboard = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                        assert keyboard != null;
                        keyboard.hideSoftInputFromWindow(view.getWindowToken(), 0);

                    }
                })
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences sp = mContext.getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                        String sets = mvolume.getText().toString();
                        int glutesTally = Integer.parseInt(sets);
                        glutesTally = glutesTally * 10;
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt(GLUTES_TALLY, glutesTally);
                        int hamstringsTally = Integer.parseInt(sets);
                        hamstringsTally = hamstringsTally * 10;
                        hamstringsTally = hamstringsTally / 2;
                        editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                        int erectorsTally = Integer.parseInt(sets);
                        erectorsTally = erectorsTally * 10;
                        erectorsTally = erectorsTally / 2;
                        editor.putInt(ERECTORS_TALLY, erectorsTally);
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
                assert keyboard != null;
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