package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.GluteMediusAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.GluteMediusList;
import Aesthet.X.adfree.PopUpDialogs.AddGluteMediusVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddIsoHipThrustDialog;
import Aesthet.X.adfree.PopUpDialogs.AddIsoRDLDialog;
import Aesthet.X.adfree.PopUpDialogs.AddPistolSquatDialog;
import Aesthet.X.adfree.PopUpDialogs.ErectorGluteMedius;
import Aesthet.X.adfree.PopUpDialogs.GluteMediusHalfObliques;


public class GluteMediusVolume extends AppCompatActivity implements GluteMediusAdapter.OnItemClickListener, AddGluteMediusVolumeDialog.ExampleDialogListener,
        AddIsoHipThrustDialog.ExampleDialogListener, AddIsoRDLDialog.ExampleDialogListener, AddPistolSquatDialog.ExampleDialogListener, GluteMediusHalfObliques.ExampleDialogListener, ErectorGluteMedius.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glute_medius_volume);

        //CreateList
        final ArrayList<GluteMediusList> GluteMediusExerciseListList = new ArrayList<>();


        GluteMediusExerciseListList.add(new GluteMediusList("Glute Medius", "One set towards glute medius"));
        GluteMediusExerciseListList.add(new GluteMediusList("Machine Abduction", "Glute Medius"));
        GluteMediusExerciseListList.add(new GluteMediusList("Banded Lateral Walkout", "Glute Medius"));
        GluteMediusExerciseListList.add(new GluteMediusList("Banded Abduction", "Glute Medius"));
        GluteMediusExerciseListList.add(new GluteMediusList("Glute Side Plank", "Glute Medius Secondary: Obliques"));
        GluteMediusExerciseListList.add(new GluteMediusList("Frog Pumps", "Spinal Erectors, Glute Medius"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.gluteMediusRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        GluteMediusAdapter mAdapter = new GluteMediusAdapter(GluteMediusExerciseListList, this);

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
            case 3:
                AddGluteMediusVolumeDialog exampleDialog = new AddGluteMediusVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 4:
                GluteMediusHalfObliques exampleDialog4 = new GluteMediusHalfObliques(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                ErectorGluteMedius exampleDialog3 = new ErectorGluteMedius(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}
