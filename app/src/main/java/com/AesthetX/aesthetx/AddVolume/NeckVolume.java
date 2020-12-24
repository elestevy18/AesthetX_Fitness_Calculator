package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;


import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.Adapters.NeckExerciseAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.ExerciseListByMuscleGroup;
import com.AesthetX.aesthetx.PopUpDialogs.AddVolumeDialog;


public class
NeckVolume extends AppCompatActivity implements NeckExerciseAdapter.OnItemClickListener, AddVolumeDialog.ExampleDialogListener {
    private EditText volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neck_volume);

        //CreateList
        final ArrayList<ExerciseListByMuscleGroup> NeckExercisesListList = new ArrayList<>();
        NeckExercisesListList.add(new ExerciseListByMuscleGroup("Neck", "1 set towards neck"));
        NeckExercisesListList.add(new ExerciseListByMuscleGroup("Plate Curl", "Neck Flexion"));
        NeckExercisesListList.add(new ExerciseListByMuscleGroup("Neck Harness Curl", "Neck Flexion"));
        NeckExercisesListList.add(new ExerciseListByMuscleGroup("Plated Neck Extension", "Neck Extension"));
        NeckExercisesListList.add(new ExerciseListByMuscleGroup("Harness Lateral Flexion", "Lateral Flexion"));
        NeckExercisesListList.add(new ExerciseListByMuscleGroup("Suspended Neck Rotation", "Neck Flexion, Rotation"));
        NeckExercisesListList.add(new ExerciseListByMuscleGroup("Neck Flexion", "Lateral and forward Flexion"));
        NeckExercisesListList.add(new ExerciseListByMuscleGroup("Head Floats", "Neck Flexion, Lateral Flexion or Extension"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.neckExercisesRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        NeckExerciseAdapter mAdapter = new NeckExerciseAdapter(NeckExercisesListList, this);

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
                AddVolumeDialog exampleDialog = new AddVolumeDialog(this, R.style.DialogeTheme);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;

        }

    }


    @Override
    public void addVolume() {
//SHARED PREFERNCES SET AND STORE MAX AND PROGRESS
    }
}
