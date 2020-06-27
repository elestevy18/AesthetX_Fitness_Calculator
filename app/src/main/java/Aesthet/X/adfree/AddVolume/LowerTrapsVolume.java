package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.LowerTrapAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.LowerTrapExerciseList;
import Aesthet.X.adfree.PopUpDialogs.AddAngelOfDeathDialog;
import Aesthet.X.adfree.PopUpDialogs.AddFacePullDialog;
import Aesthet.X.adfree.PopUpDialogs.AddLowerTrapPostDeltDialog;
import Aesthet.X.adfree.PopUpDialogs.AddLowerTrapVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.UpperLowerTrap;


public class LowerTrapsVolume extends AppCompatActivity implements LowerTrapAdapter.OnItemClickListener,
        AddLowerTrapVolumeDialog.ExampleDialogListener, AddAngelOfDeathDialog.ExampleDialogListener, AddFacePullDialog.ExampleDialogListener,
        UpperLowerTrap.ExampleDialogListener, AddLowerTrapPostDeltDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_traps_volume);

        //CreateList
        final ArrayList<LowerTrapExerciseList> LowerTrapExerciseListList = new ArrayList<>();
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Lower Trap", "One set towards lower traps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Y Raise", "Lower Traps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Reverse Pec Dec", "Lower Traps, Post Delt"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Angels of Death", "Spinal Erectors, Lower Traps, Post Delt"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Floor/Dip Bar Scapular Depression", "Lower Traps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("W's", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Facepulls", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Ring Facepulls", "Rotator Cuff, Lower Trap, Posterior Deltoid"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Hanging/Cable Scapular Retraction", "Lower Traps"));
        LowerTrapExerciseListList.add(new LowerTrapExerciseList("Inverted Y", "Upper and Lower Trapezoid"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.lowerTrapsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        LowerTrapAdapter mAdapter = new LowerTrapAdapter(LowerTrapExerciseListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    //Watch out for the typo
    public void onExerciseClick(int position) {
        switch (position) {
        }
    }

    public void onAddVolumeClick(int position) {
        switch (position) {
            case 0:
            case 1:
            case 4:
            case 8:
                AddLowerTrapVolumeDialog exampleDialog = new AddLowerTrapVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                AddLowerTrapPostDeltDialog exampleDialog4 = new AddLowerTrapPostDeltDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
            case 3:
                AddAngelOfDeathDialog exampleDialog6 = new AddAngelOfDeathDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;

            case 6:
            case 7:
            case 5:
                AddFacePullDialog exampleDialog3 = new AddFacePullDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
            case 9:
                UpperLowerTrap exampleDialog1 = new UpperLowerTrap(this);
                exampleDialog1.show(getSupportFragmentManager(), "example dialog");
                break;

        }

    }

    @Override
    public void addVolume() {

    }
}
