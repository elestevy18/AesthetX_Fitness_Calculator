package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.AbsAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.AbsList;
import com.example.scifit.PopUpDialogs.AbCirclesDialog;
import com.example.scifit.PopUpDialogs.AddAbsVolumeDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class AbsVolume extends AppCompatActivity implements AbsAdapter.OnItemClickListener, AddAbsVolumeDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_volume);

        //CreateList
        final ArrayList<AbsList> AbsExerciseListList = new ArrayList<>();
        //WHOLE ABS
        AbsExerciseListList.add(new AbsList ("Hanging Leg Raise", "5-15 Controlled reps, strong contraction"));
        //LOWER ABS
        AbsExerciseListList.add(new AbsList ("Captain Chair/ Hanging Leg Raises", "5-15 Controlled reps, strong contraction"));
        AbsExerciseListList.add(new AbsList ("Ab Circles", "8-12 Controlled reps, strong contraction"));
        AbsExerciseListList.add(new AbsList ("Reverse Crunches", "8-12 Strong contraction"));
        AbsExerciseListList.add(new AbsList ("Pulse Up", "8-12 Controlled reps, strong contraction"));
        //MID ABS
        AbsExerciseListList.add(new AbsList ("Cable Crunch", "8-12 Controlled reps, strong contraction"));
        AbsExerciseListList.add(new AbsList ("Protracted Cable Crunch", "8-12 Controlled reps, strong contraction"));
        AbsExerciseListList.add(new AbsList ("V-Up", "8-12 Controlled reps, strong contraction"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.absRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        AbsAdapter mAdapter = new AbsAdapter(AbsExerciseListList, this);

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
                AddAbsVolumeDialog exampleDialog = new AddAbsVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddAbsVolumeDialog exampleDialog2 = new AddAbsVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AbCirclesDialog exampleDialog3 = new AbCirclesDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
                AddAbsVolumeDialog exampleDialog4 = new AddAbsVolumeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
            case 4:
                AddAbsVolumeDialog exampleDialog5 = new AddAbsVolumeDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddAbsVolumeDialog exampleDialog6 = new AddAbsVolumeDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddAbsVolumeDialog exampleDialog7 = new AddAbsVolumeDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                AddAbsVolumeDialog exampleDialog8 = new AddAbsVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");
                break;
            case 8:
                AddAbsVolumeDialog exampleDialog9 = new AddAbsVolumeDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}
