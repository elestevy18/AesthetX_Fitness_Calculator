package com.AesthetX.aesthetx.Classes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

import java.util.Objects;

public class NotesAndRPE extends AppCompatActivity {

    String note, pR, vPR;
    String [] weights, volumes, notes;
    private static final String PREFS = Constants.PREFS;
    TextView noteTxt, prTxt, vPRTxt;
    float  prFloat, vPRFloat;
    int notePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_and_r_p_e);


        noteTxt =findViewById(R.id.notesText);

        SharedPreferences sp = Objects.requireNonNull(this).getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        notes  = sp.getString(Constants.NOTES_HISTORY_LIST, "--`").split("`");
        notePosition  = sp.getInt(Constants.NOTE_POSITION, 0);
        note = notes[notePosition];
        if(!(note.equals("No notes for this set."))){

            //find highest weight and volume in for loop
            weights = sp.getString(Constants.WEIGHT_HISTORY_LIST, "--`").split("`");
            volumes = sp.getString(Constants.VOLUME_HISTORY_LIST, "--`").split("`");

            for(int i = 0; i < weights.length; i++){

                prFloat = 0;
                vPRFloat = 0;

                if(Float.parseFloat(weights[i]) > prFloat){
                    prFloat = Float.parseFloat(weights[i]);
                }

                if(Float.parseFloat(volumes[i]) > prFloat){
                    vPRFloat = Float.parseFloat(volumes[i]);
                }
            }
            prTxt = findViewById(R.id.pRtext);
            prTxt.setText(Float.toString(prFloat));

            vPRTxt =findViewById(R.id.vPRtext);
            vPRTxt.setText(Float.toString(vPRFloat));

        }
        Log.e("Position and note: ", Integer.toString(notePosition) + note);
        noteTxt.setText(notes[notes.length - notePosition - 1]);






    }
}