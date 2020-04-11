package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.GlutesAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.GlutesList;
import com.example.scifit.PopUpDialogs.AddDeadliftVolumeDialog;
import com.example.scifit.PopUpDialogs.AddGluteHamDialog;
import com.example.scifit.PopUpDialogs.AddGlutesVolumeDialog;
import com.example.scifit.PopUpDialogs.AddHamGluteDialog;
import com.example.scifit.PopUpDialogs.AddHipThrustVolumeDialog;
import com.example.scifit.PopUpDialogs.AddIsoHipThrustDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class GlutesVolume extends AppCompatActivity implements GlutesAdapter.OnItemClickListener, AddGlutesVolumeDialog.ExampleDialogListener,
AddHipThrustVolumeDialog.ExampleDialogListener, AddGluteHamDialog.ExampleDialogListener, AddHamGluteDialog.ExampleDialogListener,
AddIsoHipThrustDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glutes_volume);

        //CreateList
        final ArrayList<GlutesList> GlutesExerciseListList = new ArrayList<>();


        GlutesExerciseListList.add(new GlutesList ("Machine/Barbell Hip Thrust", "8-12 Controlled reps"));
        GlutesExerciseListList.add(new GlutesList ("Dumbell/Plated HipThrust", "8-12 Controlled reps"));
        GlutesExerciseListList.add(new GlutesList ("Isolateral Dumbell/Plated Hip Thrust", "8-12 Strong contraction"));
        GlutesExerciseListList.add(new GlutesList ("Cable Kick Backs", "8-12 Controlled reps"));
        GlutesExerciseListList.add(new GlutesList ("Glute Hyperextension", "8-12 Controlled reps"));
        GlutesExerciseListList.add(new GlutesList ("Kettlebell/Dumbbell Swing", "8-12 Controlled reps"));
        GlutesExerciseListList.add(new GlutesList ("Cable Pull Through", "8-12 Controlled reps"));
        //SECONDARY
        GlutesExerciseListList.add(new GlutesList ("Deadlift", "8-12 Controlled reps"));
        GlutesExerciseListList.add(new GlutesList ("Sprinter Lunge", "8-12 Controlled reps"));

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
        switch (position) {
            case 0:
                AddHipThrustVolumeDialog exampleDialog = new AddHipThrustVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddHipThrustVolumeDialog exampleDialog2 = new AddHipThrustVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddIsoHipThrustDialog exampleDialog3 = new AddIsoHipThrustDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddGluteHamDialog exampleDialog4 = new AddGluteHamDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddGluteHamDialog exampleDialog5 = new AddGluteHamDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddGluteHamDialog exampleDialog6 = new AddGluteHamDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddGluteHamDialog exampleDialog7 = new AddGluteHamDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                AddDeadliftVolumeDialog exampleDialog8 = new AddDeadliftVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;
                case 8:
                    AddGluteHamDialog exampleDialog9 = new AddGluteHamDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");

                break;

        }
    }
}
