package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.TricepAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.TricepList;
import com.example.scifit.PopUpDialogs.AddCaliforniaPressDialog;
import com.example.scifit.PopUpDialogs.AddDipDialog;
import com.example.scifit.PopUpDialogs.AddTricepLatVolumeDialog;
import com.example.scifit.PopUpDialogs.AddTricepVolumeDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class TricepsVolume extends AppCompatActivity implements TricepAdapter.OnItemClickListener, AddTricepVolumeDialog.ExampleDialogListener,
AddTricepLatVolumeDialog.ExampleDialogListener, AddDipDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triceps_volume);

        //CreateList
        final ArrayList<TricepList> TricepExerciseListList = new ArrayList<>();
        //, California Press, Rope Cable Pushdowns, V Bar Pushdown Close Grip dumbbell Press, Close Grip Barbelll Press, Rope Overhead Tricep Extension, Long Head Tricep Push Downs, Pull Over,Kickback
        //PullOvers
        TricepExerciseListList.add(new TricepList ("Narrow Dips", "5-15 Heavy/Controlled/Explosive reps"));
        TricepExerciseListList.add(new TricepList ("Incline SkullCrushers", "8-12 Controlled reps"));
        TricepExerciseListList.add(new TricepList ("California Press", "8-12 Controlled reps, elbows tucked"));
        TricepExerciseListList.add(new TricepList ("Cable Rope Pushdowns", "8-15 Controlled, pause at the bottom"));
        TricepExerciseListList.add(new TricepList ("V Bar Pushdown", "8-15 Controlled, pause at the bottom"));
        TricepExerciseListList.add(new TricepList ("Close Grip Dumbbell Press", "8-12 Constant tension/full extension"));
        TricepExerciseListList.add(new TricepList ("Rope Overhead Tricep Extension", "8-12 Pause on the stretch"));
        TricepExerciseListList.add(new TricepList ("Long Head Tricep Push Downs", "8-12 Strong contraction"));
        TricepExerciseListList.add(new TricepList ("Tricep Kickback", "8-12 Strong contraction"));
        //Front Lever Presses



        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.tricepsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        TricepAdapter mAdapter = new TricepAdapter(TricepExerciseListList, this);

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
                AddDipDialog exampleDialog = new AddDipDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddTricepVolumeDialog exampleDialog2 = new AddTricepVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:

                AddCaliforniaPressDialog exampleDialog3 = new AddCaliforniaPressDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddTricepVolumeDialog exampleDialog4 = new AddTricepVolumeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddTricepVolumeDialog exampleDialog5 = new AddTricepVolumeDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddCaliforniaPressDialog exampleDialog6 = new AddCaliforniaPressDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddTricepVolumeDialog exampleDialog7 = new AddTricepVolumeDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                AddTricepLatVolumeDialog exampleDialog8 = new AddTricepLatVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;
            case 8:
                AddTricepLatVolumeDialog exampleDialog9 = new AddTricepLatVolumeDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");

                break;

        }
    }
}
