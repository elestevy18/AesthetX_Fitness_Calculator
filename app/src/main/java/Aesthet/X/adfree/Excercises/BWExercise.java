package Aesthet.X.adfree.Excercises;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import Aesthet.X.adfree.Classes.Adapters.BWAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.BWList;
import Aesthet.X.adfree.PopUpDialogs.AbCirclesDialog;
import Aesthet.X.adfree.PopUpDialogs.AddAbsSerratusVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddAbsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddAngelOfDeathDialog;
import Aesthet.X.adfree.PopUpDialogs.AddAnteriorDeltoidVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddBicepsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddCaliforniaPressDialog;
import Aesthet.X.adfree.PopUpDialogs.AddCalvesVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddChestDeltVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddChestPressDialog;
import Aesthet.X.adfree.PopUpDialogs.AddChestTricepsDialog;
import Aesthet.X.adfree.PopUpDialogs.AddChestVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddChinUpsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddCurlsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddDeadliftVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddDiaphragmVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddDipDialog;
import Aesthet.X.adfree.PopUpDialogs.AddErectorsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddFacePullDialog;
import Aesthet.X.adfree.PopUpDialogs.AddForearmCurlsDialog;
import Aesthet.X.adfree.PopUpDialogs.AddForearmExtensorVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddForearmFlexorVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddGluteErectorDialog;
import Aesthet.X.adfree.PopUpDialogs.AddGluteHamDialog;
import Aesthet.X.adfree.PopUpDialogs.AddGluteMediusVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddGlutesVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddHalfLowerTrapPostDeltDialog;
import Aesthet.X.adfree.PopUpDialogs.AddHamGluteDialog;
import Aesthet.X.adfree.PopUpDialogs.AddHammerCurlVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddHamstringsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddHighPullDialog;
import Aesthet.X.adfree.PopUpDialogs.AddHipThrustVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddIsoHipThrustDialog;
import Aesthet.X.adfree.PopUpDialogs.AddIsoRDLDialog;
import Aesthet.X.adfree.PopUpDialogs.AddLatLeverVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddLatsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddLowerTrapPostDeltDialog;
import Aesthet.X.adfree.PopUpDialogs.AddLowerTrapVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddMedialDeltoidVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddNeckVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddObliquesVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddPistolSquatDialog;
import Aesthet.X.adfree.PopUpDialogs.AddPosteriorDeltoidVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddProtractionDialog;
import Aesthet.X.adfree.PopUpDialogs.AddPullOverDialog;
import Aesthet.X.adfree.PopUpDialogs.AddPullUpVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddQuadsGluteMediusDialog;
import Aesthet.X.adfree.PopUpDialogs.AddQuadsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddRadialForearmVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddRotatorCuffVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddRowsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddSerratusVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddSquatDialog;
import Aesthet.X.adfree.PopUpDialogs.AddSuspendedRowsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddTrapDeltDialog;
import Aesthet.X.adfree.PopUpDialogs.AddTricepsLatVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddTricepsVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddUlnarForearmVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddUpperTrapVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.ErectorGluteMedius;
import Aesthet.X.adfree.PopUpDialogs.GluteGluteMediusHamstrings;
import Aesthet.X.adfree.PopUpDialogs.GluteMediusHalfObliques;
import Aesthet.X.adfree.PopUpDialogs.OHPDialog;
import Aesthet.X.adfree.PopUpDialogs.ObliqueAbDiaphragmDialog;
import Aesthet.X.adfree.PopUpDialogs.ObliqueAbDiaphragmFullDialog;
import Aesthet.X.adfree.PopUpDialogs.ObliqueDiaphragmDialog;
import Aesthet.X.adfree.PopUpDialogs.ObliqueDiaphragmFullDialog;
import Aesthet.X.adfree.PopUpDialogs.QuadGluteMediusFullDialog;
import Aesthet.X.adfree.PopUpDialogs.QuadsGluteGluteMediusDialog;
import Aesthet.X.adfree.PopUpDialogs.QuadsHalfGlute;
import Aesthet.X.adfree.PopUpDialogs.SideLungeDialog;
import Aesthet.X.adfree.PopUpDialogs.SprinterLungeDialog;

