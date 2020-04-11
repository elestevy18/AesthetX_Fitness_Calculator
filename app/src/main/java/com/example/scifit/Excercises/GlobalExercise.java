package com.example.scifit.Excercises;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.AddVolume.SerratusVolume;
import com.example.scifit.Classes.Adapters.GlobalAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.AbsList;
import com.example.scifit.Classes.MuscleGroupObjects.AnteriorDeltoidList;
import com.example.scifit.Classes.MuscleGroupObjects.BicepsList;
import com.example.scifit.Classes.MuscleGroupObjects.CalvesList;
import com.example.scifit.Classes.MuscleGroupObjects.ChestList;
import com.example.scifit.Classes.MuscleGroupObjects.DiaphragmList;
import com.example.scifit.Classes.MuscleGroupObjects.ErectorsList;
import com.example.scifit.Classes.MuscleGroupObjects.ForearmExtensorList;
import com.example.scifit.Classes.MuscleGroupObjects.ForearmFlexorList;
import com.example.scifit.Classes.MuscleGroupObjects.GlobalList;
import com.example.scifit.Classes.MuscleGroupObjects.GluteMediusList;
import com.example.scifit.Classes.MuscleGroupObjects.GlutesList;
import com.example.scifit.Classes.MuscleGroupObjects.HamstringsList;
import com.example.scifit.Classes.MuscleGroupObjects.LatsList;
import com.example.scifit.Classes.MuscleGroupObjects.LowerTrapExerciseList;
import com.example.scifit.Classes.MuscleGroupObjects.MedialDeltoidList;
import com.example.scifit.Classes.MuscleGroupObjects.NeckExerciseList;
import com.example.scifit.Classes.MuscleGroupObjects.ObliquesList;
import com.example.scifit.Classes.MuscleGroupObjects.PosteriorDeltoidList;
import com.example.scifit.Classes.MuscleGroupObjects.QuadsList;
import com.example.scifit.Classes.MuscleGroupObjects.RadialForearmList;
import com.example.scifit.Classes.MuscleGroupObjects.RotatorCuffList;
import com.example.scifit.Classes.MuscleGroupObjects.SerratusList;
import com.example.scifit.Classes.MuscleGroupObjects.TricepList;
import com.example.scifit.Classes.MuscleGroupObjects.UlnarForearmList;
import com.example.scifit.Classes.MuscleGroupObjects.UpperTrapExerciseList;
import com.example.scifit.PopUpDialogs.AbCirclesDialog;
import com.example.scifit.PopUpDialogs.AddAbsSerratusVolumeDialog;
import com.example.scifit.PopUpDialogs.AddAbsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddAngelOfDeathDialog;
import com.example.scifit.PopUpDialogs.AddAnteriorDeltoidVolumeDialog;
import com.example.scifit.PopUpDialogs.AddBicepsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddCaliforniaPressDialog;
import com.example.scifit.PopUpDialogs.AddCalvesVolumeDialog;
import com.example.scifit.PopUpDialogs.AddChestDeltVolumeDialog;
import com.example.scifit.PopUpDialogs.AddChestPressDialog;
import com.example.scifit.PopUpDialogs.AddChestVolumeDialog;
import com.example.scifit.PopUpDialogs.AddChinUpsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddCurlsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddDeadliftVolumeDialog;
import com.example.scifit.PopUpDialogs.AddDiaphragmVolumeDialog;
import com.example.scifit.PopUpDialogs.AddDipDialog;
import com.example.scifit.PopUpDialogs.AddErectorsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddFacePullDialog;
import com.example.scifit.PopUpDialogs.AddForearmCurlsDialog;
import com.example.scifit.PopUpDialogs.AddForearmExtensorVolumeDialog;
import com.example.scifit.PopUpDialogs.AddForearmFlexorVolumeDialog;
import com.example.scifit.PopUpDialogs.AddGluteHamDialog;
import com.example.scifit.PopUpDialogs.AddGluteMediusVolumeDialog;
import com.example.scifit.PopUpDialogs.AddGlutesVolumeDialog;
import com.example.scifit.PopUpDialogs.AddHalfLowerTrapPostDeltDialog;
import com.example.scifit.PopUpDialogs.AddHamGluteDialog;
import com.example.scifit.PopUpDialogs.AddHammerCurlVolumeDialog;
import com.example.scifit.PopUpDialogs.AddHamstringsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddHighPullDialog;
import com.example.scifit.PopUpDialogs.AddHipThrustVolumeDialog;
import com.example.scifit.PopUpDialogs.AddIsoHipThrustDialog;
import com.example.scifit.PopUpDialogs.AddIsoRDLDialog;
import com.example.scifit.PopUpDialogs.AddLatLeverVolumeDialog;
import com.example.scifit.PopUpDialogs.AddLatsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddLowerTrapPostDeltDialog;
import com.example.scifit.PopUpDialogs.AddLowerTrapVolumeDialog;
import com.example.scifit.PopUpDialogs.AddMedialDeltoidVolumeDialog;
import com.example.scifit.PopUpDialogs.AddNeckVolumeDialog;
import com.example.scifit.PopUpDialogs.AddObliquesVolumeDialog;
import com.example.scifit.PopUpDialogs.AddPistolSquatDialog;
import com.example.scifit.PopUpDialogs.AddPosteriorDeltoidVolumeDialog;
import com.example.scifit.PopUpDialogs.AddProtractionDialog;
import com.example.scifit.PopUpDialogs.AddPullOverDialog;
import com.example.scifit.PopUpDialogs.AddPullUpVolumeDialog;
import com.example.scifit.PopUpDialogs.AddQuadsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddRadialForearmVolumeDialog;
import com.example.scifit.PopUpDialogs.AddRotatorCuffVolumeDialog;
import com.example.scifit.PopUpDialogs.AddRowsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddSerratusVolumeDialog;
import com.example.scifit.PopUpDialogs.AddSquatDialog;
import com.example.scifit.PopUpDialogs.AddSuspendedRowsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddTrapDeltDialog;
import com.example.scifit.PopUpDialogs.AddTricepLatVolumeDialog;
import com.example.scifit.PopUpDialogs.AddTricepVolumeDialog;
import com.example.scifit.PopUpDialogs.AddUlnarForearmVolumeDialog;
import com.example.scifit.PopUpDialogs.AddUpperTrapVolumeDialog;
import com.example.scifit.PopUpDialogs.OHPDialog;
import com.example.scifit.PopUpDialogs.ObliqueAbDiaphragmDialog;
import com.example.scifit.PopUpDialogs.ObliqueAbDiaphragmFullDialog;
import com.example.scifit.PopUpDialogs.ObliqueDiaphragmDialog;
import com.example.scifit.PopUpDialogs.ObliqueDiaphragmFullDialog;
import com.example.scifit.PopUpDialogs.QuadGluteMediusFullDialog;
import com.example.scifit.PopUpDialogs.QuadsGluteGluteMediusDialog;
import com.example.scifit.PopUpDialogs.SideLungeDialog;
import com.example.scifit.PopUpDialogs.SprinterLungeDialog;
import com.example.scifit.R;

        import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//IMPLEMENTATIONS ARE ALL THE DIALOG LISTENERS
