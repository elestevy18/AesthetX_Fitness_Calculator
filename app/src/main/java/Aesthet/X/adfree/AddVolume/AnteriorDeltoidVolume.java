package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.AnteriorDeltoidAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.AnteriorDeltoidList;
import Aesthet.X.adfree.PopUpDialogs.AddAnteriorDeltoidVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.OHPDialog;


public class AnteriorDeltoidVolume extends AppCompatActivity implements AnteriorDeltoidAdapter.OnItemClickListener, AddAnteriorDeltoidVolumeDialog.ExampleDialogListener,
        OHPDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anterior_deltoid_volume);

        //CreateList
        final ArrayList<AnteriorDeltoidList> AnteriorDeltoidExerciseListList = new ArrayList<>();
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Anterior Deltoid", "One set towards anterior deltoids"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Arnolds", "Anterior Delt Secondary: Triceps, Medial Delt"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Barbell Overhead Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Dumbbell OHP", "Anterior Delt Secondary: Triceps, Medial Delt"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Cable Stretch to OHP", "Anterior Delt Secondary: Triceps, Medial Delt"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Landmine Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Machine Shoulder Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Push Press", "Anterior Delt Secondary: Triceps, Medial Delt"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Pike Pushup", "Anterior Delt Secondary: Triceps, Medial Delt"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Handstand Pushup", "Anterior Delt, Secondary: Triceps, Medial Delt"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList("Cable Front Raise", "Anterior Delt"));



        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.anteriorDeltoidRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        AnteriorDeltoidAdapter mAdapter = new AnteriorDeltoidAdapter(AnteriorDeltoidExerciseListList, this);

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
            case 10:
                AddAnteriorDeltoidVolumeDialog exampleDialog10 = new AddAnteriorDeltoidVolumeDialog(this);
                exampleDialog10.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
            case 9:
            case 8:
            case 7:
            case 6:
            case 5:
            case 4:
            case 3:
            case 2:
                OHPDialog exampleDialog = new OHPDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;

        }
    }
}
