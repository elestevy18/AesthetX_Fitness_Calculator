package Aesthet.X.adfree.AddVolume;

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

import Aesthet.X.adfree.Classes.Adapters.QuadsAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.QuadsList;
import Aesthet.X.adfree.PopUpDialogs.AddPistolSquatDialog;
import Aesthet.X.adfree.PopUpDialogs.AddQuadsGluteMediusDialog;
import Aesthet.X.adfree.PopUpDialogs.AddQuadsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddSquatDialog;
import Aesthet.X.adfree.PopUpDialogs.QuadGluteMediusFullDialog;
import Aesthet.X.adfree.PopUpDialogs.QuadsGluteGluteMediusDialog;
import Aesthet.X.adfree.PopUpDialogs.QuadsHalfGlute;
import Aesthet.X.adfree.PopUpDialogs.SideLungeDialog;
import Aesthet.X.adfree.PopUpDialogs.SprinterLungeDialog;


public class QuadsVolume extends AppCompatActivity implements QuadsAdapter.OnItemClickListener, AddQuadsVolumeDialog.ExampleDialogListener,
        AddSquatDialog.ExampleDialogListener, QuadGluteMediusFullDialog.ExampleDialogListener, QuadsGluteGluteMediusDialog.ExampleDialogListener,
        SprinterLungeDialog.ExampleDialogListener, SideLungeDialog.ExampleDialogListener, AddPistolSquatDialog.ExampleDialogListener, AddQuadsGluteMediusDialog.ExampleDialogListener, QuadsHalfGlute.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quads_volume);

        //CreateList
        final ArrayList<QuadsList> QuadsExerciseListList = new ArrayList<>();
        QuadsExerciseListList.add(new QuadsList("Quads", "One set towards quads"));
        QuadsExerciseListList.add(new QuadsList("Squats", "Quads, Erectors Secondary: Glutes, Transverse"));
        QuadsExerciseListList.add(new QuadsList("Cable Walkaways", "Quads"));
        QuadsExerciseListList.add(new QuadsList("Banded Leg Press", "Quads, Glute Medius"));
        QuadsExerciseListList.add(new QuadsList("Leg Press", "Quads"));

        QuadsExerciseListList.add(new QuadsList("Explosive Bulgarian Split Squat", "Quads Secondary: Glute Medius"));
        QuadsExerciseListList.add(new QuadsList("Traditional Lunge", "Quads Secondary: Glute Medius"));
        QuadsExerciseListList.add(new QuadsList("Bulgarian Split Squat", "Quads Secondary: Glute Medius"));
        QuadsExerciseListList.add(new QuadsList("Pistol Squats", "Quads, Glute Medius Secondary: Glute"));
        QuadsExerciseListList.add(new QuadsList("Side Lunge", "Quads, Glute Medius"));
        QuadsExerciseListList.add(new QuadsList("Banded Lunge", "Quads"));
        QuadsExerciseListList.add(new QuadsList("Bodyweight Squats", "Quads Secondary: Glutes"));
        QuadsExerciseListList.add(new QuadsList("Wall Sit", "Quads "));
        QuadsExerciseListList.add(new QuadsList("Lunges", "Quads Secondary: Glute Medius, Glutes"));




        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.quadsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        QuadsAdapter mAdapter = new QuadsAdapter(QuadsExerciseListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void addVolume() {

    }


    private void stringcomparison(Integer position) {
        // GET TEXT FROM RECYCLER VIEW ITEM CLICKED
        RecyclerView recyclerView = findViewById(R.id.quadsRecyclerView);
        TextView text = Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(position)).itemView.findViewById(R.id.exercise);
        String exercise = text.getText().toString();
        String[] quadsGluteMediusExercises = {"Bulgarian Split Squat", "Explosive Bulgarian Split Squat"};
        List<String> quadsGluteMediusList = Arrays.asList(quadsGluteMediusExercises);
        String[] quadsExercises = {"Leg Press", "Cable Walkaways", "Banded Lunge", "Quads", "Wall Sit"};
        List<String> quadsList = Arrays.asList(quadsExercises);
        if (quadsGluteMediusList.contains(exercise)) {
            AddQuadsGluteMediusDialog exampleDialog = new AddQuadsGluteMediusDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (quadsList.contains(exercise)) {
            AddQuadsVolumeDialog exampleDialog = new AddQuadsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Bodyweight Squats")) {
            QuadsHalfGlute exampleDialog = new QuadsHalfGlute(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Squats")) {
            AddSquatDialog exampleDialog = new AddSquatDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Pistol Squats")) {
            AddPistolSquatDialog exampleDialog = new AddPistolSquatDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Side Lunge") || exercise.equals("Banded Leg Press")) {
            SideLungeDialog exampleDialog = new SideLungeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Lunges")) {
            QuadsGluteGluteMediusDialog exampleDialog = new QuadsGluteGluteMediusDialog(this);
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
                AddSquatDialog exampleDialog = new AddSquatDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddQuadsVolumeDialog exampleDialog2 = new AddQuadsVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                QuadGluteMediusFullDialog exampleDialog3 = new QuadGluteMediusFullDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
                QuadsGluteGluteMediusDialog exampleDialog4 = new QuadsGluteGluteMediusDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
            case 4:
                SprinterLungeDialog exampleDialog5 = new SprinterLungeDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                SideLungeDialog exampleDialog6 = new SideLungeDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                QuadsGluteGluteMediusDialog exampleDialog7 = new QuadsGluteGluteMediusDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                QuadsGluteGluteMediusDialog exampleDialog8 = new QuadsGluteGluteMediusDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");
                break;
            case 8:
                QuadsGluteGluteMediusDialog exampleDialog9 = new QuadsGluteGluteMediusDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");
                break;
            case 9:
                AddQuadsVolumeDialog exampleDialog10 = new AddQuadsVolumeDialog(this);
                exampleDialog10.show(getSupportFragmentManager(), "example dialog");
                break;
            case 10:
                AddPistolSquatDialog exampleDialog12 = new AddPistolSquatDialog(this);
                exampleDialog12.show(getSupportFragmentManager(), "example dialog");
                break;*/
        }
    }

