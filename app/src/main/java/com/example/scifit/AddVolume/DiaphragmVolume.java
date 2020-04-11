package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.DiaphragmAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.DiaphragmList;
import com.example.scifit.PopUpDialogs.AddDiaphragmVolumeDialog;
import com.example.scifit.PopUpDialogs.ObliqueDiaphragmFullDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class DiaphragmVolume extends AppCompatActivity implements DiaphragmAdapter.OnItemClickListener, AddDiaphragmVolumeDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaphragm_volume);

        //CreateList
        final ArrayList<DiaphragmList> DiaphragmExerciseListList = new ArrayList<>();
        DiaphragmExerciseListList.add(new DiaphragmList ("Vacuums", "Squeeze until failure"));
        DiaphragmExerciseListList.add(new DiaphragmList ("Banded/Cable/ Resisted rotation", "To failure"));
        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.diaphragmRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        DiaphragmAdapter mAdapter = new DiaphragmAdapter(DiaphragmExerciseListList, this);

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
                AddDiaphragmVolumeDialog exampleDialog = new AddDiaphragmVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                ObliqueDiaphragmFullDialog exampleDialog2 = new ObliqueDiaphragmFullDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}
