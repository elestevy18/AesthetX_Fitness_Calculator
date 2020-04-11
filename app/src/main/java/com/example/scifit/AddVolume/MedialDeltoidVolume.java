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
import com.example.scifit.Classes.Adapters.MedialDeltoidAdapter;
import com.example.scifit.Classes.Adapters.MedialDeltoidAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.MedialDeltoidList;
import com.example.scifit.Classes.MuscleGroupObjects.MedialDeltoidList;
import com.example.scifit.MuscleGroupInfo.AnteriorDeltoid;
import com.example.scifit.MuscleGroupInfo.MedialDeltoid;
import com.example.scifit.MuscleGroupInfo.MedialDeltoid;
import com.example.scifit.MuscleGroupInfo.MedialDeltoid;
import com.example.scifit.MuscleGroupInfo.RotatorCuff;
import com.example.scifit.MuscleGroupInfo.Triceps;
import com.example.scifit.MuscleGroupInfo.UlnarForearm;
import com.example.scifit.PopUpDialogs.AddMedialDeltoidVolumeDialog;
import com.example.scifit.PopUpDialogs.AddMedialDeltoidVolumeDialog;
import com.example.scifit.PopUpDialogs.AddTrapDeltDialog;
import com.example.scifit.R;
import java.util.ArrayList;


public class MedialDeltoidVolume extends AppCompatActivity implements MedialDeltoidAdapter.OnItemClickListener, AddMedialDeltoidVolumeDialog.ExampleDialogListener,
AddTrapDeltDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posterior_deltoid_volume);

        //CreateList
        final ArrayList<MedialDeltoidList> MedialDeltoidExerciseListList = new ArrayList<>();
        MedialDeltoidExerciseListList.add(new MedialDeltoidList ("Lateral raise", "10-15 Controlled with strong Contraction"));
        MedialDeltoidExerciseListList.add(new MedialDeltoidList ("Cable Lateral Raises", "10-15 Constant tension"));
        MedialDeltoidExerciseListList.add(new MedialDeltoidList ("Machine Lateral Raise", "10-15 Strong contraction"));
        MedialDeltoidExerciseListList.add(new MedialDeltoidList ("Cheat Lateral Raise", "8-12 Controlled hard, use upper trap"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.posteriorDeltoidRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        MedialDeltoidAdapter mAdapter = new MedialDeltoidAdapter(MedialDeltoidExerciseListList, this);

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
                AddMedialDeltoidVolumeDialog exampleDialog = new AddMedialDeltoidVolumeDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddMedialDeltoidVolumeDialog exampleDialog2 = new AddMedialDeltoidVolumeDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddMedialDeltoidVolumeDialog exampleDialog3 = new AddMedialDeltoidVolumeDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                AddTrapDeltDialog exampleDialog4 = new AddTrapDeltDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;


        }
    }
}
