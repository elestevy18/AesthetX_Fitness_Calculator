package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.BicepsAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.BicepsList;
import Aesthet.X.adfree.PopUpDialogs.AddBicepsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddCurlsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddHammerCurlVolumeDialog;


public class BicepsVolume extends AppCompatActivity implements BicepsAdapter.OnItemClickListener, AddBicepsVolumeDialog.ExampleDialogListener,
        AddCurlsVolumeDialog.ExampleDialogListener, AddHammerCurlVolumeDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps_volume);

        //CreateList
        final ArrayList<BicepsList> BicepsExerciseListList = new ArrayList<>();
        BicepsExerciseListList.add(new BicepsList("Biceps", "One set towards biceps"));
        BicepsExerciseListList.add(new BicepsList("Dumbbell Curls", "Biceps Secondary: Forearm Flexors"));
        BicepsExerciseListList.add(new BicepsList("Narrow Dumbbell Curls", "Bicep; short head Secondary: Forearm Flexors"));
        BicepsExerciseListList.add(new BicepsList("Wide Dumbbell Curls", "Bicep; long head Secondary: Forearm Flexors"));
        BicepsExerciseListList.add(new BicepsList("Barbell Curls", "Biceps Secondary: Forearm Flexors"));
        BicepsExerciseListList.add(new BicepsList("Narrow Barbell Curls", "Bicep; short head Secondary: Forearm Flexors"));
        BicepsExerciseListList.add(new BicepsList("Wide Barbell Curls", "Bicep; long head Secondary: Forearm Flexors"));
        BicepsExerciseListList.add(new BicepsList("Narrow EZ Bar Curls", "Bicep; short head Secondary: Forearm Flexors"));
        BicepsExerciseListList.add(new BicepsList("Wide EZ Bar Curls", "Bicep; long head Secondary: Forearm Flexors"));
        BicepsExerciseListList.add(new BicepsList("Preacher Curls", "Biceps Secondary: Forearm Flexors"));
        BicepsExerciseListList.add(new BicepsList("Limp Wrist Curls", "Biceps"));
        BicepsExerciseListList.add(new BicepsList("Bicep Isometric", "Biceps"));
        BicepsExerciseListList.add(new BicepsList("Cross Body Hammer Curls", "Brachialis, Radial Forearm Secondary: Biceps"));
        BicepsExerciseListList.add(new BicepsList("Cable/Dumbbell Spider Curls", "Biceps Secondary: Forearm Flexors"));
        BicepsExerciseListList.add(new BicepsList("Banded Curls", "Biceps Secondary: Forearm Flexors"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.bicepsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        BicepsAdapter mAdapter = new BicepsAdapter(BicepsExerciseListList, this);

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
            case 14:
            case 15:
            case 13:
            case 7:
            case 6:
            case 5:
            case 4:
            case 3:
            case 2:
            case 8:
            case 9:
            case 1:
                AddCurlsVolumeDialog exampleDialog = new AddCurlsVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;

            case 0:
            case 10:
            case 11:
                AddBicepsVolumeDialog exampleDialog8 = new AddBicepsVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;

            case 12:
                AddHammerCurlVolumeDialog exampleDialog10 = new AddHammerCurlVolumeDialog(this);
                exampleDialog10.show(getSupportFragmentManager(), "example dialog");
                break;

        }
    }
}
