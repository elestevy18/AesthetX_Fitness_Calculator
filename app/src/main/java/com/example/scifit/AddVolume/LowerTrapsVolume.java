package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.LowerTrapAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.LowerTrapExerciseList;
import com.example.scifit.PopUpDialogs.AddAngelOfDeathDialog;
import com.example.scifit.PopUpDialogs.AddFacePullDialog;
import com.example.scifit.PopUpDialogs.AddLowerTrapPostDeltDialog;
import com.example.scifit.PopUpDialogs.AddLowerTrapVolumeDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class LowerTrapsVolume extends AppCompatActivity implements LowerTrapAdapter.OnItemClickListener,
        AddLowerTrapVolumeDialog.ExampleDialogListener, AddAngelOfDeathDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_traps_volume);

        //CreateList
        final ArrayList<LowerTrapExerciseList> LowerTrapExerciseListList = new ArrayList<>();
        LowerTrapExerciseListList.add(new LowerTrapExerciseList ("Y raise", "10-15 controlled reps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList ("Hanging/Cable Scapular Retraction", "8-12 Strong Contraction"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList ("Dumbbell Posterior Delt Fly", "10-20 Controlled reps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList ("Reverse Pec Dec", "10-20 Controlled reps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList ("Facepulls", "12-15 Strong contraction"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList ("Angels of Death", "10-12 Slow and controlled reps"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.lowerTrapsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        LowerTrapAdapter mAdapter = new LowerTrapAdapter(LowerTrapExerciseListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    //Watch out for the typo
    public void onExerciseClick(int position) {
        switch(position){
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
    }
    public void onAddVolumeClick(int position){
        switch(position){
            case 0:
                AddLowerTrapPostDeltDialog exampleDialog = new AddLowerTrapPostDeltDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddLowerTrapVolumeDialog exampleDialog2 = new AddLowerTrapVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddLowerTrapPostDeltDialog exampleDialog3 = new AddLowerTrapPostDeltDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddLowerTrapPostDeltDialog exampleDialog4 = new AddLowerTrapPostDeltDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddFacePullDialog exampleDialog5 = new AddFacePullDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddAngelOfDeathDialog exampleDialog6 = new AddAngelOfDeathDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;

        }

    }

    @Override
    public void addVolume() {

    }
}
