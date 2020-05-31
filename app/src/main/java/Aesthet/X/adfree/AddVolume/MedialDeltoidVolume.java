package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.MedialDeltoidAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.MedialDeltoidList;
import Aesthet.X.adfree.PopUpDialogs.AddMedialDeltoidVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddTrapDeltDialog;


public class MedialDeltoidVolume extends AppCompatActivity implements MedialDeltoidAdapter.OnItemClickListener, AddMedialDeltoidVolumeDialog.ExampleDialogListener,
        AddTrapDeltDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posterior_deltoid_volume);

        //CreateList
        final ArrayList<MedialDeltoidList> MedialDeltoidExerciseListList = new ArrayList<>();
        MedialDeltoidExerciseListList.add(new MedialDeltoidList("Medial Deltoid", "One set towards medial deltoid"));
        MedialDeltoidExerciseListList.add(new MedialDeltoidList("Cable Lateral Raises", "Medial Deltoid"));
        MedialDeltoidExerciseListList.add(new MedialDeltoidList("Machine Lateral Raise", "Medial Deltoid"));
        MedialDeltoidExerciseListList.add(new MedialDeltoidList("Cheat Lateral Raise", "Medial Deltoid, Upper Trap"));
        MedialDeltoidExerciseListList.add(new MedialDeltoidList("Lateral Raise", "Medial Deltoid"));
        MedialDeltoidExerciseListList.add(new MedialDeltoidList("Delt Rotating Plank", "Medial Deltoid"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.posteriorDeltoidRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        MedialDeltoidAdapter mAdapter = new MedialDeltoidAdapter(MedialDeltoidExerciseListList, this);

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
            case 4:
            case 1:
            case 5:
                AddMedialDeltoidVolumeDialog exampleDialog = new AddMedialDeltoidVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
                AddTrapDeltDialog exampleDialog4 = new AddTrapDeltDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;


        }
    }
}
