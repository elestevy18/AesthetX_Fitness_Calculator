package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;


import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.Adapters.NeckExerciseAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.NeckExerciseList;
import com.AesthetX.aesthetx.PopUpDialogs.AddNeckVolumeDialog;


public class
NeckVolume extends AppCompatActivity implements NeckExerciseAdapter.OnItemClickListener, AddNeckVolumeDialog.ExampleDialogListener {
    private EditText volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neck_volume);

        //CreateList
        final ArrayList<NeckExerciseList> NeckExercisesListList = new ArrayList<>();
        NeckExercisesListList.add(new NeckExerciseList("Neck", "1 set towards neck"));
        NeckExercisesListList.add(new NeckExerciseList("Plate Curl", "Neck Flexion"));
        NeckExercisesListList.add(new NeckExerciseList("Neck Harness Curl", "Neck Flexion"));
        NeckExercisesListList.add(new NeckExerciseList("Plated Neck Extension", "Neck Extension"));
        NeckExercisesListList.add(new NeckExerciseList("Harness Lateral Flexion", "Lateral Flexion"));
        NeckExercisesListList.add(new NeckExerciseList("Suspended Neck Rotation", "Neck Flexion, Rotation"));
        NeckExercisesListList.add(new NeckExerciseList("Neck Flexion", "Lateral and forward Flexion"));
        NeckExercisesListList.add(new NeckExerciseList("Head Floats", "Neck Flexion, Lateral Flexion or Extension"));


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
                AddNeckVolumeDialog exampleDialog = new AddNeckVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;

        }

    }


    @Override
    public void addVolume() {
//SHARED PREFERNCES SET AND STORE MAX AND PROGRESS
    }
}
