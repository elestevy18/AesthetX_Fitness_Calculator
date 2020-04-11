package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.GluteMediusAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.GluteMediusList;
import com.example.scifit.PopUpDialogs.AddGluteMediusVolumeDialog;
import com.example.scifit.PopUpDialogs.AddIsoHipThrustDialog;
import com.example.scifit.PopUpDialogs.AddIsoRDLDialog;
import com.example.scifit.PopUpDialogs.AddPistolSquatDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class GluteMediusVolume extends AppCompatActivity implements GluteMediusAdapter.OnItemClickListener, AddGluteMediusVolumeDialog.ExampleDialogListener,
AddIsoHipThrustDialog.ExampleDialogListener, AddIsoRDLDialog.ExampleDialogListener, AddPistolSquatDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glute_medius_volume);

        //CreateList
        final ArrayList<GluteMediusList> GluteMediusExerciseListList = new ArrayList<>();

        GluteMediusExerciseListList.add(new GluteMediusList ("Machine Abduction", "8-12 Controlled reps"));
        GluteMediusExerciseListList.add(new GluteMediusList ("Cable Abduction", "8-12 Controlled reps"));
        GluteMediusExerciseListList.add(new GluteMediusList ("Banded Lateral Walkout", "8-12 Controlled reps"));
        //SECONDARY
        GluteMediusExerciseListList.add(new GluteMediusList ("Single Leg Dumbell/Plated Hip Thrust", "8-12 Strong contraction"));
        GluteMediusExerciseListList.add(new GluteMediusList ("Single Leg RDL", "8-12 Controlled reps"));
        GluteMediusExerciseListList.add(new GluteMediusList ("Pistol Squat", "8-12 Controlled reps"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.gluteMediusRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        GluteMediusAdapter mAdapter = new GluteMediusAdapter(GluteMediusExerciseListList, this);

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
                AddGluteMediusVolumeDialog exampleDialog = new AddGluteMediusVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddGluteMediusVolumeDialog exampleDialog2 = new AddGluteMediusVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AddGluteMediusVolumeDialog exampleDialog3 = new AddGluteMediusVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
                AddIsoHipThrustDialog exampleDialog4 = new  AddIsoHipThrustDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
            case 4:
                AddIsoRDLDialog exampleDialog5 = new AddIsoRDLDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddPistolSquatDialog exampleDialog6 = new AddPistolSquatDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;


        }
    }
}
