package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.ErectorsAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.ErectorsList;
import Aesthet.X.adfree.PopUpDialogs.AddAngelOfDeathDialog;
import Aesthet.X.adfree.PopUpDialogs.AddDeadliftVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddErectorHalfHamDialog;
import Aesthet.X.adfree.PopUpDialogs.AddErectorsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddGluteErectorDialog;
import Aesthet.X.adfree.PopUpDialogs.AddSquatDialog;
import Aesthet.X.adfree.PopUpDialogs.ErectorGluteMedius;


public class ErectorsVolume extends AppCompatActivity implements ErectorsAdapter.OnItemClickListener, AddErectorsVolumeDialog.ExampleDialogListener,
        AddDeadliftVolumeDialog.ExampleDialogListener, AddSquatDialog.ExampleDialogListener, AddAngelOfDeathDialog.ExampleDialogListener, ErectorGluteMedius.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erectors_volume);

        //CreateList
        final ArrayList<ErectorsList> ErectorsExerciseListList = new ArrayList<>();

        ErectorsExerciseListList.add(new ErectorsList("Erectors", "One set towards erectors"));
        ErectorsExerciseListList.add(new ErectorsList("Hyperextension", "Spinal Erector"));
        ErectorsExerciseListList.add(new ErectorsList("Machine Erector Extension", "Spinal Erector"));

        ErectorsExerciseListList.add(new ErectorsList("Deadlift", "Spinal Erector Secondary: Glutes, Hamstrings"));
        ErectorsExerciseListList.add(new ErectorsList("Squats", "Quads Spinal Erector Secondary: Glutes, Hamstrings"));

        ErectorsExerciseListList.add(new ErectorsList("Frog Pumps", "Spinal Erectors, Glute Medius"));
        ErectorsExerciseListList.add(new ErectorsList("Angels of Death", "Spinal Erectors, Lower Traps, Post Delt"));
        ErectorsExerciseListList.add(new ErectorsList("Marching Bridge", "Spinal Erector, Glutes"));


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
    }

    @Override
    public void onAddVolumeClick(int position) {
        switch (position) {
            case 0:
            case 1:
            case 2:
                AddErectorsVolumeDialog exampleDialog = new AddErectorsVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
                AddDeadliftVolumeDialog exampleDialog7 = new AddDeadliftVolumeDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;

            case 4:
                AddSquatDialog exampleDialog8 = new AddSquatDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                ErectorGluteMedius exampleDialog3 = new ErectorGluteMedius(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddAngelOfDeathDialog exampleDialog4 = new AddAngelOfDeathDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                AddGluteErectorDialog exampleDialog5 = new AddGluteErectorDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 8:
                AddErectorHalfHamDialog exampleDialog6 = new AddErectorHalfHamDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;

        }
    }
}
