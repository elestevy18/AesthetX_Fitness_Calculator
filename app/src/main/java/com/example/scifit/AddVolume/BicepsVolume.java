package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.BicepsAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.BicepsList;
import com.example.scifit.PopUpDialogs.AddBicepsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddCurlsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddHammerCurlVolumeDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class BicepsVolume extends AppCompatActivity implements BicepsAdapter.OnItemClickListener, AddBicepsVolumeDialog.ExampleDialogListener,
AddCurlsVolumeDialog.ExampleDialogListener,  AddHammerCurlVolumeDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps_volume);

        //CreateList
        final ArrayList<BicepsList> BicepsExerciseListList = new ArrayList<>();
        BicepsExerciseListList.add(new BicepsList ("Dumbbell Curls", "8-15 Controlled reps"));
        BicepsExerciseListList.add(new BicepsList ("Narrow Dumbell Curls", "8-15 Controlled reps"));
        BicepsExerciseListList.add(new BicepsList ("Barbell Curls", "8-15 Controlled reps"));
        BicepsExerciseListList.add(new BicepsList ("Narrow Barbell Curls", "8-15 Controlled reps"));
        BicepsExerciseListList.add(new BicepsList ("Narrow EZ Bar Curls", "8-15 Controlled reps"));
        BicepsExerciseListList.add(new BicepsList ("Wide EZ Bar Curls", "8-15 Controlled reps"));
        BicepsExerciseListList.add(new BicepsList ("Preacher Curls", "8-15 Strong Contraction"));
        BicepsExerciseListList.add(new BicepsList ("Limp Wrist Curls", "8-15 Mind muscle connection"));
        BicepsExerciseListList.add(new BicepsList ("Bicep Isometric", "30 - 60 seconds, near failure"));
        BicepsExerciseListList.add(new BicepsList ("Cross Body Hammer Curls", "8-15 Controlled reps"));
        BicepsExerciseListList.add(new BicepsList ("Cable/Dumbbell Spider Curls", "8-15 Pause at the stretch"));
        BicepsExerciseListList.add(new BicepsList ("Banded Curls", "8-15 Strong contraction"));


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
                AddCurlsVolumeDialog exampleDialog = new AddCurlsVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddCurlsVolumeDialog exampleDialog2 = new AddCurlsVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddCurlsVolumeDialog exampleDialog3 = new AddCurlsVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddCurlsVolumeDialog exampleDialog4 = new AddCurlsVolumeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddCurlsVolumeDialog exampleDialog5 = new AddCurlsVolumeDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddCurlsVolumeDialog exampleDialog6 = new AddCurlsVolumeDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddCurlsVolumeDialog exampleDialog7 = new AddCurlsVolumeDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                AddBicepsVolumeDialog exampleDialog8 = new AddBicepsVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;
            case 8:
                AddBicepsVolumeDialog exampleDialog9 = new AddBicepsVolumeDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");

                break;
                case 9:
                AddHammerCurlVolumeDialog exampleDialog10 = new  AddHammerCurlVolumeDialog(this);
                exampleDialog10.show(getSupportFragmentManager(), "example dialog");
                break;
            case 10:
                AddCurlsVolumeDialog exampleDialog11 = new AddCurlsVolumeDialog(this);
                exampleDialog11.show(getSupportFragmentManager(), "example dialog");

                break;
            case 11:
                AddCurlsVolumeDialog exampleDialog12 = new AddCurlsVolumeDialog(this);
                exampleDialog12.show(getSupportFragmentManager(), "example dialog");

                break;

        }
    }
}
