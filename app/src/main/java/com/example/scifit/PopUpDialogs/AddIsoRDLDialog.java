package com.example.scifit.PopUpDialogs;

import android.app.Activity;
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
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.scifit.AddVolume.HamstringsVolume;
import com.example.scifit.DashBoardTabs.Dashboards;
import com.example.scifit.Intro.Activity7;
import com.example.scifit.R;

import java.util.Objects;

public class AddIsoRDLDialog extends AppCompatDialogFragment {
    public static final String PREFS = "PREFS";
    public static final String HAMSTRINGS_TALLY = "com.example.application.scifit.HAMSTRINGS_TALLY";
    public static final String GLUTEMEDIUS_TALLY = "com.example.application.scifit.GLUTEMEDIUS_TALLY";
    public static final String GLUTES_TALLY = "com.example.application.scifit.GLUTES_TALLY";
    private ExampleDialogListener listener;
    private Context mContext;
    private EditText mvolume;

    //private EditText mvolume;
    public AddIsoRDLDialog(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogeTheme);

        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        final View view = inflater.inflate(R.layout.add_hamstrings_volume_dialog, null);
        mvolume = view.findViewById(R.id.add_volume);
        mvolume.setOnEditorActionListener(editorListener);
        mvolume.setFocusableInTouchMode(true);


        builder.setView(view)
                .setTitle("Add Volume")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InputMethodManager keyboard = (InputMethodManager)mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                        keyboard.hideSoftInputFromWindow(view.getWindowToken(), 0);

                    }
                })
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences sp = mContext.getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
                        String sets = mvolume.getText().toString();
                        int hamstringsTally = Integer.parseInt(sets);
                        hamstringsTally = hamstringsTally * 10;
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                        int gluteMediusTally = Integer.parseInt(sets);
                        gluteMediusTally = gluteMediusTally * 10;
                        editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                        int glutesTally = Integer.parseInt(sets);
                        glutesTally = glutesTally *10;
                        glutesTally = glutesTally /2;
                        editor.putInt(GLUTES_TALLY, glutesTally);
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
                InputMethodManager keyboard = (InputMethodManager)mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(mvolume, 0);
            }
        },300);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener {
        void addVolume();

    }
    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {
                SharedPreferences sp = mContext.getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);

                String sets = mvolume.getText().toString();
                int hamstringsTally = Integer.parseInt(sets);
                hamstringsTally = hamstringsTally *10;
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

                return true;
            }
            return false;
        }
    };

}