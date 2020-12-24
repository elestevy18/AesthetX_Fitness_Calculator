package com.AesthetX.aesthetx.AddVolume.Form;


        import android.app.AlertDialog;
        import android.app.Dialog;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.content.ContextCompat;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.AesthetX.aesthetx.Classes.Constants;
        import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.ErectorsList;
        import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.ExerciseListByMuscleGroup;
        import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.ExerciseListByMuscleGroup;
        import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.GlutesList;
        import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;
        import com.AesthetX.aesthetx.PopUpDialogs.AbCirclesDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddAbsSerratusVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddAbsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddAngelOfDeathDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddAnteriorDeltoidVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddBicepsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddCaliforniaPressDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddCalvesVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddChestDeltVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddChestPressDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddChestTricepsDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddChestVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddChinUpsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddCurlsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddDeadliftVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddDiaphragmVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddDipDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddErectorsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddFacePullDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddForearmCurlsDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddForearmExtensorVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddForearmFlexorVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddGluteErectorDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddGluteHamDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddGluteMediusVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddGlutesVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddHalfLowerTrapPostDeltDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddHamGluteDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddHammerCurlVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddHamstringsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddHighPullDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddHipThrustVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddIsoHipThrustDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddIsoRDLDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddLatLeverVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddLatsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddLowerTrapPostDeltDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddLowerTrapVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddMedialDeltoidVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddObliquesVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddPistolSquatDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddPosteriorDeltoidVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddProtractionDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddPullOverDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddPullUpVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddQuadsGluteMediusDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddQuadsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddRadialForearmVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddRotatorCuffVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddRowsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddSerratusVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddSquatDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddSuspendedRowsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddTrapDeltDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddTricepsLatVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddTricepsVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddUlnarForearmVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.AddUpperTrapVolumeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.ErectorGluteMedius;
        import com.AesthetX.aesthetx.PopUpDialogs.GluteGluteMediusHamstrings;
        import com.AesthetX.aesthetx.PopUpDialogs.GluteMediusHalfObliques;
        import com.AesthetX.aesthetx.PopUpDialogs.OHPDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.ObliqueAbDiaphragmDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.ObliqueAbDiaphragmFullDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.ObliqueDiaphragmDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.ObliqueDiaphragmFullDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.QuadGluteMediusFullDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.QuadsGluteGluteMediusDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.QuadsHalfGlute;
        import com.AesthetX.aesthetx.PopUpDialogs.SideLungeDialog;
        import com.AesthetX.aesthetx.PopUpDialogs.SprinterLungeDialog;
        import com.example.scifit.R;


        import java.util.ArrayList;
        import java.util.Objects;

        import com.AesthetX.aesthetx.Classes.Adapters.NeckExerciseAdapter;
        import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.ExerciseListByMuscleGroup;
        import com.AesthetX.aesthetx.PopUpDialogs.AddVolumeDialog;

