package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.CalvesAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.CalvesList;
import com.example.scifit.PopUpDialogs.AddCalvesVolumeDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class CalvesVolume extends AppCompatActivity implements CalvesAdapter.OnItemClickListener, AddCalvesVolumeDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calves_volume);

        //CreateList
        final ArrayList<CalvesList> CalvesExerciseListList = new ArrayList<>();

        CalvesExerciseListList.add(new CalvesList ("Machine Standing Calf Raise", "8-20 Paused stretch"));
        CalvesExerciseListList.add(new CalvesList ("Straight Leg Machine Calf Raise", "8-20 Paused stretch"));
        CalvesExerciseListList.add(new CalvesList ("Seated Cal Raise", "8-20 Paused stretch"));
        CalvesExerciseListList.add(new CalvesList ("Donkey Calf Raise", "8-20 Paused stretch"));
        CalvesExerciseListList.add(new CalvesList ("Dumbbell/Plated Calf Raise", "8-20 Paused stretch"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.calvesRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        CalvesAdapter mAdapter = new CalvesAdapter(CalvesExerciseListList, this);

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
                AddCalvesVolumeDialog exampleDialog = new AddCalvesVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddCalvesVolumeDialog exampleDialog2 = new AddCalvesVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AddCalvesVolumeDialog exampleDialog3 = new AddCalvesVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddCalvesVolumeDialog exampleDialog4 = new AddCalvesVolumeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
            case 4:
                AddCalvesVolumeDialog exampleDialog5 = new AddCalvesVolumeDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}
