package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.Adapters.PosteriorDeltoidAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.PosteriorDeltoidList;
import com.AesthetX.aesthetx.PopUpDialogs.AddAngelOfDeathDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddFacePullDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddHalfLowerTrapPostDeltDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddLowerTrapPostDeltDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddPosteriorDeltoidVolumeDialog;


public class PosteriorDeltoidVolume extends AppCompatActivity implements PosteriorDeltoidAdapter.OnItemClickListener, AddPosteriorDeltoidVolumeDialog.ExampleDialogListener,
        AddHalfLowerTrapPostDeltDialog.ExampleDialogListener, AddFacePullDialog.ExampleDialogListener, AddLowerTrapPostDeltDialog.ExampleDialogListener, AddAngelOfDeathDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posterior_deltoid_volume);

        //CreateList
        final ArrayList<PosteriorDeltoidList> PosteriorDeltoidExerciseListList = new ArrayList<>();

        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList("Posterior Deltoid", "One set towards posterior deltoids"));


        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList("Barbell/Dumbbell High Rows", "Posterior Deltoid, Lower Trap"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList("Facepulls", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList("W's", "Posterior Deltoid, Rotator Cuff, Lower Traps"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList("Reverse Pec Dec", "Lower Traps, Post Delt"));

        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList("Floor T's", "Posterior Deltoid"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList("Banded Pull Aparts", "Posterior Delt, Lower Traps"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList("Ring Facepulls", "Posterior Deltoid, Rotator Cuff, Lower Traps"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList("Angels of Death", "Spinal Erectors, Lower Traps, Post Delt"));



        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.posteriorDeltoidRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        PosteriorDeltoidAdapter mAdapter = new PosteriorDeltoidAdapter(PosteriorDeltoidExerciseListList, this);

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
                AddPosteriorDeltoidVolumeDialog exampleDialog0 = new AddPosteriorDeltoidVolumeDialog(this);
                exampleDialog0.show(getSupportFragmentManager(), "example dialog");
                break;

            case 1:
                AddHalfLowerTrapPostDeltDialog exampleDialog1 = new AddHalfLowerTrapPostDeltDialog(this);
                exampleDialog1.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AddFacePullDialog exampleDialog2 = new AddFacePullDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddFacePullDialog exampleDialog3 = new AddFacePullDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddLowerTrapPostDeltDialog exampleDialog4 = new AddLowerTrapPostDeltDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 5:
                AddPosteriorDeltoidVolumeDialog exampleDialog5 = new AddPosteriorDeltoidVolumeDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddLowerTrapPostDeltDialog exampleDialog6 = new AddLowerTrapPostDeltDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;

            case 7:
                AddFacePullDialog exampleDialog7 = new AddFacePullDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 8:
                AddAngelOfDeathDialog exampleDialog8 = new AddAngelOfDeathDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");
                break;


        }
    }
}
