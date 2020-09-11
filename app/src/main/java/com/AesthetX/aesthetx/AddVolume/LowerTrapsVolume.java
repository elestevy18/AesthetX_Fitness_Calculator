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

import com.AesthetX.aesthetx.Classes.Adapters.LowerTrapAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.LowerTrapExerciseList;
import com.AesthetX.aesthetx.PopUpDialogs.AddAngelOfDeathDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddFacePullDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddLowerTrapPostDeltDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddLowerTrapVolumeDialog;
import com.AesthetX.aesthetx.PopUpDialogs.UpperLowerTrap;


public class LowerTrapsVolume extends AppCompatActivity implements LowerTrapAdapter.OnItemClickListener,
        AddLowerTrapVolumeDialog.ExampleDialogListener, AddAngelOfDeathDialog.ExampleDialogListener, AddFacePullDialog.ExampleDialogListener,
        UpperLowerTrap.ExampleDialogListener, AddLowerTrapPostDeltDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_traps_volume);

        //CreateList
        final ArrayList<LowerTrapExerciseList> LowerTrapExerciseListList = new ArrayList<>();
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Lower Trap", "One set towards lower traps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Y Raise", "Lower Traps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Reverse Pec Dec", "Lower Traps, Post Delt"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Angels of Death", "Spinal Erectors, Lower Traps, Post Delt"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Floor/Dip Bar\nScapular Depression", "Lower Traps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("W's", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Facepulls", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Ring Facepulls", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Hanging/Cable\nScapular Retraction", "Lower Traps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Inverted Y", "Upper and Lower Trapezoid"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.lowerTrapsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        LowerTrapAdapter mAdapter = new LowerTrapAdapter(LowerTrapExerciseListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    //Watch out for the typo
    public void onExerciseClick(int position) {
        switch (position) {
        }
    }

    public void onAddVolumeClick(int position) {
        stringcomparison(position);

    }

    @Override
    public void addVolume() {

    }

    public void stringcomparison(Integer position){
        //GET TEXT FROM RECYCLER VIEW ITEM CLICKED
        RecyclerView recyclerView = findViewById(R.id.lowerTrapsRecyclerView);
        TextView text = Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(position)).itemView.findViewById(R.id.exercise);
        String exercise = text.getText().toString();
        //CREATE ARRAYS AND LISTS FOR EXERCISES WITH EQUAL VOLUME PROFILES
        String[] lowerTrapExercises = {"Lower Trap", "Y Raise", "Hanging/Cable\nScapular Retraction", "Prone Press", "Floor/Dip\nBar Scapular Depression"};
        List<String> lowerTrapList = Arrays.asList(lowerTrapExercises);

        String[] postDeltExercises = {"Barbell/Dumbbell High Rows", "Banded Pull Aparts", "Reverse Pec Dec"};
        List<String> postDeltList = Arrays.asList(postDeltExercises);

        if (lowerTrapList.contains(exercise)) {
            AddLowerTrapVolumeDialog exampleDialog = new AddLowerTrapVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Inverted Y")) {
            UpperLowerTrap exampleDialog = new UpperLowerTrap(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }  else if (postDeltList.contains(exercise)) {
            AddLowerTrapPostDeltDialog exampleDialog = new AddLowerTrapPostDeltDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Ring Facepulls") || exercise.equals("W's") || exercise.equals("Facepulls")) {
            AddFacePullDialog exampleDialog = new AddFacePullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Angels of Death")) {
            AddAngelOfDeathDialog exampleDialog = new AddAngelOfDeathDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }
    }
}