//IMPLEMENTATIONS ARE ALL THE DIALOG LISTENERS
public class BWExercise extends AppCompatActivity implements BWAdapter.OnItemClickListener, AddUpperTrapVolumeDialog.ExampleDialogListener,
        AddDeadliftVolumeDialog.ExampleDialogListener, AddLowerTrapVolumeDialog.ExampleDialogListener, AddAngelOfDeathDialog.ExampleDialogListener,
        AddPosteriorDeltoidVolumeDialog.ExampleDialogListener, AddHalfLowerTrapPostDeltDialog.ExampleDialogListener, AddFacePullDialog.ExampleDialogListener,
        AddNeckVolumeDialog.ExampleDialogListener, AddMedialDeltoidVolumeDialog.ExampleDialogListener, AddTrapDeltDialog.ExampleDialogListener,
        AddLowerTrapPostDeltDialog.ExampleDialogListener, AddAnteriorDeltoidVolumeDialog.ExampleDialogListener, OHPDialog.ExampleDialogListener,
        AddRotatorCuffVolumeDialog.ExampleDialogListener, AddTricepsVolumeDialog.ExampleDialogListener, AddTricepsLatVolumeDialog.ExampleDialogListener,
        AddDipDialog.ExampleDialogListener, AddHighPullDialog.ExampleDialogListener, AddUlnarForearmVolumeDialog.ExampleDialogListener,
        AddForearmExtensorVolumeDialog.ExampleDialogListener, AddRadialForearmVolumeDialog.ExampleDialogListener, AddHammerCurlVolumeDialog.ExampleDialogListener,
        AddLatsVolumeDialog.ExampleDialogListener, AddSuspendedRowsVolumeDialog.ExampleDialogListener, AddRowsVolumeDialog.ExampleDialogListener,
        AddLatLeverVolumeDialog.ExampleDialogListener, AddPullUpVolumeDialog.ExampleDialogListener, AddChinUpsVolumeDialog.ExampleDialogListener,
        AddErectorsVolumeDialog.ExampleDialogListener, AddGlutesVolumeDialog.ExampleDialogListener, AddHipThrustVolumeDialog.ExampleDialogListener,
        AddGluteHamDialog.ExampleDialogListener, AddHamGluteDialog.ExampleDialogListener, AddGluteMediusVolumeDialog.ExampleDialogListener,
        AddIsoHipThrustDialog.ExampleDialogListener, AddIsoRDLDialog.ExampleDialogListener, AddPistolSquatDialog.ExampleDialogListener, AddHamstringsVolumeDialog.ExampleDialogListener,
        AddCalvesVolumeDialog.ExampleDialogListener, AddChestVolumeDialog.ExampleDialogListener, AddPullOverDialog.ExampleDialogListener, AddChestDeltVolumeDialog.ExampleDialogListener,
        AddBicepsVolumeDialog.ExampleDialogListener, AddCurlsVolumeDialog.ExampleDialogListener, AddSerratusVolumeDialog.ExampleDialogListener,
        AddProtractionDialog.ExampleDialogListener, AddAbsSerratusVolumeDialog.ExampleDialogListener, AddAbsVolumeDialog.ExampleDialogListener, AbCirclesDialog.ExampleDialogListener,
        AddObliquesVolumeDialog.ExampleDialogListener, ObliqueAbDiaphragmDialog.ExampleDialogListener, ObliqueAbDiaphragmFullDialog.ExampleDialogListener,
        ObliqueDiaphragmDialog.ExampleDialogListener, AddDiaphragmVolumeDialog.ExampleDialogListener, AddQuadsVolumeDialog.ExampleDialogListener,
        AddSquatDialog.ExampleDialogListener, QuadGluteMediusFullDialog.ExampleDialogListener, QuadsGluteGluteMediusDialog.ExampleDialogListener,
        SprinterLungeDialog.ExampleDialogListener, SideLungeDialog.ExampleDialogListener, ObliqueDiaphragmFullDialog.ExampleDialogListener, AddForearmFlexorVolumeDialog.ExampleDialogListener,
        AddCaliforniaPressDialog.ExampleDialogListener, AddChestPressDialog.ExampleDialogListener, AddForearmCurlsDialog.ExampleDialogListener, AddChestTricepsDialog.ExampleDialogListener,
        GluteGluteMediusHamstrings.ExampleDialogListener, AddGluteErectorDialog.ExampleDialogListener, ErectorGluteMedius.ExampleDialogListener, GluteMediusHalfObliques.ExampleDialogListener,
        QuadsHalfGlute.ExampleDialogListener, AddQuadsGluteMediusDialog.ExampleDialogListener {
    private BWAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_w_exercise);


        //CreateList
        final List<BWList> BWExerciseListList = new ArrayList<>();
        //NECK
        BWExerciseListList.add(new BWList("Head Floats", "Neck Flexion, Lateral Flexion or Extension "));
        BWExerciseListList.add(new BWList("Neck Flexion", "Lateral and forward Flexion"));

        //UPPER TRAP
        BWExerciseListList.add(new BWList("Trap Pushaway", "Upper Trapezoid"));
        BWExerciseListList.add(new BWList("Inverted Y", "Upper and Lower Trapezoid"));

        //LOWER TRAP
        BWExerciseListList.add(new BWList("Hanging Scapular Retraction", "Lower Traps"));
        BWExerciseListList.add(new BWList("Floor Scapular Depression", "Lower Traps"));
        //POSTERIOR DELTOID
        BWExerciseListList.add(new BWList("Ring Facepulls", "Posterior Deltoid, Rotator Cuff, Lower Traps"));
        BWExerciseListList.add(new BWList("Floor T's", "Posterior Deltoid"));
        BWExerciseListList.add(new BWList("Banded Pull Aparts", "Posterior Delt, Lower Traps"));
        //MEDIAL DELTOID
        BWExerciseListList.add(new BWList("Banded Lateral Raise", "Medial Deltoid"));
        BWExerciseListList.add(new BWList("Delt Rotating Plank", "Medial Deltoid"));

        //ANTERIOR DELTOID
        BWExerciseListList.add(new BWList("Pike Pushup", "Anterior Delt Secondary: Triceps, Medial Delt"));
        BWExerciseListList.add(new BWList("Handstand Pushup", "Anterior Delt, Secondary: Triceps, Medial Delt"));

        //ROTATOR CUFF
        BWExerciseListList.add(new BWList("Banded External Rotation", "Rotator Cuffs, Forearm Extensors"));

        //Triceps
        BWExerciseListList.add(new BWList("Narrow Dip", "Triceps, Chest"));
        BWExerciseListList.add(new BWList("Narrow Pushup", "Triceps, Chest Secondary: Anterior Delt"));
        BWExerciseListList.add(new BWList("Triceps Extension", "Triceps; short and medial head"));
        BWExerciseListList.add(new BWList("Ring Overhead Extension", "Triceps; long head"));
        BWExerciseListList.add(new BWList("Bench Dip", "Triceps"));

        //ULNAR FOREARM
        BWExerciseListList.add(new BWList("Banded Ulnar Deviation", "Ulnar Forearm"));
        //Extensors
        BWExerciseListList.add(new BWList("Banded Wrist Extension", "Primary: Forearm Extensors"));
        //FOREARMFLEXORS
        BWExerciseListList.add(new BWList("Banded Wrist Curls", "Forearm Flexors"));
        //RADIAL FOREARM
        BWExerciseListList.add(new BWList("Banded Radial Deviation", "Radial Forearm"));
        //LATS
        BWExerciseListList.add(new BWList("Ring Rows", "Lats, Lower Traps\nSecondary:Post Delt, Biceps, Forearm"));
        BWExerciseListList.add(new BWList("Front Levers", "Lats, Triceps"));
        BWExerciseListList.add(new BWList("Pull Ups", "Lats, Lower Trap\nSecondary:Post Delt, Bicep, Forearms"));
        BWExerciseListList.add(new BWList("Chin Ups", "Lats, Lower Trap, Bicep\nSecondary:Post Delt, Forearms"));
        BWExerciseListList.add(new BWList("Australian Pull Up", "Lats, Lower Traps\nSecondary: Post Delt, Biceps, Forearm "));

        //ERECTORS
        BWExerciseListList.add(new BWList("Frog Pumps", "Spinal Erectors, Glute Medius"));
        BWExerciseListList.add(new BWList("Angels of Death", "Spinal Erectors, Lower Traps, Post Delt"));
        BWExerciseListList.add(new BWList("Marching Bridge", "Spinal Erector, Glutes"));
        BWExerciseListList.add(new BWList("Reverse Hyperextension", "Glutes Secondary: Spinal Erector, Hamstrings "));
        //GLUTES
        BWExerciseListList.add(new BWList("Isolateral Hip Thrust", "Glutes, Glute Medius Secondary: Hamstrings"));
        BWExerciseListList.add(new BWList("Bodyweight Hip Thrust", "Glutes Secondary: Hamstrings"));
        BWExerciseListList.add(new BWList("Sprinter Lunge", "Glutes, Glute Medius Secondary: Hamstrings"));
        BWExerciseListList.add(new BWList("Banded RDL", "Glutes, Glute Medius, Hamstrings"));

        //GLUTEMEDIUS
        BWExerciseListList.add(new BWList("Banded Abduction", "Glute Medius"));
        BWExerciseListList.add(new BWList("Glute Side Bridge", "Glute Medius Secondary: Obliques"));

        //HAMSTRINGS
        BWExerciseListList.add(new BWList("Physioball Hamstring Curls", "Hamstring Secondary: Glutes"));
        BWExerciseListList.add(new BWList("Isolateral Hamstring Curls", "Hamstring, Glute Medius\nSecondary: Glutes, Erectors"));
        //CALVES
        BWExerciseListList.add(new BWList("Bodyweight Calf Raise", "Calves"));

        //CHEST
        BWExerciseListList.add(new BWList("Pushups", "Chest, Triceps, Anterior Delt"));
        BWExerciseListList.add(new BWList("Wide Dip", "Chest, Triceps Secondary: Anterior Delt"));
        //BICEPS
        BWExerciseListList.add(new BWList("Banded Curls", "Bicep"));
        BWExerciseListList.add(new BWList("Ring Curls", "Bicep"));
        //SERRATUS
        BWExerciseListList.add(new BWList("Plank/Dip Protraction", "Serratus Anterior"));
        BWExerciseListList.add(new BWList("Banded/Cable Punches", "Serratus Anterior"));
        BWExerciseListList.add(new BWList("Protracted Roll Out", "Serratus Anterior, Abs, Transverse Ab"));

        //ABS
        //WHOLE ABS
        //LOWER BW
        BWExerciseListList.add(new BWList("Leg Raises", "Abs Secondary: Transverse Ab"));
        BWExerciseListList.add(new BWList("Ab Circles", "Lower Abs, Obliques Secondary: Transverse Ab"));
        BWExerciseListList.add(new BWList("Reverse Crunches", "Lower Abs Secondary: Transverse Ab"));
        BWExerciseListList.add(new BWList("Pulse Up", "Lower Abs Secondary: Transverse Ab"));
        BWExerciseListList.add(new BWList("Twisting Pulse Up", "Lower Abs, Obliques Secondary: Transverse Ab"));
        //MID ABS
        BWExerciseListList.add(new BWList("Band Crunch", "Middle Abs Secondary; Transverse Ab"));
        BWExerciseListList.add(new BWList("V-Up", "Middle Abs Secondary; Transverse Ab"));
        BWExerciseListList.add(new BWList("Ab Rollout", "Middle Abs Secondary; Transverse Ab"));
        //OBLIQUES
        BWExerciseListList.add(new BWList("Twisting Leg Raise", "Obliques Secondary: Transverse Ab, Lower Abs"));
        BWExerciseListList.add(new BWList("Leg Raise Scissors", "Obliques, Abs Secondary: Transverse Ab"));
        BWExerciseListList.add(new BWList("Elbow to Knee Tucks", "Obliques Secondary: Transverse Ab, Middle Abs"));
        BWExerciseListList.add(new BWList("Banded/Cable Step Out", "Obliques Secondary: Transverse Ab"));
        BWExerciseListList.add(new BWList("Rotating Plank", "Obliques Secondary: Abs, Transverse Ab"));
        BWExerciseListList.add(new BWList("Elbow to Knee Plank", "Obliques Secondary: Abs, Transverse Ab"));
        BWExerciseListList.add(new BWList("X-Crunch", "Obliques Secondary: Abs, Transverse Ab"));
        //Transverse Ab
        BWExerciseListList.add(new BWList("Vacuums", "Transverse Ab"));
        //QUADS
        BWExerciseListList.add(new BWList("Bodyweight Squats", "Quadriceps Secondary: Glutes"));
        BWExerciseListList.add(new BWList("Pistol Squats", "Quadriceps, Glute Medius Secondary: Glutes"));
        BWExerciseListList.add(new BWList("Lunges", "Quadriceps, Glute Medius Secondary: Glutes"));
        BWExerciseListList.add(new BWList("Banded Lunge", "Quads"));
        BWExerciseListList.add(new BWList("Bulgarian Split Squat", "Quadriceps, Glute Medius Secondary: Glutes"));
        BWExerciseListList.add(new BWList("Side Lunges", "Quadriceps, Glute Medius "));
        BWExerciseListList.add(new BWList("Wall Sit", "Quadriceps"));
        BWExerciseListList.add(new BWList("Explosive Bulgarian Split Squat", "Quads Secondary: Glute Medius"));



        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.BWExerciseRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new BWAdapter(BWExerciseListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        ImageView logo = findViewById(R.id.tostore);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.aesthet-x.com/shop/"));
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }


    @Override
    public void onExerciseClick(int position) {

        // GET TEXT FROM RECYCLER VIEW ITEM CLICKED
        RecyclerView recyclerView = findViewById(R.id.BWExerciseRecyclerView);
        TextView text = Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(position)).itemView.findViewById(R.id.exercise);
        String exercise = text.getText().toString();

        //CHECK WHICH DIALOG TO OPEN FOR PROPER VOLUME INPUT
        if (exercise.equals("Head Floats")) {
            Intent i = new Intent(this, HeadFloats.class);
            startActivity(i);
        } else if (exercise.equals("Angels of Death")) {
            Intent i = new Intent(this, AngelofDeath.class);
            startActivity(i);
        } else if (exercise.equals("Neck Flexion")) {
            Intent i = new Intent(this, NeckFlexion.class);
            startActivity(i);
        } else if (exercise.equals("Pushups")) {
            Intent i = new Intent(this, Pushups.class);
            startActivity(i);
        } else if (exercise.equals("Ab Rollout")) {
            Intent i = new Intent(this, AbRollout.class);
            startActivity(i);
        } else if (exercise.equals("Bodyweight Hip Thrust")) {
            Intent i = new Intent(this, BWHipThrust.class);
            startActivity(i);
        } else if (exercise.equals("Bench Dip")) {
            Intent i = new Intent(this, BenchDip.class);
            startActivity(i);
        } else if (exercise.equals("Bulgarian Split Squat")) {
            Intent i4 = new Intent(this, BulgarianSplitSquat.class);
            startActivity(i4);
        } else if (exercise.equals("Rotating Plank")) {
            Intent i4 = new Intent(this, DeltRotating.class);
            startActivity(i4);
        } else if (exercise.equals("Trap Pushaway")) {
            Intent i4 = new Intent(this, TrapPushaway.class);
            startActivity(i4);
        } else if (exercise.equals("Band Crunch")) {
            Intent i4 = new Intent(this, BandCrunch.class);
            startActivity(i4);
        } else if (exercise.equals("Banded Lunge")) {
            Intent i4 = new Intent(this, BandedLunge.class);
            startActivity(i4);
        } else if (exercise.equals("Ring Overhead Extension")) {
            Intent i4 = new Intent(this, RingOverheadExtension.class);
            startActivity(i4);
        } else if (exercise.equals("Twisting Leg Raise")) {
            Intent i4 = new Intent(this, TwistingLegRaise.class);
            startActivity(i4);
        } else if (exercise.equals("Bodyweight Squats")) {
            Intent i4 = new Intent(this, BWsquats.class);
            startActivity(i4);
        } else if (exercise.equals("Floor Scapular Depression")) {
            Intent i = new Intent(this, FloorScapularDepression.class);
            startActivity(i);
        } else if (exercise.equals("Banded Lateral Raise")) {
            Intent i = new Intent(this, BandedLateralRaise.class);
            startActivity(i);
        } else if (exercise.equals("Delt Rotating Plank")) {
            Intent i = new Intent(this, DeltRotating.class);
            startActivity(i);
        } else if (exercise.equals("Marching Bridge")) {
            Intent i = new Intent(this, MarchingBridge.class);
            startActivity(i);
        } else if (exercise.equals("Reverse Hyperextension")) {
            Intent i = new Intent(this, ReverseHyper.class);
            startActivity(i);
        } else if (exercise.equals("Reverse Crunches")) {
            Intent i = new Intent(this, ReverseCrunch.class);
            startActivity(i);
        } else if (exercise.equals("Triceps Extension")) {
            Intent i = new Intent(this, TricepsExtension.class);
            startActivity(i);
        } else if (exercise.equals("Lunges")) {
            Intent i = new Intent(this, Lunges.class);
            startActivity(i);
        } else if (exercise.equals("Pulse Up")) {
            Intent i = new Intent(this, PulseUp.class);
            startActivity(i);
        } else if (exercise.equals("Glute Side Bridge")) {
            Intent i27 = new Intent(this, SidePlank.class);
            startActivity(i27);
        } else if (exercise.equals("Banded Abduction")) {
            Intent i27 = new Intent(this, BandedAbduction.class);
            startActivity(i27);
        } else if (exercise.equals("Pistol Squats")) {
            Intent i = new Intent(this, PistolSquat.class);
            startActivity(i);
        } else if (exercise.equals("Band/Bodyweight Lunge")) {
            AddQuadsGluteMediusDialog exampleDialog = new AddQuadsGluteMediusDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Wrist Extension")) {
            Intent i = new Intent(this, BandExtension.class);
            startActivity(i);
        } else if (exercise.equals("Banded/Cable Step Out")) {
            Intent i = new Intent(this, BandedStepOut.class);
            startActivity(i);
        } else if (exercise.equals("Bodyweight Calf Raise")) {
            Intent i = new Intent(this, CalfRaise.class);
            startActivity(i);
        } else if (exercise.equals("Side Lunges")) {
            Intent i = new Intent(this, SideLunge.class);
            startActivity(i);
        } else if (exercise.equals("Sprinter Lunge")) {
            Intent i = new Intent(this, SprinterLunge.class);
            startActivity(i);
        } else if (exercise.equals("Wall Sit")) {
            Intent i = new Intent(this, WallSit.class);
            startActivity(i);
        } else if (exercise.equals("Banded/Cable/ Resisted Rotation")) {
            ObliqueDiaphragmFullDialog exampleDialog = new ObliqueDiaphragmFullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Vacuums")) {
            Intent i = new Intent(this, Vacuums.class);
            startActivity(i);
        } else if (exercise.equals("Leg Raises")) {
            Intent i = new Intent(this, LegRaise.class);
            startActivity(i);
        } else if (exercise.equals("Ab Circles")) {
            Intent i = new Intent(this, AbCircles.class);
            startActivity(i);
        } else if (exercise.equals("Plank/Dip Protraction")) {
            Intent i = new Intent(this, PlankProtraction.class);
            startActivity(i);
        } else if (exercise.equals("Narrow Dip")) {
            Intent i = new Intent(this, NarrowDip.class);
            startActivity(i);
        } else if (exercise.equals("Isolateral Hip Thrust")) {
            Intent i = new Intent(this, IsoHT.class);
            startActivity(i);
        } else if (exercise.equals("Banded Radial Deviation")) {
            Intent i = new Intent(this, RadialDeviation.class);
            startActivity(i);
        } else if (exercise.equals("Inverted Y")) {
            Intent i = new Intent(this, InvertedY.class);
            startActivity(i);
        } else if (exercise.equals("Hanging Scapular Retraction")) {
            Intent i = new Intent(this, HangingScapularRetraction.class);
            startActivity(i);
        } else if (exercise.equals("Banded RDL")) {
            Intent i = new Intent(this, BandedRDL.class);
            startActivity(i);
        } else if (exercise.equals("Leg Raise Scissors")) {
            Intent i = new Intent(this, LegRaiseScissor.class);
            startActivity(i);
        } else if (exercise.equals("Narrow Pushup")) {
            Intent i = new Intent(this, NarrowPushup.class);
            startActivity(i);
        } else if (exercise.equals("Banded Ulnar Deviation")) {
            Intent i = new Intent(this, UlnarDeviation.class);
            startActivity(i);
        } else if (exercise.equals("Frog Pumps")) {
            Intent i = new Intent(this, FrogPump.class);
            startActivity(i);
        } else if (exercise.equals("Push Up")) {
            AddChestPressDialog exampleDialog = new AddChestPressDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Ring Facepulls")) {
            Intent i = new Intent(this, RingFacepulls.class);
            startActivity(i);
        } else if (exercise.equals("Banded Pull Aparts")) {
            Intent i = new Intent(this, BandedPullApart.class);
            startActivity(i);
        } else if (exercise.equals("Handstand Pushup")) {
            Intent i = new Intent(this, HandstandPushup.class);
            startActivity(i);
        } else if (exercise.equals("Pike Pushup")) {
            Intent i = new Intent(this, PikePushup.class);
            startActivity(i);
        } else if (exercise.equals("Banded External Rotation")) {
            Intent i = new Intent(this, BandedExternalRotation.class);
            startActivity(i);
        } else if (exercise.equals("Banded Wrist Curls")) {
            Intent i = new Intent(this, BandedForearmCurl.class);
            startActivity(i);
        } else if (exercise.equals("Wrist Flexed Curls")) {
            AddForearmCurlsDialog exampleDialog = new AddForearmCurlsDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Curls")) {
            Intent i27 = new Intent(this, BandedCurls.class);
            startActivity(i27);
        } else if (exercise.equals("Ring Curls")) {
            Intent i27 = new Intent(this, RingCurls.class);
            startActivity(i27);
        } else if (exercise.equals("Australian Pull Up")) {
            Intent i27 = new Intent(this, AustralianPullUp.class);
            startActivity(i27);
        } else if (exercise.equals("Ring Rows")) {
            Intent i27 = new Intent(this, RingRows.class);
            startActivity(i27);
        } else if (exercise.equals("V-Up")) {
            Intent i27 = new Intent(this, VUp.class);
            startActivity(i27);
        } else if (exercise.equals("Front Levers")) {
            Intent i27 = new Intent(this, LatLever.class);
            startActivity(i27);
        } else if (exercise.equals("Pull Ups")) {
            Intent i27 = new Intent(this, PullUps.class);
            startActivity(i27);
        } else if (exercise.equals("Twisting Pulse Up")) {
            Intent i27 = new Intent(this, TwistingPulseUp.class);
            startActivity(i27);
        } else if (exercise.equals("Pull ins")) {
            AddLatsVolumeDialog exampleDialog = new AddLatsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Chin Ups")) {
            Intent i = new Intent(this, ChinUps.class);
            startActivity(i);
        } else if (exercise.equals("Hip Thrust")) {
            AddHipThrustVolumeDialog exampleDialog = new AddHipThrustVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Floor T's")) {
            Intent i = new Intent(this, Ts.class);
            startActivity(i);
        } else if (exercise.equals("Physioball Hamstring Curls") || exercise.equals("Isolateral Hamstring Curls")) {
            Intent i = new Intent(this, HamCurl.class);
            startActivity(i);
        } else if (exercise.equals("Protracted Roll Out")) {
            Intent i = new Intent(this, ProtractedRollout.class);
            startActivity(i);
        } else if (exercise.equals("Elbow to Knee Plank")) {
            Intent i = new Intent(this, ElbowToKneePlank.class);
            startActivity(i);
        } else if (exercise.equals("Elbow to Knee Tucks")) {
            Intent i = new Intent(this, ElbowToKneeTuck.class);
            startActivity(i);
        } else if (exercise.equals("X-Crunch")) {
            Intent i = new Intent(this, XCrunch.class);
            startActivity(i);
        } else if (exercise.equals("Wide Dip")) {
            Intent i = new Intent(this, WideDip.class);
            startActivity(i);
        } else if (exercise.equals("Banded/Cable Punches")) {
            Intent i = new Intent(this, BandedPunch.class);
            startActivity(i);
        } else {
            Toast toast = Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
            toast.show();
        }
    }

    @Override
    public void onAddVolumeClick(int position) {
        stringcomparison(position);
    }

    @Override
    public void addVolume() {

    }

    private void stringcomparison(Integer position) {
        // GET TEXT FROM RECYCLER VIEW ITEM CLICKED
        RecyclerView recyclerView = findViewById(R.id.BWExerciseRecyclerView);
        TextView text = Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(position)).itemView.findViewById(R.id.exercise);
        String exercise = text.getText().toString();
        //CREATE ARRAYS AND LISTS FOR EXERCISES WITH EQUAL VOLUME PROFILES

        String[] TricepsExercises = {"Triceps Extension", "Ring Overhead Extension", "Bench Dip"};
        List<String> TricepsList = Arrays.asList(TricepsExercises);
        String[] absExercises = {"Hanging Leg Raise", "Reverse Crunches", "Pulse Up", "Band Crunch", "V-Up", "Ab Rollout"};
        List<String> absList = Arrays.asList(absExercises);
        String[] obliqueAbTransverseExercises = {"Elbow to Knee Tucks", "Rotating Plank", "Elbow to Knee Plank", "X-Crunch"};
        List<String> obliqueAbTransverseList = Arrays.asList(obliqueAbTransverseExercises);

        //CHECK WHICH DIALOG TO OPEN FOR PROPER VOLUME INPUT
        if (exercise.equals("Head Floats")) {
            AddNeckVolumeDialog exampleDialog = new AddNeckVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Neck Flexion")) {
            AddNeckVolumeDialog exampleDialog = new AddNeckVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Angels of Death")) {
            AddAngelOfDeathDialog exampleDialog = new AddAngelOfDeathDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Trap Pushaway")) {
            AddUpperTrapVolumeDialog exampleDialog = new AddUpperTrapVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Pushups")) {
            AddDipDialog exampleDialog = new AddDipDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Leg Raises")) {
            AddAbsVolumeDialog exampleDialog = new AddAbsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Bulgarian Split Squat") || exercise.equals("Explosive Bulgarian Split Squat")) {
            AddQuadsGluteMediusDialog exampleDialog = new AddQuadsGluteMediusDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Bodyweight Squats")) {
            QuadsHalfGlute exampleDialog = new QuadsHalfGlute(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Hanging Scapular Retraction") || exercise.equals("Floor Scapular Depression")) {
            AddLowerTrapVolumeDialog exampleDialog = new AddLowerTrapVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Marching Bridge")) {
            AddGluteErectorDialog exampleDialog = new AddGluteErectorDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Reverse Hyperextension")) {
            AddGluteHamDialog exampleDialog = new AddGluteHamDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Lunges")) {
            QuadsGluteGluteMediusDialog exampleDialog = new QuadsGluteGluteMediusDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Physioball Hamstring Curls")) {
            AddHamGluteDialog exampleDialog2 = new AddHamGluteDialog(this);
            exampleDialog2.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Glute Side Bridge")) {
            GluteMediusHalfObliques exampleDialog = new GluteMediusHalfObliques(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Lateral raise") || exercise.equals("Delt Rotating Plank")) {
            AddMedialDeltoidVolumeDialog exampleDialog = new AddMedialDeltoidVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Abduction")) {
            AddGluteMediusVolumeDialog exampleDialog = new AddGluteMediusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Lunge")) {
            AddQuadsVolumeDialog exampleDialog = new AddQuadsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Lateral Raise")) {
            AddMedialDeltoidVolumeDialog exampleDialog = new AddMedialDeltoidVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Pistol Squats")) {
            AddPistolSquatDialog exampleDialog = new AddPistolSquatDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Band/Bodyweight Lunge")) {
            AddQuadsGluteMediusDialog exampleDialog = new AddQuadsGluteMediusDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Wrist Extension")) {
            AddForearmExtensorVolumeDialog exampleDialog = new AddForearmExtensorVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded/Cable Step Out")) {
            ObliqueDiaphragmDialog exampleDialog = new ObliqueDiaphragmDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Bodyweight Calf Raise")) {
            AddCalvesVolumeDialog exampleDialog = new AddCalvesVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Side Lunges")) {
            SideLungeDialog exampleDialog = new SideLungeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Sprinter Lunge")) {
            SprinterLungeDialog exampleDialog = new SprinterLungeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Isolateral Hamstring Curls")) {
            AddIsoRDLDialog exampleDialog = new AddIsoRDLDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Wall Sit")) {
            AddQuadsVolumeDialog exampleDialog = new AddQuadsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded/Cable/ Resisted Rotation")) {
            ObliqueDiaphragmFullDialog exampleDialog = new ObliqueDiaphragmFullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Vacuums")) {
            AddDiaphragmVolumeDialog exampleDialog = new AddDiaphragmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Leg Raise Scissors")) {
            ObliqueAbDiaphragmFullDialog exampleDialog = new ObliqueAbDiaphragmFullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Twisting Leg Raise")) {
            ObliqueAbDiaphragmDialog exampleDialog = new ObliqueAbDiaphragmDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Twisting Pulse Up")) {
            ObliqueAbDiaphragmFullDialog exampleDialog = new ObliqueAbDiaphragmFullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Ab Circles")) {
            AbCirclesDialog exampleDialog = new AbCirclesDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Plank Protraction")) {
            AddProtractionDialog exampleDialog = new AddProtractionDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded/Cable Punches")) {
            AddSerratusVolumeDialog exampleDialog = new AddSerratusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Narrow Dip")) {
            AddChestTricepsDialog exampleDialog = new AddChestTricepsDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Isolateral Hip Thrust")) {
            AddIsoHipThrustDialog exampleDialog = new AddIsoHipThrustDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Radial Deviation")) {
            AddRadialForearmVolumeDialog exampleDialog = new AddRadialForearmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Inverted Y") || exercise.equals("W's")) {
            AddUpperTrapVolumeDialog exampleDialog = new AddUpperTrapVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded RDL")) {
            GluteGluteMediusHamstrings exampleDialog = new GluteGluteMediusHamstrings(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Wide Dip") || exercise.equals("Narrow Pushup")) {
            AddDipDialog exampleDialog = new AddDipDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Ulnar Deviation")) {
            AddUlnarForearmVolumeDialog exampleDialog = new AddUlnarForearmVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Frog Pumps")) {
            ErectorGluteMedius exampleDialog = new ErectorGluteMedius(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Push Up")) {
            AddChestPressDialog exampleDialog = new AddChestPressDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Ring Facepulls")) {
            AddFacePullDialog exampleDialog = new AddFacePullDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Pull Aparts")) {
            AddLowerTrapPostDeltDialog exampleDialog = new AddLowerTrapPostDeltDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Handstand Pushup") || exercise.equals("Pike Pushup")) {
            OHPDialog exampleDialog = new OHPDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded External Rotation")) {
            AddRotatorCuffVolumeDialog exampleDialog = new AddRotatorCuffVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (TricepsList.contains(exercise)) {
            AddTricepsVolumeDialog exampleDialog = new AddTricepsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Wrist Curls")) {
            AddForearmFlexorVolumeDialog exampleDialog = new AddForearmFlexorVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Wrist Flexed Curls")) {
            AddForearmCurlsDialog exampleDialog = new AddForearmCurlsDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Banded Curls") || exercise.equals("Ring Curls")) {
            AddBicepsVolumeDialog exampleDialog = new AddBicepsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Australian Pull Up") || exercise.equals("Ring Rows")) {
            AddRowsVolumeDialog exampleDialog = new AddRowsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Front Levers")) {
            AddLatLeverVolumeDialog exampleDialog = new AddLatLeverVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Pull Ups")) {
            AddPullUpVolumeDialog exampleDialog = new AddPullUpVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Pull ins")) {
            AddLatsVolumeDialog exampleDialog = new AddLatsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Chin Ups")) {
            AddChinUpsVolumeDialog exampleDialog = new AddChinUpsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Bodyweight Hip Thrust")) {
            AddHipThrustVolumeDialog exampleDialog = new AddHipThrustVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Floor T's")) {
            AddPosteriorDeltoidVolumeDialog exampleDialog = new AddPosteriorDeltoidVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Hamstring Curls")) {
            AddHamGluteDialog exampleDialog = new AddHamGluteDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (exercise.equals("Plank/Dip Protraction") || exercise.equals("Protracted Roll Out")) {
            AddAbsSerratusVolumeDialog exampleDialog = new AddAbsSerratusVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (obliqueAbTransverseList.contains(exercise)) {
            ObliqueAbDiaphragmDialog exampleDialog = new ObliqueAbDiaphragmDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (absList.contains(exercise)) {
            AddAbsVolumeDialog exampleDialog = new AddAbsVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else {
            Toast toast = Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 120);
            toast.show();
        }
    }

}