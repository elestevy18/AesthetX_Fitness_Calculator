package com.AesthetX.aesthetx.PopUpDialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;

import com.AesthetX.aesthetx.Classes.Constants;
import com.example.scifit.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;

//TODO Make this dialogue so that it loads the exercise it is to add volume for and at it accordingly. Also For ALL cases
//add arrays to store title, date,
public class AddVolumeDialog extends AppCompatDialogFragment {
    private static final String PREFS = Constants.PREFS;
    private static final String EXERCISE = "EXERCISE";
    private static final String MUSCLE_STRING = "MUSCLESTRING";
    private static final String NECK_TALLY = "com.example.application.scifit.NECK_TALLY";
    private static final String UPPERTRAP_TALLY = "com.example.application.scifit.UPPERTRAP_TALLY";
    //Lower TRAPS
    private static final String LOWERTRAP_TALLY = "com.example.application.scifit.LOWERTRAP_TALLY";

    //Posterior Deltoid
    private static final String POSTERIORDELTOID_TALLY = "com.example.application.scifit.POSTERIORDELTOID_TALLY";

    //Posterior Deltoid
    private static final String MEDIALDELTOID_TALLY = "com.example.application.scifit.MEDIALDELTOID_TALLY";

    //ANTERIOR DELTOID
    private static final String ANTERIORDELTOID_TALLY = "com.example.application.scifit.ANTERIORDELTOID_TALLY";


    //ROTATOR CUFF
    private static final String ROTATORCUFF_TALLY = "com.example.application.scifit.ROTATORCUFF_TALLY";


    //Triceps
    private static final String TRICEPS_TALLY = "com.example.application.scifit.TRICEPS_TALLY";


    //ULNARFOREARM
    private static final String ULNARFOREARM_TALLY = "com.example.application.scifit.ULNARFOREARM_TALLY";


    //FOREARMExtensors
    private static final String FOREARMEXTENSORS_TALLY = "com.example.application.scifit.FOREARMEXTENSORS_TALLY";


    //FOREARMFLEXORS
    private static final String FOREARMFLEXORS_TALLY = "com.example.application.scifit.FOREARMFLEXORS_TALLY";


    //ANTERIOR DELTOID
    private static final String RADIALFOREARM_TALLY = "com.example.application.scifit.RADIALFOREARM_TALLY";


    //LATS
    private static final String LATS_TALLY = "com.example.application.scifit.LATS_TALLY";


    //ERECTORS
    private static final String ERECTORS_TALLY = "com.example.application.scifit.ERECTORS_TALLY";

    //GLUTES
    private static final String GLUTES_TALLY = "com.example.application.scifit.GLUTES_TALLY";


    //GLUTEMEDIUS
    private static final String GLUTEMEDIUS_TALLY = "com.example.application.scifit.GLUTEMEDIUS_TALLY";


    //HAMSTRINGS
    private static final String HAMSTRINGS_TALLY = "com.example.application.scifit.HAMSTRINGS_TALLY";

    //CALVES
    private static final String CALVES_TALLY = "com.example.application.scifit.CALVES_TALLY";

    //CHEST
    private static final String CHEST_TALLY = "com.example.application.scifit.CHEST_TALLY";

    //BICEPS
    private static final String BICEPS_TALLY = "com.example.application.scifit.BICEPS_TALLY";

    //SERRATUS
    private static final String SERRATUS_TALLY = "com.example.application.scifit.SERRATUS_TALLY";

    //ABS
    private static final String ABS_TALLY = "com.example.application.scifit.ABS_TALLY";

    //OBLIQUES
    private static final String OBLIQUES_TALLY = "com.example.application.scifit.OBLIQUES_TALLY";

    //TRANSVERSE
    private static final String TRANSVERSE_TALLY = "com.example.application.scifit.TRANSVERSE_TALLY";

    //TRANSVERSE
    private static final String QUADS_TALLY = "com.example.application.scifit.QUADS_TALLY";


    //TODO BELOW ARE THE MUSCLES TO BE ADDED
    //SHORT AND MEDIAL TRICEPS
    private static final String SHORTRI_TALLY = "com.example.application.scifit.TRANSVERSE_TALLY";
    //BRACHIALIS
    private static final String BRACHIALIS_TALLY = "com.example.application.scifit.TRANSVERSE_TALLY";
    //BICEP FEMORIS
    private static final String BICEPFEMORIS_TALLY = "com.example.application.scifit.TRANSVERSE_TALLY";
    //SEMOTENDINOSUS
    private static final String SEMITENDINOSUS_TALLY = "com.example.application.scifit.TRANSVERSE_TALLY";
    //NECK ROTATOR
    private static final String NECKROTATOR_TALLY = "com.example.application.scifit.TRANSVERSE_TALLY";
    //NECK ROTATOR
    private static final String LATROWS_TALLY = "com.example.application.scifit.LATROWS_TALLY";
    //NECK ROTATOR
    private static final String LATPUSHDOWNS_TALLY = "com.example.application.scifit.LATPUSHDOWNS_TALLY";
    //NECK ROTATOR
    private static final String LATPULLDOWN_TALLY = "com.example.application.scifit.LATPULLDOWN_TALLY";

    private static final String TIBIALIS_TALLY = "com.example.application.scifit.TIBIALIS_TALLY";


    private final Context mContext;
    private EditText mvolume;
    private EditText mreps;
    private EditText mweight;
    private EditText mrpe;
    private EditText mnotes;

    //private EditText mvolume;
    public AddVolumeDialog(Context mContext, int dialogeTheme) {
        this.mContext = mContext;
    }

