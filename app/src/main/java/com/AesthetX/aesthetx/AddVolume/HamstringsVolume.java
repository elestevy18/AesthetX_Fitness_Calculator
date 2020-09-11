package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.Adapters.HamstringsAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.HamstringsList;
import com.AesthetX.aesthetx.PopUpDialogs.AddDeadliftVolumeDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddHamGluteDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddHamstringsVolumeDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddIsoRDLDialog;


public class

HamstringsVolume extends AppCompatActivity implements HamstringsAdapter.OnItemClickListener, AddHamstringsVolumeDialog.ExampleDialogListener,
        AddHamGluteDialog.ExampleDialogListener, AddIsoRDLDialog.ExampleDialogListener, AddDeadliftVolumeDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamstrings_volume);

        //CreateListg
        final ArrayList<HamstringsList> HamstringsExerciseListList = new ArrayList<>();

        HamstringsExerciseListList.add(new HamstringsList("Hamstrings", "One set towards hamstrings"));
        HamstringsExerciseListList.add(new HamstringsList("Deadlift", "Hamstrings, Erectors, Upper Traps \nSecondary: Lats, Glutes, Lower Trap, Transverse"));


        HamstringsExerciseListList.add(new HamstringsList("Romanian Deadlift", "Hamstring Secondary: Glutes, Erectors"));
        HamstringsExerciseListList.add(new HamstringsList("Deficit Deadlift", "Hamstring Secondary: Glutes, Erectors"));
        HamstringsExerciseListList.add(new HamstringsList("Hamstring Hyperextension", "Hamstring Secondary: Glutes, Erectors"));
        HamstringsExerciseListList.add(new HamstringsList("Glute Ham Raise", "Hamstring Secondary: Glutes, Erectors"));
        HamstringsExerciseListList.add(new HamstringsList("Physioball Hamstring Curls", "Hamstring Secondary: Glutes, Erectors"));

        HamstringsExerciseListList.add(new HamstringsList("Isolateral Hamstring Curls", "Hamstrings, Glute Medius\nSecondary: Glutes, Erectors"));
        HamstringsExerciseListList.add(new HamstringsList("Single Leg Romanian Deadlift", "Hamstrings, Glute Medius\nSecondary: Glutes, Erectors"));
        
        

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
    }

    @Override
    public void onAddVolumeClick(int position) {
        switch (position) {
            case 0:

                AddHamstringsVolumeDialog exampleDialog = new AddHamstringsVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddDeadliftVolumeDialog exampleDialog1 = new AddDeadliftVolumeDialog(this);
                exampleDialog1.show(getSupportFragmentManager(), "example dialog");
                break;

            case 2:
            case 3:
            case 4:
            case 5:
            case 6:

                AddHamGluteDialog exampleDialog2 = new AddHamGluteDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
            case 8:
                AddIsoRDLDialog exampleDialog8 = new AddIsoRDLDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");
                break;

        }
    }
}
