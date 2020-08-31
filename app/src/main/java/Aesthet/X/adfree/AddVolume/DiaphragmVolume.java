package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import Aesthet.X.adfree.Classes.Adapters.DiaphragmAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.DiaphragmList;
import Aesthet.X.adfree.PopUpDialogs.AddDiaphragmVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.ObliqueDiaphragmFullDialog;


public class DiaphragmVolume extends AppCompatActivity implements DiaphragmAdapter.OnItemClickListener, AddDiaphragmVolumeDialog.ExampleDialogListener, ObliqueDiaphragmFullDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaphragm_volume);

        //CreateList
        final ArrayList<DiaphragmList> TransverseExerciseListList = new ArrayList<>();
        TransverseExerciseListList.add(new DiaphragmList("Transverse Ab", "One set towards Transverse Ab"));
        TransverseExerciseListList.add(new DiaphragmList("Vacuums", "Transverse Ab"));
        TransverseExerciseListList.add(new DiaphragmList("Banded/Cable Resisted Rotation", "Transverse Ab, Obliques"));
        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.TransverseRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        DiaphragmAdapter mAdapter = new DiaphragmAdapter(TransverseExerciseListList, this);

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
                AddDiaphragmVolumeDialog exampleDialog = new AddDiaphragmVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 2:
                ObliqueDiaphragmFullDialog exampleDialog2 = new ObliqueDiaphragmFullDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");
                break;
        }
    }
}
