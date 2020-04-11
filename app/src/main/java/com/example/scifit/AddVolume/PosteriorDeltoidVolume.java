package com.example.scifit.AddVolume;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.scifit.AddVolume.Form.HarnessLateralFlexion;
import com.example.scifit.AddVolume.Form.HarnessNeckExtension;
import com.example.scifit.AddVolume.Form.NeckHarnessCurls;
import com.example.scifit.AddVolume.Form.PlateCurl;
import com.example.scifit.AddVolume.Form.PlatedNeckExtension;
import com.example.scifit.AddVolume.Form.PlatedNeckLateralFlexion;
import com.example.scifit.AddVolume.Form.SuspendedNeckRotation;
import com.example.scifit.AddVolume.Form.TowelLateralFlexion;
import com.example.scifit.AddVolume.Form.TowelNeckExtension;
import com.example.scifit.Classes.Adapters.PosteriorDeltoidAdapter;
import com.example.scifit.Classes.Adapters.PosteriorDeltoidAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.PosteriorDeltoidList;
import com.example.scifit.Classes.MuscleGroupObjects.PosteriorDeltoidList;
import com.example.scifit.MuscleGroupInfo.AnteriorDeltoid;
import com.example.scifit.MuscleGroupInfo.PosteriorDeltoid;
import com.example.scifit.MuscleGroupInfo.MedialDeltoid;
import com.example.scifit.MuscleGroupInfo.PosteriorDeltoid;
import com.example.scifit.MuscleGroupInfo.RotatorCuff;
import com.example.scifit.MuscleGroupInfo.Triceps;
import com.example.scifit.MuscleGroupInfo.UlnarForearm;
import com.example.scifit.PopUpDialogs.AddAngelOfDeathDialog;
import com.example.scifit.PopUpDialogs.AddFacePullDialog;
import com.example.scifit.PopUpDialogs.AddHalfLowerTrapPostDeltDialog;
import com.example.scifit.PopUpDialogs.AddPosteriorDeltoidVolumeDialog;
import com.example.scifit.PopUpDialogs.AddPosteriorDeltoidVolumeDialog;
import com.example.scifit.R;
import java.util.ArrayList;


public class PosteriorDeltoidVolume extends AppCompatActivity implements PosteriorDeltoidAdapter.OnItemClickListener, AddPosteriorDeltoidVolumeDialog.ExampleDialogListener,
AddHalfLowerTrapPostDeltDialog.ExampleDialogListener, AddFacePullDialog. ExampleDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posterior_deltoid_volume);

        //CreateList
        final ArrayList<PosteriorDeltoidList> PosteriorDeltoidExerciseListList = new ArrayList<>();
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList ("High Rows", "8-12 Strong Contraction"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList ("Facepulls", "10-15 Controlled reps"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList ("Reverse Pec Dec", "8-12 Strong Contraction"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList ("Reverse Dumbbell Flies", "10-20 Controlled reps"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList ("Banded Pull Aparts", "10-30 Strong Contraction"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList ("Angels of Death", "10 Slow and controlled"));
        PosteriorDeltoidExerciseListList.add(new PosteriorDeltoidList ("W's", "10-12 Slow and controlled reps"));

        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.posteriorDeltoidRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        PosteriorDeltoidAdapter mAdapter = new PosteriorDeltoidAdapter(PosteriorDeltoidExerciseListList, this);

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
                AddHalfLowerTrapPostDeltDialog exampleDialog = new AddHalfLowerTrapPostDeltDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddFacePullDialog exampleDialog2 = new AddFacePullDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddHalfLowerTrapPostDeltDialog exampleDialog3 = new AddHalfLowerTrapPostDeltDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddHalfLowerTrapPostDeltDialog exampleDialog4 = new AddHalfLowerTrapPostDeltDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddHalfLowerTrapPostDeltDialog exampleDialog5 = new AddHalfLowerTrapPostDeltDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddAngelOfDeathDialog exampleDialog6 = new AddAngelOfDeathDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddHalfLowerTrapPostDeltDialog exampleDialog7 = new AddHalfLowerTrapPostDeltDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;


        }
    }
}
