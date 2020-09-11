package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.AesthetX.aesthetx.Classes.Adapters.RotatorCuffAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.RotatorCuffList;
import com.AesthetX.aesthetx.PopUpDialogs.AddFacePullDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddHalfLowerTrapPostDeltDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddHighPullDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddRotatorCuffVolumeDialog;
import com.AesthetX.aesthetx.PopUpDialogs.RotatorCuffOnlyVolumeDialog;


public class RotatorCuffVolume extends AppCompatActivity implements RotatorCuffAdapter.OnItemClickListener, AddRotatorCuffVolumeDialog.ExampleDialogListener,
        AddHalfLowerTrapPostDeltDialog.ExampleDialogListener, AddHighPullDialog.ExampleDialogListener, AddFacePullDialog.ExampleDialogListener, RotatorCuffOnlyVolumeDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotator_cuff_volume);

        //CreateList
        final ArrayList<RotatorCuffList> RotatorCuffExerciseListList = new ArrayList<>();

        RotatorCuffExerciseListList.add(new RotatorCuffList("Rotator Cuff", "One set towards rotator cuff"));
        RotatorCuffExerciseListList.add(new RotatorCuffList("Cable External Rotation", "Rotator Cuff, Forearm Extensors"));
        RotatorCuffExerciseListList.add(new RotatorCuffList("Bench Dumbbell External Rotation", "Rotator Cuff, Forearm Extensors"));
        RotatorCuffExerciseListList.add(new RotatorCuffList("W's", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        RotatorCuffExerciseListList.add(new RotatorCuffList("Dumbbell High Pull", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        RotatorCuffExerciseListList.add(new RotatorCuffList("Facepulls", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        RotatorCuffExerciseListList.add(new RotatorCuffList("Ring Facepulls", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        RotatorCuffExerciseListList.add(new RotatorCuffList("Banded External Rotation", "Rotator Cuff, Forearm Extensors"));


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
    }

    @Override
    public void onAddVolumeClick(int position) {
        stringcomparison(position);
    }

    private void stringcomparison(Integer position) {
        // GET TEXT FROM RECYCLER VIEW ITEM CLICKED
        RecyclerView recyclerView = findViewById(R.id.rotatorCuffRecyclerView);
        TextView text = Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(position)).itemView.findViewById(R.id.exercise);
        String exercise = text.getText().toString();

        String[] rotatorCuffExercises = {"Cable External Rotation", "Bench Dumbbell External Rotation", "Banded External Rotation"};
        List<String> rotatorList = Arrays.asList(rotatorCuffExercises);

        String[] facepullExercises = {"Dumbbell High Pull", "W's", "Facepulls", "Ring Facepulls"};
        List<String> facepull = Arrays.asList(facepullExercises);

        if (rotatorList.contains(exercise)) {
            AddRotatorCuffVolumeDialog exampleDialog = new AddRotatorCuffVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (facepull.contains(exercise)) {
            AddFacePullDialog exampleDialog = new AddFacePullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Rotator Cuff")) {
            RotatorCuffOnlyVolumeDialog exampleDialog = new RotatorCuffOnlyVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }
    }
}
