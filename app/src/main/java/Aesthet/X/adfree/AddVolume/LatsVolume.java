package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.LatsAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.LatsList;
import Aesthet.X.adfree.PopUpDialogs.AddChinUpsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddLatLeverVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddLatsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddPullUpVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddRowsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddSuspendedRowsVolumeDialog;


public class LatsVolume extends AppCompatActivity implements LatsAdapter.OnItemClickListener, AddLatsVolumeDialog.ExampleDialogListener,
        AddSuspendedRowsVolumeDialog.ExampleDialogListener, AddRowsVolumeDialog.ExampleDialogListener, AddLatLeverVolumeDialog.ExampleDialogListener,
        AddPullUpVolumeDialog.ExampleDialogListener, AddChinUpsVolumeDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lats_volume);

        //CreateList
        final ArrayList<LatsList> LatsExerciseListList = new ArrayList<>();

        LatsExerciseListList.add(new LatsList("Lats", "One set towards lats"));
        LatsExerciseListList.add(new LatsList("Lat Pull Over", "Lats, Triceps"));
        LatsExerciseListList.add(new LatsList("Lat Pushdowns", "Lats, Triceps"));

        LatsExerciseListList.add(new LatsList("Cable Pulldown", "Lats, Lower Trap, \nSecondary: Post Delt, Bicep, Forearms"));


        LatsExerciseListList.add(new LatsList("High Pulley Row", "Lats, Lower Traps \nSecondary: Post Delt, Biceps, Forearm Flexors"));
        LatsExerciseListList.add(new LatsList("Chest Supported Rows", "Lats, Lower Traps \nSecondary: Post Delt, Biceps, Forearm Flexors"));

        LatsExerciseListList.add(new LatsList("Barbell Rows", "Lats, Lower Traps, Erectors \nSecondary: Post Delt, Biceps, Forearm Flexor"));
        LatsExerciseListList.add(new LatsList("Cable Rows", "Lats, Lower Traps, Erectors \nSecondary: Post Delt, Biceps, Forearm Flexor"));


        LatsExerciseListList.add(new LatsList("Front Levers", "Lats, Triceps"));

        LatsExerciseListList.add(new LatsList("Pull Ups", "Lats, Lower Trap, \nSecondary: Post Delt, Bicep, Forearms"));
        LatsExerciseListList.add(new LatsList("Chin Ups", "Lats, Lower Trap, Bicep \nSecondary: Post Delt, Forearms"));
        LatsExerciseListList.add(new LatsList("Pull ins", "Lats"));

        LatsExerciseListList.add(new LatsList("Ring Rows", "Lats, Lower Traps \nSecondary: Post Delt, Biceps, Forearm Flexors"));
        LatsExerciseListList.add(new LatsList("Australian Pull Up", "Lats, Lower Traps \nSecondary: Post Delt, Biceps, Forearm Flexors"));




        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.latsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        LatsAdapter mAdapter = new LatsAdapter(LatsExerciseListList, this);

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
            case 1:
            case 2:
            case 8:
                AddLatLeverVolumeDialog exampleDialog = new AddLatLeverVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 0:
            case 11:
                AddLatsVolumeDialog exampleDialog3 = new AddLatsVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
            case 9:
                AddPullUpVolumeDialog exampleDialog4 = new AddPullUpVolumeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
            case 10:
                AddChinUpsVolumeDialog exampleDialog7 = new AddChinUpsVolumeDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 4:
            case 5:
            case 12:
            case 13:
                AddRowsVolumeDialog exampleDialog8 = new AddRowsVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
            case 7:
                AddSuspendedRowsVolumeDialog exampleDialog12 = new AddSuspendedRowsVolumeDialog(this);
                exampleDialog12.show(getSupportFragmentManager(), "example dialog");
                break;

        }
    }
}
