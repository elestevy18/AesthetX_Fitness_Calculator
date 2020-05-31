
package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.ForearmFlexorAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.ForearmFlexorList;
import Aesthet.X.adfree.PopUpDialogs.AddForearmCurlsDialog;
import Aesthet.X.adfree.PopUpDialogs.AddForearmFlexorVolumeDialog;


public class ForearmFlexorsVolume extends AppCompatActivity implements ForearmFlexorAdapter.OnItemClickListener, AddForearmFlexorVolumeDialog.ExampleDialogListener, AddForearmCurlsDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forearm_flexors_volume);

        //CreateList
        final ArrayList<ForearmFlexorList> ForearmFlexorExerciseListList = new ArrayList<>();

        ForearmFlexorExerciseListList.add(new ForearmFlexorList("Forearm Flexors", "One set towards forearm flexors"));
        ForearmFlexorExerciseListList.add(new ForearmFlexorList("Prone Wrist Curls", "Forearm Flexors"));
        ForearmFlexorExerciseListList.add(new ForearmFlexorList("Wrist Flexed Curls", "Biceps, Forearm Flexors"));
        ForearmFlexorExerciseListList.add(new ForearmFlexorList("Banded Wrist Curls", "Forearm Flexors"));

        //curls


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.forearmFlexorsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        ForearmFlexorAdapter mAdapter = new ForearmFlexorAdapter(ForearmFlexorExerciseListList, this);

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
                AddForearmFlexorVolumeDialog exampleDialog = new AddForearmFlexorVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AddForearmCurlsDialog exampleDialog2 = new AddForearmCurlsDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;


        }
    }
}

