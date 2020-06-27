package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.ObliquesAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.ObliquesList;
import Aesthet.X.adfree.PopUpDialogs.AddObliquesVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.ObliqueAbDiaphragmDialog;
import Aesthet.X.adfree.PopUpDialogs.ObliqueAbDiaphragmFullDialog;
import Aesthet.X.adfree.PopUpDialogs.ObliqueDiaphragmDialog;


public class ObliquesVolume extends AppCompatActivity implements ObliquesAdapter.OnItemClickListener, AddObliquesVolumeDialog.ExampleDialogListener,
        ObliqueAbDiaphragmDialog.ExampleDialogListener, ObliqueAbDiaphragmFullDialog.ExampleDialogListener, ObliqueDiaphragmDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obliques_volume);

        //CreateList
        final ArrayList<ObliquesList> ObliquesExerciseListList = new ArrayList<>();


        ObliquesExerciseListList.add(new ObliquesList("Obliques", "One set towards obliques"));
        ObliquesExerciseListList.add(new ObliquesList("Neutral Wood Choppers", "Mid Obliques Secondary: Transverse Ab"));
        ObliquesExerciseListList.add(new ObliquesList("Low to High Wood Choppers", "Upper and Lower Obliques Secondary: Transverse Ab"));
        ObliquesExerciseListList.add(new ObliquesList("High to Low Wood Choppers", "Upper and Lower Obliques Secondary: Transverse Ab"));
        ObliquesExerciseListList.add(new ObliquesList("Twisting Leg Raise", "Obliques Secondary: TransverseAb, Lower Abs"));


        ObliquesExerciseListList.add(new ObliquesList("Leg Raise Scissors", "Obliques, Abs Secondary: Transverse Ab"));


        ObliquesExerciseListList.add(new ObliquesList("Elbow to Knee Tucks", "Obliques Secondary: Transverse Ab, Middle Abs"));
        ObliquesExerciseListList.add(new ObliquesList("Banded/Cable Step Out", "Obliques Secondary: Transverse Ab"));
        ObliquesExerciseListList.add(new ObliquesList("Rotating Plank", "Obliques Secondary: Abs, Transverse Ab"));
        ObliquesExerciseListList.add(new ObliquesList("Elbow to Knee Plank", "Obliques Secondary: Abs, Transverse Ab"));
        ObliquesExerciseListList.add(new ObliquesList("Twisting Pulse Up", "Obliques Secondary: Abs, Transverse Ab"));
        ObliquesExerciseListList.add(new ObliquesList("X-Crunch", "Obliques Secondary: Abs, Transverse Ab"));


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
    }

    @Override
    public void onAddVolumeClick(int position) {
        switch (position) {
            case 0:
                AddObliquesVolumeDialog exampleDialog = new AddObliquesVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;

            case 2:
            case 1:
            case 3:
            case 7:
                ObliqueDiaphragmDialog exampleDialog1 = new ObliqueDiaphragmDialog(this);
                exampleDialog1.show(getSupportFragmentManager(), "example dialog");
                break;
            case 4:
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
                ObliqueAbDiaphragmDialog exampleDialog2 = new ObliqueAbDiaphragmDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                ObliqueAbDiaphragmFullDialog exampleDialog4 = new ObliqueAbDiaphragmFullDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;


        }
    }
}