// wHAT THIS CLASS DOES IS READ THE TITLE OF THE MUSCLE GROUP CLICKED O THE MUSCLE TRACKER AND DISPLAY THE EXERCISES
// ACCORDING THIS. THEN, WHEN A USER CLICKS ON ADD SET IT DIRECTS TO THE DIALOGUE BOX
public class ExercisesByMuscle extends AppCompatActivity implements NeckExerciseAdapter.OnItemClickListener,
        AddVolumeDialog.ExampleDialogListener, AddUpperTrapVolumeDialog.ExampleDialogListener,
        AddDeadliftVolumeDialog.ExampleDialogListener, AddLowerTrapVolumeDialog.ExampleDialogListener, AddAngelOfDeathDialog.ExampleDialogListener,
        AddPosteriorDeltoidVolumeDialog.ExampleDialogListener, AddHalfLowerTrapPostDeltDialog.ExampleDialogListener, AddFacePullDialog.ExampleDialogListener,
        AddMedialDeltoidVolumeDialog.ExampleDialogListener, AddTrapDeltDialog.ExampleDialogListener,
        AddAnteriorDeltoidVolumeDialog.ExampleDialogListener, OHPDialog.ExampleDialogListener,
        AddRotatorCuffVolumeDialog.ExampleDialogListener, AddTricepsVolumeDialog.ExampleDialogListener, AddTricepsLatVolumeDialog.ExampleDialogListener,
        AddDipDialog.ExampleDialogListener, AddHighPullDialog.ExampleDialogListener, AddUlnarForearmVolumeDialog.ExampleDialogListener,
        AddForearmExtensorVolumeDialog.ExampleDialogListener, AddRadialForearmVolumeDialog.ExampleDialogListener, AddHammerCurlVolumeDialog.ExampleDialogListener,
        AddLatsVolumeDialog.ExampleDialogListener, AddSuspendedRowsVolumeDialog.ExampleDialogListener, AddRowsVolumeDialog.ExampleDialogListener,
        AddLatLeverVolumeDialog.ExampleDialogListener, AddPullUpVolumeDialog.ExampleDialogListener, AddChinUpsVolumeDialog.ExampleDialogListener,
        AddErectorsVolumeDialog.ExampleDialogListener, AddGlutesVolumeDialog.ExampleDialogListener, AddHipThrustVolumeDialog.ExampleDialogListener,
        AddGluteHamDialog.ExampleDialogListener, AddHamGluteDialog.ExampleDialogListener, AddGluteMediusVolumeDialog.ExampleDialogListener,
        AddIsoHipThrustDialog.ExampleDialogListener, AddIsoRDLDialog.ExampleDialogListener, AddPistolSquatDialog.ExampleDialogListener, AddHamstringsVolumeDialog.ExampleDialogListener,
        AddCalvesVolumeDialog.ExampleDialogListener, AddChestVolumeDialog.ExampleDialogListener, AddPullOverDialog.ExampleDialogListener, AddChestDeltVolumeDialog.ExampleDialogListener,
        AddBicepsVolumeDialog.ExampleDialogListener, AddCurlsVolumeDialog.ExampleDialogListener, AddSerratusVolumeDialog.ExampleDialogListener,
        AddProtractionDialog.ExampleDialogListener, AddAbsSerratusVolumeDialog.ExampleDialogListener, AddAbsVolumeDialog.ExampleDialogListener, AbCirclesDialog.ExampleDialogListener,
        AddObliquesVolumeDialog.ExampleDialogListener, ObliqueAbDiaphragmDialog.ExampleDialogListener, ObliqueAbDiaphragmFullDialog.ExampleDialogListener,
        ObliqueDiaphragmDialog.ExampleDialogListener, AddDiaphragmVolumeDialog.ExampleDialogListener, AddQuadsVolumeDialog.ExampleDialogListener,
        AddSquatDialog.ExampleDialogListener, QuadGluteMediusFullDialog.ExampleDialogListener, QuadsGluteGluteMediusDialog.ExampleDialogListener,
        SprinterLungeDialog.ExampleDialogListener, SideLungeDialog.ExampleDialogListener, ObliqueDiaphragmFullDialog.ExampleDialogListener, AddForearmFlexorVolumeDialog.ExampleDialogListener,
        AddCaliforniaPressDialog.ExampleDialogListener, AddChestPressDialog.ExampleDialogListener, AddForearmCurlsDialog.ExampleDialogListener, AddChestTricepsDialog.ExampleDialogListener,
        AddLowerTrapPostDeltDialog.ExampleDialogListener, AddQuadsGluteMediusDialog.ExampleDialogListener, GluteGluteMediusHamstrings.ExampleDialogListener, AddGluteErectorDialog.ExampleDialogListener,
        ErectorGluteMedius.ExampleDialogListener, GluteMediusHalfObliques.ExampleDialogListener, QuadsHalfGlute.ExampleDialogListener  {
    //Declarations
    private static final String PREFS = Constants.PREFS;
    private static final String EXERCISE = "EXERCISE";
    private static final String MUSCLE_STRING = "MUSCLESTRING";

    private EditText volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_by_muscle);
        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String muscleString = sp.getString(MUSCLE_STRING, "No MusCle, no GaiNs");

        Log.e("Muscle: ", muscleString);
        //Code was intially implemented by making a seperate class for every muscle group to diplay a muscle.
        // This was a naive approach as it made too many unnesecarry files.
        //Neck exercise list is
        final ArrayList<ExerciseListByMuscleGroup> ExercisesListList = new ArrayList<>();


        //todo make sure// that you spell this the same as in the dialog. DO THIS BY MAKING SURE YOU COPY FROM GLOBAL EXERCISE
