package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.ObliquesAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.ObliquesList;
import com.example.scifit.PopUpDialogs.AddObliquesVolumeDialog;
import com.example.scifit.PopUpDialogs.ObliqueAbDiaphragmDialog;
import com.example.scifit.PopUpDialogs.ObliqueAbDiaphragmFullDialog;
import com.example.scifit.PopUpDialogs.ObliqueDiaphragmDialog;
import com.example.scifit.PopUpDialogs.ObliqueDiaphragmFullDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class ObliquesVolume extends AppCompatActivity implements ObliquesAdapter.OnItemClickListener, AddObliquesVolumeDialog.ExampleDialogListener,
ObliqueAbDiaphragmDialog.ExampleDialogListener, ObliqueAbDiaphragmFullDialog.ExampleDialogListener, ObliqueDiaphragmDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obliques_volume);

        //CreateList
        final ArrayList<ObliquesList> ObliquesExerciseListList = new ArrayList<>();
        ObliquesExerciseListList.add(new ObliquesList ("Twisting Leg Raise", "5-10 Controlled reps"));
        ObliquesExerciseListList.add(new ObliquesList ("Neutral Wood Choppers", "8-12 Controlled reps"));
        ObliquesExerciseListList.add(new ObliquesList ("Low to High Wood Choppers", "8-12 Controlled reps"));
        ObliquesExerciseListList.add(new ObliquesList ("High to Low Wood Choppers", "8-12 Controlled reps"));
        ObliquesExerciseListList.add(new ObliquesList ("Elbow to Knee Tucks", "8-12 Strong contraction, controlled"));
        ObliquesExerciseListList.add(new ObliquesList ("Banded/Cable Step Out", "30-60 seconds"));
        ObliquesExerciseListList.add(new ObliquesList ("Twisted Pulse Up", "8-12 Controlled reps, strong contraction"));
        ObliquesExerciseListList.add(new ObliquesList ("Rotating Plank", "30-60 seconds Controlled reps"));
        ObliquesExerciseListList.add(new ObliquesList ("Elbow to Knee Plank", "30-60 seconds"));
        ObliquesExerciseListList.add(new ObliquesList ("Leg Raise Scissors", "5-12 Controlled reps"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.obliquesRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        ObliquesAdapter mAdapter = new ObliquesAdapter(ObliquesExerciseListList, this);

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
                ObliqueAbDiaphragmDialog exampleDialog = new ObliqueAbDiaphragmDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                ObliqueDiaphragmDialog exampleDialog2 = new ObliqueDiaphragmDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                ObliqueDiaphragmDialog exampleDialog3 = new ObliqueDiaphragmDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
                ObliqueDiaphragmDialog exampleDialog4 = new ObliqueDiaphragmDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
            case 4:
                ObliqueAbDiaphragmDialog exampleDialog5 = new ObliqueAbDiaphragmDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                ObliqueAbDiaphragmDialog exampleDialog6 = new ObliqueAbDiaphragmDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                ObliqueAbDiaphragmDialog exampleDialog7 = new  ObliqueAbDiaphragmDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                ObliqueAbDiaphragmDialog exampleDialog8 = new  ObliqueAbDiaphragmDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");
                break;
            case 8:
                AddObliquesVolumeDialog exampleDialog9 = new AddObliquesVolumeDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");
                break;
                case 9:
                    ObliqueAbDiaphragmFullDialog exampleDialog10 = new ObliqueAbDiaphragmFullDialog(this);
                exampleDialog10.show(getSupportFragmentManager(), "example dialog");
                break;

        }
    }
}
