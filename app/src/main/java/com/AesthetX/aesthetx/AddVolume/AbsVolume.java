package com.AesthetX.aesthetx.AddVolume;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.AesthetX.aesthetx.Classes.Adapters.AbsAdapter;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.AbsList;
import com.AesthetX.aesthetx.PopUpDialogs.AbCirclesDialog;
import com.AesthetX.aesthetx.PopUpDialogs.AddAbsVolumeDialog;


public class AbsVolume extends AppCompatActivity implements AbsAdapter.OnItemClickListener, AddAbsVolumeDialog.ExampleDialogListener, AbCirclesDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_volume);

        //CreateList
        final ArrayList<AbsList> AbsExerciseListList = new ArrayList<>();
        //WHOLE ABS

        //ABS
        //WHOLE ABS
        AbsExerciseListList.add(new AbsList("Abs", "One set towards abs, half for Transverse"));
        AbsExerciseListList.add(new AbsList("Leg Raises", "Abs Secondary: Transverse"));
        //LOWER Global
        AbsExerciseListList.add(new AbsList("Ab Circles", "Lower Abs, Obliques Secondary: Transverse"));
        AbsExerciseListList.add(new AbsList("Reverse Crunches", "Lower Abs Secondary: Transverse"));
        AbsExerciseListList.add(new AbsList("Pulse Up", "Lower Abs Secondary: Transverse"));
        //MID ABS
        AbsExerciseListList.add(new AbsList("Cable Crunch", "Middle Abs Secondary; Transverse"));
        AbsExerciseListList.add(new AbsList("Band Crunch", "Middle Abs Secondary; Transverse"));
        AbsExerciseListList.add(new AbsList("V-Up", "Middle Abs Secondary; Transverse"));
        AbsExerciseListList.add(new AbsList("Ab Rollout", "Middle Abs Secondary; Transverse Ab"));



        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.absRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        AbsAdapter mAdapter = new AbsAdapter(AbsExerciseListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void addVolume() {

    }

    private void stringcomparison(Integer position) {
        // GET TEXT FROM RECYCLER VIEW ITEM CLICKED
        RecyclerView recyclerView = findViewById(R.id.absRecyclerView);
        TextView text = Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(position)).itemView.findViewById(R.id.exercise);
        String exercise = text.getText().toString();
        String[] absExercises = {"Abs", "Leg Raises", "Hanging Leg Raise", "Reverse Crunches", "Pulse Up", "Cable Crunch", "V-Up", "Band Crunch", "Ab Rollout"};
        List<String> absList = Arrays.asList(absExercises);
        if (absList.contains(exercise)) {
            AddAbsVolumeDialog exampleDialog = new AddAbsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Ab Circles")) {
            AbCirclesDialog exampleDialog = new AbCirclesDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }
    }

    @Override
    public void onExerciseClick(int position) {
    }

    @Override
    public void onAddVolumeClick(int position) {
        stringcomparison(position);
        /*switch (position) {
            case 0:
                AddAbsVolumeDialog exampleDialog = new AddAbsVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddAbsVolumeDialog exampleDialog2 = new AddAbsVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AbCirclesDialog exampleDialog3 = new AbCirclesDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
                AddAbsVolumeDialog exampleDialog4 = new AddAbsVolumeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
            case 4:
                AddAbsVolumeDialog exampleDialog5 = new AddAbsVolumeDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddAbsVolumeDialog exampleDialog6 = new AddAbsVolumeDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddAbsVolumeDialog exampleDialog7 = new AddAbsVolumeDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                AddAbsVolumeDialog exampleDialog8 = new AddAbsVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");
                break;
            case 8:
                AddAbsVolumeDialog exampleDialog9 = new AddAbsVolumeDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");
                break;*/
        }
    }

