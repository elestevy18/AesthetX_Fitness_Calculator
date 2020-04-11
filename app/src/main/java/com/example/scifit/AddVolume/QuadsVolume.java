package com.example.scifit.AddVolume;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.Adapters.QuadsAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.QuadsList;
import com.example.scifit.PopUpDialogs.AddPistolSquatDialog;
import com.example.scifit.PopUpDialogs.AddQuadsVolumeDialog;
import com.example.scifit.PopUpDialogs.AddSquatDialog;
import com.example.scifit.PopUpDialogs.QuadGluteMediusFullDialog;
import com.example.scifit.PopUpDialogs.QuadsGluteGluteMediusDialog;
import com.example.scifit.PopUpDialogs.SideLungeDialog;
import com.example.scifit.PopUpDialogs.SprinterLungeDialog;
import com.example.scifit.R;

import java.util.ArrayList;


public class QuadsVolume extends AppCompatActivity implements QuadsAdapter.OnItemClickListener, AddQuadsVolumeDialog.ExampleDialogListener,
AddSquatDialog.ExampleDialogListener, QuadGluteMediusFullDialog.ExampleDialogListener, QuadsGluteGluteMediusDialog.ExampleDialogListener,
SprinterLungeDialog.ExampleDialogListener, SideLungeDialog.ExampleDialogListener, AddPistolSquatDialog.ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quads_volume);

        //CreateList
        final ArrayList<QuadsList> QuadsExerciseListList = new ArrayList<>();
        QuadsExerciseListList.add(new QuadsList ("Squats", "3-10 Heavy/For Volume. Study Form"));
        QuadsExerciseListList.add(new QuadsList ("Leg Press", "8-12 Constant Tension"));
        QuadsExerciseListList.add(new QuadsList ("Banded Leg Press", "8-12 Constant Tension"));
        QuadsExerciseListList.add(new QuadsList ("Traditional Lunge", "8-15 Mind Muscle connection"));
        QuadsExerciseListList.add(new QuadsList ("Sprinter Lunge", "8-15 Mind Muscle connection"));
        QuadsExerciseListList.add(new QuadsList ("Side Lunge", "8-15 Mind Muscle connection"));
        QuadsExerciseListList.add(new QuadsList ("Banded Behind the Knee Lunge", "Strong Contraction"));
        QuadsExerciseListList.add(new QuadsList ("Bulgarian Split Squat", "8-12 Controlled reps"));
        QuadsExerciseListList.add(new QuadsList ("Explosive Bulgarian Split Squat", "8-12 Get air time"));
        QuadsExerciseListList.add(new QuadsList ("Cable Walkaways", "8-12 Get air time"));
        QuadsExerciseListList.add(new QuadsList ("Pistol Squats", "3-10 Heavy/For Volume. Study Form"));

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
                AddSquatDialog exampleDialog = new  AddSquatDialog(this);
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
                    break;
        }
    }
}