    private final TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
          //  POTENTIALLY USELESS CODE
//            if (actionId == EditorInfo.IME_ACTION_NEXT) {
//                SharedPreferences sp = mContext.getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
//                String sets = mvolume.getText().toString();
//                int neckTally = Integer.parseInt(sets);
//                neckTally = neckTally * 10;
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putInt(NECK_TALLY, neckTally);
//                editor.apply();
//
//                Intent intent = new Intent(mContext, Dashboards.class);
//                //intent.putExtra(NECK_TALLY, neckTally);
//
//                startActivity(intent);
//
//                return true;
//            }
            return false;
        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogeTheme);


        TextView textView = new TextView(getContext());
        textView.setText("Add Volume");
        textView.setPadding(455, 30, 20, 30);
        textView.setTextSize(20F);
        textView.setBackgroundColor(Color.BLACK);
        textView.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.colorAccent));


        builder.setCustomTitle(textView);


        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        final View view = inflater.inflate(R.layout.add_exercise_volume_dialog, null);

        //below are the edit texts that receive
        mvolume = view.findViewById(R.id.add_sets);
        mvolume.setOnEditorActionListener(editorListener);
        mvolume.setFocusableInTouchMode(true);

        mreps = view.findViewById(R.id.add_reps);
        mreps.setOnEditorActionListener(editorListener);
        mreps.setFocusableInTouchMode(true);

        mweight = view.findViewById(R.id.add_weight);
        mweight.setOnEditorActionListener(editorListener);
        mweight.setFocusableInTouchMode(true);

        mrpe = view.findViewById(R.id.add_rpe);
        mrpe.setOnEditorActionListener(editorListener);
        mrpe.setFocusableInTouchMode(true);

        mnotes = view.findViewById(R.id.add_notes);
        mnotes.setOnEditorActionListener(editorListener);
        mnotes.setFocusableInTouchMode(true);

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
                        SharedPreferences.Editor editor = sp.edit();
                        String sets = mvolume.getText().toString();
                        if (sets.equals("")){
                            //TODO display toast
                        }
                        String reps = mreps.getText().toString();

                        if (reps.equals("")){
                            reps = "0";
                        }
                        String weight = mweight.getText().toString();
                        if (weight.equals("")){
                            weight = "0";
                        }
                        String rpe = mrpe.getText().toString();
                        if (rpe.equals("")){
                            rpe = "0";
                        }
                        String notes = mnotes.getText().toString();
                        if (notes.equals("")){
                            notes = "No notes for this set.";
                        }

                        float volumeFloat;

                        if (weight.equals("0") || reps.equals("0")){
                            volumeFloat = (float) 0.0;
                        } else {
                            volumeFloat = Float.parseFloat(weight) * Float.parseFloat(reps);

                        }

                        String volume = Float.toString(volumeFloat);

                        //Download strings to know what exercise we're talking about
                        String muscleString = sp.getString(MUSCLE_STRING, "No MusCle, no GaiNs");
                        String exercise = sp.getString(EXERCISE, "No MusCle, no GaiNs");


                        //Compare information to latest entry to see if it should combine
                        String lastTitle = sp.getString(Constants.LAST_TITLE, "No last title");
                        // Log.e("LAST TITLE:", lastTitle);
                        String lastRpe = sp.getString(Constants.LAST_RPE, "No last rpe");
                        // Log.e("LAST rpe:", lastRpe);

                        String lastVolume = sp.getString(Constants.LAST_VOLUME, "No las volume");
                        //Log.e("LAST VOLUME:", lastVolume);

                        boolean combineLatest = exercise.equals(lastTitle) && rpe.equals(lastRpe) && volume.equals(lastVolume);
                        boolean titleEQ = exercise.equals(lastTitle);
                        boolean volumeEQ = volume.equals(lastVolume);
                        boolean rpeEQ = rpe.equals(lastRpe);

                        Log.e("COMBINE LAST:", combineLatest + "\nTitles are equal :" + titleEQ
                                + "\nVolumes are equal :" + volumeEQ + "\n//rpes are equal :" + rpeEQ);

                        if (combineLatest) {
                            addRepeatedSet(sp, editor, sets, muscleString, exercise);
                            Log.e("Combining entries:", "Inside the if statement ");


                        } else {
                            Log.e("NOT Combining entries:", "Inside the else statement ");

                            addVolumeForExercise(sp, editor, muscleString, exercise,  sets, weight,  rpe, volume, notes, reps);

                        }




                    }
                });
        mvolume.requestFocus();

        mvolume.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                InputMethodManager keyboard = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                assert keyboard != null;
                Objects.requireNonNull(keyboard).showSoftInput(mvolume, 0);
            }
        }, 0);

        view.setBackgroundColor(ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.colorPrimaryDark));

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

    public void addTally(SharedPreferences.Editor editor,
                         String muscleString, String exercise, String sets){

        //add tally accordingly

        //NECK
        if (muscleString.equals("Neck")) {
            //CreateList
            int neckTally = Integer.parseInt(sets);
            neckTally = neckTally * 10;
            editor.putInt(NECK_TALLY, neckTally);
            editor.apply();
            Intent intent = new Intent(mContext, Dashboards.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
            startActivity(intent);
        } else if (muscleString.equals("Upper Traps")) {

            String[] upperTrapsExercises = {"Trap Pushaway", "Farmer Walk", "Trap Bar Shrugs",
                    "Dumbbell Shrugs", "Upper Traps", "Cable Shrugs"};
            List<String> upperTrapList = Arrays.asList(upperTrapsExercises);

            //UPPER TRAPS
            if(upperTrapList.contains(exercise)){
                int upperTrapTally = Integer.parseInt(sets);
                upperTrapTally = upperTrapTally * 10;
                editor.putInt(UPPERTRAP_TALLY, upperTrapTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

            } else if(exercise.equals("Inverted Y")){

                int upperTrapTally = Integer.parseInt(sets);
                upperTrapTally = upperTrapTally * 10;
                editor.putInt(UPPERTRAP_TALLY, upperTrapTally);
                int lowerTrapTally = Integer.parseInt(sets);
                lowerTrapTally = lowerTrapTally * 10;
                editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

            } else if(exercise.equals("Deadlift")){

                int upperTrapTally = Integer.parseInt(sets);
                upperTrapTally = upperTrapTally * 10;
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

        } else {
            boolean containsFPExercise = exercise.equals("Ring Facepulls") || exercise.equals("W's") || exercise.equals("Facepulls");
            if (muscleString.equals("Lower Traps")) {

                String[] lowerTrapExercises = {"Lower Traps", "Y Raise", "Hanging/Cable\nScapular Retraction", "Prone Press", "Floor/Dip Bar\nScapularDepression"};
                List<String> lowerTrapList = Arrays.asList(lowerTrapExercises);
                String[] postDeltExercises = {"Barbell/Dumbbell High Rows", "Banded Pull Aparts", "Reverse Pec Dec"};
                List<String> postDeltList = Arrays.asList(postDeltExercises);

                if(lowerTrapList.contains(exercise)){
                    int lowerTrapTally = Integer.parseInt(sets);
                    lowerTrapTally = lowerTrapTally * 10;
                    editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (exercise.equals("Inverted Y")) {
                    int upperTrapTally = Integer.parseInt(sets);
                    upperTrapTally = upperTrapTally * 10;
                    editor.putInt(UPPERTRAP_TALLY, upperTrapTally);
                    int lowerTrapTally = Integer.parseInt(sets);
                    lowerTrapTally = lowerTrapTally * 10;
                    editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                    editor.apply();
                }  else if (postDeltList.contains(exercise)) {
                    int lowerTrapTally = Integer.parseInt(sets);
                    lowerTrapTally = lowerTrapTally * 10;
                    editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                    int posteriorDeltoidTally = Integer.parseInt(sets);
                    posteriorDeltoidTally = posteriorDeltoidTally * 10;
                    editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    //  intent.putExtra(LowerTrap_TALLY, lowerTrapTally);
                    startActivity(intent);
                } else if (containsFPExercise) {
                    int rotatorCuffTally = Integer.parseInt(sets);
                    rotatorCuffTally = rotatorCuffTally * 10;
                    editor.putInt(ROTATORCUFF_TALLY, rotatorCuffTally);
                    int lowerTrapTally = Integer.parseInt(sets);
                    lowerTrapTally = lowerTrapTally * 10;
                    editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                    int posteriorDeltoidTally = Integer.parseInt(sets);
                    posteriorDeltoidTally = posteriorDeltoidTally * 10;
                    editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (exercise.equals("Angels of Death")) {
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
                    startActivity(intent);
                }
                //TODO continue here. Final solution is to add the logic of tallies to thi

            } else if (muscleString.equals("Posterior Deltoids")) {
                String[] postDeltExercises = {"Barbell/Dumbbell High Rows", "Banded Pull Aparts", "Reverse Pec Dec"};
                List<String> postDeltList = Arrays.asList(postDeltExercises);
                String[] postDeltIsoExercises = {"Floor T's", "Posterior Deltoid"};
                List<String> postDeltIsoList = Arrays.asList(postDeltIsoExercises);
                if (postDeltList.contains(exercise)) {

                    int lowerTrapTally = Integer.parseInt(sets);
                    lowerTrapTally = lowerTrapTally * 10;
                    editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                    int posteriorDeltoidTally = Integer.parseInt(sets);
                    posteriorDeltoidTally = posteriorDeltoidTally * 10;
                    editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (postDeltIsoList.contains(exercise)) {

                    int posteriorDeltoidTally = Integer.parseInt(sets);
                    posteriorDeltoidTally = posteriorDeltoidTally * 10;
                    editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (containsFPExercise) {
                    int rotatorCuffTally = Integer.parseInt(sets);
                    rotatorCuffTally = rotatorCuffTally * 10;
                    editor.putInt(ROTATORCUFF_TALLY, rotatorCuffTally);
                    int lowerTrapTally = Integer.parseInt(sets);
                    lowerTrapTally = lowerTrapTally * 10;
                    editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                    int posteriorDeltoidTally = Integer.parseInt(sets);
                    posteriorDeltoidTally = posteriorDeltoidTally * 10;
                    editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                }
    //Todo check from her and up if the isolation list have the muscle grup in there
            } else if (muscleString.equals("Medial Deltoids")) {
                String[] lateralDeltExercises = {"Banded Lateral Raise", "Lateral Raise", "Delt Rotating Plank", "Cable Lateral Raises", "Machine Lateral Raise", "Medial Deltoid"};
                List<String> lateralDeltList = Arrays.asList(lateralDeltExercises);

                if (lateralDeltList.contains(exercise)) {
                    int medialDeltoidTally = Integer.parseInt(sets);
                    medialDeltoidTally = medialDeltoidTally * 10;
                    editor.putInt(MEDIALDELTOID_TALLY, medialDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (exercise.equals("Cheat Lateral Raise")){
                    int medialDeltoidTally = Integer.parseInt(sets);
                    medialDeltoidTally = medialDeltoidTally * 10;
                    editor.putInt(MEDIALDELTOID_TALLY, medialDeltoidTally);
                    int upperTrapTally = Integer.parseInt(sets);
                    upperTrapTally = upperTrapTally * 10;
                    editor.putInt(UPPERTRAP_TALLY, upperTrapTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                }

            } else if (muscleString.equals("Anterior Deltoids")) {
                String[] OHPExercises = {"Anterior Deltoid", "Barbell Overhead Press", "Dumbbell OHP", "Arnolds", "Cable Stretch to OHP", "Landmine Press", "Machine Shoulder Press", "Push Press", "Handstand Pushup", "Pike Pushup"};
                List<String> OHP = Arrays.asList(OHPExercises);

                if (OHP.contains(exercise)) {
                    int anteriorDeltoidTally = Integer.parseInt(sets);
                    anteriorDeltoidTally = anteriorDeltoidTally * 10;
                    editor.putInt(ANTERIORDELTOID_TALLY, anteriorDeltoidTally);
                    int TricepsTally = Integer.parseInt(sets);
                    TricepsTally = TricepsTally * 10;
                    TricepsTally = TricepsTally / 2;
                    editor.putInt(TRICEPS_TALLY, TricepsTally);
                    int medialDeltoidTally = Integer.parseInt(sets);
                    medialDeltoidTally = medialDeltoidTally * 10;
                    medialDeltoidTally = medialDeltoidTally / 2;
                    editor.putInt(MEDIALDELTOID_TALLY, medialDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (exercise.equals("Cable Front Raise")) {
                    int anteriorDeltoidTally = Integer.parseInt(sets);
                    anteriorDeltoidTally = anteriorDeltoidTally * 10;
                    editor.putInt(ANTERIORDELTOID_TALLY, anteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                    //todo continue here
                }
            } else if (muscleString.equals("Rotator Cuffs")) {
                String[] rotatorCuffExercises = {"Dumbbell High Pull", "Cable External Rotation", "Bench/Dumbbell External Rotation", "Banded External Rotation"};
                List<String> rotatorList = Arrays.asList(rotatorCuffExercises);

                if (rotatorList.contains(exercise)) {
                    int rotatorCuffTally = Integer.parseInt(sets);
                    rotatorCuffTally = rotatorCuffTally * 10;
                    editor.putInt(ROTATORCUFF_TALLY, rotatorCuffTally);
                    int forearmExtensorsTally = Integer.parseInt(sets);
                    forearmExtensorsTally = forearmExtensorsTally * 10;
                    forearmExtensorsTally = forearmExtensorsTally / 2;
                    editor.putInt(FOREARMEXTENSORS_TALLY, forearmExtensorsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (containsFPExercise) {
                    int rotatorCuffTally = Integer.parseInt(sets);
                    rotatorCuffTally = rotatorCuffTally * 10;
                    editor.putInt(ROTATORCUFF_TALLY, rotatorCuffTally);
                    int lowerTrapTally = Integer.parseInt(sets);
                    lowerTrapTally = lowerTrapTally * 10;
                    editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                    int posteriorDeltoidTally = Integer.parseInt(sets);
                    posteriorDeltoidTally = posteriorDeltoidTally * 10;
                    editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (exercise.equals("Rotator Cuffs")) {
                    int rotatorCuffTally = Integer.parseInt(sets);
                    rotatorCuffTally = rotatorCuffTally * 10;
                    editor.putInt(ROTATORCUFF_TALLY, rotatorCuffTally);
                }

            } else if (muscleString.equals("Triceps")) {

                String[] TricepsExercises = {"Triceps", "Incline Skull Crushers",
                        "Cable Rope Pushdowns", "V Bar Pushdowns", "Rope Overhead Triceps\nExtension",
                        "Long Head Triceps Push Downs", "Triceps Kickback", "Triceps Extension",
                        "Ring Overhead Extension", "Bench Dip"};
                List<String> TricepsList = Arrays.asList(TricepsExercises);
                String[] californiaPressExercises = {"California Press", "Close Grip Dumbbell Press"};
                List<String> californiaPressList = Arrays.asList(californiaPressExercises);

                if (TricepsList.contains(exercise)) {
                    int TricepsTally = Integer.parseInt(sets);
                    TricepsTally = TricepsTally * 10;
                    editor.putInt(TRICEPS_TALLY, TricepsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (californiaPressList.contains(exercise)){

                    int TricepsTally = Integer.parseInt(sets);
                    TricepsTally = TricepsTally * 10;
                    editor.putInt(TRICEPS_TALLY, TricepsTally);
                    int chestTally = Integer.parseInt(sets);
                    chestTally = chestTally * 10;
                    chestTally = chestTally / 2;
                    editor.putInt(CHEST_TALLY, chestTally);
                    int anteriorDeltoidTally = Integer.parseInt(sets);
                    anteriorDeltoidTally = anteriorDeltoidTally * 10;
                    anteriorDeltoidTally = anteriorDeltoidTally / 2;
                    editor.putInt(ANTERIORDELTOID_TALLY, anteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if( exercise.equals("Narrow Dip") || exercise.equals("Narrow Pushup")){

                    int TricepsTally = Integer.parseInt(sets);
                    TricepsTally = TricepsTally * 10;
                    editor.putInt(TRICEPS_TALLY, TricepsTally);
                    int chestTally = Integer.parseInt(sets);
                    chestTally = chestTally * 10;
                    editor.putInt(CHEST_TALLY, chestTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                }


            } else if (muscleString.equals("Ulnar Forearms")) {

                int ulnarForearmTally = Integer.parseInt(sets);
                ulnarForearmTally = ulnarForearmTally * 10;
                editor.putInt(ULNARFOREARM_TALLY, ulnarForearmTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

            } else if (muscleString.equals("Forearm Extensors")) {

                int forearmExtensorsTally = Integer.parseInt(sets);
                forearmExtensorsTally = forearmExtensorsTally * 10;
                editor.putInt(FOREARMEXTENSORS_TALLY, forearmExtensorsTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

    //            String[] extensionExercises = {"Standing Barbell Wrist Extension", "Barbell Extension Rolls", "Reverse Curls", "Banded Wrist Extension", "Triceps Extension", "Ring Overhead Extension", "Bench Dip"};
    //            List<String> extensionList = Arrays.asList(extensionExercises);

            } else if (muscleString.equals("Forearm Flexors")) {

                if (exercise.equals("Wrist Flexed Curls")){

                    int bicepsTally = Integer.parseInt(sets);
                    bicepsTally = bicepsTally * 10;
                    editor.putInt(BICEPS_TALLY, bicepsTally);
                    int forearmFlexorTally = Integer.parseInt(sets);
                    forearmFlexorTally = forearmFlexorTally * 10;
                    editor.putInt(FOREARMFLEXORS_TALLY, forearmFlexorTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else {

                    int forearmFlexorTally = Integer.parseInt(sets);
                    forearmFlexorTally = forearmFlexorTally * 10;
                    editor.putInt(FOREARMFLEXORS_TALLY, forearmFlexorTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                }

            } else if (muscleString.equals("Radial Forearms")) {

                if (exercise.equals("Wrist Flexed Curls")){

                    int bicepsTally = Integer.parseInt(sets);
                    bicepsTally = bicepsTally * 10;
                    editor.putInt(BICEPS_TALLY, bicepsTally);
                    int forearmFlexorTally = Integer.parseInt(sets);
                    forearmFlexorTally = forearmFlexorTally * 10;
                    editor.putInt(FOREARMFLEXORS_TALLY, forearmFlexorTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else {

                    int forearmFlexorTally = Integer.parseInt(sets);
                    forearmFlexorTally = forearmFlexorTally * 10;
                    editor.putInt(FOREARMFLEXORS_TALLY, forearmFlexorTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                }

            } else if (muscleString.equals("Lats")) {

                String[] rowsExercises = {"High Pulley Row", "Chest Supported Rows", "Australian Pull Up", "Ring Rows"};
                List<String> rowsList = Arrays.asList(rowsExercises);
                String[] suspendedRowsExercises = {"Cable Rows", "Barbell Rows"};
                List<String> suspendedRowsList = Arrays.asList(suspendedRowsExercises);
                String[] latLeverExercises = {"Front Levers", "Lat Pull Over", "Lat Pushdowns"};
                List<String> latLeverList = Arrays.asList(latLeverExercises);
                String[] pullUpExercises = {"Pull Ups", "Cable Pulldown"};
                List<String> pullUpList = Arrays.asList(pullUpExercises);
                String[]latIsoExercises = {"Lats", "Pull Ins"};
                List<String> latIsoList = Arrays.asList(latIsoExercises);

                if (latLeverList.contains(exercise)) {

                    int latsTally = Integer.parseInt(sets);
                    latsTally = latsTally * 10;
                    editor.putInt(LATS_TALLY, latsTally);
                    int TricepsTally = Integer.parseInt(sets);
                    TricepsTally = TricepsTally * 10;
                    editor.putInt(TRICEPS_TALLY, TricepsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                }  else if (suspendedRowsList.contains(exercise)) {

                    int posteriorDeltoidTally = Integer.parseInt(sets);
                    posteriorDeltoidTally = posteriorDeltoidTally * 10;
                    posteriorDeltoidTally = posteriorDeltoidTally / 2;
                    editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                    int lowerTrapTally = Integer.parseInt(sets);
                    lowerTrapTally = lowerTrapTally * 10;
                    editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                    int bicepsTally = Integer.parseInt(sets);
                    bicepsTally = bicepsTally * 10;
                    bicepsTally = bicepsTally / 2;
                    editor.putInt(BICEPS_TALLY, bicepsTally);
                    int erectorsTally = Integer.parseInt(sets);
                    erectorsTally = erectorsTally * 10;
                    editor.putInt(ERECTORS_TALLY, erectorsTally);
                    int forearmFlexorTally = Integer.parseInt(sets);
                    forearmFlexorTally = forearmFlexorTally * 10;
                    forearmFlexorTally = forearmFlexorTally / 2;
                    editor.putInt(FOREARMFLEXORS_TALLY, forearmFlexorTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (rowsList.contains(exercise)) {

                    int latsTally = Integer.parseInt(sets);
                    latsTally = latsTally * 10;
                    editor.putInt(LATS_TALLY, latsTally);
                    int posteriorDeltoidTally = Integer.parseInt(sets);
                    posteriorDeltoidTally = posteriorDeltoidTally * 10;
                    posteriorDeltoidTally = posteriorDeltoidTally / 2;
                    editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                    int lowerTrapTally = Integer.parseInt(sets);
                    lowerTrapTally = lowerTrapTally * 10;
                    editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                    int bicepsTally = Integer.parseInt(sets);
                    bicepsTally = bicepsTally * 10;
                    bicepsTally = bicepsTally / 2;
                    editor.putInt(BICEPS_TALLY, bicepsTally);
                    int forearmFlexorTally = Integer.parseInt(sets);
                    forearmFlexorTally = forearmFlexorTally * 10;
                    forearmFlexorTally = forearmFlexorTally / 2;
                    editor.putInt(FOREARMFLEXORS_TALLY, forearmFlexorTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (latIsoList.contains(exercise)) {

                    int latsTally = Integer.parseInt(sets);
                    latsTally = latsTally * 10;
                    editor.putInt(LATS_TALLY, latsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if(pullUpList.contains(exercise)){

                    int latsTally = Integer.parseInt(sets);
                    latsTally = latsTally * 10;
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

                } else if (exercise.equals("Chin Ups")) {

                    int latsTally = Integer.parseInt(sets);
                    latsTally = latsTally * 10;
                    editor.putInt(LATS_TALLY, latsTally);
                    int bicepsTally = Integer.parseInt(sets);
                    bicepsTally = bicepsTally * 10;
                    editor.putInt(BICEPS_TALLY, bicepsTally);
                    editor.apply();
                    int forearmFlexorTally = Integer.parseInt(sets);
                    forearmFlexorTally = forearmFlexorTally * 10;
                    forearmFlexorTally = forearmFlexorTally / 2;
                    editor.putInt(FOREARMFLEXORS_TALLY, forearmFlexorTally);
                    editor.apply();
                    int lowerTrapTally = Integer.parseInt(sets);
                    lowerTrapTally = lowerTrapTally * 10;
                    lowerTrapTally = lowerTrapTally / 2;
                    editor.putInt(LOWERTRAP_TALLY, lowerTrapTally);
                    editor.apply();
                    int posteriorDeltoidTally = Integer.parseInt(sets);
                    posteriorDeltoidTally = posteriorDeltoidTally * 10;
                    posteriorDeltoidTally = posteriorDeltoidTally / 2;
                    editor.putInt(POSTERIORDELTOID_TALLY, posteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                }



            } else if (muscleString.equals("Erectors")) {

                String[] erectorsExercises = {"Erectors", "Hyperextension", "Machine Erector Extension"};
                List<String> erectorsList = Arrays.asList(erectorsExercises);

                if (erectorsList.contains(exercise)) {
                    int erectorsTally = Integer.parseInt(sets);
                    erectorsTally = erectorsTally * 10;
                    editor.putInt(ERECTORS_TALLY, erectorsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if(exercise.equals("Deadlift")){

                    int upperTrapTally = Integer.parseInt(sets);
                    upperTrapTally = upperTrapTally * 10;
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
                    startActivity(intent);
                } else if(exercise.equals("Squats")){

                    int quadsTally = Integer.parseInt(sets);
                    quadsTally = quadsTally * 10;
                    editor.putInt(QUADS_TALLY, quadsTally);
                    int erectorsTally = Integer.parseInt(sets);
                    erectorsTally = erectorsTally * 10;
                    editor.putInt(ERECTORS_TALLY, erectorsTally);
                    int TransverseTally = Integer.parseInt(sets);
                    TransverseTally = TransverseTally * 10;
                    TransverseTally = TransverseTally / 2;
                    editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    glutesTally = glutesTally / 2;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if(exercise.equals("Frog Pumps")){

                    int erectorsTally = Integer.parseInt(sets);
                    erectorsTally = erectorsTally * 10;
                    editor.putInt(ERECTORS_TALLY, erectorsTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (exercise.equals("Angels of Death")){

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

                } else if (exercise.equals("Marching Bridge")){

                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    int erectorsTally = Integer.parseInt(sets);
                    erectorsTally = erectorsTally * 10;
                    editor.putInt(ERECTORS_TALLY, erectorsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                }

            } else if (muscleString.equals("Glute Max")) {

                String[] gluteHamExercises = {"Cable Kick Backs", "Glute Hyperextension", "Kettlebell/Dumbbell Swing", "Cable Pull Through"};
                List<String> gluteHamList = Arrays.asList(gluteHamExercises);
                String[] hipThrustExercises = {"Hip Thrust", "Bodyweight Hip Thrust"};
                List<String> hipThrustList = Arrays.asList(hipThrustExercises);

                if (gluteHamList.contains(exercise)) {
                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
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
                } else if (hipThrustList.contains(exercise)) {
                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    int hamstringsTally = Integer.parseInt(sets);
                    hamstringsTally = hamstringsTally * 10;
                    hamstringsTally = hamstringsTally / 2;
                    editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    gluteMediusTally = gluteMediusTally / 2;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    int erectorsTally = Integer.parseInt(sets);
                    erectorsTally = erectorsTally * 10;
                    editor.putInt(ERECTORS_TALLY, erectorsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if(exercise.equals("Glute Max")){

                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if(exercise.equals("Isolateral Hip Thrust")){

                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    int hamstringsTally = Integer.parseInt(sets);
                    hamstringsTally = hamstringsTally * 10;
                    hamstringsTally = hamstringsTally / 2;
                    editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if(exercise.equals("Sprinter Lunge")){

                    int quadsTally = Integer.parseInt(sets);
                    quadsTally = quadsTally * 10;
                    editor.putInt(QUADS_TALLY, quadsTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    gluteMediusTally = gluteMediusTally / 2;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    int hamstringsTally = Integer.parseInt(sets);
                    hamstringsTally = hamstringsTally * 10;
                    hamstringsTally = hamstringsTally / 2;
                    editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if(exercise.equals("Banded RDL")){

                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    int hamstringsTally = Integer.parseInt(sets);
                    hamstringsTally = hamstringsTally * 10;
                    editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if(exercise.equals("Marching Bridge")){

                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    int erectorsTally = Integer.parseInt(sets);
                    erectorsTally = erectorsTally * 10;
                    editor.putInt(ERECTORS_TALLY, erectorsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                }

            } else if (muscleString.equals("Glute Medius")) {

                if (exercise.equals("Glute Side Plank")){

                    int obliquesTally = Integer.parseInt(sets);
                    obliquesTally = obliquesTally * 10;
                    editor.putInt(OBLIQUES_TALLY, obliquesTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else {

                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                }

            } else if (muscleString.equals("Hamstrings")) {

                String[] hamGluteExercises = {"Hamstring Hyperextension", "Romanian Deadlift", "Physioball Hamstring Curls", "Deficit Deadlift", "Glute Ham Raise", "Hamstring Curls"};
                List<String> hamGluteList = Arrays.asList(hamGluteExercises);
                String[] isoRDLExercises = {"Isolateral Hamstring Curls", "Single Leg Romanian Deadlift"};
                List<String> isoRDLList = Arrays.asList(isoRDLExercises);

                if (hamGluteList.contains(exercise)) {

                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    glutesTally = glutesTally / 2;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    int hamstringsTally = Integer.parseInt(sets);
                    hamstringsTally = hamstringsTally * 10;
                    editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                    int erectorsTally = Integer.parseInt(sets);
                    erectorsTally = erectorsTally * 10;
                    erectorsTally = erectorsTally / 2;
                    editor.putInt(ERECTORS_TALLY, erectorsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (isoRDLList.contains(exercise)) {

                    int hamstringsTally = Integer.parseInt(sets);
                    hamstringsTally = hamstringsTally * 10;
                    editor.putInt(HAMSTRINGS_TALLY, hamstringsTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    glutesTally = glutesTally / 2;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    int erectorsTally = Integer.parseInt(sets);
                    erectorsTally = erectorsTally * 10;
                    erectorsTally = erectorsTally / 2;
                    editor.putInt(ERECTORS_TALLY, erectorsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                }

            } else if (muscleString.equals("Calves")) {

                int calvesTally = Integer.parseInt(sets);
                calvesTally = calvesTally * 10;
                editor.putInt(CALVES_TALLY, calvesTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

            } else if (muscleString.equals("Chest")) {

                String[] chestPressExercises = {"Incline Cable Press", "Incline Dumbbell Press", "Incline Bench Press"};
                List<String> chestPressList = Arrays.asList(chestPressExercises);

                String[] chestTricepsExercises = {"Decline Cable Press", "Decline Bench Press", "Decline Dumbbell Press", "Narrow Dip"};
                List<String> chestTricepsList = Arrays.asList(chestTricepsExercises);

                String[] dipExercises = {"Wide Dip", "Narrow Pushup", "Pushups", "Bench Press",
                        "Neutral Cable Press", "Machine Chest Press", "Dumbbell Chest Press"};
                List<String> dipList = Arrays.asList(dipExercises);
                String[] chestExercises = {"Horizontal Crossover Flyes", "Decline Crossover Flyes"};
                List<String> chestList = Arrays.asList(chestExercises);

                if (chestPressList.contains(exercise)) {

                    int TricepsTally = Integer.parseInt(sets);
                    TricepsTally = TricepsTally * 10;
                    editor.putInt(TRICEPS_TALLY, TricepsTally);
                    int chestTally = Integer.parseInt(sets);
                    chestTally = chestTally * 10;
                    editor.putInt(CHEST_TALLY, chestTally);
                    int anteriorDeltoidTally = Integer.parseInt(sets);
                    anteriorDeltoidTally = anteriorDeltoidTally * 10;
                    editor.putInt(ANTERIORDELTOID_TALLY, anteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    //  intent.putExtra(TRICEPS_TALLY, TricepsTally);
                    startActivity(intent);

                } else if(chestTricepsList.contains(exercise)){

                    int TricepsTally = Integer.parseInt(sets);
                    TricepsTally = TricepsTally * 10;
                    editor.putInt(TRICEPS_TALLY, TricepsTally);
                    int chestTally = Integer.parseInt(sets);
                    chestTally = chestTally * 10;
                    editor.putInt(CHEST_TALLY, chestTally);
                    int anteriorDeltoidTally = Integer.parseInt(sets);
                    anteriorDeltoidTally = anteriorDeltoidTally * 10;
                    anteriorDeltoidTally = anteriorDeltoidTally / 2;
                    editor.putInt(ANTERIORDELTOID_TALLY, anteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (dipList.contains(exercise)) {

                    int TricepsTally = Integer.parseInt(sets);
                    TricepsTally = TricepsTally * 10;
                    editor.putInt(TRICEPS_TALLY, TricepsTally);
                    int chestTally = Integer.parseInt(sets);
                    chestTally = chestTally * 10;
                    editor.putInt(CHEST_TALLY, chestTally);
                    int anteriorDeltoidTally = Integer.parseInt(sets);
                    anteriorDeltoidTally = anteriorDeltoidTally * 10;
                    anteriorDeltoidTally = anteriorDeltoidTally / 2;
                    editor.putInt(ANTERIORDELTOID_TALLY, anteriorDeltoidTally);
                    editor.apply();

                } else if (chestList.contains(exercise)) {

                    int chestTally = Integer.parseInt(sets);
                    chestTally = chestTally * 10;
                    editor.putInt(CHEST_TALLY, chestTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (exercise.equals("Chest Pullover")) {
                    int chestTally = Integer.parseInt(sets);
                    chestTally = chestTally * 10;
                    editor.putInt(CHEST_TALLY, chestTally);
                    int latsTally = Integer.parseInt(sets);
                    latsTally = latsTally * 10;
                    latsTally = latsTally / 2;
                    editor.putInt(LATS_TALLY, latsTally);
                    int TricepsTally = Integer.parseInt(sets);
                    TricepsTally = TricepsTally * 10;
                    editor.putInt(TRICEPS_TALLY, TricepsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (exercise.equals("Incline Crossover Flyes")) {
                    int chestTally = Integer.parseInt(sets);
                    chestTally = chestTally * 10;
                    editor.putInt(CHEST_TALLY, chestTally);
                    int anteriorDeltoidTally = Integer.parseInt(sets);
                    anteriorDeltoidTally = anteriorDeltoidTally * 10;
                    editor.putInt(ANTERIORDELTOID_TALLY, anteriorDeltoidTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                }

            } else if (muscleString.equals("Biceps")) {

                String[] curlExercises = {"Cable/Dumbbell Spider Curls", "Banded Curls", "Preacher Curls", "Wide EZ Bar Curls", "Narrow EZ Bar Curls", "Narrow Barbell Curls", "Barbell Curls", "Narrow Dumbbell Curls", "Dumbbell Curls"};
                List<String> curlList = Arrays.asList(curlExercises);
                String[] bicepExercises = {"Limp Wrist Curls", "Bicep Isometric", "Ring Curls"};
                List<String> bicepList = Arrays.asList(bicepExercises);

                if (curlList.contains(exercise)) {

                    int bicepsTally = Integer.parseInt(sets);
                    bicepsTally = bicepsTally * 10;
                    editor.putInt(BICEPS_TALLY, bicepsTally);
                    int forearmFlexorTally = Integer.parseInt(sets);
                    forearmFlexorTally = forearmFlexorTally * 10;
                    forearmFlexorTally = forearmFlexorTally / 2;
                    editor.putInt(FOREARMFLEXORS_TALLY, forearmFlexorTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (bicepList.contains(exercise)){
                    int bicepsTally = Integer.parseInt(sets);
                    bicepsTally = bicepsTally * 10;
                    editor.putInt(BICEPS_TALLY, bicepsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                }

            } else if (muscleString.equals("Serratus")) {

                String[] absSerratusExercises = {"Plank/Dip Protraction", "Protracted Roll Out", "Protracted Cable Crunch"};
                List<String> absSerratusList = Arrays.asList(absSerratusExercises);
                String[] serratusExercises = {"Serratus Anterior", "Banded/Cable Punches"};
                List<String> serratusList = Arrays.asList(serratusExercises);

                if (absSerratusList.contains(exercise)) {
                    int serratusTally = Integer.parseInt(sets);
                    serratusTally = serratusTally * 10;
                    editor.putInt(SERRATUS_TALLY, serratusTally);
                    int TransverseTally = Integer.parseInt(sets);
                    TransverseTally = TransverseTally * 10;
                    TransverseTally = TransverseTally / 2;
                    editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                    int absTally = Integer.parseInt(sets);
                    absTally = absTally * 10;
                    editor.putInt(ABS_TALLY, absTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if(serratusList.contains(exercise)){
                    int serratusTally = Integer.parseInt(sets);
                    serratusTally = serratusTally * 10;
                    editor.putInt(SERRATUS_TALLY, serratusTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                }



            } else if (muscleString.equals("Abs")) {

                String[] absExercises = {"Abs", "Leg Raises", "Hanging Leg Raise", "Reverse Crunches", "Pulse Up", "Cable Crunch", "V-Up", "Band Crunch", "Ab Rollout"};
                List<String> absList = Arrays.asList(absExercises);

                if (absList.contains(exercise)) {
                    int absTally = Integer.parseInt(sets);
                    absTally = absTally * 10;
                    editor.putInt(ABS_TALLY, absTally);
                    int TransverseTally = Integer.parseInt(sets);
                    TransverseTally = TransverseTally * 10;
                    TransverseTally = TransverseTally / 2;
                    editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (exercise.equals("Ab Circles")) {
                    int absTally = Integer.parseInt(sets);
                    absTally = absTally * 10;
                    editor.putInt(ABS_TALLY, absTally);
                    int TransverseTally = Integer.parseInt(sets);
                    TransverseTally = TransverseTally * 10;
                    TransverseTally = TransverseTally / 2;
                    editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                    int obliquesTally = Integer.parseInt(sets);
                    obliquesTally = obliquesTally * 10;
                    editor.putInt(OBLIQUES_TALLY, obliquesTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                }

            } else if (muscleString.equals("Obliques")) {

                String[] obliqueAbTransverseExercises = {"Twisting Leg Raise", "Elbow to Knee Tucks", "Banded/Cable Step Out", "Twisting Pulse Up", "Rotating Plank", "Elbow to Knee Plank", "X-Crunch"};
                List<String> obliqueAbTransverseList = Arrays.asList(obliqueAbTransverseExercises);
                String[] obliqueTransverseExercises = {"Neutral Wood Choppers", "Low to High Wood Choppers", "High to Low Wood Choppers"};
                List<String> obliqueTransverseList = Arrays.asList(obliqueTransverseExercises);

                if (obliqueTransverseList.contains(exercise)){
                    int obliquesTally = Integer.parseInt(sets);
                    obliquesTally = obliquesTally * 10;
                    editor.putInt(OBLIQUES_TALLY, obliquesTally);
                    int TransverseTally = Integer.parseInt(sets);
                    TransverseTally = TransverseTally * 10;
                    TransverseTally = TransverseTally / 2;
                    editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (obliqueAbTransverseList.contains(exercise)){
                    int obliquesTally = Integer.parseInt(sets);
                    obliquesTally = obliquesTally * 10;
                    editor.putInt(OBLIQUES_TALLY, obliquesTally);
                    int TransverseTally = Integer.parseInt(sets);
                    TransverseTally = TransverseTally * 10;
                    TransverseTally = TransverseTally / 2;
                    editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                    int absTally = Integer.parseInt(sets);
                    absTally = absTally * 10;
                    absTally = absTally / 2;
                    editor.putInt(ABS_TALLY, absTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else if (exercise.equals("Leg Raise Scissors")){
                    int obliquesTally = Integer.parseInt(sets);
                    obliquesTally = obliquesTally * 10;
                    editor.putInt(OBLIQUES_TALLY, obliquesTally);
                    int TransverseTally = Integer.parseInt(sets);
                    TransverseTally = TransverseTally * 10;
                    TransverseTally = TransverseTally / 2;
                    editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                    int absTally = Integer.parseInt(sets);
                    absTally = absTally * 10;
                    absTally = absTally / 2;
                    editor.putInt(ABS_TALLY, absTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                } else  if (exercise.equals("Obliques")){
                    int obliquesTally = Integer.parseInt(sets);
                    obliquesTally = obliquesTally * 10;
                    editor.putInt(OBLIQUES_TALLY, obliquesTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);
                }


            } else if (muscleString.equals("Transverse Ab")) {

                String[] transIso = {"Transverse Ab", "Vacuums"};
                List<String> transIsoList = Arrays.asList(transIso);

                if (transIsoList.contains(exercise)){

                    int TransverseTally = Integer.parseInt(sets);
                    TransverseTally = TransverseTally * 10;
                    editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (exercise.equals("Banded/Cable Resisted Rotation")){

                    int obliquesTally = Integer.parseInt(sets);
                    obliquesTally = obliquesTally * 10;
                    editor.putInt(OBLIQUES_TALLY, obliquesTally);
                    int TransverseTally = Integer.parseInt(sets);
                    TransverseTally = TransverseTally * 10;
                    editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                }

            } else if (muscleString.equals("Quads")) {

                String[] quadsGluteMediusExercises = {"Bulgarian Split Squat", "Explosive Bulgarian Split Squat", "Lunges"};
                List<String> quadsGluteMediusList = Arrays.asList(quadsGluteMediusExercises);
                String[] quadsExercises = {"Leg Press", "Cable Walkaways", "Banded Lunge"};
                List<String> quadsList = Arrays.asList(quadsExercises);

                if (quadsGluteMediusList.contains(exercise)) {

                    int quadsTally = Integer.parseInt(sets);
                    quadsTally = quadsTally * 10;
                    editor.putInt(QUADS_TALLY, quadsTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    gluteMediusTally = gluteMediusTally / 2;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (quadsList.contains(exercise)) {

                    int quadsTally = Integer.parseInt(sets);
                    quadsTally = quadsTally * 10;
                    editor.putInt(QUADS_TALLY, quadsTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (exercise.equals("Bodyweight Squats")) {

                    int quadsTally = Integer.parseInt(sets);
                    quadsTally = quadsTally * 10;
                    editor.putInt(QUADS_TALLY, quadsTally);
                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (exercise.equals("Squats")) {

                    int quadsTally = Integer.parseInt(sets);
                    quadsTally = quadsTally * 10;
                    editor.putInt(QUADS_TALLY, quadsTally);
                    int erectorsTally = Integer.parseInt(sets);
                    erectorsTally = erectorsTally * 10;
                    editor.putInt(ERECTORS_TALLY, erectorsTally);
                    int TransverseTally = Integer.parseInt(sets);
                    TransverseTally = TransverseTally * 10;
                    TransverseTally = TransverseTally / 2;
                    editor.putInt(TRANSVERSE_TALLY, TransverseTally);
                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    glutesTally = glutesTally / 2;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (exercise.equals("Pistol Squats")) {

                    int quadsTally = Integer.parseInt(sets);
                    quadsTally = quadsTally * 10;
                    editor.putInt(QUADS_TALLY, quadsTally);
                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    glutesTally = glutesTally / 2;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (exercise.equals("Side Lunge") || exercise.equals("Banded Leg Press")) {

                    int quadsTally = Integer.parseInt(sets);
                    quadsTally = quadsTally * 10;
                    editor.putInt(QUADS_TALLY, quadsTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                } else if (exercise.equals("Lunges")) {


                    int quadsTally = Integer.parseInt(sets);
                    quadsTally = quadsTally * 10;
                    editor.putInt(QUADS_TALLY, quadsTally);
                    int gluteMediusTally = Integer.parseInt(sets);
                    gluteMediusTally = gluteMediusTally * 10;
                    gluteMediusTally = gluteMediusTally / 2;
                    editor.putInt(GLUTEMEDIUS_TALLY, gluteMediusTally);
                    int glutesTally = Integer.parseInt(sets);
                    glutesTally = glutesTally * 10;
                    glutesTally = glutesTally / 2;
                    editor.putInt(GLUTES_TALLY, glutesTally);
                    editor.apply();
                    Intent intent = new Intent(mContext, Dashboards.class);
                    startActivity(intent);

                }
    //TODO below are the muscles that are missin still need to add to list and take away from current
            } else if (muscleString.equals("Anterior Tibialis")) {

                String[] tibialisExercises = {"Anterior Tibialis", "Tow Raises", " Machine Tibialis Raise"};
                List<String> tibialisList = Arrays.asList(tibialisExercises);

                int tibialisTally = Integer.parseInt(sets);
                tibialisTally = tibialisTally * 10;
                editor.putInt(TIBIALIS_TALLY, tibialisTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

            } else if (muscleString.equals("Short and Medial Triceps")) {

                String[] shortTriExercises = {"", " ", "   "};
                List<String> shortTriList = Arrays.asList(shortTriExercises);

                int shortTriTally = Integer.parseInt(sets);
                shortTriTally = shortTriTally * 10;
                editor.putInt(SHORTRI_TALLY, shortTriTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

            } else if (muscleString.equals("Brachialis")) {

                String[] brachialisExercises = {"", " ", "   "};
                List<String> brachialisList = Arrays.asList(brachialisExercises);

                int brachialisTally = Integer.parseInt(sets);
                brachialisTally = brachialisTally * 10;
                editor.putInt(BRACHIALIS_TALLY, brachialisTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

            } else if (muscleString.equals("Bicep Femoris")) {

                String[] shortTriExercises = {"Hamstring Curls", " ", "   "};
                List<String> shortTriList = Arrays.asList(shortTriExercises);

                int bicepFemorisTally = Integer.parseInt(sets);
                bicepFemorisTally = bicepFemorisTally * 10;
                editor.putInt(BICEPFEMORIS_TALLY, bicepFemorisTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

            } else if (muscleString.equals("Semitendinosus and Semimembranosus")) {

                String[] shortTriExercises = {"", " ", "   "};
                List<String> shortTriList = Arrays.asList(shortTriExercises);

                int semitendinosusTally = Integer.parseInt(sets);
                semitendinosusTally = semitendinosusTally * 10;
                editor.putInt(SEMITENDINOSUS_TALLY, semitendinosusTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

            } else if (muscleString.equals("Neck Rotators")) {

                String[] shortTriExercises = {"", " ", "   "};
                List<String> shortTriList = Arrays.asList(shortTriExercises);

                int neckrotatorTally = Integer.parseInt(sets);
                neckrotatorTally = neckrotatorTally * 10;
                editor.putInt(NECKROTATOR_TALLY, neckrotatorTally);
                editor.apply();
                Intent intent = new Intent(mContext, Dashboards.class);
                startActivity(intent);

            }
        }
    }

    public void addRepeatedSet(SharedPreferences sp, SharedPreferences.Editor editor, String sets, String muscleString, String exercise){//, String exercise, String rpe, String volume){

            //retrieve sets array and add the last element to the current input
            String[] setsArray = sp.getString(Constants.SETS_HISTORY_LIST, "--`").split("`");
            int totalSets = Integer.parseInt(setsArray[setsArray.length - 1]) + Integer.parseInt(sets);

            //Log.e("Calculated total sets", Integer.toString(totalSets));


            //Log.e("Last sets, current sets", setsArray[setsArray.length - 1] + "current" +sets);
            setsArray[setsArray.length - 1] = totalSets + "`";
            Log.e("Last set value in array", setsArray[setsArray.length - 1] );


            StringBuilder sb = new StringBuilder();
int count = 0;
            for (String s : setsArray) {
                Log.e("Set Entry: ", s +"  Count: " + Integer.toString(count));
                count += 1;
                sb.append(s + "`");

            }
        Log.e("Sets string value", sb.toString());
        editor.putString(Constants.SETS_HISTORY_LIST, sb.toString()).apply();
        addTally(editor, muscleString, exercise, sets);
    }


    public void addVolumeForExercise( SharedPreferences sp, SharedPreferences.Editor editor,
                                     String muscleString, String exercise, String sets, String weight,
                                      String rpe, String volume, String notes, String reps) {

        // the following logic dowloads the history list and if it fails it then creates one and stores it
        //These two variables are here to be able to combine equal consecutive entries.
        //Their equivalents are declared where used otherwise
        String setHistoryListString = sp.getString(Constants.SETS_HISTORY_LIST, "noSetHistoryYet");


        if (!(sets.equals(""))) {

            String exerciseHistoryListString = sp.getString(Constants.EXERCISE_HISTORY_LIST, "noHistoryYet");

            if (exerciseHistoryListString.equals("noHistoryYet")) {
                String exerciseFirstEntry = exercise + "`"; //create the list and add exercise
              //  Log.e("title if: ", exercise);
                editor.putString(Constants.EXERCISE_HISTORY_LIST, exerciseFirstEntry).apply();
                editor.putString(Constants.LAST_TITLE, exercise).apply();
            } else {


                StringBuilder sb = new StringBuilder();
                sb.append(exerciseHistoryListString).append(exercise).append("`");
                //  Log.e("title else: ", exercise);
                editor.putString(Constants.EXERCISE_HISTORY_LIST, sb.toString()).apply();
                editor.putString(Constants.LAST_TITLE, exercise).apply();

            }

            //Log.e("PAST-------", "PAST ADD tALLY, ON TO ADDING DATE STRING");
            String exerciseDatesListString = sp.getString(Constants.DATES_HISTORY_LIST, "noDatesYet");

            @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String dateString = dateFormat.format(date);

            if (exerciseDatesListString.equals("noDatesYet")) {

                String dateFirstEntry = dateString + "`"; //create the list and add exercise
               // Log.e("date if: ", dateString);
                editor.putString(Constants.DATES_HISTORY_LIST, dateFirstEntry).apply();

            } else {

                StringBuilder sb = new StringBuilder();
                sb.append(exerciseDatesListString).append(dateString).append("`");
               // Log.e("date else: ", dateString);
                editor.putString(Constants.DATES_HISTORY_LIST, sb.toString()).apply();


            }

            //sets


            if (setHistoryListString.equals("noSetHistoryYet")) {
                String setFirstEntry = sets + "`"; //create the list and add exercise
               // Log.e("sets if: ", sets);
                editor.putString(Constants.SETS_HISTORY_LIST, setFirstEntry).apply();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(setHistoryListString).append(sets).append("`");
               // Log.e("sets else: ", sets);
                editor.putString(Constants.SETS_HISTORY_LIST, sb.toString()).apply();

            }

            //reps

            String repsHistoryListString = sp.getString(Constants.REPS_HISTORY_LIST, "noSetHistoryYet");

            if (repsHistoryListString.equals("noSetHistoryYet")) {
                String repsFirstEntry = reps + "`"; //create the list and add exercise
               // Log.e("reps if: ", reps);
                editor.putString(Constants.REPS_HISTORY_LIST, repsFirstEntry).apply();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(repsHistoryListString).append(reps).append("`");
                //Log.e("reps else: ", reps);
                editor.putString(Constants.REPS_HISTORY_LIST, sb.toString()).apply();

            }

            //weight

            String weightHistoryListString = sp.getString(Constants.WEIGHT_HISTORY_LIST, "noWeightHistoryYet");

            if (weightHistoryListString.equals("noWeightHistoryYet")) {
                String weightFirstEntry = weight + "`"; //create the list and add exercise
                //Log.e("weight if: ", weight);
                editor.putString(Constants.WEIGHT_HISTORY_LIST, weightFirstEntry).apply();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(weightHistoryListString).append(weight).append("`");
                //Log.e("weight else: ", weight);

                editor.putString(Constants.WEIGHT_HISTORY_LIST, sb.toString()).apply();

            }

            //vOLUME

            String volumeHistoryListString = sp.getString(Constants.VOLUME_HISTORY_LIST, "noVolumeHistoryYet");

            if (volumeHistoryListString.equals("noVolumeHistoryYet")) {
                String volumeFirstEntry = volume + "`"; //create the list and add exercise
                editor.putString(Constants.LAST_VOLUME, volume).apply();
                //Log.e("volume if: ", volume);
                editor.putString(Constants.VOLUME_HISTORY_LIST, volumeFirstEntry).apply();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(volumeHistoryListString).append(volume).append("`");
                //Log.e("volume else: ", volume);
                editor.putString(Constants.VOLUME_HISTORY_LIST, sb.toString()).apply();
                editor.putString(Constants.LAST_VOLUME, volume).apply();


            }
            //RPE

            String rpeHistoryListString = sp.getString(Constants.RPE_HISTORY_LIST, "noRPEHistoryYet");

            if (rpeHistoryListString.equals("noRPEHistoryYet")) {
                String rpeFirstEntry = rpe + "`"; //create the list and add exercise
                editor.putString(Constants.LAST_RPE, rpe).apply();
                //Log.e("rpe if: ", rpe);
                editor.putString(Constants.RPE_HISTORY_LIST, rpeFirstEntry).apply();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(rpeHistoryListString).append(rpe).append("`");
                //Log.e("rpe else: ", rpe);
                editor.putString(Constants.RPE_HISTORY_LIST, sb.toString()).apply();
                editor.putString(Constants.LAST_RPE, rpe).apply();


            }
            //NOTES

            String notesHistoryListString = sp.getString(Constants.NOTES_HISTORY_LIST, "noNotesHistoryYet");

            if (notesHistoryListString.equals("noNotesHistoryYet")) {
                String notesFirstEntry = notes + "`"; //create the list and add exercise
                //Log.e("history if: ", notes);
                editor.putString(Constants.NOTES_HISTORY_LIST, notesFirstEntry).apply();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(notesHistoryListString).append(notes).append("`");
                //Log.e("history else: ", notes);
                editor.putString(Constants.NOTES_HISTORY_LIST, sb.toString()).apply();

            }

            addTally(editor, muscleString, exercise, sets);


        }else {
            Toast toast= Toast.makeText(getContext(),
                    "Your string here", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
    }


    public interface ExampleDialogListener {
        void addVolume();

    }

}
