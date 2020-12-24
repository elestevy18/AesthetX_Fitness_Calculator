package com.AesthetX.aesthetx.Excercises;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.AesthetX.aesthetx.Classes.Adapters.GlobalAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.GlobalList;
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
import com.AesthetX.aesthetx.PopUpDialogs.AddVolumeDialog;
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
import com.AesthetX.aesthetx.PopUpDialogs.UpperLowerTrap;

//IMPLEMENTATIONS ARE ALL THE DIALOG LISTENERS
public class GlobalExercise extends AppCompatActivity implements GlobalAdapter.OnItemClickListener, AddUpperTrapVolumeDialog.ExampleDialogListener,
        AddDeadliftVolumeDialog.ExampleDialogListener, AddLowerTrapVolumeDialog.ExampleDialogListener, AddAngelOfDeathDialog.ExampleDialogListener,
        AddPosteriorDeltoidVolumeDialog.ExampleDialogListener, AddHalfLowerTrapPostDeltDialog.ExampleDialogListener, AddFacePullDialog.ExampleDialogListener,
        AddVolumeDialog.ExampleDialogListener, AddMedialDeltoidVolumeDialog.ExampleDialogListener, AddTrapDeltDialog.ExampleDialogListener,
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
        ErectorGluteMedius.ExampleDialogListener, GluteMediusHalfObliques.ExampleDialogListener, QuadsHalfGlute.ExampleDialogListener {
    private GlobalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_exercise_list);


        //CreateList for recyclerview. Adds All muscle groups to list
        final List<GlobalList> GlobalExerciseListList = new ArrayList<>();
        //NECK
        GlobalExerciseListList.add(new GlobalList("Plate Curl", "Neck Flexion"));
        GlobalExerciseListList.add(new GlobalList("Neck Harness Curl", "Neck Flexion"));
        GlobalExerciseListList.add(new GlobalList("Plated Neck Extension", "Neck Extension"));
        GlobalExerciseListList.add(new GlobalList("Harness Lateral Flexion", "Lateral Flexion"));
        GlobalExerciseListList.add(new GlobalList("Head Floats", "Neck Flexion, Lateral Flexion or Extension"));
        GlobalExerciseListList.add(new GlobalList("Suspended Neck Rotation", "Neck Flexion, Rotation"));
        GlobalExerciseListList.add(new GlobalList("Towel Lateral Flexion", "Lateral Flexion"));
        GlobalExerciseListList.add(new GlobalList("Neck Flexion", "Lateral and forward Flexion"));


        //UPPER TRAP
        GlobalExerciseListList.add(new GlobalList("Deadlift", "Hamstrings, Erectors, Upper Traps \nSecondary: Lats, Glutes, Lower Trap, Transverse"));
        GlobalExerciseListList.add(new GlobalList("Cable Shrug", "Upper Trap"));
        GlobalExerciseListList.add(new GlobalList("Dumbbell Shrugs", "Upper Trap"));
        GlobalExerciseListList.add(new GlobalList("Trap Bar Shrugs", "Upper Trap"));
        GlobalExerciseListList.add(new GlobalList("Farmer Walk", "Upper Trap"));
        //LOWER TRAP
        GlobalExerciseListList.add(new GlobalList("Y Raise", "Lower Traps"));
        GlobalExerciseListList.add(new GlobalList("Hanging/Cable\nScapular Retraction", "Lower Traps"));
        GlobalExerciseListList.add(new GlobalList("Angels of Death", "Spinal Erectors, Lower Traps, Post Delt"));
        GlobalExerciseListList.add(new GlobalList("Floor/Dip Bar\nScapular Depression", "Lower Traps"));
        //POSTERIOR DELTOID
        GlobalExerciseListList.add(new GlobalList("Facepulls", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        GlobalExerciseListList.add(new GlobalList("Barbell/Dumbbell High Rows", "Posterior Deltoid, Lower Trap"));
        GlobalExerciseListList.add(new GlobalList("W's", "Rotator Cuff, Secondary: Posterior Deltoid"));
        GlobalExerciseListList.add(new GlobalList("Reverse Pec Dec", "Lower Traps, Post Delts"));
        GlobalExerciseListList.add(new GlobalList("Floor T's", "Posterior Deltoid"));
        GlobalExerciseListList.add(new GlobalList("Banded Pull Aparts", "Posterior Delt, Lower Traps"));
        GlobalExerciseListList.add(new GlobalList("Ring Facepulls", "Posterior Deltoid, Rotator Cuff, Lower Traps"));
        //MEDIAL DELTOID
        GlobalExerciseListList.add(new GlobalList("Cable Lateral Raises", "Medial Deltoid"));
        GlobalExerciseListList.add(new GlobalList("Lateral Raise", "Medial Deltoid"));
        GlobalExerciseListList.add(new GlobalList("Machine Lateral Raise", "Medial Deltoid"));
        GlobalExerciseListList.add(new GlobalList("Cheat Lateral Raise", "Medial Deltoid, Upper Trap"));
        GlobalExerciseListList.add(new GlobalList("Delt Rotating Plank", "Medial Deltoid"));
        GlobalExerciseListList.add(new GlobalList("Banded Lateral Raise", "Medial Deltoid"));

        //ANTERIOR DELTOID
        GlobalExerciseListList.add(new GlobalList("Arnolds", "Anterior Delt Secondary: Triceps, Medial Delt"));
        GlobalExerciseListList.add(new GlobalList("Barbell Overhead Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
        GlobalExerciseListList.add(new GlobalList("Dumbbell OHP", "Anterior Delt Secondary: Triceps, Medial Delt"));
        GlobalExerciseListList.add(new GlobalList("Cable Front Raise", "Anterior Delt"));
        GlobalExerciseListList.add(new GlobalList("Cable Stretch to OHP", "Anterior Delt Secondary: Triceps, Medial Delt"));
        GlobalExerciseListList.add(new GlobalList("Landmine Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
        GlobalExerciseListList.add(new GlobalList("Machine Shoulder Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
        GlobalExerciseListList.add(new GlobalList("Push Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
        GlobalExerciseListList.add(new GlobalList("Pike Pushup", "Anterior Delt Secondary: Triceps, Medial Delt"));
        GlobalExerciseListList.add(new GlobalList("Handstand Pushup", "Anterior Delt, Secondary: Triceps, Medial Delt"));

        //ROTATOR CUFF
        GlobalExerciseListList.add(new GlobalList("Cable External Rotation", "Rotator Cuff, Forearm Extensors"));
        GlobalExerciseListList.add(new GlobalList("Bench Dumbbell\nExternal Rotation", "Rotator Cuff, Forearm Extensors"));
        GlobalExerciseListList.add(new GlobalList("Banded External Rotation", "Rotator Cuff, Forearm Extensors"));
        GlobalExerciseListList.add(new GlobalList("Dumbbell High Pull", "Rotator Cuff, Forearm Extensors"));

        //Triceps
        GlobalExerciseListList.add(new GlobalList("California Press", "Triceps; All Heads\nSecondary: Chest, Anterior Deltoid "));
        GlobalExerciseListList.add(new GlobalList("Incline Skull Crushers", "Triceps; Long Head"));
        GlobalExerciseListList.add(new GlobalList("Narrow Dip", "Triceps; All Heads, Chest"));
        GlobalExerciseListList.add(new GlobalList("Cable Rope Pushdowns", "Triceps; Medial and Short Head"));
        GlobalExerciseListList.add(new GlobalList("V Bar Pushdowns", "Triceps; Medial and Short Head"));
        GlobalExerciseListList.add(new GlobalList("Close Grip Dumbbell Press", "Triceps Short And Medial Head\nSecondary: Chest, Anterior Deltoid "));
        GlobalExerciseListList.add(new GlobalList("Rope Overhead Triceps\nExtension", "Triceps; Long Head"));
        GlobalExerciseListList.add(new GlobalList("Long Head Triceps Push Downs", "Triceps; Long Head"));
        GlobalExerciseListList.add(new GlobalList("Triceps Kickback", "Triceps; Short Head"));
        GlobalExerciseListList.add(new GlobalList("Narrow Pushup", "Triceps; Short and Medial Head, Chest\nSecondary: Anterior Delt"));
        GlobalExerciseListList.add(new GlobalList("Triceps Extension", "Triceps; short and medial head"));
        GlobalExerciseListList.add(new GlobalList("Ring Overhead Extension", "Triceps; long head"));
        GlobalExerciseListList.add(new GlobalList("Bench Dip", "Triceps; All Heads"));
        //ULNAR
        GlobalExerciseListList.add(new GlobalList("Rope Ulnar Deviation", "Ulnar Forearm"));
        GlobalExerciseListList.add(new GlobalList("Banded Ulnar Deviation", "Ulnar Forearm"));
        //Extensors
        GlobalExerciseListList.add(new GlobalList("Banded Wrist Extension", "Forearm Extensors"));
        GlobalExerciseListList.add(new GlobalList("Standing Barbell Wrist Extension", "Forearm Extensors"));
        GlobalExerciseListList.add(new GlobalList("Barbell Extension Rolls", "Forearm Extensors"));
        GlobalExerciseListList.add(new GlobalList("Reverse Curls", "Forearm Extensors"));
        //FOREARMFLEXOR
        GlobalExerciseListList.add(new GlobalList("Banded Wrist Curls", "Forearm Flexors"));
        GlobalExerciseListList.add(new GlobalList("Prone Wrist Curls", "Forearm Flexors"));
        //RADIAL DEVIATION
        GlobalExerciseListList.add(new GlobalList("Rope Radial Deviation", "Radial Forearm"));
        GlobalExerciseListList.add(new GlobalList("Hammer/Crossbody Curls", "Biceps; Brachialis, Radial Forearm"));
        //LATS
        GlobalExerciseListList.add(new GlobalList("Lat Pull Over", "Lats Triceps"));
        GlobalExerciseListList.add(new GlobalList("Lat Pushdowns", "Lats Triceps"));
        GlobalExerciseListList.add(new GlobalList("Cable Pulldown", "Lats, Lower Trap\nSecondary:Post Delt, Bicep, Forearms"));
        GlobalExerciseListList.add(new GlobalList("Front Levers", "Lats, Triceps"));

        GlobalExerciseListList.add(new GlobalList("Pull ins", "Lats"));
        GlobalExerciseListList.add(new GlobalList("Pull Ups", "Lats, Lower Trap\nSecondary:Post Delt, Bicep, Forearms"));
        GlobalExerciseListList.add(new GlobalList("Chin Ups", "Lats, Lower Trap, Bicep\nSecondary: Post Delt, Forearms"));

        GlobalExerciseListList.add(new GlobalList("High Pulley Row", "Lats, Lower Traps\nSecondary: Post Delt, Biceps, Forearm Flexor"));
        GlobalExerciseListList.add(new GlobalList("Cable Rows", "Lats, Lower Traps, Erectors\nSecondary: Post Delt, Biceps, Forearm Flexor"));
        GlobalExerciseListList.add(new GlobalList("Barbell Rows", "Lats, Lower Traps\nSecondary: Post Delt, Biceps, Forearm Flexor"));
        GlobalExerciseListList.add(new GlobalList("Chest Supported Rows", "Lats, Lower Traps\nSecondary: Post Delt, Biceps, Forearm Flexor"));
        GlobalExerciseListList.add(new GlobalList("Ring Rows", "Lats, Lower Traps\nSecondary:Post Delt, Biceps, Forearm"));
        GlobalExerciseListList.add(new GlobalList("Australian Pull Up", "Lats, Lower Traps\nSecondary: Post Delt, Biceps, Forearm "));

        //ERECTOR
        GlobalExerciseListList.add(new GlobalList("Hyperextension", "Spinal Erector"));
        GlobalExerciseListList.add(new GlobalList("Machine Erector Extension", "Spinal Erector"));
        GlobalExerciseListList.add(new GlobalList("Frog Pumps", "Spinal Erectors, Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Marching Bridge", "Spinal Erector, Glutes"));

        //GLUTES
        GlobalExerciseListList.add(new GlobalList("Hip Thrust", "Glutes Secondary: Hamstrings, Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Isolateral Hip Thrust", "Glutes, Glute Medius Secondary: Hamstrings"));
        GlobalExerciseListList.add(new GlobalList("Cable Pull Through", "Glutes Secondary: Hamstrings, Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Sprinter Lunge", "Glutes, Glute Medius Secondary: Hamstrings"));
        GlobalExerciseListList.add(new GlobalList("Glute Hyperextension", "Glutes Secondary: Hamstrings, Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Reverse Hyperextension", "Glutes Secondary:Spinal Erector, Hamstrings "));
        GlobalExerciseListList.add(new GlobalList("Kettlebell/Dumbbell Swing", "Glutes Secondary: Hamstrings, Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Cable Kick Backs", "Glutes Secondary: Hamstrings, Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Banded RDL", "Glutes, Glute Medius, Hamstrings"));
        GlobalExerciseListList.add(new GlobalList("Bodyweight Hip Thrust", "Glutes Secondary: Hamstrings"));


        //GLUTEMEDIUS
        GlobalExerciseListList.add(new GlobalList("Machine Abduction", "Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Banded Lateral Walkout", "Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Banded Abduction", "Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Glute Side Plank", "Glute Medius Secondary: Obliques"));

        //HAMSTRINGS
        GlobalExerciseListList.add(new GlobalList("Romanian Deadlift", "Hamstring Secondary: Glutes, Erectors"));
        GlobalExerciseListList.add(new GlobalList("Hamstring Curls", "Hamstring Secondary: Glutes, Erectors"));
        GlobalExerciseListList.add(new GlobalList("Hamstring Hyperextension", "Hamstring Secondary: Glutes, Erectors"));
        GlobalExerciseListList.add(new GlobalList("Physioball Hamstring Curls", "Hamstring Secondary: Glutes, Erectors"));
        GlobalExerciseListList.add(new GlobalList("Deficit Deadlift", "Hamstring Secondary: Glutes, Erectors"));
        GlobalExerciseListList.add(new GlobalList("Glute Ham Raise", "Hamstring Secondary: Glutes, Erectors"));
        GlobalExerciseListList.add(new GlobalList("Isolateral Hamstring Curls", "Hamstrings, Glute Medius\nSecondary: Glutes, Erectors"));
        GlobalExerciseListList.add(new GlobalList("Single Leg Romanian Deadlift", "Hamstrings, Glute Medius\nSecondary: Glutes, Erectors"));

        //CALVES
        GlobalExerciseListList.add(new GlobalList("Machine Standing Calf Raise", "Calves"));
        GlobalExerciseListList.add(new GlobalList("Straight Leg Machine Calf Raise", "Calves"));
        GlobalExerciseListList.add(new GlobalList("Seated Calf Raise", "Calves"));
        GlobalExerciseListList.add(new GlobalList("Donkey Calf Raise", "Calves"));
        GlobalExerciseListList.add(new GlobalList("Dumbbell/Plated Calf Raise", "Calves"));
        GlobalExerciseListList.add(new GlobalList("Bodyweight Calf Raise", "Calves"));

        //CHEST
        GlobalExerciseListList.add(new GlobalList("Bench Press", "Chest, Triceps Secondary: Anterior Delt"));
        GlobalExerciseListList.add(new GlobalList("Dumbbell Chest Press", "Chest, Triceps Secondary: Anterior Delt"));
        GlobalExerciseListList.add(new GlobalList("Machine Chest Press", "Chest, Triceps Secondary: Anterior Delt"));
        GlobalExerciseListList.add(new GlobalList("Neutral Cable Press", "Chest, Triceps Secondary: Anterior Delt"));
        GlobalExerciseListList.add(new GlobalList("Incline Cable Press", "Upper Pectoral, Triceps Anterior Delt"));
        GlobalExerciseListList.add(new GlobalList("Decline Cable Press", "Lower Pectoral, Triceps"));
        GlobalExerciseListList.add(new GlobalList("Chest Pullover", "Upper Pectoral, Triceps Secondary: Lats"));
        GlobalExerciseListList.add(new GlobalList("Incline Crossover Flyes", "Upper Pectoral, Anterior Deltoid"));
        GlobalExerciseListList.add(new GlobalList("Horizontal Crossover Flyes", "Middle Pectoral"));
        GlobalExerciseListList.add(new GlobalList("Decline Crossover Flyes", "Lower Pectoral"));
        GlobalExerciseListList.add(new GlobalList("Pushups", "Chest, Triceps, Anterior Delt"));
        GlobalExerciseListList.add(new GlobalList("Wide Dip", "Lower Pectoral, Triceps Secondary: Anterior Delt"));
        //BICEPS
        GlobalExerciseListList.add(new GlobalList("Dumbbell Curls", "Bicep"));
        GlobalExerciseListList.add(new GlobalList("Narrow Dumbbell Curls", "Bicep; Short Head"));
        GlobalExerciseListList.add(new GlobalList("Barbell Curls", "Bicep"));
        GlobalExerciseListList.add(new GlobalList("Narrow Barbell Curls", "Bicep; Short Head"));
        GlobalExerciseListList.add(new GlobalList("Narrow EZ Bar Curls", "Bicep; Short Head"));
        GlobalExerciseListList.add(new GlobalList("Wide EZ Bar Curls", "Bicep;Long Head"));
        GlobalExerciseListList.add(new GlobalList("Preacher Curls", "Bicep"));
        GlobalExerciseListList.add(new GlobalList("Limp Wrist Curls", "Bicep"));
        GlobalExerciseListList.add(new GlobalList("Bicep Isometric", "Bicep"));
        GlobalExerciseListList.add(new GlobalList("Cable/Dumbbell Spider Curls", "Bicep"));
        GlobalExerciseListList.add(new GlobalList("Banded Curls", "Bicep"));
        GlobalExerciseListList.add(new GlobalList("Ring Curls", "Bicep"));
        //SERRATUS
        GlobalExerciseListList.add(new GlobalList("Plank/Dip Protraction", "Serratus Anterior"));
        GlobalExerciseListList.add(new GlobalList("Banded/Cable Punches", "Serratus Anterior"));
        GlobalExerciseListList.add(new GlobalList("Protracted Roll Out", "Serratus Anterior, Abs Secondary: Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Protracted Cable Crunch", "Serratus Anterior, Abs Secondary: Transverse Ab"));
        //ABS
        //WHOLE ABS
        GlobalExerciseListList.add(new GlobalList("Leg Raises", "Abs Secondary: Transverse Ab"));
        //LOWER Global
        GlobalExerciseListList.add(new GlobalList("Ab Circles", "Lower Abs, Obliques Secondary: Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Reverse Crunches", "Lower Abs Secondary: Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Pulse Up", "Lower Abs Secondary: Transverse Ab"));

        //MID ABS
        GlobalExerciseListList.add(new GlobalList("Cable Crunch", "Middle Abs Secondary; Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Band Crunch", "Middle Abs Secondary; Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("V-Up", "Middle Abs Secondary; Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Ab Rollout", "Middle Abs Secondary; Transverse Ab"));


        //OBLIQUES
        GlobalExerciseListList.add(new GlobalList("Neutral Wood Choppers", "Mid Obliques Secondary: Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Low to High Wood Choppers", "Upper and Lower Obliques\nSecondary: Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("High to Low Wood Choppers", "Upper and Lower Obliques\nSecondary: Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Twisting Leg Raise", "Obliques Secondary: Transverse Ab, Lower Abs"));
        GlobalExerciseListList.add(new GlobalList("Leg Raise Scissors", "Obliques, Abs Secondary: Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Elbow to Knee Tucks", "Obliques\nSecondary: Transverse Ab, Middle Abs"));
        GlobalExerciseListList.add(new GlobalList("Banded/Cable Step Out", "Obliques Secondary: Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Rotating Plank", "Obliques Secondary: Abs Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Elbow to Knee Plank", "Obliques Secondary: Abs Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Twisting Pulse Up", "Obliques Secondary: Abs Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("X-Crunch", "Obliques Secondary: Abs, Transverse Ab"));


        //Transverse Ab
        GlobalExerciseListList.add(new GlobalList("Vacuums", "Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Banded/Cable/Resisted Rotation", "Transverse Ab, Obliques"));
        //QUADS
        GlobalExerciseListList.add(new GlobalList("Squats", "Quads, Erectors\nSecondary: Glutes, Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Bodyweight Squats", "Quads Secondary: Glutes, Transverse Ab"));
        GlobalExerciseListList.add(new GlobalList("Lunges", "Quads Secondary: Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Bulgarian Split Squat", "Quads Secondary: Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Explosive Bulgarian Split Squat", "Quads Secondary: Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Pistol Squats", "Quads, Glute Medius Secondary: Glute"));
        GlobalExerciseListList.add(new GlobalList("Side Lunge", "Quads, Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Banded Lunge", "Quads"));
        GlobalExerciseListList.add(new GlobalList("Cable Walkaways", "Quads"));
        GlobalExerciseListList.add(new GlobalList("Banded Leg Press", "Quads, Glute Medius"));
        GlobalExerciseListList.add(new GlobalList("Leg Press", "Quads"));



        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.globalExerciseRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new GlobalAdapter(GlobalExerciseListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        //STORE LINK FROM IMAGE


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
    }

    @Override
    public void onAddVolumeClick(int position) {
        stringcomparison(position);
    }

    @Override
    public void addVolume() {

    }

    private void stringcomparison(Integer position) {
        //GET TEXT FROM RECYCLER VIEW ITEM CLICKED
        RecyclerView recyclerView = findViewById(R.id.globalExerciseRecyclerView);
        TextView text = Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(position)).itemView.findViewById(R.id.exercise);
        String exercise = text.getText().toString();
        //CREATE ARRAYS AND LISTS FOR EXERCISES WITH EQUAL VOLUME PROFILES
        String[] neckExercises = {"Plate Curl", "Neck Harness Curl", "Plated Neck Extension", "Towel Lateral Flexion", "Harness Lateral Flexion", "Suspended Neck Rotation", "Head Floats"};
        List<String> neckList = Arrays.asList(neckExercises);
        String[] upperTrapExercises = {"Cable Shrug", "Dumbbell Shrugs", "Trap Bar Shrugs", "Farmer Walk", "Trap Pushaway"};
        List<String> trapList = Arrays.asList(upperTrapExercises);
        String[] lowerTrapExercises = {"Y Raise", "Hanging/Cable\nScapular Retraction", "Prone Press", "Floor/Dip Bar\nScapularDepression"};
        List<String> lowerTrapList = Arrays.asList(lowerTrapExercises);
        String[] postDeltExercises = {"Barbell/Dumbbell High Rows", "Banded Pull Aparts", "Reverse Pec Dec"};
        List<String> postDeltList = Arrays.asList(postDeltExercises);
        String[] lateralDeltExercises = {"Lateral Raise", "Delt Rotating Plank", "Cable Lateral Raises", "Machine Lateral Raise"};
        List<String> lateralDeltList = Arrays.asList(lateralDeltExercises);
        String[] OHPExercises = {"Barbell Overhead Press", "Dumbbell OHP", "Arnolds", "Cable Stretch to OHP", "Landmine Press", "Machine Shoulder Press", "Push Press", "Handstand Pushup", "Pike Pushup"};
        List<String> OHP = Arrays.asList(OHPExercises);
        String[] rotatorCuffExercises = {"Cable External Rotation", "Bench Dumbbell\nExternal Rotation", "Banded External Rotation"};
        List<String> rotatorList = Arrays.asList(rotatorCuffExercises);
        String[] TricepsExercises = {"Incline Skull Crushers", "Cable Rope Pushdowns", "V Bar Pushdowns", "Rope Overhead Triceps\nExtension", "Long Head Triceps Push Downs", "Triceps Kickback", "Triceps Extension", "Ring Overhead Extension", "Bench Dip"};
        List<String> TricepsList = Arrays.asList(TricepsExercises);
        String[] extensionExercises = {"Standing Barbell Wrist Extension", "Barbell Extension Rolls", "Reverse Curls", "Banded Wrist Extension", "Triceps Extension", "Ring Overhead Extension", "Bench Dip"};
        List<String> extensionList = Arrays.asList(extensionExercises);
        String[] rowsExercises = {"High Pulley Row", "Chest Supported Rows", "Australian Pull Up", "Ring Rows"};
        List<String> rowsList = Arrays.asList(rowsExercises);
        String[] suspendedRowsExercises = {"Cable Rows", "Barbell Rows"};
        List<String> suspendedRowsList = Arrays.asList(suspendedRowsExercises);
        String[] latLeverExercises = {"Front Levers", "Lat Pull Over", "Lat Pushdowns"};
        List<String> latLeverList = Arrays.asList(latLeverExercises);
        String[] pullUpExercises = {"Pull ups", "Cable Pulldown"};
        List<String> pullUpList = Arrays.asList(pullUpExercises);
        String[] erectorsExercises = {"Hyperextension", "Machine Erector Extension"};
        List<String> erectorsList = Arrays.asList(erectorsExercises);
        String[] gluteHamExercises = {"Cable Kick Backs", "Glute Hyperextension", "Kettlebell/Dumbbell Swing", "Cable Pull Through"};
        List<String> gluteHamList = Arrays.asList(gluteHamExercises);
        String[] gluteMediusExercises = {"Machine Abduction", "Standing Abduction", "Banded Lateral Walkout"};
        List<String> gluteMediusList = Arrays.asList(gluteMediusExercises);
        String[] hamGluteExercises = {"Hamstring Hyperextension", "Romanian Deadlift", "Physioball Hamstring Curls", "Deficit Deadlift", "Glute Ham Raise", "Hamstring Curls"};
        List<String> hamGluteList = Arrays.asList(hamGluteExercises);
        String[] isoRDLExercises = {"Isolateral Hamstring Curls", "Single Leg Romanian Deadlift"};
        List<String> isoRDLList = Arrays.asList(isoRDLExercises);
        String[] calvesExercises = {"Machine Standing Calf Raise", "Straight Leg Machine Calf Raise", "Seated Calf Raise", "Donkey Calf Raise", "Dumbbell/Plated Calf Raise"};
        List<String> calvesList = Arrays.asList(calvesExercises);
        String[] chestPressExercises = {"Incline Cable Press", "Incline Dumbbell Press", "Incline Bench Press"};
        List<String> chestPressList = Arrays.asList(chestPressExercises);
        String[] dipExercises = {"Wide Dip", "Narrow Pushup", "Pushups", "Bench Press",
                "Neutral Cable Press", "Machine Chest Press", "Dumbbell Chest Press"};
        List<String> dipList = Arrays.asList(dipExercises);
        String[] chestExercises = {"Horizontal Crossover Flyes", "Decline Crossover Flyes"};
        List<String> chestList = Arrays.asList(chestExercises);
        String[] curlExercises = {"Cable/Dumbbell Spider Curls", "Banded Curls", "Preacher Curls", "Wide EZ Bar Curls", "Narrow EZ Bar Curls", "Narrow Barbell Curls", "Barbell Curls", "Narrow Dumbbell Curls", "Dumbbell Curls"};
        List<String> curlList = Arrays.asList(curlExercises);
        String[] bicepExercises = {"Limp Wrist Curls", "Bicep Isometric", "Ring Curls"};
        List<String> bicepList = Arrays.asList(bicepExercises);
        String[] absSerratusExercises = {"Plank/Dip Protraction", "Protracted Roll Out", "Protracted Cable Crunch"};
        List<String> absSerratusList = Arrays.asList(absSerratusExercises);
        String[] absExercises = {"Leg Raises", "Hanging Leg Raise", "Reverse Crunches", "Pulse Up", "Cable Crunch", "V-Up", "Band Crunch", "Ab Rollout"};
        List<String> absList = Arrays.asList(absExercises);
        String[] obliqueAbTransverseExercises = {"Twisting Leg Raise", "Elbow to Knee Tucks", "Banded/Cable Step Out", "Twisting Pulse Up", "Rotating Plank", "Elbow to Knee Plank", "X-Crunch"};
        List<String> obliqueAbTransverseList = Arrays.asList(obliqueAbTransverseExercises);
        String[] obliqueTransverseExercises = {"Neutral Wood Choppers", "Low to High Wood Choppers", "High to Low Wood Choppers"};
        List<String> obliqueTransverseList = Arrays.asList(obliqueTransverseExercises);
        String[] quadsGluteMediusExercises = {"Bulgarian Split Squat", "Explosive Bulgarian Split Squat", "Lunges"};
        List<String> quadsGluteMediusList = Arrays.asList(quadsGluteMediusExercises);
        String[] quadsExercises = {"Leg Press", "Cable Walkaways", "Banded Lunge"};
        List<String> quadsList = Arrays.asList(quadsExercises);
        String[] californiaPressExercises = {"California Press", "Close Grip Dumbbell Press"};
        List<String> californiaPressList = Arrays.asList(californiaPressExercises);
        String[] chestTricepsExercises = {"Decline Cable Press", "Decline Bench Press", "Decline Dumbbell Press", "Narrow Dip"};
        List<String> chestTricepsList = Arrays.asList(chestTricepsExercises);


        //CHECK WHICH DIALOG TO OPEN FOR PROPER VOLUME INPUT
        if (neckList.contains(exercise)) {
            AddVolumeDialog exampleDialog = new AddVolumeDialog(this, R.style.DialogeTheme);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Neck Flexion")) {
            AddVolumeDialog exampleDialog = new AddVolumeDialog(this, R.style.DialogeTheme);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Bodyweight Squats")) {
            QuadsHalfGlute exampleDialog = new QuadsHalfGlute(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Marching Bridge")) {
            AddGluteErectorDialog exampleDialog = new AddGluteErectorDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Reverse Hyperextension")) {
            AddGluteHamDialog exampleDialog = new AddGluteHamDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Glute Side Plank")) {
            GluteMediusHalfObliques exampleDialog = new GluteMediusHalfObliques(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Abduction")) {
            AddGluteMediusVolumeDialog exampleDialog = new AddGluteMediusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Wrist Extension")) {
            AddForearmExtensorVolumeDialog exampleDialog = new AddForearmExtensorVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Bodyweight Calf Raise")) {
            AddCalvesVolumeDialog exampleDialog = new AddCalvesVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Side Lunge")) {
            SideLungeDialog exampleDialog = new SideLungeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Sprinter Lunge")) {
            SprinterLungeDialog exampleDialog = new SprinterLungeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Wall Sit")) {
            AddQuadsVolumeDialog exampleDialog = new AddQuadsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Vacuums")) {
            AddDiaphragmVolumeDialog exampleDialog = new AddDiaphragmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Leg Raise Scissors")) {
            ObliqueAbDiaphragmFullDialog exampleDialog = new ObliqueAbDiaphragmFullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Ab Circles")) {
            AbCirclesDialog exampleDialog = new AbCirclesDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Plank Protraction")) {
            AddProtractionDialog exampleDialog = new AddProtractionDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded/ Cable Punches")) {
            AddSerratusVolumeDialog exampleDialog = new AddSerratusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Narrow Dip")) {
            AddChestTricepsDialog exampleDialog = new AddChestTricepsDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Isolateral Hip Thrust")) {
            AddIsoHipThrustDialog exampleDialog = new AddIsoHipThrustDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Radial Deviation")) {
            AddRadialForearmVolumeDialog exampleDialog = new AddRadialForearmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Inverted Y")) {
            UpperLowerTrap exampleDialog = new UpperLowerTrap(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded RDL")) {
            GluteGluteMediusHamstrings exampleDialog = new GluteGluteMediusHamstrings(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Wide Dip") || exercise.equals("Narrow Pushup")) {
            AddDipDialog exampleDialog = new AddDipDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Ulnar Deviation")) {
            AddUlnarForearmVolumeDialog exampleDialog = new AddUlnarForearmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Frog Pumps")) {
            ErectorGluteMedius exampleDialog = new ErectorGluteMedius(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Push Up")) {
            AddChestPressDialog exampleDialog = new AddChestPressDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Ring Facepulls") || exercise.equals("W's")) {
            AddFacePullDialog exampleDialog = new AddFacePullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Pull Aparts")) {
            AddLowerTrapPostDeltDialog exampleDialog = new AddLowerTrapPostDeltDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Handstand Pushup") || exercise.equals("Pike Pushup")) {
            OHPDialog exampleDialog = new OHPDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded External Rotation")) {
            AddRotatorCuffVolumeDialog exampleDialog = new AddRotatorCuffVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (TricepsList.contains(exercise)) {
            AddTricepsVolumeDialog exampleDialog = new AddTricepsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Wrist Curls")) {
            AddForearmFlexorVolumeDialog exampleDialog = new AddForearmFlexorVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Wrist Flexed Curls")) {
            AddForearmCurlsDialog exampleDialog = new AddForearmCurlsDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Curls")) {
            AddBicepsVolumeDialog exampleDialog = new AddBicepsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Australian Pull Up") || exercise.equals("Ring Rows")) {
            AddRowsVolumeDialog exampleDialog = new AddRowsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Front Levers")) {
            AddLatLeverVolumeDialog exampleDialog = new AddLatLeverVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Pull Ups")) {
            AddPullUpVolumeDialog exampleDialog = new AddPullUpVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Pull ins")) {
            AddLatsVolumeDialog exampleDialog = new AddLatsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Chin Ups")) {
            AddChinUpsVolumeDialog exampleDialog = new AddChinUpsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Hip Thrust")) {
            AddHipThrustVolumeDialog exampleDialog = new AddHipThrustVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Bodyweight Hip Thrust")) {
            AddHipThrustVolumeDialog exampleDialog = new AddHipThrustVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Floor T's")) {
            AddPosteriorDeltoidVolumeDialog exampleDialog = new AddPosteriorDeltoidVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Hamstring Curls")) {
            AddHamGluteDialog exampleDialog = new AddHamGluteDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Plank/Dip Protraction") || exercise.equals("Protracted Roll Out")) {
            AddAbsSerratusVolumeDialog exampleDialog = new AddAbsSerratusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (obliqueAbTransverseList.contains(exercise)) {
            ObliqueAbDiaphragmDialog exampleDialog = new ObliqueAbDiaphragmDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Twisting Leg Raise")) {
            ObliqueAbDiaphragmDialog exampleDialog = new ObliqueAbDiaphragmDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Twisting Pulse Up")) {
            ObliqueAbDiaphragmFullDialog exampleDialog = new ObliqueAbDiaphragmFullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (absList.contains(exercise)) {
            AddAbsVolumeDialog exampleDialog = new AddAbsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Angels of Death")) {
            AddAngelOfDeathDialog exampleDialog = new AddAngelOfDeathDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Squats")) {
            AddSquatDialog exampleDialog = new AddSquatDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Incline Crossover Flyes")) {
            AddChestDeltVolumeDialog exampleDialog = new AddChestDeltVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Pistol Squats")) {
            AddPistolSquatDialog exampleDialog = new AddPistolSquatDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Leg Press")) {
            SideLungeDialog exampleDialog = new SideLungeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded/Cable/Resisted Rotation")) {
            ObliqueDiaphragmFullDialog exampleDialog = new ObliqueDiaphragmFullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded/Cable Punches")) {
            AddSerratusVolumeDialog exampleDialog = new AddSerratusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Chest Pullover")) {
            AddPullOverDialog exampleDialog = new AddPullOverDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Rope Radial Deviation")) {
            AddRadialForearmVolumeDialog exampleDialog = new AddRadialForearmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Dumbbell High Pull")) {
            AddFacePullDialog exampleDialog = new AddFacePullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Cable Front Raise")) {
            AddAnteriorDeltoidVolumeDialog exampleDialog = new AddAnteriorDeltoidVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Cheat Lateral Raise")) {
            AddTrapDeltDialog exampleDialog = new AddTrapDeltDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Rope Ulnar Deviation")) {
            AddUlnarForearmVolumeDialog exampleDialog = new AddUlnarForearmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Deadlift")) {
            AddDeadliftVolumeDialog exampleDialog = new AddDeadliftVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Facepulls")) {
            AddFacePullDialog exampleDialog = new AddFacePullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (chestTricepsList.contains(exercise)) {
            AddChestTricepsDialog exampleDialog = new AddChestTricepsDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (trapList.contains(exercise)) {
            AddUpperTrapVolumeDialog exampleDialog = new AddUpperTrapVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (lowerTrapList.contains(exercise)) {
            AddLowerTrapVolumeDialog exampleDialog = new AddLowerTrapVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (postDeltList.contains(exercise)) {
            AddLowerTrapPostDeltDialog exampleDialog = new AddLowerTrapPostDeltDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (OHP.contains(exercise)) {
            OHPDialog exampleDialog = new OHPDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (rotatorList.contains(exercise)) {
            AddRotatorCuffVolumeDialog exampleDialog = new AddRotatorCuffVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Lateral Raise")) {
            AddMedialDeltoidVolumeDialog exampleDialog = new AddMedialDeltoidVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (TricepsList.contains(exercise)) {
            AddTricepsVolumeDialog exampleDialog = new AddTricepsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (extensionList.contains(exercise)) {
            AddForearmExtensorVolumeDialog exampleDialog = new AddForearmExtensorVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Prone Wrist Curls")) {
            AddForearmFlexorVolumeDialog exampleDialog = new AddForearmFlexorVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Hammer/Crossbody Curls")) {
            AddHammerCurlVolumeDialog exampleDialog = new AddHammerCurlVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (rowsList.contains(exercise)) {
            AddRowsVolumeDialog exampleDialog = new AddRowsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (suspendedRowsList.contains(exercise)) {
            AddSuspendedRowsVolumeDialog exampleDialog = new AddSuspendedRowsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (latLeverList.contains(exercise)) {
            AddLatLeverVolumeDialog exampleDialog = new AddLatLeverVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (chestPressList.contains(exercise)) {
            AddChestPressDialog exampleDialog = new AddChestPressDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (pullUpList.contains(exercise)) {
            AddPullUpVolumeDialog exampleDialog = new AddPullUpVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (erectorsList.contains(exercise)) {
            AddErectorsVolumeDialog exampleDialog = new AddErectorsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (gluteHamList.contains(exercise)) {
            AddGluteHamDialog exampleDialog = new AddGluteHamDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (gluteMediusList.contains(exercise)) {
            AddGluteMediusVolumeDialog exampleDialog = new AddGluteMediusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (hamGluteList.contains(exercise)) {
            AddHamGluteDialog exampleDialog = new AddHamGluteDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (isoRDLList.contains(exercise)) {
            AddIsoRDLDialog exampleDialog = new AddIsoRDLDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (calvesList.contains(exercise)) {
            AddCalvesVolumeDialog exampleDialog = new AddCalvesVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (chestPressList.contains(exercise)) {
            AddChestPressDialog exampleDialog = new AddChestPressDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (dipList.contains(exercise)) {
            AddDipDialog exampleDialog = new AddDipDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (chestList.contains(exercise)) {
            AddChestVolumeDialog exampleDialog = new AddChestVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (curlList.contains(exercise)) {
            AddCurlsVolumeDialog exampleDialog = new AddCurlsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (bicepList.contains(exercise)) {
            AddBicepsVolumeDialog exampleDialog = new AddBicepsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (absSerratusList.contains(exercise)) {
            AddAbsSerratusVolumeDialog exampleDialog = new AddAbsSerratusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (obliqueAbTransverseList.contains(exercise)) {
            ObliqueAbDiaphragmDialog exampleDialog = new ObliqueAbDiaphragmDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (obliqueTransverseList.contains(exercise)) {
            ObliqueDiaphragmDialog exampleDialog = new ObliqueDiaphragmDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (quadsGluteMediusList.contains(exercise)) {
            AddQuadsGluteMediusDialog exampleDialog = new AddQuadsGluteMediusDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (californiaPressList.contains(exercise)) {
            AddCaliforniaPressDialog exampleDialog = new AddCaliforniaPressDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (quadsList.contains(exercise)) {
            AddQuadsVolumeDialog exampleDialog = new AddQuadsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (absList.contains(exercise)) {
            AddAbsVolumeDialog exampleDialog = new AddAbsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (lateralDeltList.contains(exercise)) {
            AddMedialDeltoidVolumeDialog exampleDialog = new AddMedialDeltoidVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else {
            Toast toast = Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
            toast.show();
        }
    }


}


