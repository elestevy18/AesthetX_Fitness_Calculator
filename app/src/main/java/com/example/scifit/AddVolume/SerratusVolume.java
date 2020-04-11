package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.SerratusAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.SerratusList;
import com.example.scifit.PopUpDialogs.AddAbsSerratusVolumeDialog;
import com.example.scifit.PopUpDialogs.AddProtractionDialog;
import com.example.scifit.PopUpDialogs.AddSerratusVolumeDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class SerratusVolume extends AppCompatActivity implements SerratusAdapter.OnItemClickListener, AddSerratusVolumeDialog.ExampleDialogListener,
AddProtractionDialog.ExampleDialogListener, AddAbsSerratusVolumeDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serratus_volume);

        //CreateList
        final ArrayList<SerratusList> SerratusExerciseListList = new ArrayList<>();
        SerratusExerciseListList.add(new SerratusList ("Plank Protaction", "8-15 Strong Contraction"));
        SerratusExerciseListList.add(new SerratusList ("Banded/ Cable Punches", "8-12 Strong Contraction"));
        SerratusExerciseListList.add(new SerratusList ("Protracted Roll Out", "5-12 Strong contraction"));
        SerratusExerciseListList.add(new SerratusList ("Protracted Cable Crunch", "8-12 Strong contraction"));

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
                AddProtractionDialog exampleDialog = new AddProtractionDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddSerratusVolumeDialog exampleDialog2 = new AddSerratusVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AddAbsSerratusVolumeDialog exampleDialog3 = new AddAbsSerratusVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
                AddAbsSerratusVolumeDialog exampleDialog4 = new AddAbsSerratusVolumeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}
