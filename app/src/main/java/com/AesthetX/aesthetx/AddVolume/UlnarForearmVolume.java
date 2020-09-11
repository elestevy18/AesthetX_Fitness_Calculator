package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.Adapters.UlnarForearmAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.UlnarForearmList;
import com.AesthetX.aesthetx.PopUpDialogs.AddUlnarForearmVolumeDialog;


public class UlnarForearmVolume extends AppCompatActivity implements UlnarForearmAdapter.OnItemClickListener, AddUlnarForearmVolumeDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulnar_forearm_volume);

        //CreateList
        final ArrayList<UlnarForearmList> UlnarForearmExerciseListList = new ArrayList<>();
        //, California Press, Rope Cable Pushdowns, V Bar Pushdown Close Grip Dumbbell Press, Close Grip Barbelll Press, Rope Overhead UlnarForearm Extension, Long Head UlnarForearm Push Downs, Pull Over,Kickback
        //PullOvers
        UlnarForearmExerciseListList.add(new UlnarForearmList("Ulnar Forearm", "One set towards ulnar forearm"));
        UlnarForearmExerciseListList.add(new UlnarForearmList("Rope Ulnar Deviation", "Ulnar Forearm"));
        UlnarForearmExerciseListList.add(new UlnarForearmList("Banded Ulnar Deviation", "Ulnar Forearm"));
        //Front Lever Presses


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.ulnarForearmRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        UlnarForearmAdapter mAdapter = new UlnarForearmAdapter(UlnarForearmExerciseListList, this);

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
                AddUlnarForearmVolumeDialog exampleDialog = new AddUlnarForearmVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;


        }
    }
}
