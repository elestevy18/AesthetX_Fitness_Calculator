package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.RotatorCuffAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.RotatorCuffList;
import com.example.scifit.PopUpDialogs.AddHalfLowerTrapPostDeltDialog;
import com.example.scifit.PopUpDialogs.AddHighPullDialog;
import com.example.scifit.PopUpDialogs.AddRotatorCuffVolumeDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class RotatorCuffVolume extends AppCompatActivity implements RotatorCuffAdapter.OnItemClickListener, AddRotatorCuffVolumeDialog.ExampleDialogListener,
AddHalfLowerTrapPostDeltDialog.ExampleDialogListener, AddHighPullDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotator_cuff_volume);

        //CreateList
        final ArrayList<RotatorCuffList> RotatorCuffExerciseListList = new ArrayList<>();
        RotatorCuffExerciseListList.add(new RotatorCuffList ("Cable External Rotation", "8-12 Controlled reps"));
        RotatorCuffExerciseListList.add(new RotatorCuffList ("Lying Bench Dumbbell External Rotation", "8-12 Controlled reps"));
        RotatorCuffExerciseListList.add(new RotatorCuffList ("Banded External Rotation", "8-12 Strong contraction"));
        RotatorCuffExerciseListList.add(new RotatorCuffList ("W's", "8-12 Controlled reps"));
        RotatorCuffExerciseListList.add(new RotatorCuffList ("Dumbbell High Pull", "8-12 Controlled reps"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.rotatorCuffRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        RotatorCuffAdapter mAdapter = new RotatorCuffAdapter(RotatorCuffExerciseListList, this);

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
                AddRotatorCuffVolumeDialog exampleDialog = new AddRotatorCuffVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddRotatorCuffVolumeDialog exampleDialog2 = new AddRotatorCuffVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddRotatorCuffVolumeDialog exampleDialog3 = new AddRotatorCuffVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddHalfLowerTrapPostDeltDialog exampleDialog4 = new AddHalfLowerTrapPostDeltDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddHighPullDialog exampleDialog5 = new AddHighPullDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;


        }
    }
}
