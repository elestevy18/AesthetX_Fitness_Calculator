package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.HamstringsAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.HamstringsList;
import com.example.scifit.PopUpDialogs.AddDeadliftVolumeDialog;
import com.example.scifit.PopUpDialogs.AddHamGluteDialog;
import com.example.scifit.PopUpDialogs.AddHamstringsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddIsoRDLDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class HamstringsVolume extends AppCompatActivity implements HamstringsAdapter.OnItemClickListener, AddHamstringsVolumeDialog.ExampleDialogListener,
AddHamGluteDialog.ExampleDialogListener, AddIsoRDLDialog.ExampleDialogListener, AddDeadliftVolumeDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamstrings_volume);

        //CreateList
        final ArrayList<HamstringsList> HamstringsExerciseListList = new ArrayList<>();

        HamstringsExerciseListList.add(new HamstringsList ("Deadlift", "3-10 reps"));
        HamstringsExerciseListList.add(new HamstringsList ("Hamstring Hyperextension", "8-12 reps"));
        HamstringsExerciseListList.add(new HamstringsList ("Romanian Deadlift", "6-12 reps"));
        HamstringsExerciseListList.add(new HamstringsList ("Single Leg Romanian Deadlift", "8-12 reps"));
        HamstringsExerciseListList.add(new HamstringsList ("Medicine Ball Curl", "10-15 reps"));
        HamstringsExerciseListList.add(new HamstringsList ("Single Leg Medicine Ball Curl", "8-12 reps"));
        HamstringsExerciseListList.add(new HamstringsList ("Deficit Deadlift", "6-12 reps"));
        HamstringsExerciseListList.add(new HamstringsList ("Glute Ham Raise", "6-12 reps"));



        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.hamstringsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        HamstringsAdapter mAdapter = new HamstringsAdapter(HamstringsExerciseListList, this);

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
               AddDeadliftVolumeDialog  exampleDialog = new  AddDeadliftVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddHamGluteDialog exampleDialog2 = new AddHamGluteDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddHamGluteDialog exampleDialog3 = new AddHamGluteDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddIsoRDLDialog exampleDialog4 = new AddIsoRDLDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddHamGluteDialog exampleDialog5 = new AddHamGluteDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddIsoRDLDialog exampleDialog6 = new AddIsoRDLDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddHamGluteDialog exampleDialog7 = new AddHamGluteDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                AddHamGluteDialog exampleDialog8 = new AddHamGluteDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;
            case 8:
                AddHamstringsVolumeDialog exampleDialog9 = new AddHamstringsVolumeDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");

                break;

        }
    }
}
