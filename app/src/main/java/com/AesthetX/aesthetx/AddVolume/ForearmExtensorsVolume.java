package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.Adapters.ForearmExtensorAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.ForearmExtensorList;
import com.AesthetX.aesthetx.PopUpDialogs.AddForearmExtensorVolumeDialog;


public class ForearmExtensorsVolume extends AppCompatActivity implements ForearmExtensorAdapter.OnItemClickListener, AddForearmExtensorVolumeDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forearm_extensors_volume);

        //CreateList
        final ArrayList<ForearmExtensorList> ForearmExtensorExerciseListList = new ArrayList<>();
        ForearmExtensorExerciseListList.add(new ForearmExtensorList("Forearm Extensors", "One set towards forearm extensors"));
        ForearmExtensorExerciseListList.add(new ForearmExtensorList("Standing Barbell Wrist Extension", "Forearm Extensors"));
        ForearmExtensorExerciseListList.add(new ForearmExtensorList("Barbell Extension Rolls", "Forearm Extensors"));
        ForearmExtensorExerciseListList.add(new ForearmExtensorList("Reverse Curls", "Forearm Extensors"));
        ForearmExtensorExerciseListList.add(new ForearmExtensorList("Banded Wrist Extension", "Forearm Extensors"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.forearmExtensorsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        ForearmExtensorAdapter mAdapter = new ForearmExtensorAdapter(ForearmExtensorExerciseListList, this);

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
            case 1:
            case 2:
            case 3:
            case 4:
                AddForearmExtensorVolumeDialog exampleDialog = new AddForearmExtensorVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}


