package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.CalvesAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.CalvesList;
import Aesthet.X.adfree.PopUpDialogs.AddCalvesVolumeDialog;


public class CalvesVolume extends AppCompatActivity implements CalvesAdapter.OnItemClickListener, AddCalvesVolumeDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calves_volume);

        //CreateList
        final ArrayList<CalvesList> CalvesExerciseListList = new ArrayList<>();

        CalvesExerciseListList.add(new CalvesList("Calves", "One set towards calves"));
        CalvesExerciseListList.add(new CalvesList("Machine Standing Calf Raise", "Calves"));
        CalvesExerciseListList.add(new CalvesList("Straight Leg Machine Calf Raise", "Calves"));
        CalvesExerciseListList.add(new CalvesList("Seated Calf Raise", "Calves"));
        CalvesExerciseListList.add(new CalvesList("Donkey Calf Raise", "Calves"));
        CalvesExerciseListList.add(new CalvesList("Dumbbell/Plated Calf Raise", "Calves"));
        CalvesExerciseListList.add(new CalvesList("Bodyweight Calf Raise", "Calves"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.calvesRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        CalvesAdapter mAdapter = new CalvesAdapter(CalvesExerciseListList, this);

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
            case 5:
            case 6:
                AddCalvesVolumeDialog exampleDialog = new AddCalvesVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}
