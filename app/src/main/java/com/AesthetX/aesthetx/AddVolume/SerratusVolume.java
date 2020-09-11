package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.Adapters.SerratusAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.SerratusList;
import com.AesthetX.aesthetx.PopUpDialogs.AddAbsSerratusVolumeDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddProtractionDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddSerratusVolumeDialog;


public class SerratusVolume extends AppCompatActivity implements SerratusAdapter.OnItemClickListener, AddSerratusVolumeDialog.ExampleDialogListener,
        AddProtractionDialog.ExampleDialogListener, AddAbsSerratusVolumeDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serratus_volume);

        //CreateList
        final ArrayList<SerratusList> SerratusExerciseListList = new ArrayList<>();
        SerratusExerciseListList.add(new SerratusList("Serratus Anterior", "One set towards serratus"));
        SerratusExerciseListList.add(new SerratusList("Plank Protraction", "Serratus Anterior"));
        SerratusExerciseListList.add(new SerratusList("Banded/ Cable Punches", "Serratus Anterior"));
        SerratusExerciseListList.add(new SerratusList("Protracted Roll Out", "Serratus Anterior, Abs Secondary: Transverse"));
        SerratusExerciseListList.add(new SerratusList("Protracted Cable Crunch", "Serratus Anterior, Abs Secondary: Transverse"));



        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.serratusRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        SerratusAdapter mAdapter = new SerratusAdapter(SerratusExerciseListList, this);

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
            case 2:
                AddSerratusVolumeDialog exampleDialog = new AddSerratusVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddProtractionDialog exampleDialog1 = new AddProtractionDialog(this);
                exampleDialog1.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
            case 4:
                AddAbsSerratusVolumeDialog exampleDialog3 = new AddAbsSerratusVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}
