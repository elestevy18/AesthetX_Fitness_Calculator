package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.Adapters.UpperTrapAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.UpperTrapExerciseList;
import com.AesthetX.aesthetx.PopUpDialogs.AddDeadliftVolumeDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddUpperTrapVolumeDialog;
import com.AesthetX.aesthetx.PopUpDialogs.UpperLowerTrap;

public class UpperTrapVolume extends AppCompatActivity implements UpperTrapAdapter.OnItemClickListener, AddUpperTrapVolumeDialog.ExampleDialogListener,
        AddDeadliftVolumeDialog.ExampleDialogListener, UpperLowerTrap.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_traps_volume);

        //CreateList
        final ArrayList<UpperTrapExerciseList> UpperTrapExerciseListList = new ArrayList<>();

        UpperTrapExerciseListList.add(new UpperTrapExerciseList("Upper Trap", "One set towards upper traps"));
        UpperTrapExerciseListList.add(new UpperTrapExerciseList("Dumbbell Shrugs", "Upper Trap"));
        UpperTrapExerciseListList.add(new UpperTrapExerciseList("Trap Bar Shrugs", "Upper Trap"));
        UpperTrapExerciseListList.add(new UpperTrapExerciseList("Farmer Walk", "Upper Trap"));
        UpperTrapExerciseListList.add(new UpperTrapExerciseList("Trap Pushaway", "Upper Trapezoid"));
        UpperTrapExerciseListList.add(new UpperTrapExerciseList("Inverted Y", "Upper and Lower Trapezoid"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.upperTrapRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        UpperTrapAdapter mAdapter = new UpperTrapAdapter(UpperTrapExerciseListList, this);

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

        switch (position) {


            case 1:
                AddDeadliftVolumeDialog exampleDialog = new AddDeadliftVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                AddUpperTrapVolumeDialog exampleDialog2 = new AddUpperTrapVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                UpperLowerTrap exampleDialog3 = new UpperLowerTrap(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;

        }

    }

    @Override
    public void addVolume() {

    }
}
