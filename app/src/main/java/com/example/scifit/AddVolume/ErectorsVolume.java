package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.ErectorsAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.ErectorsList;
import com.example.scifit.PopUpDialogs.AddDeadliftVolumeDialog;
import com.example.scifit.PopUpDialogs.AddErectorsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddSquatDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class ErectorsVolume extends AppCompatActivity implements ErectorsAdapter.OnItemClickListener, AddErectorsVolumeDialog.ExampleDialogListener,
AddDeadliftVolumeDialog.ExampleDialogListener, AddSquatDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erectors_volume);

        //CreateList
        final ArrayList<ErectorsList> ErectorsExerciseListList = new ArrayList<>();

        ErectorsExerciseListList.add(new ErectorsList ("Hyperextension", "8-12 Controlled reps"));
        ErectorsExerciseListList.add(new ErectorsList ("Machine Erector Extension", "8-12 Controlled reps"));
        //SECONDARY
        ErectorsExerciseListList.add(new ErectorsList ("Deadlifts", "8-12 Strong contraction"));
        ErectorsExerciseListList.add(new ErectorsList ("Squats", "8-12 Controlled reps"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.erectorsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        ErectorsAdapter mAdapter = new ErectorsAdapter(ErectorsExerciseListList, this);

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
                AddErectorsVolumeDialog exampleDialog = new AddErectorsVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddErectorsVolumeDialog exampleDialog2 = new AddErectorsVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddDeadliftVolumeDialog exampleDialog3 = new AddDeadliftVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddSquatDialog exampleDialog4 = new AddSquatDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
        }
    }
}
