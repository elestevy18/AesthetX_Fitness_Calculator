package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.ChestAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.ChestList;
import com.example.scifit.PopUpDialogs.AddChestDeltVolumeDialog;
import com.example.scifit.PopUpDialogs.AddChestPressDialog;
import com.example.scifit.PopUpDialogs.AddChestVolumeDialog;
import com.example.scifit.PopUpDialogs.AddDipDialog;
import com.example.scifit.PopUpDialogs.AddPullOverDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class ChestVolume extends AppCompatActivity implements ChestAdapter.OnItemClickListener, AddChestVolumeDialog.ExampleDialogListener,
AddPullOverDialog.ExampleDialogListener, AddChestDeltVolumeDialog.ExampleDialogListener, AddDipDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_volume);

        //CreateList
        final ArrayList<ChestList> ChestExerciseListList = new ArrayList<>();
        ChestExerciseListList.add(new ChestList ("Bench Press", "3-12 Study Form"));
        ChestExerciseListList.add(new ChestList ("Dumbbell Chest Press", "5-12 Full range of motion"));
        ChestExerciseListList.add(new ChestList ("Machine Chest Press", "5-12 Constant tension"));
        ChestExerciseListList.add(new ChestList ("Neutral Cable Press", "8-12 Strong contraction"));
        ChestExerciseListList.add(new ChestList ("Incline Cable Press", "8-12 Strong contraction"));
        ChestExerciseListList.add(new ChestList ("Decline Cable Press", "8-12 Strong contraction"));
        ChestExerciseListList.add(new ChestList ("Chest Pullover", "8-12 Strong contraction"));
        ChestExerciseListList.add(new ChestList ("Incline Crossover Flyes", "8-12 Strong contraction, paused stretch"));
        ChestExerciseListList.add(new ChestList ("Horizontal Crossover Flyes", "8-12 Strong contraction, paused stretch"));
        ChestExerciseListList.add(new ChestList ("Decline Crossover Flyes", "8-12 Strong contraction, paused stretch"));
        ChestExerciseListList.add(new ChestList ("Wide Dips", "3-12 Weighted/Explosive/Controlled"));
        ChestExerciseListList.add(new ChestList ("Pushups", "8-20 Weighted/Explosive/Controlled"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.chestRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        ChestAdapter mAdapter = new ChestAdapter(ChestExerciseListList, this);

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
                AddDipDialog exampleDialog2 = new AddDipDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddDipDialog exampleDialog3 = new AddDipDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                //Chest Press == Incline press
                AddChestPressDialog exampleDialog4 = new AddChestPressDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddChestVolumeDialog exampleDialog5 = new AddChestVolumeDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddChestVolumeDialog exampleDialog6 = new AddChestVolumeDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddPullOverDialog exampleDialog7 = new AddPullOverDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                AddChestDeltVolumeDialog exampleDialog8 = new AddChestDeltVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;
            case 8:
                AddChestVolumeDialog exampleDialog9 = new AddChestVolumeDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");

                break;

                case 9:

                    AddChestVolumeDialog exampleDialog10 = new AddChestVolumeDialog(this);
                exampleDialog10.show(getSupportFragmentManager(), "example dialog");
                break;
            case 10:
                AddDipDialog exampleDialog11 = new AddDipDialog(this);
                exampleDialog11.show(getSupportFragmentManager(), "example dialog");

                break;
            case 11:
                AddDipDialog exampleDialog12 = new AddDipDialog(this);
                exampleDialog12.show(getSupportFragmentManager(), "example dialog");

                break;

        }
    }
}
