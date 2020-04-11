package com.example.scifit.AddVolume;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.NeckExerciseAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.NeckExerciseList;
import com.example.scifit.PopUpDialogs.AddNeckVolumeDialog;
import com.example.scifit.R;
import java.util.ArrayList;


public class
NeckVolume extends AppCompatActivity implements NeckExerciseAdapter.OnItemClickListener, AddNeckVolumeDialog.ExampleDialogListener{
    private EditText volume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neck_volume);

        //CreateList
        final ArrayList<NeckExerciseList> NeckExercisesListList = new ArrayList<>();
        NeckExercisesListList.add(new NeckExerciseList ("Plate Curl", "10-20 controlled reps"));
        NeckExercisesListList.add(new NeckExerciseList ("Neck Harness Curl", "10-20 controlled reps"));
        NeckExercisesListList.add(new NeckExerciseList ("Plated Neck Extension", "10-20 controlled reps"));
        NeckExercisesListList.add(new NeckExerciseList ("Towel Lateral Flexion", "10-20 controlled reps"));
        NeckExercisesListList.add(new NeckExerciseList ("Harness Lateral Flexion", "10-20 controlled reps"));
        NeckExercisesListList.add(new NeckExerciseList ("Suspended Neck Rotation", "10-20 controlled reps"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.neckExercisesRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        NeckExerciseAdapter mAdapter = new NeckExerciseAdapter(NeckExercisesListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    //Watch out for the typo
    public void onNeckClick(int position) {
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
    public void onAddNeckClick(int position){
        switch(position){
            case 0:
                AddNeckVolumeDialog exampleDialog = new AddNeckVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddNeckVolumeDialog exampleDialog1 = new AddNeckVolumeDialog(this);
                exampleDialog1.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AddNeckVolumeDialog exampleDialog2 = new AddNeckVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddNeckVolumeDialog exampleDialog3 = new AddNeckVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddNeckVolumeDialog exampleDialog4 = new AddNeckVolumeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 5:
                AddNeckVolumeDialog exampleDialog5 = new AddNeckVolumeDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");

                break;
            case 6:
                AddNeckVolumeDialog exampleDialog6 = new AddNeckVolumeDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");

                break;
            case 7:
                AddNeckVolumeDialog exampleDialog7 = new AddNeckVolumeDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");

                break;
            case 8:
                AddNeckVolumeDialog exampleDialog8 = new AddNeckVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;
        }

    }


       @Override
    public void addVolume() {
//SHARED PREFERNCES SET AND STORE MAX AND PROGRESS
    }
}
