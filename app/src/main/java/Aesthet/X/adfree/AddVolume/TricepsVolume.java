package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.TricepsAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.TricepsList;
import Aesthet.X.adfree.PopUpDialogs.AddCaliforniaPressDialog;
import Aesthet.X.adfree.PopUpDialogs.AddChestTricepsDialog;
import Aesthet.X.adfree.PopUpDialogs.AddDipDialog;
import Aesthet.X.adfree.PopUpDialogs.AddTricepsLatVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddTricepsVolumeDialog;


public class TricepsVolume extends AppCompatActivity implements TricepsAdapter.OnItemClickListener, AddTricepsVolumeDialog.ExampleDialogListener,
        AddTricepsLatVolumeDialog.ExampleDialogListener, AddDipDialog.ExampleDialogListener, AddChestTricepsDialog.ExampleDialogListener, AddCaliforniaPressDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triceps_volume);

        //CreateList
        final ArrayList<TricepsList> TricepsExerciseListList = new ArrayList<>();
        //, California Press, Rope Cable Pushdowns, V Bar Pushdown Close Grip Dumbbell Press, Close Grip Barbelll Press, Rope Overhead Triceps Extension, Long Head Triceps Push Downs, Pull Over,Kickback
        TricepsExerciseListList.add(new TricepsList("Triceps", "One set towards triceps"));
        TricepsExerciseListList.add(new TricepsList("Narrow Dip", "Triceps; All Heads, Chest"));
        TricepsExerciseListList.add(new TricepsList("Incline SkullCrushers", "Triceps; Long Head"));
        TricepsExerciseListList.add(new TricepsList("California Press", "Triceps; All Heads Secondary: Chest, Anterior Deltoid "));
        TricepsExerciseListList.add(new TricepsList("Cable Rope Pushdowns", "Triceps; Medial and Short Head"));
        TricepsExerciseListList.add(new TricepsList("V Bar Pushdowns", "Triceps; Medial and Short Head"));
        TricepsExerciseListList.add(new TricepsList("Close Grip Dumbbell Press", "Triceps Short And Medial Head \nSecondary: Chest, Anterior Deltoid "));
        TricepsExerciseListList.add(new TricepsList("Rope Overhead Triceps Extension", "Triceps; Long Head"));
        TricepsExerciseListList.add(new TricepsList("Long Head Triceps Push Downs", "Triceps; Long Head"));
        TricepsExerciseListList.add(new TricepsList("Triceps Kickback", "Triceps; Short Head"));


        TricepsExerciseListList.add(new TricepsList("Narrow Pushup", "Triceps; Short and Medial Head, Chest \nSecondary: Anterior Delt"));
        TricepsExerciseListList.add(new TricepsList("Triceps Extension", "Triceps; short and medial head"));
        TricepsExerciseListList.add(new TricepsList("Ring Overhead Extension", "Triceps; long head"));
        TricepsExerciseListList.add(new TricepsList("Bench Dip", "Triceps; All Heads"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.TricepsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        TricepsAdapter mAdapter = new TricepsAdapter(TricepsExerciseListList, this);

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
                AddChestTricepsDialog exampleDialog = new AddChestTricepsDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 0:
            case 2:
            case 4:
            case 5:
            case 7:
            case 11:
            case 12:
            case 13:
                AddTricepsVolumeDialog exampleDialog2 = new AddTricepsVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
            case 6:

                AddCaliforniaPressDialog exampleDialog3 = new AddCaliforniaPressDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 8:
            case 9:
                AddTricepsLatVolumeDialog exampleDialog8 = new AddTricepsLatVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;

            case 10:
                AddDipDialog exampleDialog10 = new AddDipDialog(this);
                exampleDialog10.show(getSupportFragmentManager(), "example dialog");
                break;

        }
    }
}
