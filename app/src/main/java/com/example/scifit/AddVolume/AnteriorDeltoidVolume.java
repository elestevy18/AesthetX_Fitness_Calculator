package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.AnteriorDeltoidAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.AnteriorDeltoidList;
import com.example.scifit.PopUpDialogs.AddAnteriorDeltoidVolumeDialog;
import com.example.scifit.PopUpDialogs.OHPDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class AnteriorDeltoidVolume extends AppCompatActivity implements AnteriorDeltoidAdapter.OnItemClickListener, AddAnteriorDeltoidVolumeDialog.ExampleDialogListener,
OHPDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anterior_deltoid_volume);

        //CreateList
        final ArrayList<AnteriorDeltoidList> AnteriorDeltoidExerciseListList = new ArrayList<>();
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList ("Barbell Overhead Press", "3-10 Heavy/ Controlled reps"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList ("Dumbbell OHP", "8-12 Controlled reps"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList ("Arnolds", "8-12 Controlled reps"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList ("Cable Front Raise", "Pause at the bottom"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList ("Cable Stretch to OHP", "10-15 Full range of motion, controlled."));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList ("Landmine Press", "8-12 Explosive."));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList ("Machine Shoulder Press", "8-12 Constant Tension"));
        AnteriorDeltoidExerciseListList.add(new AnteriorDeltoidList ("Push Press", "8-12 Strict -> cheat reps"));



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
                OHPDialog exampleDialog = new OHPDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                OHPDialog exampleDialog2 = new OHPDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                OHPDialog exampleDialog3 = new OHPDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddAnteriorDeltoidVolumeDialog exampleDialog4 = new AddAnteriorDeltoidVolumeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                OHPDialog exampleDialog5 = new OHPDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                OHPDialog exampleDialog6 = new OHPDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                OHPDialog exampleDialog7 = new OHPDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                OHPDialog exampleDialog8 = new OHPDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;
            case 8:
                OHPDialog exampleDialog9 = new OHPDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");

                break;

        }
    }
}
