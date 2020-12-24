package com.AesthetX.aesthetx.Classes.MuscleGroupObjects;
import android.widget.ProgressBar;

public class HistoryList {
//Initialize the information to be displayed in recyclerview cells
    private final String exerciseTitleInit;



    private final String dateTextInit;
    private final String setsTextInit;
    private final String repsTextInit;
    private final String weightTextInit;
    private final String volumeTextInit;
    private final String rpeTextInit;

//Constructor: define parameters to be passed in object/class initialization and
// assign them to the variable declarations above

    public HistoryList(String exerciseTitle, String dateText, String setsText,
                       String repsText, String weightText, String volumeText, String rpeText) {
        exerciseTitleInit = exerciseTitle;
        dateTextInit = dateText;
        setsTextInit = setsText;
        repsTextInit = repsText;
        weightTextInit = weightText;
        volumeTextInit = volumeText;
        rpeTextInit = rpeText;
    }

//Functions to return data when object is initialized
    public String setexerciseTitle() {
        return exerciseTitleInit;
    }

    public String setDateText() {
        return dateTextInit;
    }

    public String setSetsText() {
        return setsTextInit;
    }

    public String setRepsText() {
        return repsTextInit;
    }

    public String setWeightText() {
        return weightTextInit;
    }

    public String setVolumeText() {
        return volumeTextInit;
    }

    public String setRpeText() {
        return rpeTextInit;
    }

}
