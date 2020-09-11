package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.Adapters.GlutesAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.GlutesList;
import com.AesthetX.aesthetx.PopUpDialogs.AddGluteErectorDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddGluteHamDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddGlutesVolumeDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddHamGluteDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddHipThrustVolumeDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddIsoHipThrustDialog;
import com.AesthetX.aesthetx.PopUpDialogs.GluteGluteMediusHamstrings;
import com.AesthetX.aesthetx.PopUpDialogs.SprinterLungeDialog;


public class GlutesVolume extends AppCompatActivity implements GlutesAdapter.OnItemClickListener, AddGlutesVolumeDialog.ExampleDialogListener,
        AddHipThrustVolumeDialog.ExampleDialogListener, AddGluteHamDialog.ExampleDialogListener, AddHamGluteDialog.ExampleDialogListener,
        AddIsoHipThrustDialog.ExampleDialogListener, SprinterLungeDialog.ExampleDialogListener, GluteGluteMediusHamstrings.ExampleDialogListener,
        AddGluteErectorDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glutes_volume);

        //CreateList
        final ArrayList<GlutesList> GlutesExerciseListList = new ArrayList<>();

        GlutesExerciseListList.add(new GlutesList("Glutes", "One set towards glutes"));
        GlutesExerciseListList.add(new GlutesList("Hip Thrust", "Glutes, Erectors\nSecondary: Hamstrings, Glute Medius"));
        GlutesExerciseListList.add(new GlutesList("Isolateral Hip Thrust", "Glutes, Glute Medius Secondary: Hamstrings"));

        GlutesExerciseListList.add(new GlutesList("Cable Pull Through", "Glutes Secondary: Hamstrings, Glute Medius"));
        GlutesExerciseListList.add(new GlutesList("Glute Hyperextension", "Glutes Secondary: Hamstrings, Glute Medius"));
        GlutesExerciseListList.add(new GlutesList("Kettlebell/Dumbbell Swing", "Glutes Secondary: Hamstrings, Glute Medius"));
        GlutesExerciseListList.add(new GlutesList("Cable Kick Backs", "Glutes Secondary: Hamstrings, Glute Medius"));
        GlutesExerciseListList.add(new GlutesList("Reverse Hyperextension", "Glutes Secondary:Spinal Erector , Hamstrings"));


        GlutesExerciseListList.add(new GlutesList("Sprinter Lunge", "Glutes, Glute Medius Secondary: Hamstrings"));
        GlutesExerciseListList.add(new GlutesList("Banded RDL", "Glutes, Glute Medius, Hamstrings"));
        GlutesExerciseListList.add(new GlutesList("Marching Bridge", "Spinal Erector, Glutes"));
        GlutesExerciseListList.add(new GlutesList("Bodyweight Hip Thrust", "Glutes Secondary: Hamstrings"));




        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.glutesRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        GlutesAdapter mAdapter = new GlutesAdapter(GlutesExerciseListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void addVolume() {

    }

    @Override
    public void onExerciseClick(int position) {
    }

    @Override
    public void onAddVolumeClick(int position) {
        switch (position) {
            case 0:

                AddGlutesVolumeDialog exampleDialog = new AddGlutesVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
            case 11:
                AddHipThrustVolumeDialog exampleDialog1 = new AddHipThrustVolumeDialog(this);
                exampleDialog1.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AddIsoHipThrustDialog exampleDialog2 = new AddIsoHipThrustDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                AddGluteHamDialog exampleDialog3 = new AddGluteHamDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;

            case 8:
                SprinterLungeDialog exampleDialog4 = new SprinterLungeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;

            case 9:
                GluteGluteMediusHamstrings exampleDialog8 = new GluteGluteMediusHamstrings(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");
                break;
            case 10:
                AddGluteErectorDialog exampleDialog5 = new AddGluteErectorDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}
