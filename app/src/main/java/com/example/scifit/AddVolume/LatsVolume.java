package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.LatsAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.LatsList;
import com.example.scifit.PopUpDialogs.AddChinUpsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddLatLeverVolumeDialog;
import com.example.scifit.PopUpDialogs.AddLatsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddPullUpVolumeDialog;
import com.example.scifit.PopUpDialogs.AddRowsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddSuspendedRowsVolumeDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class LatsVolume extends AppCompatActivity implements LatsAdapter.OnItemClickListener, AddLatsVolumeDialog.ExampleDialogListener,
        AddSuspendedRowsVolumeDialog.ExampleDialogListener, AddRowsVolumeDialog.ExampleDialogListener, AddLatLeverVolumeDialog.ExampleDialogListener,
AddPullUpVolumeDialog.ExampleDialogListener, AddChinUpsVolumeDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lats_volume);

        //CreateList
        final ArrayList<LatsList> LatsExerciseListList = new ArrayList<>();

        LatsExerciseListList.add(new LatsList ("High Pulley Row", "8-12 Controlled reps"));
        LatsExerciseListList.add(new LatsList ("Cable Rows", "8-12 Controlled reps"));
        LatsExerciseListList.add(new LatsList ("Barbell Rows", "8-12 Controlled reps"));
        LatsExerciseListList.add(new LatsList ("Chest Supported Rows", "8-12 Strong contraction"));
        LatsExerciseListList.add(new LatsList ("Front Levers", "8-12 Controlled reps"));
        LatsExerciseListList.add(new LatsList ("Lat Pull Over", "8-12 Controlled reps"));
        LatsExerciseListList.add(new LatsList ("Lat Pushdown", "8-12 Controlled reps"));
        LatsExerciseListList.add(new LatsList ("Pull ups", "8-12 Controlled reps"));
        LatsExerciseListList.add(new LatsList ("Cable Pulldown", "8-12 Controlled reps"));
        LatsExerciseListList.add(new LatsList ("Pull ins", "8-12 Controlled reps"));
        LatsExerciseListList.add(new LatsList ("Chin Ups", "8-12 Controlled reps"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.latsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        LatsAdapter mAdapter = new LatsAdapter(LatsExerciseListList, this);

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
                AddRowsVolumeDialog exampleDialog = new AddRowsVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddSuspendedRowsVolumeDialog exampleDialog2 = new AddSuspendedRowsVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddSuspendedRowsVolumeDialog exampleDialog3 = new AddSuspendedRowsVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddRowsVolumeDialog exampleDialog4 = new AddRowsVolumeDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddLatLeverVolumeDialog exampleDialog5 = new AddLatLeverVolumeDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddLatLeverVolumeDialog exampleDialog6 = new AddLatLeverVolumeDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddLatLeverVolumeDialog exampleDialog7 = new AddLatLeverVolumeDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                AddPullUpVolumeDialog exampleDialog8 = new AddPullUpVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;
            case 8:
                AddPullUpVolumeDialog exampleDialog9 = new AddPullUpVolumeDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");

                break;
                case 9:
                    AddLatsVolumeDialog exampleDialog10 = new AddLatsVolumeDialog(this);
                    exampleDialog10.show(getSupportFragmentManager(), "example dialog");
                break;
                case 10:
                    AddChinUpsVolumeDialog exampleDialog11 = new AddChinUpsVolumeDialog(this);
                    exampleDialog11.show(getSupportFragmentManager(), "example dialog");
                break;

        }
    }
}