//Make sure you add the muscle ony too because your taking it form the global list
        if (muscleString.equals("Neck")) {
            //CreateList
            ExercisesListList.add(new ExerciseListByMuscleGroup("Neck", "One Neck Set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Plate Curl", "Neck Flexion"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Neck Harness Curl", "Neck Flexion"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Plated Neck Extension", "Neck Extension"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Harness Lateral Flexion", "Lateral Flexion"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Suspended Neck Rotation", "Neck Flexion, Rotation"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Neck Flexion", "Lateral and Forward Flexion"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Head Floats", "Neck Flexion, Lateral Flexion or Extension"));

        } else if (muscleString.equals("Upper Traps")) {
            
            ExercisesListList.add(new ExerciseListByMuscleGroup("Upper Traps", "One Upper Traps set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Dumbbell Shrugs", "Upper Trap"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Shrugs", "Upper Trap"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Trap Bar Shrugs", "Upper Trap"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Farmer Walk", "Upper Trap"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Trap Pushaway", "Upper Trapezoid"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Inverted Y", "Upper and Lower Trapezoid"));
            //TODO deadlifts
            ExercisesListList.add(new ExerciseListByMuscleGroup("Deadlift", "Hamstrings, Erectors, Upper Traps" +
                    " \nSecondary: Lats, Glutes, Lower Trap, Transverse"));


        } else if (muscleString.equals("Lower Traps")) {
            
            //LOWER TRAP
            ExercisesListList.add(new ExerciseListByMuscleGroup("Lower Traps", "One Lower Traps set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Y Raise", "Lower Traps"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Hanging/Cable\nScapular Retraction", "Lower Traps"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Angels of Death", "Spinal Erectors, Lower Traps, Post Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Floor/Dip Bar\nScapular Depression", "Lower Traps"));
           
        } else if (muscleString.equals("Posterior Deltoids")) {
            //POSTERIOR Deltoids
            ExercisesListList.add(new ExerciseListByMuscleGroup("Posterior Deltoids", "One Posterior Deltoids set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Facepulls", "Rotator Cuff, Lower Trap, Posterior Deltoids"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Barbell/Dumbbell High Rows", "Posterior Deltoids, Lower Trap"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("W's", "Rotator Cuff, Secondary: Posterior Deltoids"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Reverse Pec Dec", "Lower Traps, Post Delts"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Floor T's", "Posterior Deltoids"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded Pull Aparts", "Posterior Delt, Lower Traps"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Ring Facepulls", "Posterior Deltoids, Rotator Cuff, Lower Traps"));
         
        } else if (muscleString.equals("Medial Deltoids")) {
            //MEDIAL Deltoids
            ExercisesListList.add(new ExerciseListByMuscleGroup("Medial Deltoids", "One Medial Deltoids set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Lateral Raises", "Medial Deltoids"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Lateral Raise", "Medial Deltoids"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Machine Lateral Raise", "Medial Deltoids"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cheat Lateral Raise", "Medial Deltoids, Upper Trap"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Delt Rotating Plank", "Medial Deltoids"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded Lateral Raise", "Medial Deltoids"));

        } else if (muscleString.equals("Anterior Deltoids")) {
            //ANTERIOR Deltoids
            ExercisesListList.add(new ExerciseListByMuscleGroup("Anterior Deltoids", "One Anterior Deltoids set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Arnolds", "Anterior Delt Secondary: Triceps, Medial Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Barbell Overhead Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Dumbbell OHP", "Anterior Delt Secondary: Triceps, Medial Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Front Raise", "Anterior Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Stretch to OHP", "Anterior Delt Secondary: Triceps, Medial Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Landmine Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Machine Shoulder Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Push Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Pike Pushup", "Anterior Delt Secondary: Triceps, Medial Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Handstand Pushup", "Anterior Delt, Secondary: Triceps, Medial Delt"));

        } else if (muscleString.equals("Rotator Cuffs")) {
            //ROTATOR CUFF
            ExercisesListList.add(new ExerciseListByMuscleGroup("Rotator Cuffs", "One Rotator Cuffs set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable External Rotation", "Rotator Cuff, Forearm Extensors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Bench Dumbbell\nExternal Rotation", "Rotator Cuff, Forearm Extensors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded External Rotation", "Rotator Cuff, Forearm Extensors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Dumbbell High Pull", "Rotator Cuff, Forearm Extensors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Bench/Dumbbell External Rotation", "Rotator Cuff, Forearm Extensors"));


        } else if (muscleString.equals("Triceps")) {

            //Triceps
            ExercisesListList.add(new ExerciseListByMuscleGroup("Triceps", "One Triceps set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("California Press", "Triceps; All Heads\nSecondary: Chest, Anterior Deltoids "));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Incline Skull Crushers", "Triceps; Long Head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Narrow Dip", "Triceps; All Heads, Chest"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Rope Pushdowns", "Triceps; Medial and Short Head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("V Bar Pushdowns", "Triceps; Medial and Short Head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Close Grip Dumbbell Press", "Triceps Short And Medial Head\nSecondary: Chest, Anterior Deltoids "));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Rope Overhead Triceps\nExtension", "Triceps; Long Head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Long Head Triceps Push Downs", "Triceps; Long Head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Triceps Kickback", "Triceps; Short Head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Narrow Pushup", "Triceps; Short and Medial Head, Chest\nSecondary: Anterior Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Triceps Extension", "Triceps; short and medial head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Ring Overhead Extension", "Triceps; long head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Bench Dip", "Triceps; All Heads"));

        } else if (muscleString.equals("Ulnar Forearms")) {
            
            //ULNAR
            ExercisesListList.add(new ExerciseListByMuscleGroup("Ulnar Forearms", "One Ulnar Forearms set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Rope Ulnar Deviation", "Ulnar Forearm"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded Ulnar Deviation", "Ulnar Forearm"));

        } else if (muscleString.equals("Forearm Extensors")) {

            //Extensors
            ExercisesListList.add(new ExerciseListByMuscleGroup("Forearm Extensors", "One Ulnar Forearms set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded Wrist Extension", "Forearm Extensors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Standing Barbell Wrist Extension", "Forearm Extensors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Barbell Extension Rolls", "Forearm Extensors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Reverse Curls", "Forearm Extensors"));

        } else if (muscleString.equals("Forearm Flexors")) {
            
            //FOREARMFLEXOR
            ExercisesListList.add(new ExerciseListByMuscleGroup("Forearm Flexors", "One Forearm Flexors set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded Wrist Curls", "Forearm Flexors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Prone Wrist Curls", "Forearm Flexors"));

        } else if (muscleString.equals("Radial Forearms")) {

            //RADIAL DEVIATION
            ExercisesListList.add(new ExerciseListByMuscleGroup("Radial Forearms", "One Radial Forearms set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Rope Radial Deviation", "Radial Forearm"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Hammer/Crossbody Curls", "Biceps; Brachialis, Radial Forearm"));

        } else if (muscleString.equals("Lats")) {
            //LATS
            ExercisesListList.add(new ExerciseListByMuscleGroup("Lats", "One Lats set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Lat Pull Over", "Lats Triceps"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Lat Pushdowns", "Lats Triceps"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Pulldown", "Lats, Lower Trap\nSecondary:Post Delt, Bicep, Forearms"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Front Levers", "Lats, Triceps"));

            ExercisesListList.add(new ExerciseListByMuscleGroup("Pull Ins", "Lats"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Pull Ups", "Lats, Lower Trap\nSecondary:Post Delt, Bicep, Forearms"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Chin Ups", "Lats, Lower Trap, Bicep\nSecondary: Post Delt, Forearms"));

            ExercisesListList.add(new ExerciseListByMuscleGroup("High Pulley Row", "Lats, Lower Traps\nSecondary: Post Delt, Biceps, Forearm Flexor"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Rows", "Lats, Lower Traps, Erectors\nSecondary: Post Delt, Biceps, Forearm Flexor"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Barbell Rows", "Lats, Lower Traps\nSecondary: Post Delt, Biceps, Forearm Flexor"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Chest Supported Rows", "Lats, Lower Traps\nSecondary: Post Delt, Biceps, Forearm Flexor"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Ring Rows", "Lats, Lower Traps\nSecondary:Post Delt, Biceps, Forearm"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Australian Pull Up", "Lats, Lower Traps\nSecondary: Post Delt, Biceps, Forearm "));

        } else if (muscleString.equals("Erectors")) {

            //ERECTOR
            ExercisesListList.add(new ExerciseListByMuscleGroup("Erectors", "One Erectors set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Hyperextension", "Spinal Erector"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Machine Erector Extension", "Spinal Erector"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Frog Pumps", "Spinal Erectors, Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Marching Bridge", "Spinal Erector, Glutes"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Deadlift", "Spinal Erector Secondary: Glutes, Hamstrings"));//
            ExercisesListList.add(new ExerciseListByMuscleGroup("Squats", "Quads Spinal Erector\nSecondary: Glutes, Hamstrings"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Angels of Death", "Spinal Erectors, Lower Traps, Post Delt"));


        } else if (muscleString.equals("Glute Max")) {
//TODO glute max
            //GLUTES
            ExercisesListList.add(new ExerciseListByMuscleGroup("Glute Max", "One Glutes set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Hip Thrust", "Glutes Secondary: Hamstrings, Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Isolateral Hip Thrust", "Glutes, Glute Medius Secondary: Hamstrings"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Pull Through", "Glutes Secondary: Hamstrings, Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Sprinter Lunge", "Glutes, Glute Medius Secondary: Hamstrings"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Glute Hyperextension", "Glutes Secondary: Hamstrings, Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Reverse Hyperextension", "Glutes Secondary:Spinal Erector, Hamstrings "));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Kettlebell/Dumbbell Swing", "Glutes Secondary: Hamstrings, Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Kick Backs", "Glutes Secondary: Hamstrings, Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded RDL", "Glutes, Glute Medius, Hamstrings"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Marching Bridge", "Spinal Erector, Glutes"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Bodyweight Hip Thrust", "Glutes Secondary: Hamstrings"));

        } else if (muscleString.equals("Glute Medius")) {

            //GLUTEMEDIUS
            ExercisesListList.add(new ExerciseListByMuscleGroup("Glute Medius", "One Glute Medius set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Machine Abduction", "Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded Lateral Walkout", "Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded Abduction", "Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Glute Side Plank", "Glute Medius, Secondary: Obliques"));

        } else if (muscleString.equals("Hamstrings")) {

            //HAMSTRINGS
            ExercisesListList.add(new ExerciseListByMuscleGroup("Hamstrings", "One Hamstrings set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Romanian Deadlift", "Hamstring Secondary: Glutes, Erectors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Hamstring Curls", "Hamstring Secondary: Glutes, Erectors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Hamstring Hyperextension", "Hamstring Secondary: Glutes, Erectors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Physioball Hamstring Curls", "Hamstring Secondary: Glutes, Erectors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Deficit Deadlift", "Hamstring Secondary: Glutes, Erectors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Glute Ham Raise", "Hamstring Secondary: Glutes, Erectors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Isolateral Hamstring Curls", "Hamstrings, Glute Medius\nSecondary: Glutes, Erectors"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Single Leg Romanian Deadlift", "Hamstrings, Glute Medius\nSecondary: Glutes, Erectors"));

        } else if (muscleString.equals("Calves")) {

            //CALVES
            ExercisesListList.add(new ExerciseListByMuscleGroup("Calves", "One Calves set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Machine Standing Calf Raise", "Calves"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Straight Leg Machine Calf Raise", "Calves"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Seated Calf Raise", "Calves"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Donkey Calf Raise", "Calves"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Dumbbell/Plated Calf Raise", "Calves"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Bodyweight Calf Raise", "Calves"));

        } else if (muscleString.equals("Chest")) {

            //CHEST
            ExercisesListList.add(new ExerciseListByMuscleGroup("Chest", "One Chest set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Bench Press", "Chest, Triceps Secondary: Anterior Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Dumbbell Chest Press", "Chest, Triceps Secondary: Anterior Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Machine Chest Press", "Chest, Triceps Secondary: Anterior Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Neutral Cable Press", "Chest, Triceps Secondary: Anterior Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Incline Cable Press", "Upper Pectoral, Triceps Anterior Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Decline Cable Press", "Lower Pectoral, Triceps"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Chest Pullover", "Upper Pectoral, Triceps Secondary: Lats"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Incline Crossover Flyes", "Upper Pectoral, Anterior Deltoids"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Horizontal Crossover Flyes", "Middle Pectoral"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Decline Crossover Flyes", "Lower Pectoral"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Pushups", "Chest, Triceps, Anterior Delt"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Wide Dip", "Lower Pectoral, Triceps Secondary: Anterior Delt"));

        } else if (muscleString.equals("Biceps")) {

            //BICEPS
            ExercisesListList.add(new ExerciseListByMuscleGroup("Biceps", "One Biceps set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Dumbbell Curls", "Bicep"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Narrow Dumbbell Curls", "Bicep; Short Head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Barbell Curls", "Bicep"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Narrow Barbell Curls", "Bicep; Short Head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Narrow EZ Bar Curls", "Bicep; Short Head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Wide EZ Bar Curls", "Bicep;Long Head"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Preacher Curls", "Bicep"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Limp Wrist Curls", "Bicep"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Bicep Isometric", "Bicep"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable/Dumbbell Spider Curls", "Bicep"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded Curls", "Bicep"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Ring Curls", "Bicep"));

        } else if (muscleString.equals("Serratus")) {

            //SERRATUS
            ExercisesListList.add(new ExerciseListByMuscleGroup("Serratus Anterior", "One Serratus set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Plank/Dip Protraction", "Serratus Anterior"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded/Cable Punches", "Serratus Anterior"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Protracted Roll Out", "Serratus Anterior, Abs Secondary: Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Protracted Cable Crunch", "Serratus Anterior, Abs Secondary: Transverse Ab"));

        } else if (muscleString.equals("Abs")) {
            //ABS
            //WHOLE ABS
            ExercisesListList.add(new ExerciseListByMuscleGroup("Abs", "One Abs set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Leg Raises", "Abs Secondary: Transverse Ab"));
            //LOWER Global
            ExercisesListList.add(new ExerciseListByMuscleGroup("Ab Circles", "Lower Abs, Obliques Secondary: Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Reverse Crunches", "Lower Abs Secondary: Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Pulse Up", "Lower Abs Secondary: Transverse Ab"));

            //MID ABS
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Crunch", "Middle Abs Secondary; Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Band Crunch", "Middle Abs Secondary; Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("V-Up", "Middle Abs Secondary; Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Ab Rollout", "Middle Abs Secondary; Transverse Ab"));


        } else if (muscleString.equals("Obliques")) {

            //OBLIQUES
            ExercisesListList.add(new ExerciseListByMuscleGroup("Obliques", "One Obliques set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Neutral Wood Choppers", "Mid Obliques Secondary: Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Low to High Wood Choppers", "Upper and Lower Obliques\nSecondary: Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("High to Low Wood Choppers", "Upper and Lower Obliques\nSecondary: Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Twisting Leg Raise", "Obliques Secondary: Transverse Ab, Lower Abs"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Leg Raise Scissors", "Obliques, Abs Secondary: Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Elbow to Knee Tucks", "Obliques\nSecondary: Transverse Ab, Middle Abs"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded/Cable Step Out", "Obliques Secondary: Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Rotating Plank", "Obliques Secondary: Abs Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Elbow to Knee Plank", "Obliques Secondary: Abs Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Twisting Pulse Up", "Obliques Secondary: Abs Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("X-Crunch", "Obliques Secondary: Abs, Transverse Ab"));

        } else if (muscleString.equals("Transverse Ab")) {
            //Transverse Ab
            ExercisesListList.add(new ExerciseListByMuscleGroup("Transverse Ab", "One Transverse Ab set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Vacuums", "Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded/Cable/Resisted Rotation", "Transverse Ab, Obliques"));

        } else if (muscleString.equals("Quads")) {
            //QUADS
            ExercisesListList.add(new ExerciseListByMuscleGroup("Quads", "One Quads set"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Squats", "Quads, Erectors\nSecondary: Glutes, Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Bodyweight Squats", "Quads Secondary: Glutes, Transverse Ab"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Lunges", "Quads Secondary: Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Bulgarian Split Squat", "Quads Secondary: Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Explosive Bulgarian Split Squat", "Quads Secondary: Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Pistol Squats", "Quads, Glute Medius Secondary: Glute"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Side Lunge", "Quads, Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded Lunge", "Quads"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Cable Walkaways", "Quads"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Banded Leg Press", "Quads, Glute Medius"));
            ExercisesListList.add(new ExerciseListByMuscleGroup("Leg Press", "Quads"));
        }
        //TODO missing muscles
        //else if (muscleString.equals("Anterior Tibialis")) {
//
//        } else if (muscleString.equals("Short and Medial Triceps")) {
//
//        } else if (muscleString.equals("Brachialis")) {
//
//        }
        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.ExerciseByMuscleRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        NeckExerciseAdapter mAdapter = new NeckExerciseAdapter(ExercisesListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    //Watch out for the typo

    public void onNeckClick(int position) {
        switch (position) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
        }
    }

    public void onAddNeckClick(int position) {
     //   switch (position) {
            stringcomparison(position);
//            case 0:
//            case 1:
//            case 2:
//            case 3:
//            case 4:
//            case 5:
//            case 6:
//            case 7:
//            case 8:
//                AddNeckVolumeDialog exampleDialog = new AddNeckVolumeDialog(this);
//                exampleDialog.show(getSupportFragmentManager(), "example dialog");
//                break;
    //    }

    }


    @Override
    public void addVolume() {
//SHARED PREFERNCES SET AND STORE MAX AND PROGRESS
    }
    private void stringcomparison(Integer position) {

        //TODO eliminate all of the potentially useless code here. That includes everything that is commented out
        // GET TEXT FROM RECYCLER VIEW ITEM CLICKED. ONE SET PER MUSCLE GROUP
        //DECLARE RECYCLER VIEW TO GET MUSCLE TITLE FOR THE EXERCISE CLICKED. THIS TITLE
        //WIL BE SENT TO THE VOLUME DIALOG TO ADD DATA TO HISTORY ARRAYS.
        RecyclerView recyclerView = findViewById(R.id.ExerciseByMuscleRecyclerView);
        TextView text = Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(position)).itemView.findViewById(R.id.exercise);
        String exercise = text.getText().toString();

        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();



        String muscleString = sp.getString(MUSCLE_STRING, "No MusCle, no GaiNs");
        editor.putString(EXERCISE, exercise).apply();
        //THE OUTER LAYER OF THE NESTED IF STATEMENTS THAT FOLLOW MAKES IT SO THAT WE DON'T INITIALIZE A BUNCH AF LISTS UNNESECARILY
        //NECK

        AddVolumeDialog exampleDialog = new AddVolumeDialog(this, R.style.DialogeTheme);
        exampleDialog.show(getSupportFragmentManager(), "example dialog");



       // exampleDialog.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));



//
//        if (muscleString.equals("Neck")) {
//                AddNeckVolumeDialog exampleDialog = new AddNeckVolumeDialog(this);
//                exampleDialog.show(getSupportFragmentManager(), "example dialog");
//
//            } else if (muscleString.equals("Upper Traps")){
//
//            String[] upperTrapsExercises = {"Trap Pushaway", "Farmer Walk", "Trap Bar Shrugs", "Dumbbell Shrugs",
//                    "Upper Trap", "Cable Shrugs"};
//            List<String> upperTrapList = Arrays.asList(upperTrapsExercises);
//
//            //TODO I JUST GOT STUCK HERE BECAUSE I DON'T WANT TO DIRECT TO THE MANY UNNESECARRY DIALOGUES I MADE.
//            // I WILL GET BACK TO IT WHEN I FIND OUT IF I CAN IMPLEMENT THAT MORE EFFECTIVELOY
//
//            AddNeckVolumeDialog exampleDialog = new AddNeckVolumeDialog(this);
//            exampleDialog.show(getSupportFragmentManager(), "example dialog");
////                if (upperTrapList.contains(exercise)) {
////                    AddChestVolumeDialog exampleDialog = new AddChestVolumeDialog(this);
////                    exampleDialog.show(getSupportFragmentManager(), "example dialog");
////                } else if (exercise.equals("Chest Pullover")) {
////                    AddPullOverDialog exampleDialog = new AddPullOverDialog(this);
////                    exampleDialog.show(getSupportFragmentManager(), "example dialog");
////                }
//
//            } else if (muscleString.equals("Lower Traps")){
//
//            } else if (muscleString.equals("Posterior Deltoids")){
//
//            } else if (muscleString.equals("Medial Deltoids")){
//
//            } else if (muscleString.equals("Anterior Deltoids")){
//
//            } else if (muscleString.equals("Rotator Cuff")){
//
//            } else if (muscleString.equals("Triceps")){
//
//            } else if (muscleString.equals("Ulnar Forearm")){
//
//            } else if (muscleString.equals("Forearm Extensors")){
//
//            } else if (muscleString.equals("Forearm Flexors")){
//
//            } else if (muscleString.equals("Radial Forearm")){
//
//            } else if (muscleString.equals("Lats")){
//
//            } else if (muscleString.equals("Erectors")){
//
//            } else if (muscleString.equals("Glutes")){
//
//            } else if (muscleString.equals("Glute Medius")){
//
//            } else if (muscleString.equals("Hamstrings")){
//
//            } else if (muscleString.equals("Calves")){
//
//            } else if (muscleString.equals("Chest")){
//
//            } else if (muscleString.equals("Biceps")){
//
//            } else if (muscleString.equals("Serratus")){
//
//            } else if (muscleString.equals("Abs")){
//
//            } else if (muscleString.equals("Obliques")){
//
//            } else if (muscleString.equals("Transverse Ab")){
//
//            } else if (muscleString.equals("Quads")){
//
//            } else if (muscleString.equals("Anterior Tibialis")){
//
//            } else if (muscleString.equals("Short and Medial Triceps")){
//
//            } else if (muscleString.equals("Brachialis")){
//
//            }



        //CHEST

//        String[] chestPressExercises = {"Incline Cable Press", "Incline Dumbbell Press", "Incline Bench Press", "Pushups",
//                "Neutral Cable Press", "Machine Chest Press", "Dumbbell Chest Press", "Bench Press"};
//        List<String> chestPressList = Arrays.asList(chestPressExercises);
//        String[] dipExercises = {"Narrow Dip", "Wide Dip", "Decline Cable Press", "Decline Bench Press", "Decline Dumbbell Press"};
//        List<String> dipList = Arrays.asList(dipExercises);
//        String[] chestExercises = {"Horizontal Crossover Flyes", "Decline Crossover Flyes", "Chest"};
//        List<String> chestList = Arrays.asList(chestExercises);
//
//
//
//        if (chestPressList.contains(exercise)) {
//            AddChestPressDialog exampleDialog = new AddChestPressDialog(this);
//            exampleDialog.show(getSupportFragmentManager(), "example dialog");
//        } else if (dipList.contains(exercise)) {
//            AddDipDialog exampleDialog = new AddDipDialog(this);
//            exampleDialog.show(getSupportFragmentManager(), "example dialog");
//        } else if (chestList.contains(exercise)) {
//            AddChestVolumeDialog exampleDialog = new AddChestVolumeDialog(this);
//            exampleDialog.show(getSupportFragmentManager(), "example dialog");
//        } else if (exercise.equals("Chest Pullover")) {
//            AddPullOverDialog exampleDialog = new AddPullOverDialog(this);
//            exampleDialog.show(getSupportFragmentManager(), "example dialog");
//        } else if (exercise.equals("Incline Crossover Flyes")) {
//            AddChestDeltVolumeDialog exampleDialog = new AddChestDeltVolumeDialog(this);
//            exampleDialog.show(getSupportFragmentManager(), "example dialog");
//        }
    }
}
