package com.example.scifit.Classes.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.AddVolume.AbsVolume;
import com.example.scifit.AddVolume.AnteriorDeltoidVolume;
import com.example.scifit.AddVolume.BicepsVolume;
import com.example.scifit.AddVolume.CalvesVolume;
import com.example.scifit.AddVolume.ChestVolume;
import com.example.scifit.AddVolume.DiaphragmVolume;
import com.example.scifit.AddVolume.ErectorsVolume;
import com.example.scifit.AddVolume.ForearmExtensorsVolume;
import com.example.scifit.AddVolume.ForearmFlexorsVolume;
import com.example.scifit.AddVolume.GluteMediusVolume;
import com.example.scifit.AddVolume.GlutesVolume;
import com.example.scifit.AddVolume.HamstringsVolume;
import com.example.scifit.AddVolume.LatsVolume;
import com.example.scifit.AddVolume.LowerTrapsVolume;
import com.example.scifit.AddVolume.MedialDeltoidVolume;
import com.example.scifit.AddVolume.NeckVolume;
import com.example.scifit.AddVolume.ObliquesVolume;
import com.example.scifit.AddVolume.PosteriorDeltoidVolume;
import com.example.scifit.AddVolume.QuadsVolume;
import com.example.scifit.AddVolume.RadialForearmVolume;
import com.example.scifit.AddVolume.RotatorCuffVolume;
import com.example.scifit.AddVolume.SerratusVolume;
import com.example.scifit.AddVolume.TricepsVolume;
import com.example.scifit.AddVolume.UlnarForearmVolume;
import com.example.scifit.AddVolume.UpperTrapVolume;
import com.example.scifit.Classes.Adapters.GlobalAdapter;
import com.example.scifit.Classes.Adapters.GlobalExerciseListAdapter;
import com.example.scifit.Classes.Adapters.MuscleListAdapter;
import com.example.scifit.Classes.MuscleGroupObjects.MuscleList;
import com.example.scifit.DashBoardTabs.Dashboards;
import com.example.scifit.Excercises.GlobalExercise;
import com.example.scifit.MuscleGroupInfo.Abs;
import com.example.scifit.MuscleGroupInfo.AnteriorDeltoid;
import com.example.scifit.MuscleGroupInfo.Biceps;
import com.example.scifit.MuscleGroupInfo.Calves;
import com.example.scifit.MuscleGroupInfo.Chest;
import com.example.scifit.MuscleGroupInfo.Diaphragm;
import com.example.scifit.MuscleGroupInfo.Erectors;
import com.example.scifit.MuscleGroupInfo.ForearmExtensors;
import com.example.scifit.MuscleGroupInfo.ForearmFlexors;
import com.example.scifit.MuscleGroupInfo.GluteMedius;
import com.example.scifit.MuscleGroupInfo.Glutes;
import com.example.scifit.MuscleGroupInfo.Hamstrings;
import com.example.scifit.MuscleGroupInfo.Lats;
import com.example.scifit.MuscleGroupInfo.LowerTrap;
import com.example.scifit.MuscleGroupInfo.MedialDeltoid;
import com.example.scifit.MuscleGroupInfo.Neck;
import com.example.scifit.MuscleGroupInfo.Obliques;
import com.example.scifit.MuscleGroupInfo.PosteriorDeltoid;
import com.example.scifit.MuscleGroupInfo.Quads;
import com.example.scifit.MuscleGroupInfo.RadialForearm;
import com.example.scifit.MuscleGroupInfo.RotatorCuff;
import com.example.scifit.MuscleGroupInfo.Serratus;
import com.example.scifit.MuscleGroupInfo.Triceps;
import com.example.scifit.MuscleGroupInfo.UlnarForearm;
import com.example.scifit.MuscleGroupInfo.UpperTrap;
import com.example.scifit.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class VolumeTrackerFragment extends Fragment implements MuscleListAdapter.OnItemClickListener {
    private MuscleListAdapter mAdapter;
    //NECK
    public static final String NECK_TALLY = "com.example.application.scifit.NECK_TALLY";
    public static final String NECKPROGRESS = "NECKPROGRESS";
    public static final String NECKMAX = "NECKMAX";
    public static final String PREFS = "PREFS";
    int neckTally;
    int neckMaxTimesTen;
    int neckProgressTimesTen;
    String neckProgress;
    String neckMax;
    //UPPER TRAPS
    public static final String UPPERTRAP_TALLY = "com.example.application.scifit.UPPERTRAP_TALLY";
    public static final String UPPERTRAPPROGRESS = "UPPERTRAPPROGRESS";
    public static final String UPPERTRAPMAX = "UPPERTRAPMAX";
    public int upperTrapTally;
    public int upperTrapMaxTimesTen;
    int upperTrapProgressTimesTen;
    String upperTrapProgress;
    String upperTrapMax;
    //Lower TRAPS
    public static final String LOWERTRAP_TALLY= "com.example.application.scifit.LOWERTRAP_TALLY";
    public static final String LOWERTRAPPROGRESS = "LOWERTRAPPROGRESS";
    public static final String LOWERTRAPMAX = "LOWERTRAPMAX";
    public int lowerTrapTally;
    public int lowerTrapMaxTimesTen;
    int lowerTrapProgressTimesTen;
    String lowerTrapProgress;
    String lowerTrapMax;
    //Posterior Deltoid
    public static final String POSTERIORDELTOID_TALLY = "com.example.application.scifit.POSTERIORDELTOID_TALLY";
    public static final String POSTERIORDELTOIDPROGRESS = "POSTERIORDELTOIDPROGRESS";
    public static final String POSTERIORDELTOIDMAX = "POSTERIORDELTOIDMAX";
    public int posteriorDeltoidTally;
    public int posteriorDeltoidMaxTimesTen;
    int posteriorDeltoidProgressTimesTen;
    String posteriorDeltoidProgress;
    String posteriorDeltoidMax;
    //Posterior Deltoid
    public static final String MEDIALDELTOID_TALLY = "com.example.application.scifit.MEDIALDELTOID_TALLY";
    public static final String MEDIALDELTOIDPROGRESS = "MEDIALDELTOIDPROGRESS";
    public static final String MEDIALDELTOIDMAX = "MEDIALDELTOIDMAX";
    public int medialDeltoidTally;
    public int medialDeltoidMaxTimesTen;
    int medialDeltoidProgressTimesTen;
    String medialDeltoidProgress;
    String medialDeltoidMax;
    //ANTERIOR DELTOID
    public static final String ANTERIORDELTOID_TALLY = "com.example.application.scifit.ANTERIORDELTOID_TALLY";
    public static final String ANTERIORDELTOIDPROGRESS = "ANTERIORDELTOIDPROGRESS";
    public static final String ANTERIORDELTOIDMAX = "ANTERIORDELTOIDMAX";
    public int anteriorDeltoidTally;
    public int anteriorDeltoidMaxTimesTen;
    int anteriorDeltoidProgressTimesTen;
    String anteriorDeltoidProgress;
    String anteriorDeltoidMax;

    //ROTATOR CUFF
    public static final String ROTATORCUFF_TALLY = "com.example.application.scifit.ROTATORCUFF_TALLY";
    public static final String ROTATORCUFFPROGRESS = "ROTATORCUFFPROGRESS";
    public static final String ROTATORCUFFMAX = "ROTATORCUFFMAX";
    int rotatorCuffTally;
    int rotatorCuffMaxTimesTen;
    int rotatorCuffProgressTimesTen;
    String rotatorCuffProgress;
    String rotatorCuffMax;

    //TRICEP
    public static final String TRICEP_TALLY = "com.example.application.scifit.TRICEP_TALLY";
    public static final String TRICEPPROGRESS = "TRICEPPROGRESS";
    public static final String TRICEPMAX = "TRICEPMAX";
    int tricepTally;
    int tricepMaxTimesTen;
    int tricepProgressTimesTen;
    String tricepProgress;
    String tricepMax;

    //ULNARFOREARM
    public static final String ULNARFOREARM_TALLY = "com.example.application.scifit.ULNARFOREARM_TALLY";
    public static final String ULNARFOREARMPROGRESS = "ULNARFOREARMPROGRESS";
    public static final String ULNARFOREARMMAX = "ULNARFOREARMMAX";
    int ulnarForearmTally;
    int ulnarForearmMaxTimesTen;
    int ulnarForearmProgressTimesTen;
    String ulnarForearmProgress;
    String ulnarForearmMax;

    //FOREARMEXTENSORS
    public static final String FOREARMEXTENSORS_TALLY = "com.example.application.scifit.FOREARMEXTENSORS_TALLY";
    public static final String FOREARMEXTENSORSPROGRESS = "FOREARMEXTENSORSPROGRESS";
    public static final String FOREARMEXTENSORSMAX = "FOREARMEXTENSORSMAX";
    int forearmExtensorsTally;
    int forearmExtensorsMaxTimesTen;
    int forearmExtensorsProgressTimesTen;
    String forearmExtensorsProgress;
    String forearmExtensorsMax;

    //FOREARMFLEXORS
    public static final String FOREARMFLEXORS_TALLY = "com.example.application.scifit.FOREARMFLEXORS_TALLY";
    public static final String FOREARMFLEXORSPROGRESS = "FOREARMFLEXORSPROGRESS";
    public static final String FOREARMFLEXORSMAX = "FOREARMFLEXORSMAX";
    int forearmFlexorsTally;
    int forearmFlexorsMaxTimesTen;
    int forearmFlexorsProgressTimesTen;
    String forearmFlexorsProgress;
    String forearmFlexorsMax;

    //ANTERIOR DELTOID
    public static final String RADIALFOREARM_TALLY = "com.example.application.scifit.RADIALFOREARM_TALLY";
    public static final String RADIALFOREARMPROGRESS = "RADIALFOREARMPROGRESS";
    public static final String RADIALFOREARMMAX = "RADIALFOREARMMAX";
    public int radialForearmTally;
    public int radialForearmMaxTimesTen;
    int radialForearmProgressTimesTen;
    String radialForearmProgress;
    String radialForearmMax;

    //LATS
    public static final String LATS_TALLY = "com.example.application.scifit.LATS_TALLY";
    public static final String LATSPROGRESS = "LATSPROGRESS";
    public static final String LATSMAX = "LATSMAX";
    public int latsTally;
    public int latsMaxTimesTen;
    int latsProgressTimesTen;
    String latsProgress;
    String latsMax;

    //ERECTORS
    public static final String ERECTORS_TALLY = "com.example.application.scifit.ERECTORS_TALLY";
    public static final String ERECTORSPROGRESS = "ERECTORSPROGRESS";
    public static final String ERECTORSMAX = "ERECTORSMAX";
    public int erectorsTally;
    public int erectorsMaxTimesTen;
    int erectorsProgressTimesTen;
    String erectorsProgress;
    String erectorsMax;

    //GLUTES
    public static final String GLUTES_TALLY = "com.example.application.scifit.GLUTES_TALLY";
    public static final String GLUTESPROGRESS = "GLUTESPROGRESS";
    public static final String GLUTESMAX = "GLUTESMAX";
    public int glutesTally;
    public int glutesMaxTimesTen;
    int glutesProgressTimesTen;
    String glutesProgress;
    String glutesMax;

    //GLUTEMEDIUS
    public static final String GLUTEMEDIUS_TALLY = "com.example.application.scifit.GLUTEMEDIUS_TALLY";
    public static final String GLUTEMEDIUSPROGRESS = "GLUTEMEDIUSPROGRESS";
    public static final String GLUTEMEDIUSMAX = "GLUTEMEDIUSMAX";
    public int gluteMediusTally;
    public int gluteMediusMaxTimesTen;
    int gluteMediusProgressTimesTen;
    String gluteMediusProgress;
    String gluteMediusMax;

    //HAMSTRINGS
    public static final String HAMSTRINGS_TALLY = "com.example.application.scifit.HAMSTRINGS_TALLY";
    public static final String HAMSTRINGSPROGRESS = "HAMSTRINGSPROGRESS";
    public static final String HAMSTRINGSMAX = "HAMSTRINGSMAX";
    public int hamstringsTally;
    public int hamstringsMaxTimesTen;
    int hamstringsProgressTimesTen;
    String hamstringsProgress;
    String hamstringsMax;

    //CALVES
    public static final String CALVES_TALLY = "com.example.application.scifit.CALVES_TALLY";
    public static final String CALVESPROGRESS = "CALVESPROGRESS";
    public static final String CALVESMAX = "CALVESMAX";
    public int calvesTally;
    public int calvesMaxTimesTen;
    int calvesProgressTimesTen;
    String calvesProgress;
    String calvesMax;

    //CHEST
    public static final String CHEST_TALLY = "com.example.application.scifit.CHEST_TALLY";
    public static final String CHESTPROGRESS = "CHESTPROGRESS";
    public static final String CHESTMAX = "CHESTMAX";
    public int chestTally;
    public int chestMaxTimesTen;
    int chestProgressTimesTen;
    String chestProgress;
    String chestMax;

    //BICEPS
    public static final String BICEPS_TALLY = "com.example.application.scifit.BICEPS_TALLY";
    public static final String BICEPSPROGRESS = "BICEPSPROGRESS";
    public static final String BICEPSMAX = "BICEPSMAX";
    public int bicepsTally;
    public int bicepsMaxTimesTen;
    int bicepsProgressTimesTen;
    String bicepsProgress;
    String bicepsMax;

    //SERRATUS
    public static final String SERRATUS_TALLY = "com.example.application.scifit.SERRATUS_TALLY";
    public static final String SERRATUSPROGRESS = "SERRATUSPROGRESS";
    public static final String SERRATUSMAX = "SERRATUSMAX";
    public int serratusTally;
    public int serratusMaxTimesTen;
    int serratusProgressTimesTen;
    String serratusProgress;
    String serratusMax;

    //ABS
    public static final String ABS_TALLY = "com.example.application.scifit.ABS_TALLY";
    public static final String ABSPROGRESS = "ABSPROGRESS";
    public static final String ABSMAX = "ABSMAX";
    public int absTally;
    public int absMaxTimesTen;
    int absProgressTimesTen;
    String absProgress;
    String absMax;

    //OBLIQUES
    public static final String OBLIQUES_TALLY = "com.example.application.scifit.OBLIQUES_TALLY";
    public static final String OBLIQUESPROGRESS = "OBLIQUESPROGRESS";
    public static final String OBLIQUESMAX = "OBLIQUESMAX";
    public int obliquesTally;
    public int obliquesMaxTimesTen;
    int obliquesProgressTimesTen;
    String obliquesProgress;
    String obliquesMax;

    //DIAPHRAGM
    public static final String DIAPHRAGM_TALLY = "com.example.application.scifit.DIAPHRAGM_TALLY";
    public static final String DIAPHRAGMPROGRESS = "DIAPHRAGMPROGRESS";
    public static final String DIAPHRAGMMAX = "DIAPHRAGMMAX";
    public int diaphragmTally;
    public int diaphragmMaxTimesTen;
    int diaphragmProgressTimesTen;
    String diaphragmProgress;
    String diaphragmMax;

    //QUADS
    public static final String QUADS_TALLY = "com.example.application.scifit.QUADS_TALLY";
    public static final String QUADSPROGRESS = "QUADSPROGRESS";
    public static final String QUADSMAX = "QUADSMAX";
    public int quadsTally;
    public int quadsMaxTimesTen;
    int quadsProgressTimesTen;
    String quadsProgress;
    String quadsMax;


    ExtendedFloatingActionButton fab;

    public VolumeTrackerFragment() {
        // Required empty public constructor
    }

    public static VolumeTrackerFragment newInstance(String param1, String param2) {
        VolumeTrackerFragment fragment = new VolumeTrackerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        SharedPreferences sp = context.getSharedPreferences("pref", 0);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // = container.getContext();
        View v = inflater.inflate(R.layout.fragment_volume_tracker, container, false);
        SharedPreferences sp = getActivity().getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


        //NECK
        neckTally = sp.getInt(NECK_TALLY, 0);
        neckMaxTimesTen = sp.getInt(NECKMAX, 100);
        neckProgressTimesTen = sp.getInt(NECKPROGRESS, 0);
        neckProgressTimesTen = neckProgressTimesTen + neckTally;
        editor.putInt(NECKPROGRESS, neckProgressTimesTen).apply();
        float neckProgressTimesTenFloat = (float) neckProgressTimesTen;
        neckProgress = String.valueOf(neckProgressTimesTenFloat / 10.00);
        neckMax = String.valueOf(neckMaxTimesTen / 10);
        sp.edit().remove(NECK_TALLY).apply();

        //UPPERTRAP
        upperTrapTally = sp.getInt(UPPERTRAP_TALLY, 0);
        upperTrapMaxTimesTen = sp.getInt(UPPERTRAPMAX, 120);
        upperTrapProgressTimesTen = sp.getInt(UPPERTRAPPROGRESS, 0);
        upperTrapProgressTimesTen = upperTrapProgressTimesTen + upperTrapTally;
        editor.putInt(UPPERTRAPPROGRESS, upperTrapProgressTimesTen).apply();
        float upperTrapProgressTimesTenFloat = (float) upperTrapProgressTimesTen;
        upperTrapProgress = String.valueOf(upperTrapProgressTimesTenFloat / 10.00);
        upperTrapMax = String.valueOf(upperTrapMaxTimesTen / 10);
        sp.edit().remove(UPPERTRAP_TALLY).apply();

        //LOWERTRAP
        lowerTrapTally = sp.getInt(LOWERTRAP_TALLY, 0);
        lowerTrapMaxTimesTen = sp.getInt(LOWERTRAPMAX, 120);
        lowerTrapProgressTimesTen = sp.getInt(LOWERTRAPPROGRESS, 0);
        lowerTrapProgressTimesTen = lowerTrapProgressTimesTen + lowerTrapTally;
        editor.putInt(LOWERTRAPPROGRESS, lowerTrapProgressTimesTen).apply();
        float lowerTrapProgressTimesTenFloat = (float) lowerTrapProgressTimesTen;
        lowerTrapProgress = String.valueOf(lowerTrapProgressTimesTenFloat / 10.00);
        lowerTrapMax = String.valueOf(lowerTrapMaxTimesTen / 10);
        sp.edit().remove(LOWERTRAP_TALLY).apply();

        //POSTERIORDELTOID
        posteriorDeltoidTally = sp.getInt(POSTERIORDELTOID_TALLY, 0);
        posteriorDeltoidMaxTimesTen = sp.getInt(POSTERIORDELTOIDMAX, 160);
        posteriorDeltoidProgressTimesTen = sp.getInt(POSTERIORDELTOIDPROGRESS, 0);
        posteriorDeltoidProgressTimesTen = posteriorDeltoidProgressTimesTen + posteriorDeltoidTally;
        editor.putInt(POSTERIORDELTOIDPROGRESS, posteriorDeltoidProgressTimesTen).apply();
        float posteriorDeltoidProgressTimesTenFloat = (float) posteriorDeltoidProgressTimesTen;
        posteriorDeltoidProgress = String.valueOf(posteriorDeltoidProgressTimesTenFloat / 10.00);
        posteriorDeltoidMax = String.valueOf(posteriorDeltoidMaxTimesTen / 10);
        sp.edit().remove(POSTERIORDELTOID_TALLY).apply();
        //MEDIALDELTOID
        medialDeltoidTally = sp.getInt(MEDIALDELTOID_TALLY, 0);
        medialDeltoidMaxTimesTen = sp.getInt(MEDIALDELTOIDMAX, 160);
        medialDeltoidProgressTimesTen = sp.getInt(MEDIALDELTOIDPROGRESS, 0);
        medialDeltoidProgressTimesTen = medialDeltoidProgressTimesTen + medialDeltoidTally;
        editor.putInt(MEDIALDELTOIDPROGRESS, medialDeltoidProgressTimesTen).apply();
        float medialDeltoidProgressTimesTenFloat = (float) medialDeltoidProgressTimesTen;
        medialDeltoidProgress = String.valueOf(medialDeltoidProgressTimesTenFloat / 10.00);
        medialDeltoidMax = String.valueOf(medialDeltoidMaxTimesTen / 10);
        sp.edit().remove(MEDIALDELTOID_TALLY).apply();

        //ANTERIORDELTOID
        anteriorDeltoidTally = sp.getInt(ANTERIORDELTOID_TALLY, 0);
        anteriorDeltoidMaxTimesTen = sp.getInt(ANTERIORDELTOIDMAX, 60);
        anteriorDeltoidProgressTimesTen = sp.getInt(ANTERIORDELTOIDPROGRESS, 0);
        anteriorDeltoidProgressTimesTen = anteriorDeltoidProgressTimesTen + anteriorDeltoidTally;
        editor.putInt(ANTERIORDELTOIDPROGRESS, anteriorDeltoidProgressTimesTen).apply();
        float anteriorDeltoidProgressTimesTenFloat = (float) anteriorDeltoidProgressTimesTen;
        anteriorDeltoidProgress = String.valueOf(anteriorDeltoidProgressTimesTenFloat / 10.00);
        anteriorDeltoidMax = String.valueOf(anteriorDeltoidMaxTimesTen / 10);
        sp.edit().remove(ANTERIORDELTOID_TALLY).apply();

        //ROTATOR CUFF
        rotatorCuffTally = sp.getInt(ROTATORCUFF_TALLY, 0);
        rotatorCuffMaxTimesTen = sp.getInt(ROTATORCUFFMAX, 120);
        rotatorCuffProgressTimesTen = sp.getInt(ROTATORCUFFPROGRESS, 0);
        rotatorCuffProgressTimesTen = rotatorCuffProgressTimesTen + rotatorCuffTally;
        editor.putInt(ROTATORCUFFPROGRESS, rotatorCuffProgressTimesTen).apply();
        float rotatorCuffProgressTimesTenFloat = (float) rotatorCuffProgressTimesTen;
        rotatorCuffProgress = String.valueOf(rotatorCuffProgressTimesTenFloat / 10.00);
        rotatorCuffMax = String.valueOf(rotatorCuffMaxTimesTen / 10);
        sp.edit().remove(ROTATORCUFF_TALLY).apply();

        //TRICEP
        tricepTally = sp.getInt(TRICEP_TALLY, 0);
        tricepMaxTimesTen = sp.getInt(TRICEPMAX, 100);
        tricepProgressTimesTen = sp.getInt(TRICEPPROGRESS, 0);
        tricepProgressTimesTen = tricepProgressTimesTen + tricepTally;
        editor.putInt(TRICEPPROGRESS, tricepProgressTimesTen).apply();
        float tricepProgressTimesTenFloat = (float) tricepProgressTimesTen;
        tricepProgress = String.valueOf(tricepProgressTimesTenFloat / 10.00);
        tricepMax = String.valueOf(tricepMaxTimesTen / 10);
        sp.edit().remove(TRICEP_TALLY).apply();

        //ULNARFOREARM
        ulnarForearmTally = sp.getInt(ULNARFOREARM_TALLY, 0);
        ulnarForearmMaxTimesTen = sp.getInt(ULNARFOREARMMAX, 100);
        ulnarForearmProgressTimesTen = sp.getInt(ULNARFOREARMPROGRESS, 0);
        ulnarForearmProgressTimesTen = ulnarForearmProgressTimesTen + ulnarForearmTally;
        editor.putInt(ULNARFOREARMPROGRESS, ulnarForearmProgressTimesTen).apply();
        float ulnarForearmProgressTimesTenFloat = (float) ulnarForearmProgressTimesTen;
        ulnarForearmProgress = String.valueOf(ulnarForearmProgressTimesTenFloat / 10.00);
        ulnarForearmMax = String.valueOf(ulnarForearmMaxTimesTen / 10);
        sp.edit().remove(ULNARFOREARM_TALLY).apply();

        //FOREARMEXTENSORS
        forearmExtensorsTally = sp.getInt(FOREARMEXTENSORS_TALLY, 0);
        forearmExtensorsMaxTimesTen = sp.getInt(FOREARMEXTENSORSMAX, 100);
        forearmExtensorsProgressTimesTen = sp.getInt(FOREARMEXTENSORSPROGRESS, 0);
        forearmExtensorsProgressTimesTen = forearmExtensorsProgressTimesTen + forearmExtensorsTally;
        editor.putInt(FOREARMEXTENSORSPROGRESS, forearmExtensorsProgressTimesTen).apply();
        float forearmExtensorsProgressTimesTenFloat = (float) forearmExtensorsProgressTimesTen;
        forearmExtensorsProgress = String.valueOf(forearmExtensorsProgressTimesTenFloat / 10.00);
        forearmExtensorsMax = String.valueOf(forearmExtensorsMaxTimesTen / 10);
        sp.edit().remove(FOREARMEXTENSORS_TALLY).apply();

        //FOREARMFLEXORS
        forearmFlexorsTally = sp.getInt(FOREARMFLEXORS_TALLY, 0);
        forearmFlexorsMaxTimesTen = sp.getInt(FOREARMFLEXORSMAX, 100);
        forearmFlexorsProgressTimesTen = sp.getInt(FOREARMFLEXORSPROGRESS, 0);
        forearmFlexorsProgressTimesTen = forearmFlexorsProgressTimesTen + forearmFlexorsTally;
        editor.putInt(FOREARMFLEXORSPROGRESS, forearmFlexorsProgressTimesTen).apply();
        float forearmFlexorsProgressTimesTenFloat = (float) forearmFlexorsProgressTimesTen;
        forearmFlexorsProgress = String.valueOf(forearmFlexorsProgressTimesTenFloat / 10.00);
        forearmFlexorsMax = String.valueOf(forearmFlexorsMaxTimesTen / 10);
        sp.edit().remove(FOREARMFLEXORS_TALLY).apply();

        //RADIALFOREARM
        radialForearmTally = sp.getInt(RADIALFOREARM_TALLY, 0);
        radialForearmMaxTimesTen = sp.getInt(RADIALFOREARMMAX, 100);
        radialForearmProgressTimesTen = sp.getInt(RADIALFOREARMPROGRESS, 0);
        radialForearmProgressTimesTen = radialForearmProgressTimesTen + radialForearmTally;
        editor.putInt(RADIALFOREARMPROGRESS, radialForearmProgressTimesTen).apply();
        float radialForearmProgressTimesTenFloat = (float) radialForearmProgressTimesTen;
        radialForearmProgress = String.valueOf(radialForearmProgressTimesTenFloat/10.0);
        radialForearmMax = String.valueOf(radialForearmMaxTimesTen / 10);
        sp.edit().remove(RADIALFOREARM_TALLY).apply();
        //LATS
        latsTally = sp.getInt(LATS_TALLY, 0);
        latsMaxTimesTen = sp.getInt(LATSMAX, 120);
        latsProgressTimesTen = sp.getInt(LATSPROGRESS, 0);
        latsProgressTimesTen = latsProgressTimesTen + latsTally;
        editor.putInt(LATSPROGRESS, latsProgressTimesTen).apply();
        float latsProgressTimesTenFloat = (float) latsProgressTimesTen;
        latsProgress = String.valueOf(latsProgressTimesTenFloat / 10.00);
        latsMax = String.valueOf(latsMaxTimesTen / 10);
        sp.edit().remove(LATS_TALLY).apply();
        //ERECTORS
        erectorsTally = sp.getInt(ERECTORS_TALLY, 0);
        erectorsMaxTimesTen = sp.getInt(ERECTORSMAX, 100);
        erectorsProgressTimesTen = sp.getInt(ERECTORSPROGRESS, 0);
        erectorsProgressTimesTen = erectorsProgressTimesTen + erectorsTally;
        editor.putInt(ERECTORSPROGRESS, erectorsProgressTimesTen).apply();
        float erectorsProgressTimesTenFloat = (float) erectorsProgressTimesTen;
        erectorsProgress = String.valueOf(erectorsProgressTimesTenFloat / 10.00);
        erectorsMax = String.valueOf(erectorsMaxTimesTen / 10);
        sp.edit().remove(ERECTORS_TALLY).apply();
        //GLUTES
        glutesTally = sp.getInt(GLUTES_TALLY, 0);
        glutesMaxTimesTen = sp.getInt(GLUTESMAX, 40);
        glutesProgressTimesTen = sp.getInt(GLUTESPROGRESS, 0);
        glutesProgressTimesTen = glutesProgressTimesTen + glutesTally;
        editor.putInt(GLUTESPROGRESS, glutesProgressTimesTen).apply();
        float glutesProgressTimesTenFloat = (float) glutesProgressTimesTen;
        glutesProgress = String.valueOf(glutesProgressTimesTenFloat / 10.00);
        glutesMax = String.valueOf(glutesMaxTimesTen / 10);
        sp.edit().remove(GLUTES_TALLY).apply();
        //GLUTEMEDIUS
        gluteMediusTally = sp.getInt(GLUTEMEDIUS_TALLY, 0);
        gluteMediusMaxTimesTen = sp.getInt(GLUTEMEDIUSMAX, 120);
        gluteMediusProgressTimesTen = sp.getInt(GLUTEMEDIUSPROGRESS, 0);
        gluteMediusProgressTimesTen = gluteMediusProgressTimesTen + gluteMediusTally;
        editor.putInt(GLUTEMEDIUSPROGRESS, gluteMediusProgressTimesTen).apply();
        float gluteMediusProgressTimesTenFloat = (float) gluteMediusProgressTimesTen;
        gluteMediusProgress = String.valueOf(gluteMediusProgressTimesTenFloat / 10.00);
        gluteMediusMax = String.valueOf(gluteMediusMaxTimesTen / 10);
        sp.edit().remove(GLUTEMEDIUS_TALLY).apply();
        //HAMSTRINGS
        hamstringsTally = sp.getInt(HAMSTRINGS_TALLY, 0);
        hamstringsMaxTimesTen = sp.getInt(HAMSTRINGSMAX, 100);
        hamstringsProgressTimesTen = sp.getInt(HAMSTRINGSPROGRESS, 0);
        hamstringsProgressTimesTen = hamstringsProgressTimesTen + hamstringsTally;
        editor.putInt(HAMSTRINGSPROGRESS, hamstringsProgressTimesTen).apply();
        float hamstringsProgressTimesTenFloat = (float) hamstringsProgressTimesTen;
        hamstringsProgress = String.valueOf(hamstringsProgressTimesTenFloat / 10.00);
        hamstringsMax = String.valueOf(hamstringsMaxTimesTen / 10);
        sp.edit().remove(HAMSTRINGS_TALLY).apply();
        //CALVES
        calvesTally = sp.getInt(CALVES_TALLY, 0);
        calvesMaxTimesTen = sp.getInt(CALVESMAX, 120);
        calvesProgressTimesTen = sp.getInt(CALVESPROGRESS, 0);
        calvesProgressTimesTen = calvesProgressTimesTen + calvesTally;
        editor.putInt(CALVESPROGRESS, calvesProgressTimesTen).apply();
        float calvesProgressTimesTenFloat = (float) calvesProgressTimesTen;
        calvesProgress = String.valueOf(calvesProgressTimesTenFloat / 10.00);
        calvesMax = String.valueOf(calvesMaxTimesTen / 10);
        sp.edit().remove(CALVES_TALLY).apply();
        //CHEST
        chestTally = sp.getInt(CHEST_TALLY, 0);
        chestMaxTimesTen = sp.getInt(CHESTMAX, 120);
        chestProgressTimesTen = sp.getInt(CHESTPROGRESS, 0);
        chestProgressTimesTen = chestProgressTimesTen + chestTally;
        editor.putInt(CHESTPROGRESS, chestProgressTimesTen).apply();
        float chestProgressTimesTenFloat = (float) chestProgressTimesTen;
        chestProgress = String.valueOf(chestProgressTimesTenFloat / 10.00);
        chestMax = String.valueOf(chestMaxTimesTen / 10);
        sp.edit().remove(CHEST_TALLY).apply();
        //BICEPS
        bicepsTally = sp.getInt(BICEPS_TALLY, 0);
        bicepsMaxTimesTen = sp.getInt(BICEPSMAX, 140);
        bicepsProgressTimesTen = sp.getInt(BICEPSPROGRESS, 0);
        bicepsProgressTimesTen = bicepsProgressTimesTen + bicepsTally;
        editor.putInt(BICEPSPROGRESS, bicepsProgressTimesTen).apply();
        float bicepsProgressTimesTenFloat = (float) bicepsProgressTimesTen;
        bicepsProgress = String.valueOf(bicepsProgressTimesTenFloat / 10.00);
        bicepsMax = String.valueOf(bicepsMaxTimesTen / 10);
        sp.edit().remove(BICEPS_TALLY).apply();
        //SERRATUS
        serratusTally = sp.getInt(SERRATUS_TALLY, 0);
        serratusMaxTimesTen = sp.getInt(SERRATUSMAX, 160);
        serratusProgressTimesTen = sp.getInt(SERRATUSPROGRESS, 0);
        serratusProgressTimesTen = serratusProgressTimesTen + serratusTally;
        editor.putInt(SERRATUSPROGRESS, serratusProgressTimesTen).apply();
        float serratusProgressTimesTenFloat = (float) serratusProgressTimesTen;
        serratusProgress = String.valueOf(serratusProgressTimesTenFloat / 10.00);
        serratusMax = String.valueOf(serratusMaxTimesTen / 10);
        sp.edit().remove(SERRATUS_TALLY).apply();
        //ABS
        absTally = sp.getInt(ABS_TALLY, 0);
        absMaxTimesTen = sp.getInt(ABSMAX, 160);
        absProgressTimesTen = sp.getInt(ABSPROGRESS, 0);
        absProgressTimesTen = absProgressTimesTen + absTally;
        editor.putInt(ABSPROGRESS, absProgressTimesTen).apply();
        float absProgressTimesTenFloat = (float) absProgressTimesTen;
        absProgress = String.valueOf(absProgressTimesTenFloat / 10.00);
        absMax = String.valueOf(absMaxTimesTen / 10);
        sp.edit().remove(ABS_TALLY).apply();
        //OBLIQUES
        obliquesTally = sp.getInt(OBLIQUES_TALLY, 0);
        obliquesMaxTimesTen = sp.getInt(OBLIQUESMAX, 160);
        obliquesProgressTimesTen = sp.getInt(OBLIQUESPROGRESS, 0);
        obliquesProgressTimesTen = obliquesProgressTimesTen + obliquesTally;
        editor.putInt(OBLIQUESPROGRESS, obliquesProgressTimesTen).apply();
        float obliquesProgressTimesTenFloat = (float) obliquesProgressTimesTen;
        obliquesProgress = String.valueOf(obliquesProgressTimesTenFloat / 10.00);
        obliquesMax = String.valueOf(obliquesMaxTimesTen / 10);
        sp.edit().remove(OBLIQUES_TALLY).apply();
        //DIAPHRAGM
        diaphragmTally = sp.getInt(DIAPHRAGM_TALLY, 0);
        diaphragmMaxTimesTen = sp.getInt(DIAPHRAGMMAX, 160);
        diaphragmProgressTimesTen = sp.getInt(DIAPHRAGMPROGRESS, 0);
        diaphragmProgressTimesTen = diaphragmProgressTimesTen + diaphragmTally;
        editor.putInt(DIAPHRAGMPROGRESS, diaphragmProgressTimesTen).apply();
        float diaphragmProgressTimesTenFloat = (float) diaphragmProgressTimesTen;
        diaphragmProgress = String.valueOf(diaphragmProgressTimesTenFloat / 10.00);
        diaphragmMax = String.valueOf(diaphragmMaxTimesTen / 10);
        sp.edit().remove(DIAPHRAGM_TALLY).apply();
        //QUADS
        quadsTally = sp.getInt(QUADS_TALLY, 0);
        quadsMaxTimesTen = sp.getInt(QUADSMAX, 120);
        quadsProgressTimesTen = sp.getInt(QUADSPROGRESS, 0);
        quadsProgressTimesTen = quadsProgressTimesTen + quadsTally;
        editor.putInt(QUADSPROGRESS, quadsProgressTimesTen).apply();
        float quadsProgressTimesTenFloat = (float) quadsProgressTimesTen;
        quadsProgress = String.valueOf(quadsProgressTimesTenFloat / 10.00);
        quadsMax = String.valueOf(quadsMaxTimesTen / 10);
        sp.edit().remove(QUADS_TALLY).apply();

        //ACTUAL PROGRAM
        //CreateList
        final ArrayList<MuscleList> muscleListList = new ArrayList<>();
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_white, "Neck", "MAV:10-16\nFREQ:2-3", neckProgress, neckMax, neckProgressTimesTen, neckMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_white, "Upper Traps", "MAV:12-20\nFREQ:2-6", upperTrapProgress, upperTrapMax, upperTrapProgressTimesTen, upperTrapMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Lower Traps", "MAV:12-20\nFREQ:2-6", lowerTrapProgress, lowerTrapMax, lowerTrapProgressTimesTen, lowerTrapMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Posterior Delt", "MAV:16-22\nFREQ:2-6", posteriorDeltoidProgress, posteriorDeltoidMax, posteriorDeltoidProgressTimesTen, posteriorDeltoidMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Medial Delt", "MAV:16-22\nFREQ:2-6", medialDeltoidProgress, medialDeltoidMax, medialDeltoidProgressTimesTen, medialDeltoidMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Anterior Delt", "MAV:6-8\nFREQ:1-2", anteriorDeltoidProgress, anteriorDeltoidMax, anteriorDeltoidProgressTimesTen, anteriorDeltoidMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Rotator Cuff", "MAV:12-20\nFREQ:3-6", rotatorCuffProgress, rotatorCuffMax, rotatorCuffProgressTimesTen, rotatorCuffMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Triceps", "MAV:10-14\nFREQ:2-4", tricepProgress, tricepMax, tricepProgressTimesTen, tricepMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Ulnar Forearm", "MAV:10-20\nFREQ:2-6", ulnarForearmProgress, ulnarForearmMax, ulnarForearmProgressTimesTen, ulnarForearmMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Forearm Extensors", "MAV:10-20\nFREQ:2-6", forearmExtensorsProgress, forearmExtensorsMax, forearmExtensorsProgressTimesTen, forearmExtensorsMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Forearm Flexors", "MAV:10-20\nFREQ:2-6", forearmFlexorsProgress, forearmFlexorsMax, forearmFlexorsProgressTimesTen, forearmFlexorsMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Radial Forearm", "MAV:10-20\nFREQ:2-6",  radialForearmProgress, radialForearmMax, radialForearmProgressTimesTen, radialForearmMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Lats", "MAV:12-22\nFREQ:2-4", latsProgress, latsMax, latsProgressTimesTen, latsMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Erectors", "MAV:10-15\nFREQ:2-4", erectorsProgress, erectorsMax, erectorsProgressTimesTen, erectorsMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Glutes", "MAV:4-12\nFREQ:2-3", glutesProgress, glutesMax, glutesProgressTimesTen, glutesMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Glute Medius", "MAV:12-15\nFREQ:2-4", gluteMediusProgress, gluteMediusMax, gluteMediusProgressTimesTen, gluteMediusMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Hamstrings", "MAV:10-16\nFREQ:2-3", hamstringsProgress, hamstringsMax, hamstringsProgressTimesTen, hamstringsMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Calves", "MAV:12-16\nFREQ:2-4", calvesProgress, calvesMax, calvesProgressTimesTen, calvesMaxTimesTen));
        //Upper, Middle, Lower
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Chest", "MAV:12-20\nFREQ:2-3", chestProgress, chestMax, chestProgressTimesTen, chestMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Biceps", "MAV:14-20\nFREQ:2-6", bicepsProgress, bicepsMax, bicepsProgressTimesTen, bicepsMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Serratus", "MAV:16-20\nFREQ:3-5", serratusProgress, serratusMax, serratusProgressTimesTen, serratusMaxTimesTen));
        //Upper, Middle, Lower
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Abs", "MAV:16-20\nFREQ:3-5", absProgress, absMax, absProgressTimesTen, absMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Obliques", "MAV:16-20\nFREQ:3-5", obliquesProgress, obliquesMax, obliquesProgressTimesTen, obliquesMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Diaphragm", "MAV:16-20\nFREQ:3-5", diaphragmProgress, diaphragmMax, diaphragmProgressTimesTen, diaphragmMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Quads", "MAV:12-18\nFREQ:1.5-3", quadsProgress, quadsMax, quadsProgressTimesTen, quadsMaxTimesTen));

        //Create Recycler View
        RecyclerView mRecyclerView = v.findViewById(R.id.musclesRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new MuscleListAdapter(muscleListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy){
                if (dy<0 && !fab.isShown())
                    fab.show();
                else if(dy>0 && fab.isShown())
                    fab.hide();
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        fab = v.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), GlobalExercise.class));
            }
        });
    return v;
    }

    @Override
    public void onItemCLick(int position) {
        switch (position) {
            case 0:
                Intent intent = new Intent(getContext(), Neck.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent2 = new Intent(getContext(), UpperTrap.class);
                startActivity(intent2);
                break;
            case 2:
                Intent intent3 = new Intent(getContext(), LowerTrap.class);
                startActivity(intent3);
                break;
            case 3:
                Intent intent4 = new Intent(getContext(), PosteriorDeltoid.class);
                startActivity(intent4);
                break;
            case 4:
                Intent intent5 = new Intent(getContext(), MedialDeltoid.class);
                startActivity(intent5);
                break;
            case 5:
                Intent intent6 = new Intent(getContext(), AnteriorDeltoid.class);
                startActivity(intent6);
                break;
            case 6:
                Intent intent7 = new Intent(getContext(), RotatorCuff.class);
                startActivity(intent7);
                break;
            case 7:
                Intent intent8 = new Intent(getContext(), Triceps.class);
                startActivity(intent8);
                break;
            case 8:
                Intent intent9 = new Intent(getContext(), UlnarForearm.class);
                startActivity(intent9);
                break;
            case 9:
                Intent intent10 = new Intent(getContext(), ForearmExtensors.class);
                startActivity(intent10);
                break;
            case 10:
                Intent intent11 = new Intent(getContext(), ForearmFlexors.class);
                startActivity(intent11);
                break;
            case 11:
                Intent intent12 = new Intent(getContext(), RadialForearm.class);
                startActivity(intent12);
                break;
            case 12:
                Intent intent13 = new Intent(getContext(), Lats.class);
                startActivity(intent13);
                break;
            case 13:
                Intent intent14 = new Intent(getContext(), Erectors.class);
                startActivity(intent14);
                break;
            case 14:
                Intent intent15 = new Intent(getContext(), Glutes.class);
                startActivity(intent15);
                break;
            case 15:
                Intent intent16 = new Intent(getContext(), GluteMedius.class);
                startActivity(intent16);
                break;
            case 16:
                Intent intent17 = new Intent(getContext(), Hamstrings.class);
                startActivity(intent17);
                break;
            case 17:
                Intent intent18 = new Intent(getContext(), Calves.class);
                startActivity(intent18);
                break;
            case 18:
                Intent intent19 = new Intent(getContext(), Chest.class);
                startActivity(intent19);
                break;
            case 19:
                Intent intent20 = new Intent(getContext(), Biceps.class);
                startActivity(intent20);
                break;
            case 20:
                Intent intent21 = new Intent(getContext(), Serratus.class);
                startActivity(intent21);
                break;
            case 21:
                Intent intent22 = new Intent(getContext(), Abs.class);
                startActivity(intent22);
                break;
            case 22:
                Intent intent23 = new Intent(getContext(), Obliques.class);
                startActivity(intent23);
                break;
            case 23:
                Intent intent24 = new Intent(getContext(), Diaphragm.class);
                startActivity(intent24);
                break;
            case 24:
                Intent intent25 = new Intent(getContext(), Quads.class);
                startActivity(intent25);
                break;

        }
    }
    @Override
    public void onAddVolumeClick(int position) {
        switch(position){
            case 0:
                Intent intent = new Intent(getContext(), NeckVolume.class);

                startActivity(intent);
                break;
            case 1:
                Intent intent2 = new Intent(getContext(), UpperTrapVolume.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent2);
                break;
            case 2:
                Intent intent3 = new Intent(getContext(), LowerTrapsVolume.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent3);
                break;
            case 3:
                Intent intent4 = new Intent(getContext(), PosteriorDeltoidVolume.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent4);
                break;
            case 4:
                Intent intent5 = new Intent(getContext(), MedialDeltoidVolume.class);
                startActivity(intent5);
                break;
            case 5:
                Intent intent6 = new Intent(getContext(), AnteriorDeltoidVolume.class);
                startActivity(intent6);
                break;
            case 6:
                Intent intent7 = new Intent(getContext(), RotatorCuffVolume.class);
                startActivity(intent7);
                break;
            case 7:
                Intent intent8 = new Intent(getContext(), TricepsVolume.class);
                startActivity(intent8);
                break;
            case 8:
                Intent intent9 = new Intent(getContext(), UlnarForearmVolume.class);
                startActivity(intent9);
                break;
            case 9:
                Intent intent10 = new Intent(getContext(), ForearmExtensorsVolume.class);
                startActivity(intent10);
                break;
            case 10:
                Intent intent11 = new Intent(getContext(), ForearmFlexorsVolume.class);
                startActivity(intent11);
                break;
            case 11:
                Intent intent12 = new Intent(getContext(), RadialForearmVolume.class);
                startActivity(intent12);
                break;
            case 12:
                Intent intent13 = new Intent(getContext(), LatsVolume.class);
                startActivity(intent13);
                break;
            case 13:
                Intent intent14 = new Intent(getContext(), ErectorsVolume.class);
                startActivity(intent14);
                break;
            case 14:
                Intent intent15 = new Intent(getContext(), GlutesVolume.class);
                startActivity(intent15);
                break;
            case 15:
                Intent intent16 = new Intent(getContext(), GluteMediusVolume.class);
                startActivity(intent16);
                break;
            case 16:
                Intent intent17 = new Intent(getContext(), HamstringsVolume.class);
                startActivity(intent17);
                break;
            case 17:
                Intent intent18 = new Intent(getContext(), CalvesVolume.class);
                startActivity(intent18);
                break;
            case 18:
                Intent intent19 = new Intent(getContext(), ChestVolume.class);
                startActivity(intent19);
                break;
            case 19:
                Intent intent20 = new Intent(getContext(), BicepsVolume.class);
                startActivity(intent20);
                break;
            case 20:
                Intent intent21 = new Intent(getContext(), SerratusVolume.class);
                startActivity(intent21);
                break;
            case 21:
                Intent intent22 = new Intent(getContext(), AbsVolume.class);
                startActivity(intent22);
                break;
            case 22:
                Intent intent23 = new Intent(getContext(), ObliquesVolume.class);
                startActivity(intent23);
                break;
            case 23:
                Intent intent24 = new Intent(getContext(), DiaphragmVolume.class);
                startActivity(intent24);
                break;
            case 24:
                Intent intent25 = new Intent(getContext(), QuadsVolume.class);
                startActivity(intent25);
                break;

        }
    }
}




