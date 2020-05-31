package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.RadialForearmAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.RadialForearmList;
import Aesthet.X.adfree.PopUpDialogs.AddHammerCurlVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddRadialForearmVolumeDialog;


public class RadialForearmVolume extends AppCompatActivity implements RadialForearmAdapter.OnItemClickListener, AddRadialForearmVolumeDialog.ExampleDialogListener,
        AddHammerCurlVolumeDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radial_forearm_volume);

        //CreateList
        final ArrayList<RadialForearmList> RadialForearmExerciseListList = new ArrayList<>();
        RadialForearmExerciseListList.add(new RadialForearmList("Radial Forearm", "One set towards radial forearm"));
        RadialForearmExerciseListList.add(new RadialForearmList("Rope Radial Deviation", "Radial Forearm"));
        RadialForearmExerciseListList.add(new RadialForearmList("Hammer/Crossbody Curls", "Biceps; Brachialis, Radial Forearm"));
        RadialForearmExerciseListList.add(new RadialForearmList("Banded Radial Deviation", "Radial Forearm"));
        RadialForearmExerciseListList.add(new RadialForearmList("Re-racking your plates", "Radial Forearm, put ur plates back please"));



        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.radialForearmRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        RadialForearmAdapter mAdapter = new RadialForearmAdapter(RadialForearmExerciseListList, this);

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
            case 3:
            case 4:
                AddRadialForearmVolumeDialog exampleDialog = new AddRadialForearmVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AddHammerCurlVolumeDialog exampleDialog2 = new AddHammerCurlVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}