public class GlobalExercise extends AppCompatActivity implements GlobalAdapter.OnItemClickListener, AddUpperTrapVolumeDialog.ExampleDialogListener,
        AddDeadliftVolumeDialog.ExampleDialogListener, AddLowerTrapVolumeDialog.ExampleDialogListener, AddAngelOfDeathDialog.ExampleDialogListener,
        AddPosteriorDeltoidVolumeDialog.ExampleDialogListener, AddHalfLowerTrapPostDeltDialog.ExampleDialogListener, AddFacePullDialog. ExampleDialogListener,
        AddNeckVolumeDialog.ExampleDialogListener, AddMedialDeltoidVolumeDialog.ExampleDialogListener, AddTrapDeltDialog.ExampleDialogListener,
        AddLowerTrapPostDeltDialog.ExampleDialogListener, AddAnteriorDeltoidVolumeDialog.ExampleDialogListener, OHPDialog.ExampleDialogListener,
        AddRotatorCuffVolumeDialog.ExampleDialogListener, AddTricepVolumeDialog.ExampleDialogListener, AddTricepLatVolumeDialog.ExampleDialogListener,
        AddDipDialog.ExampleDialogListener, AddHighPullDialog.ExampleDialogListener, AddUlnarForearmVolumeDialog.ExampleDialogListener,
        AddForearmExtensorVolumeDialog.ExampleDialogListener, AddRadialForearmVolumeDialog.ExampleDialogListener , AddHammerCurlVolumeDialog.ExampleDialogListener,
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
        AddCaliforniaPressDialog.ExampleDialogListener, AddChestPressDialog.ExampleDialogListener ,AddForearmCurlsDialog.ExampleDialogListener{
    private GlobalAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_exercise_list);


        //CreateList
        final List<GlobalList> GlobalExerciseListList = new ArrayList<>();
        //NECK
        GlobalExerciseListList.add(new GlobalList("Plate Curl", "10-20 controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Global Harness Curl", "10-20 controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Plated Neck Extension", "10-20 controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Towel Lateral Flexion", "10-20 controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Harness Lateral Flexion", "10-20 controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Suspended Neck Rotation", "10-20 controlled reps"));
        //UPPER TRAP
        GlobalExerciseListList.add(new GlobalList("Deadlift", "3-5 Heavy reps. 5-10 For Volume"));
        GlobalExerciseListList.add(new GlobalList ("Cable Shrug", "8-12 Full ROM and strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Dumbbell Shrugs", "8-12 strong contraction."));
        GlobalExerciseListList.add(new GlobalList ("Trap Bar Shrugs", "8-12 strong contraction."));
        GlobalExerciseListList.add(new GlobalList ("Farmer Walk", "30-60 seconds, walk don't run"));
        //LOWER TRAP
        GlobalExerciseListList.add(new GlobalList ("Y raise", "Primary: Lower Traps"));
        GlobalExerciseListList.add(new GlobalList ("Hanging/Cable Scapular Retraction", "Primary: Lower Traps"));
        GlobalExerciseListList.add(new GlobalList ("Reverse Pec Dec", "Primary: Lower Traps, Post Delts"));
        GlobalExerciseListList.add(new GlobalList ("Prone Press", "Primary: Lower Traps"));
        GlobalExerciseListList.add(new GlobalList ("Angels of Death", "10-12 Slow and controlled reps"));
        //POSTERIOR DELTOID
        GlobalExerciseListList.add(new GlobalList ("Facepulls", "12-15 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Barbell/ Dumbell High Rows", "8-12 Strong Contraction"));
        GlobalExerciseListList.add(new GlobalList ("Banded Pull Aparts", "10-30 Strong Contraction"));
        GlobalExerciseListList.add(new GlobalList ("W's", "10-12 Slow and controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Reverse Pec Dec", "10-20 Controlled reps"));
        //MEDIAL DELTOID
        GlobalExerciseListList.add(new GlobalList("Lateral raise", "10-15 Controlled with strong Contraction"));
        GlobalExerciseListList.add(new GlobalList ("Cable Lateral Raises", "10-15 Constant tension"));
        GlobalExerciseListList.add(new GlobalList ("Machine Lateral Raise", "10-15 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Cheat Lateral Raise", "8-12 Controlled hard, use upper trap"));
        //ANTERIOR DELTOID
        GlobalExerciseListList.add(new GlobalList ("Barbell Overhead Press", "3-10 Heavy/ Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Dumbbell OHP", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Arnolds", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Cable Front Raise", "Pause at the bottom"));
        GlobalExerciseListList.add(new GlobalList ("Cable Stretch to OHP", "10-15 Full range of motion, controlled."));
        GlobalExerciseListList.add(new GlobalList ("Landmine Press", "8-12 Explosive."));
        GlobalExerciseListList.add(new GlobalList ("Machine Shoulder Press", "8-12 Constant Tension"));
        GlobalExerciseListList.add(new GlobalList ("Push Press", "8-12 Strict -> cheat reps"));
        //ROTATOR CUFF
        GlobalExerciseListList.add(new GlobalList ("Cable External Rotation", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Bench Dumbbell External Rotation", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Banded External Rotation", "8-12 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Dumbbell High Pull", "8-12 Controlled reps"));
        //TRICEPS
        GlobalExerciseListList.add(new GlobalList ("Narrow Dips", "5-15 Heavy/Controlled/Explosive reps"));
        GlobalExerciseListList.add(new GlobalList ("Incline SkullCrushers", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("California Press", "8-12 Controlled reps, elbows tucked"));
        GlobalExerciseListList.add(new GlobalList ("Cable Rope Pushdowns", "8-15 Controlled, pause at the bottom"));
        GlobalExerciseListList.add(new GlobalList ("V Bar Pushdown", "8-15 Controlled, pause at the bottom"));
        GlobalExerciseListList.add(new GlobalList ("Close Grip Dumbbell Press", "8-12 Constant tension/full extension"));
        GlobalExerciseListList.add(new GlobalList ("Rope Overhead Tricep Extension", "8-12 Pause on the stretch"));
        GlobalExerciseListList.add(new GlobalList ("Long Head Tricep Push Downs", "8-12 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Tricep Kickback", "8-12 Strong contraction"));
        //ULNAR FOREARM
        GlobalExerciseListList.add(new GlobalList("Rope Ulnar Deviation", "10-12 Strong contraction"));
        //Extensors
        GlobalExerciseListList.add(new GlobalList("Standing Barbell Wrist Extension", "Primary: Forearm Extensors"));
        GlobalExerciseListList.add(new GlobalList ("Barbell Extension Rolls", "Primary: Forearm Extensors"));
        GlobalExerciseListList.add(new GlobalList ("Reverse Curls", "Primary: Forearm Extensors"));
        //FOREARMFLEXORS
        GlobalExerciseListList.add(new GlobalList("Prone Wrist Curls", "10-15 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Wrist Flexed Curls", "8-12 Controlled reps, engage forearms and biceps evenly"));
        //RADIAL FOREARM
        GlobalExerciseListList.add(new GlobalList ("Rope Radial Deviation", "10-15 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Hammer/Crossbody Curls", "8-12 Controlled reps"));
        //LATS
        GlobalExerciseListList.add(new GlobalList("High Pulley Row", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Cable Rows", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Barbell Rows", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Chest Supported Rows", "8-12 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Front Levers", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Lat Pull Over", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Lat Pushdown", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Pull ups", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Cable Pulldown", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Pull ins", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Chin Ups", "8-12 Controlled reps"));
        //EXTENSOR
        GlobalExerciseListList.add(new GlobalList ("Hyperextension", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Machine Erector Extension", "8-12 Controlled reps"));
        //GLUTES
        GlobalExerciseListList.add(new GlobalList ("Hip Thrust", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Isolateral Hip Thrust", "8-12 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Cable Kick Backs", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Glute Hyperextension", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Kettlebell/Dumbbell Swing", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Cable Pull Through", "8-12 Controlled reps"));
        //GLUTEMEDIUS
        GlobalExerciseListList.add(new GlobalList ("Machine Abduction", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Standing Abduction", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Banded Lateral Walkout", "8-12 Controlled reps"));
        //HAMSTRINGS
        GlobalExerciseListList.add(new GlobalList ("Hamstring Hyperextension", "8-12 reps"));
        GlobalExerciseListList.add(new GlobalList ("Romanian Deadlift", "6-12 reps"));
        GlobalExerciseListList.add(new GlobalList ("Medicine Ball Curl", "10-15 reps"));
        GlobalExerciseListList.add(new GlobalList ("Deficit Deadlift", "6-12 reps"));
        GlobalExerciseListList.add(new GlobalList ("Glute Ham Raise", "6-12 reps"));
        GlobalExerciseListList.add(new GlobalList ("Single Leg Medicine Ball Curl", "8-12 reps"));
        GlobalExerciseListList.add(new GlobalList ("Single Leg Romanian Deadlift", "6-12 reps"));
        //CALVES
        GlobalExerciseListList.add(new GlobalList ("Machine Standing Calf Raise", "8-20 Paused stretch"));
        GlobalExerciseListList.add(new GlobalList ("Straight Leg Machine Calf Raise", "8-20 Paused stretch"));
        GlobalExerciseListList.add(new GlobalList ("Seated Calf Raise", "8-20 Paused stretch"));
        GlobalExerciseListList.add(new GlobalList ("Donkey Calf Raise", "8-20 Paused stretch"));
        GlobalExerciseListList.add(new GlobalList ("Dumbbell/Plated Calf Raise", "8-20 Paused stretch"));
        //CHEST
        GlobalExerciseListList.add(new GlobalList ("Bench Press", "3-12 Study Form"));
        GlobalExerciseListList.add(new GlobalList ("Dumbbell Chest Press", "5-12 Full range of motion"));
        GlobalExerciseListList.add(new GlobalList ("Machine Chest Press", "5-12 Constant tension"));
        GlobalExerciseListList.add(new GlobalList ("Neutral Cable Press", "8-12 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Incline Cable Press", "8-12 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Decline Cable Press", "8-12 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Chest Pullover", "8-12 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Incline Crossover Flyes", "8-12 Strong contraction, paused stretch"));
        GlobalExerciseListList.add(new GlobalList ("Horizontal Crossover Flyes", "8-12 Strong contraction, paused stretch"));
        GlobalExerciseListList.add(new GlobalList ("Decline Crossover Flyes", "8-12 Strong contraction, paused stretch"));
        GlobalExerciseListList.add(new GlobalList ("Wide Dips", "3-12 Weighted/Explosive/Controlled"));
        GlobalExerciseListList.add(new GlobalList ("Pushups", "8-20 Weighted/Explosive/Controlled"));
        //BICEPS
        GlobalExerciseListList.add(new GlobalList ("Dumbbell Curls", "8-15 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Narrow Dumbell Curls", "8-15 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Barbell Curls", "8-15 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Narrow Barbell Curls", "8-15 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Narrow EZ Bar Curls", "8-15 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Wide EZ Bar Curls", "8-15 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Preacher Curls", "8-15 Strong Contraction"));
        GlobalExerciseListList.add(new GlobalList ("Limp Wrist Curls", "8-15 Mind muscle connection"));
        GlobalExerciseListList.add(new GlobalList ("Bicep Isometric", "30 - 60 seconds, near failure"));
        GlobalExerciseListList.add(new GlobalList ("Cable/Dumbbell Spider Curls", "8-15 Pause at the stretch"));
        GlobalExerciseListList.add(new GlobalList ("Banded Curls", "8-15 Strong contraction"));
        //SERRATUS
        GlobalExerciseListList.add(new GlobalList ("Plank Protaction", "8-15 Strong Contraction"));
        GlobalExerciseListList.add(new GlobalList ("Banded/ Cable Punches", "8-12 Strong Contraction"));
        GlobalExerciseListList.add(new GlobalList ("Protracted Roll Out", "5-12 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Protracted Cable Crunch", "8-12 Strong contraction"));
        //ABS
        //WHOLE ABS
        GlobalExerciseListList.add(new GlobalList("Hanging Leg Raise", "5-15 Controlled reps, strong contraction"));
        //LOWER Global
        GlobalExerciseListList.add(new GlobalList ("Captain Chair/ Hanging Leg Raises", "5-15 Controlled reps, strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Ab Circles", "8-12 Controlled reps, strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Reverse Crunches", "8-12 Strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Pulse Up", "8-12 Controlled reps, strong contraction"));
        //MID ABS
        GlobalExerciseListList.add(new GlobalList ("Cable Crunch", "8-12 Controlled reps, strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("V-Up", "8-12 Controlled reps, strong contraction"));
        //OBLIQUES
        GlobalExerciseListList.add(new GlobalList ("Twisting Leg Raise", "5-10 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Neutral Wood Choppers", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Low to High Wood Choppers", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("High to Low Wood Choppers", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Elbow to Knee Tucks", "8-12 Strong contraction, controlled"));
        GlobalExerciseListList.add(new GlobalList ("Banded/Cable Step Out", "30-60 seconds"));
        GlobalExerciseListList.add(new GlobalList ("Twisted Pulse Up", "8-12 Controlled reps, strong contraction"));
        GlobalExerciseListList.add(new GlobalList ("Rotating Plank", "30-60 seconds Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Elbow to Knee Plank", "30-60 seconds"));
        GlobalExerciseListList.add(new GlobalList ("Leg Raise Scissors", "5-12 Controlled reps"));
        //DIAPHRAGM
        GlobalExerciseListList.add(new GlobalList("Vacuums", "Squeeze until failure"));
        GlobalExerciseListList.add(new GlobalList ("Banded/Cable/ Resisted Rotation", "To failure"));
        //QUADS
        GlobalExerciseListList.add(new GlobalList("Squats", "3-10 Heavy/For Volume. Study Form"));
        GlobalExerciseListList.add(new GlobalList ("Leg Press", "8-12 Constant Tension"));
        GlobalExerciseListList.add(new GlobalList ("Banded Leg Press", "8-12 Constant Tension"));
        GlobalExerciseListList.add(new GlobalList ("Traditional Lunge", "8-15 Mind Muscle connection"));
        GlobalExerciseListList.add(new GlobalList ("Sprinter Lunge", "8-15 Mind Muscle connection"));
        GlobalExerciseListList.add(new GlobalList ("Side Lunge", "8-15 Mind Muscle connection"));
        GlobalExerciseListList.add(new GlobalList ("Banded Behind the Knee Lunge", "Strong Contraction"));
        GlobalExerciseListList.add(new GlobalList ("Bulgarian Split Squat", "8-12 Controlled reps"));
        GlobalExerciseListList.add(new GlobalList ("Explosive Bulgarian Split Squat", "8-12 Get air time"));
        GlobalExerciseListList.add(new GlobalList ("Cable Walkaways", "8-12 Get air time"));
        GlobalExerciseListList.add(new GlobalList ("Pistol Squats", "3-10 Heavy/For Volume. Study Form"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.globalExerciseRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new GlobalAdapter(GlobalExerciseListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }


    @Override
    public void onExerciseClick(int position) {
     /* case 0:
                Intent intent = new Intent(this, PlateCurl.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent2 = new Intent(this, NeckHarnessCurls.class);
                startActivity(intent2);
                break;
            case 2:
                Intent intent3 = new Intent(this, PlatedNeckExtension.class);
                startActivity(intent3);
                break;
            case 3:
                Intent intent4 = new Intent(this, TowelNeckExtension.class);
                startActivity(intent4);
                break;
            case 4:
                Intent intent5 = new Intent(this, HarnessNeckExtension.class);
                startActivity(intent5);
                break;
            case 5:
                Intent intent6 = new Intent(this, PlatedNeckLateralFlexion.class);
                startActivity(intent6);
            case 6:
                Intent intent7 = new Intent(this, TowelLateralFlexion.class);
                startActivity(intent7);
                break;
            case 7:
                Intent intent8 = new Intent(this, HarnessLateralFlexion.class);
                startActivity(intent8);
                break;
            case 8:
                Intent intent9 = new Intent(this, SuspendedNeckRotation.class);
                startActivity(intent9);
                break;*/

    }

    @Override
    public void onAddVolumeClick(int position) {
        stringcomparison(position);
    }

    @Override
    public void addVolume() {

    }
    public void stringcomparison(Integer position){
        // GET TEXT FROM RECYCLER VIEW ITEM CLICKED
        RecyclerView recyclerView = findViewById(R.id.globalExerciseRecyclerView);
        TextView text = recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.exercise);
        String exercise = text.getText().toString();
        //CREATE ARRAYS AND LISTS FOR EXERCISES WITH EQUAL VOLUME PROFILES
        String [] neckExercises = {"Plate Curl", "Global Harness Curl", "Plated Neck Extension", "Towel Lateral Flexion", "Harness Lateral Flexion", "Suspended Neck Rotation"};
        List<String> neckList = Arrays.asList(neckExercises);
        String [] upperTrapExercises = {"Cable Shrug", "Dumbbell Shrugs", "Trap Bar Shrugs", "Farmer Walk"};
        List<String> trapList = Arrays.asList(upperTrapExercises);
        String [] lowerTrapExercises = {"Angels of Death", "Y raise", "Hanging/Cable Scapular Retraction", "Prone Press"};
        List<String> lowerTrapList = Arrays.asList(lowerTrapExercises);
        String [] postDeltExercises = {"Barbell/ Dumbell High Rows", "Banded Pull Aparts", "W's", "Reverse Pec Dec"};
        List<String> postDeltList = Arrays.asList(postDeltExercises);
        String [] lateralDeltExercises = {"Lateral raise", "Cable Lateral Raises", "Machine Lateral Raise"};
        List<String> lateralDeltList = Arrays.asList(lateralDeltExercises);
        String [] OHPExercises = {"Barbell Overhead Press", "Dumbbell OHP", "Arnolds", "Cable Stretch to OHP", "Landmine Press", "Machine Shoulder Press", "Push Press"};
        List<String> OHP = Arrays.asList(OHPExercises);
        String [] rotatorCuffExercises = {"Cable External Rotation", "Bench Dumbbell External Rotation", "Banded External Rotation"};
        List<String> rotatorList = Arrays.asList(rotatorCuffExercises);
        String [] tricepExercises = {"Incline SkullCrushers", "Cable Rope Pushdowns", "V Bar Pushdown", "Rope Overhead Tricep Extension", "Long Head Tricep Push Downs", "Tricep Kickback"};
        List<String> tricepList = Arrays.asList(tricepExercises);
        String [] extensionExercises = {"Standing Barbell Wrist Extension", "Barbell Extension Rolls", "Reverse Curls"};
        List<String> extensionList = Arrays.asList(extensionExercises);
        String [] rowsExercises = {"High Pulley Row", "Chest Supported Rows",};
        List<String> rowsList = Arrays.asList(rowsExercises);
        String [] suspendedRowsExercises = {"Cable Rows", "Barbell Rows"};
        List<String> suspendedRowsList = Arrays.asList(suspendedRowsExercises);
        String [] latLeverExercises = {"Front Levers", "Lat Pull Over", "Lat Pushdown"};
        List<String> latLeverList = Arrays.asList(latLeverExercises);
        String [] pullUpExercises = {"Pull ups", "Cable Pulldown"};
        List<String> pullUpList = Arrays.asList(pullUpExercises);
        String [] erectorsExercises = {"Hyperextension", "Machine Erector Extension"};
        List<String> erectorsList = Arrays.asList(erectorsExercises);
        String [] gluteHamExercises = {"Cable Kick Backs", "Glute Hyperextension", "Kettlebell/Dumbbell Swing", "Cable Pull Through"};
        List<String> gluteHamList = Arrays.asList(gluteHamExercises);
        String [] gluteMediusExercises = {"Machine Abduction", "Standing Abduction", "Banded Lateral Walkout"};
        List<String> gluteMediusList = Arrays.asList(gluteMediusExercises);
        String [] hamGluteExercises = {"Hamstring Hyperextension", "Romanian Deadlift", "Medicine Ball Curl", "Deficit Deadlift", "Glute Ham Raise"};
        List<String> hamGluteList = Arrays.asList(hamGluteExercises);
        String [] isoRDLExercises = {"Single Leg Medicine Ball Curl", "Single Leg Romanian Deadlift"};
        List<String> isoRDLList = Arrays.asList(isoRDLExercises);
        String [] calvesExercises = {"Machine Standing Calf Raise", "Straight Leg Machine Calf Raise", "Seated Calf Raise", "Donkey Calf Raise", "Dumbbell/Plated Calf Raise"};
        List<String> calvesList = Arrays.asList(calvesExercises);
        String [] chestPressExercises = {"Incline Cable Press"};
        List<String> chestPressList = Arrays.asList(chestPressExercises);
        String [] dipExercises = {"Narrow Dips", "Neutral Cable Press",  "Machine Chest Press", "Dumbbell Chest Press", "Bench Press", "Wide Dips", "Pushups", "Decline Cable Press"};
        List<String> dipList = Arrays.asList(dipExercises);
        String [] chestExercises = {"Horizontal Crossover Flyes", "Decline Crossover Flyes",};
        List<String> chestList = Arrays.asList(chestExercises);
        String [] curlExercises = {"Cable/Dumbbell Spider Curls", "Banded Curls", "Preacher Curls", "Wide EZ Bar Curls","Narrow EZ Bar Curls", "Narrow Barbell Curls", "Barbell Curls", "Narrow Dumbell Curls", "Dumbbell Curls"};
        List<String> curlList = Arrays.asList(curlExercises);
        String [] bicepExercises = {"Limp Wrist Curls", "Bicep Isometric"};
        List<String> bicepList = Arrays.asList(bicepExercises);
        String [] absSerratusExercises = {"Protracted Roll Out", "Protracted Cable Crunch"};
        List<String> absSerratusList = Arrays.asList(absSerratusExercises);
        String [] absExercises = {"Captain Chair/ Hanging Leg Raises", "Hanging Leg Raise", "Reverse Crunches", "Pulse Up", "Cable Crunch","V-Up"};
        List<String> absList = Arrays.asList(absExercises);
        String [] obliqueAbDiaphragmExercises = {"Twisting Leg Raise", "Elbow to Knee Tucks", "Banded/Cable Step Out", "Twisted Pulse Up", "Rotating Plank", "Elbow to Knee Plank"};
        List<String> obliqueAbDiaphragmList = Arrays.asList(obliqueAbDiaphragmExercises);
        String [] obliqueDiaphragmExercises = {"Neutral Wood Choppers", "Low to High Wood Choppers", "High to Low Wood Choppers"};
        List<String> obliqueDiaphragmList = Arrays.asList(obliqueDiaphragmExercises);
        String [] quadsGluteMediusExercises = {"Bulgarian Split Squat", "Explosive Bulgarian Split Squat", "Traditional Lunge"};
        List<String> quadsGluteMediusList = Arrays.asList(quadsGluteMediusExercises);
        String [] quadsExercises = {"Leg Press", "Cable Walkaways", "Banded Behind the Knee Lunge"};
        List<String> quadsList = Arrays.asList(quadsExercises);
        String [] californiaPressExercises = {"California Press", "Close Grip Dumbbell Press"};
        List<String> californiaPressList = Arrays.asList(californiaPressExercises);

        //CHECK WHICH DIALOG TO OPEN FOR PROPER VOLUME INPUT
        if (neckList.contains(exercise)){
            AddNeckVolumeDialog exampleDialog = new AddNeckVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Squats")){
            AddSquatDialog exampleDialog = new AddSquatDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Incline Crossover Flyes")){
            AddChestDeltVolumeDialog exampleDialog = new AddChestDeltVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Pistol Squats")){
            AddPistolSquatDialog exampleDialog = new AddPistolSquatDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Side Lunge")){
            SideLungeDialog exampleDialog = new SideLungeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Sprinter Lunge")){
            SprinterLungeDialog exampleDialog = new SprinterLungeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Banded Leg Press")){
            AddForearmFlexorVolumeDialog exampleDialog = new AddForearmFlexorVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Banded/Cable/ Resisted Rotation")){
            ObliqueDiaphragmFullDialog exampleDialog= new ObliqueDiaphragmFullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Vacuums")){
            AddDiaphragmVolumeDialog exampleDialog = new AddDiaphragmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Leg Raise Scissors")){
            ObliqueAbDiaphragmFullDialog exampleDialog = new ObliqueAbDiaphragmFullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Ab Circles")){
            AbCirclesDialog exampleDialog = new AbCirclesDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Plank Protaction")){
            AddProtractionDialog exampleDialog = new AddProtractionDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Banded/ Cable Punches")){
            AddSerratusVolumeDialog exampleDialog = new AddSerratusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Chest Pullover")){
            AddPullOverDialog exampleDialog = new AddPullOverDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Isolateral Hip Thrust")){
            AddIsoHipThrustDialog exampleDialog = new AddIsoHipThrustDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Rope Radial Deviation")){
            AddRadialForearmVolumeDialog exampleDialog = new AddRadialForearmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Dumbbell High Pull")){
            AddHighPullDialog exampleDialog = new AddHighPullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Cable Front Raise")){
            AddAnteriorDeltoidVolumeDialog exampleDialog = new AddAnteriorDeltoidVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Cheat Lateral Raise")){
            AddTrapDeltDialog exampleDialog = new AddTrapDeltDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Rope Ulnar Deviation")){
            AddUlnarForearmVolumeDialog exampleDialog = new AddUlnarForearmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Deadlift")){
            AddDeadliftVolumeDialog exampleDialog = new AddDeadliftVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Facepulls")){
            AddFacePullDialog exampleDialog = new AddFacePullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(trapList.contains(exercise)){
            AddUpperTrapVolumeDialog exampleDialog = new AddUpperTrapVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(lowerTrapList.contains(exercise)){
            AddLowerTrapVolumeDialog exampleDialog = new AddLowerTrapVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(postDeltList.contains(exercise)){
            AddLowerTrapPostDeltDialog exampleDialog = new AddLowerTrapPostDeltDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(OHP.contains(exercise)){
            OHPDialog exampleDialog = new OHPDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(rotatorList.contains(exercise)){
            AddRotatorCuffVolumeDialog exampleDialog = new AddRotatorCuffVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(tricepList.contains(exercise)){
            AddTricepVolumeDialog exampleDialog = new AddTricepVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(extensionList.contains(exercise)){
            AddForearmExtensorVolumeDialog exampleDialog = new AddForearmExtensorVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Prone Wrist Curls")){
            AddForearmFlexorVolumeDialog exampleDialog = new AddForearmFlexorVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Wrist Flexed Curls")){
            AddForearmCurlsDialog exampleDialog = new AddForearmCurlsDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Hammer/Crossbody Curls")){
            AddHammerCurlVolumeDialog  exampleDialog = new AddHammerCurlVolumeDialog (this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(rowsList.contains(exercise)){
            AddRowsVolumeDialog exampleDialog = new AddRowsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(suspendedRowsList.contains(exercise)){
            AddSuspendedRowsVolumeDialog exampleDialog = new AddSuspendedRowsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(latLeverList.contains(exercise)){
            AddLatLeverVolumeDialog exampleDialog = new AddLatLeverVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(chestPressList.contains(exercise)){
            AddChestPressDialog exampleDialog = new AddChestPressDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(pullUpList.contains(exercise)){
            AddPullUpVolumeDialog exampleDialog = new AddPullUpVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Pull ins")){
            AddLatsVolumeDialog  exampleDialog = new AddLatsVolumeDialog (this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Chin Ups")){
            AddChinUpsVolumeDialog  exampleDialog = new AddChinUpsVolumeDialog (this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(exercise.equals("Hip Thrust")){
            AddHipThrustVolumeDialog  exampleDialog = new AddHipThrustVolumeDialog (this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(erectorsList.contains(exercise)){
            AddErectorsVolumeDialog  exampleDialog = new AddErectorsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(gluteHamList.contains(exercise)){
            AddGluteHamDialog exampleDialog = new AddGluteHamDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(gluteMediusList.contains(exercise)){
            AddGluteMediusVolumeDialog exampleDialog = new AddGluteMediusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(hamGluteList.contains(exercise)){
            AddHamGluteDialog exampleDialog = new AddHamGluteDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(isoRDLList.contains(exercise)){
            AddIsoRDLDialog exampleDialog = new AddIsoRDLDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(calvesList.contains(exercise)){
            AddCalvesVolumeDialog exampleDialog = new AddCalvesVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(chestPressList.contains(exercise)){
            AddChestPressDialog exampleDialog = new AddChestPressDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(dipList.contains(exercise)){
            AddDipDialog exampleDialog = new AddDipDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(chestList.contains(exercise)){
            AddChestVolumeDialog exampleDialog = new AddChestVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(curlList.contains(exercise)){
            AddCurlsVolumeDialog exampleDialog = new AddCurlsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(bicepList.contains(exercise)){
            AddBicepsVolumeDialog exampleDialog = new AddBicepsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(absSerratusList.contains(exercise)){
            AddAbsSerratusVolumeDialog exampleDialog = new AddAbsSerratusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(obliqueAbDiaphragmList.contains(exercise)){
            ObliqueAbDiaphragmDialog exampleDialog = new ObliqueAbDiaphragmDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(obliqueDiaphragmList.contains(exercise)){
            ObliqueDiaphragmDialog exampleDialog = new ObliqueDiaphragmDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(quadsGluteMediusList.contains(exercise)){
            AddQuadsVolumeDialog exampleDialog = new AddQuadsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(californiaPressList.contains(exercise)){
            AddCaliforniaPressDialog exampleDialog = new  AddCaliforniaPressDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(quadsList.contains(exercise)){
            AddQuadsVolumeDialog exampleDialog = new  AddQuadsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(absList.contains(exercise)){
            AddAbsVolumeDialog exampleDialog = new  AddAbsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else if(lateralDeltList.contains(exercise)){
            AddMedialDeltoidVolumeDialog exampleDialog = new  AddMedialDeltoidVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }else{
            Toast toast = Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
            toast.show();
        }
    }

}


