package Aesthet.X.adfree.Classes.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

import Aesthet.X.adfree.AddVolume.AbsVolume;
import Aesthet.X.adfree.AddVolume.AnteriorDeltoidVolume;
import Aesthet.X.adfree.AddVolume.BicepsVolume;
import Aesthet.X.adfree.AddVolume.CalvesVolume;
import Aesthet.X.adfree.AddVolume.ChestVolume;
import Aesthet.X.adfree.AddVolume.DiaphragmVolume;
import Aesthet.X.adfree.AddVolume.ErectorsVolume;
import Aesthet.X.adfree.AddVolume.ForearmExtensorsVolume;
import Aesthet.X.adfree.AddVolume.ForearmFlexorsVolume;
import Aesthet.X.adfree.AddVolume.GluteMediusVolume;
import Aesthet.X.adfree.AddVolume.GlutesVolume;
import Aesthet.X.adfree.AddVolume.HamstringsVolume;
import Aesthet.X.adfree.AddVolume.LatsVolume;
import Aesthet.X.adfree.AddVolume.LowerTrapsVolume;
import Aesthet.X.adfree.AddVolume.MedialDeltoidVolume;
import Aesthet.X.adfree.AddVolume.NeckVolume;
import Aesthet.X.adfree.AddVolume.ObliquesVolume;
import Aesthet.X.adfree.AddVolume.PosteriorDeltoidVolume;
import Aesthet.X.adfree.AddVolume.QuadsVolume;
import Aesthet.X.adfree.AddVolume.RadialForearmVolume;
import Aesthet.X.adfree.AddVolume.RotatorCuffVolume;
import Aesthet.X.adfree.AddVolume.SerratusVolume;
import Aesthet.X.adfree.AddVolume.TricepsVolume;
import Aesthet.X.adfree.AddVolume.UlnarForearmVolume;
import Aesthet.X.adfree.AddVolume.UpperTrapVolume;
import Aesthet.X.adfree.Classes.AdManager;
import Aesthet.X.adfree.Classes.Adapters.MuscleListAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.MuscleList;
import Aesthet.X.adfree.DashBoardTabs.Dashboards;
import Aesthet.X.adfree.Excercises.BWExercise;
import Aesthet.X.adfree.Excercises.GlobalExercise;
import Aesthet.X.adfree.MuscleGroupInfo.Abs;
import Aesthet.X.adfree.MuscleGroupInfo.AnteriorDeltoid;
import Aesthet.X.adfree.MuscleGroupInfo.Biceps;
import Aesthet.X.adfree.MuscleGroupInfo.Calves;
import Aesthet.X.adfree.MuscleGroupInfo.Chest;
import Aesthet.X.adfree.MuscleGroupInfo.Diaphragm;
import Aesthet.X.adfree.MuscleGroupInfo.Erectors;
import Aesthet.X.adfree.MuscleGroupInfo.ForearmExtensors;
import Aesthet.X.adfree.MuscleGroupInfo.ForearmFlexors;
import Aesthet.X.adfree.MuscleGroupInfo.GluteMedius;
import Aesthet.X.adfree.MuscleGroupInfo.Glutes;
import Aesthet.X.adfree.MuscleGroupInfo.Hamstrings;
import Aesthet.X.adfree.MuscleGroupInfo.Lats;
import Aesthet.X.adfree.MuscleGroupInfo.LowerTrap;
import Aesthet.X.adfree.MuscleGroupInfo.MedialDeltoid;
import Aesthet.X.adfree.MuscleGroupInfo.Neck;
import Aesthet.X.adfree.MuscleGroupInfo.Obliques;
import Aesthet.X.adfree.MuscleGroupInfo.PosteriorDeltoid;
import Aesthet.X.adfree.MuscleGroupInfo.Quads;
import Aesthet.X.adfree.MuscleGroupInfo.RadialForearm;
import Aesthet.X.adfree.MuscleGroupInfo.RotatorCuff;
import Aesthet.X.adfree.MuscleGroupInfo.Serratus;
import Aesthet.X.adfree.MuscleGroupInfo.Triceps;
import Aesthet.X.adfree.MuscleGroupInfo.UlnarForearm;
import Aesthet.X.adfree.MuscleGroupInfo.UpperTrap;
 import java.util.Random;

public class VolumeTrackerFragment extends Fragment implements MuscleListAdapter.OnItemClickListener {
    //NECK
    private static final String NECK_TALLY = "com.example.application.scifit.NECK_TALLY";
    private static final String NECKPROGRESS = "NECKPROGRESS";
    private static final String NECKMAX = "NECKMAX";
    private static final String PREFS = "PREFS";
    //UPPER TRAPS
    private static final String UPPERTRAP_TALLY = "com.example.application.scifit.UPPERTRAP_TALLY";
    private static final String UPPERTRAPPROGRESS = "UPPERTRAPPROGRESS";
    private static final String UPPERTRAPMAX = "UPPERTRAPMAX";
    //Lower TRAPS
    private static final String LOWERTRAP_TALLY = "com.example.application.scifit.LOWERTRAP_TALLY";
    private static final String LOWERTRAPPROGRESS = "LOWERTRAPPROGRESS";
    private static final String LOWERTRAPMAX = "LOWERTRAPMAX";
    //Posterior Deltoid
    private static final String POSTERIORDELTOID_TALLY = "com.example.application.scifit.POSTERIORDELTOID_TALLY";
    private static final String POSTERIORDELTOIDPROGRESS = "POSTERIORDELTOIDPROGRESS";
    private static final String POSTERIORDELTOIDMAX = "POSTERIORDELTOIDMAX";
    //Posterior Deltoid
    private static final String MEDIALDELTOID_TALLY = "com.example.application.scifit.MEDIALDELTOID_TALLY";
    private static final String MEDIALDELTOIDPROGRESS = "MEDIALDELTOIDPROGRESS";
    private static final String MEDIALDELTOIDMAX = "MEDIALDELTOIDMAX";
    //ANTERIOR DELTOID
    private static final String ANTERIORDELTOID_TALLY = "com.example.application.scifit.ANTERIORDELTOID_TALLY";
    private static final String ANTERIORDELTOIDPROGRESS = "ANTERIORDELTOIDPROGRESS";
    private static final String ANTERIORDELTOIDMAX = "ANTERIORDELTOIDMAX";

    //ROTATOR CUFF
    private static final String ROTATORCUFF_TALLY = "com.example.application.scifit.ROTATORCUFF_TALLY";
    private static final String ROTATORCUFFPROGRESS = "ROTATORCUFFPROGRESS";
    private static final String ROTATORCUFFMAX = "ROTATORCUFFMAX";

    //Triceps
    private static final String Triceps_TALLY = "com.example.application.scifit.Triceps_TALLY";
    private static final String TricepsPROGRESS = "TricepsPROGRESS";
    private static final String TricepsMAX = "TricepsMAX";

    //ULNARFOREARM
    private static final String ULNARFOREARM_TALLY = "com.example.application.scifit.ULNARFOREARM_TALLY";
    private static final String ULNARFOREARMPROGRESS = "ULNARFOREARMPROGRESS";
    private static final String ULNARFOREARMMAX = "ULNARFOREARMMAX";

    //FOREARMEXTENSORS
    private static final String FOREARMEXTENSORS_TALLY = "com.example.application.scifit.FOREARMEXTENSORS_TALLY";
    private static final String FOREARMEXTENSORSPROGRESS = "FOREARMEXTENSORSPROGRESS";
    private static final String FOREARMEXTENSORSMAX = "FOREARMEXTENSORSMAX";

    //FOREARMFLEXORS
    private static final String FOREARMFLEXORS_TALLY = "com.example.application.scifit.FOREARMFLEXORS_TALLY";
    private static final String FOREARMFLEXORSPROGRESS = "FOREARMFLEXORSPROGRESS";
    private static final String FOREARMFLEXORSMAX = "FOREARMFLEXORSMAX";

    //ANTERIOR DELTOID
    private static final String RADIALFOREARM_TALLY = "com.example.application.scifit.RADIALFOREARM_TALLY";
    private static final String RADIALFOREARMPROGRESS = "RADIALFOREARMPROGRESS";
    private static final String RADIALFOREARMMAX = "RADIALFOREARMMAX";

    //LATS
    private static final String LATS_TALLY = "com.example.application.scifit.LATS_TALLY";
    private static final String LATSPROGRESS = "LATSPROGRESS";
    private static final String LATSMAX = "LATSMAX";

    //ERECTORS
    private static final String ERECTORS_TALLY = "com.example.application.scifit.ERECTORS_TALLY";
    private static final String ERECTORSPROGRESS = "ERECTORSPROGRESS";
    private static final String ERECTORSMAX = "ERECTORSMAX";

    //GLUTES
    private static final String GLUTES_TALLY = "com.example.application.scifit.GLUTES_TALLY";
    private static final String GLUTESPROGRESS = "GLUTESPROGRESS";
    private static final String GLUTESMAX = "GLUTESMAX";

    //GLUTEMEDIUS
    private static final String GLUTEMEDIUS_TALLY = "com.example.application.scifit.GLUTEMEDIUS_TALLY";
    private static final String GLUTEMEDIUSPROGRESS = "GLUTEMEDIUSPROGRESS";
    private static final String GLUTEMEDIUSMAX = "GLUTEMEDIUSMAX";

    //HAMSTRINGS
    private static final String HAMSTRINGS_TALLY = "com.example.application.scifit.HAMSTRINGS_TALLY";
    private static final String HAMSTRINGSPROGRESS = "HAMSTRINGSPROGRESS";
    private static final String HAMSTRINGSMAX = "HAMSTRINGSMAX";

    //CALVES
    private static final String CALVES_TALLY = "com.example.application.scifit.CALVES_TALLY";
    private static final String CALVESPROGRESS = "CALVESPROGRESS";
    private static final String CALVESMAX = "CALVESMAX";

    //CHEST
    private static final String CHEST_TALLY = "com.example.application.scifit.CHEST_TALLY";
    private static final String CHESTPROGRESS = "CHESTPROGRESS";
    private static final String CHESTMAX = "CHESTMAX";

    //BICEPS
    private static final String BICEPS_TALLY = "com.example.application.scifit.BICEPS_TALLY";
    private static final String BICEPSPROGRESS = "BICEPSPROGRESS";
    private static final String BICEPSMAX = "BICEPSMAX";

    //SERRATUS
    private static final String SERRATUS_TALLY = "com.example.application.scifit.SERRATUS_TALLY";
    private static final String SERRATUSPROGRESS = "SERRATUSPROGRESS";
    private static final String SERRATUSMAX = "SERRATUSMAX";

    //ABS
    private static final String ABS_TALLY = "com.example.application.scifit.ABS_TALLY";
    private static final String ABSPROGRESS = "ABSPROGRESS";
    private static final String ABSMAX = "ABSMAX";

    //OBLIQUES
    private static final String OBLIQUES_TALLY = "com.example.application.scifit.OBLIQUES_TALLY";
    private static final String OBLIQUESPROGRESS = "OBLIQUESPROGRESS";
    private static final String OBLIQUESMAX = "OBLIQUESMAX";

    //Transverse
    private static final String Transverse_TALLY = "com.example.application.scifit.Transverse_TALLY";
    private static final String TransversePROGRESS = "TransversePROGRESS";
    private static final String TransverseMAX = "TransverseMAX";

    //QUADS
    private static final String QUADS_TALLY = "com.example.application.scifit.QUADS_TALLY";
    private static final String QUADSPROGRESS = "QUADSPROGRESS";
    private static final String QUADSMAX = "QUADSMAX";
    private static final String SHOWADS = "com.example.application.scifit.showads";

    //Other decleration
    private ExtendedFloatingActionButton unifab, bwfab;
    private InterstitialAd mInterstitialAd;
    Boolean showAds;
//    InterstitialAd ad;



    public VolumeTrackerFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        SharedPreferences sp = context.getSharedPreferences("pref", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // = container.getContext();
        View v = inflater.inflate(R.layout.fragment_volume_tracker, container, false);
        SharedPreferences sp = Objects.requireNonNull(getActivity()).getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

       // ADS
        final Boolean showAds = sp.getBoolean(SHOWADS, true);

        mInterstitialAd = new InterstitialAd(requireContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        //NECK
        int neckTally = sp.getInt(NECK_TALLY, 0);
        int neckMaxTimesTen = sp.getInt(NECKMAX, 100);
        int neckProgressTimesTen = sp.getInt(NECKPROGRESS, 0);
        neckProgressTimesTen = neckProgressTimesTen + neckTally;
        editor.putInt(NECKPROGRESS, neckProgressTimesTen).apply();
        float neckProgressTimesTenFloat = (float) neckProgressTimesTen;
        String neckProgress = String.valueOf(neckProgressTimesTenFloat / 10.00);
        String neckMax = String.valueOf(neckMaxTimesTen / 10);
        sp.edit().remove(NECK_TALLY).apply();

        //UPPERTRAP
        int upperTrapTally = sp.getInt(UPPERTRAP_TALLY, 0);
        int upperTrapMaxTimesTen = sp.getInt(UPPERTRAPMAX, 120);
        int upperTrapProgressTimesTen = sp.getInt(UPPERTRAPPROGRESS, 0);
        upperTrapProgressTimesTen = upperTrapProgressTimesTen + upperTrapTally;
        editor.putInt(UPPERTRAPPROGRESS, upperTrapProgressTimesTen).apply();
        float upperTrapProgressTimesTenFloat = (float) upperTrapProgressTimesTen;
        String upperTrapProgress = String.valueOf(upperTrapProgressTimesTenFloat / 10.00);
        String upperTrapMax = String.valueOf(upperTrapMaxTimesTen / 10);
        sp.edit().remove(UPPERTRAP_TALLY).apply();

        //LOWERTRAP
        int lowerTrapTally = sp.getInt(LOWERTRAP_TALLY, 0);
        int lowerTrapMaxTimesTen = sp.getInt(LOWERTRAPMAX, 120);
        int lowerTrapProgressTimesTen = sp.getInt(LOWERTRAPPROGRESS, 0);
        lowerTrapProgressTimesTen = lowerTrapProgressTimesTen + lowerTrapTally;
        editor.putInt(LOWERTRAPPROGRESS, lowerTrapProgressTimesTen).apply();
        float lowerTrapProgressTimesTenFloat = (float) lowerTrapProgressTimesTen;
        String lowerTrapProgress = String.valueOf(lowerTrapProgressTimesTenFloat / 10.00);
        String lowerTrapMax = String.valueOf(lowerTrapMaxTimesTen / 10);
        sp.edit().remove(LOWERTRAP_TALLY).apply();

        //POSTERIORDELTOID
        int posteriorDeltoidTally = sp.getInt(POSTERIORDELTOID_TALLY, 0);
        int posteriorDeltoidMaxTimesTen = sp.getInt(POSTERIORDELTOIDMAX, 160);
        int posteriorDeltoidProgressTimesTen = sp.getInt(POSTERIORDELTOIDPROGRESS, 0);
        posteriorDeltoidProgressTimesTen = posteriorDeltoidProgressTimesTen + posteriorDeltoidTally;
        editor.putInt(POSTERIORDELTOIDPROGRESS, posteriorDeltoidProgressTimesTen).apply();
        float posteriorDeltoidProgressTimesTenFloat = (float) posteriorDeltoidProgressTimesTen;
        String posteriorDeltoidProgress = String.valueOf(posteriorDeltoidProgressTimesTenFloat / 10.00);
        String posteriorDeltoidMax = String.valueOf(posteriorDeltoidMaxTimesTen / 10);
        sp.edit().remove(POSTERIORDELTOID_TALLY).apply();
        //MEDIALDELTOID
        int medialDeltoidTally = sp.getInt(MEDIALDELTOID_TALLY, 0);
        int medialDeltoidMaxTimesTen = sp.getInt(MEDIALDELTOIDMAX, 160);
        int medialDeltoidProgressTimesTen = sp.getInt(MEDIALDELTOIDPROGRESS, 0);
        medialDeltoidProgressTimesTen = medialDeltoidProgressTimesTen + medialDeltoidTally;
        editor.putInt(MEDIALDELTOIDPROGRESS, medialDeltoidProgressTimesTen).apply();
        float medialDeltoidProgressTimesTenFloat = (float) medialDeltoidProgressTimesTen;
        String medialDeltoidProgress = String.valueOf(medialDeltoidProgressTimesTenFloat / 10.00);
        String medialDeltoidMax = String.valueOf(medialDeltoidMaxTimesTen / 10);
        sp.edit().remove(MEDIALDELTOID_TALLY).apply();

        //ANTERIORDELTOID
        int anteriorDeltoidTally = sp.getInt(ANTERIORDELTOID_TALLY, 0);
        int anteriorDeltoidMaxTimesTen = sp.getInt(ANTERIORDELTOIDMAX, 160);
        int anteriorDeltoidProgressTimesTen = sp.getInt(ANTERIORDELTOIDPROGRESS, 0);
        anteriorDeltoidProgressTimesTen = anteriorDeltoidProgressTimesTen + anteriorDeltoidTally;
        editor.putInt(ANTERIORDELTOIDPROGRESS, anteriorDeltoidProgressTimesTen).apply();
        float anteriorDeltoidProgressTimesTenFloat = (float) anteriorDeltoidProgressTimesTen;
        String anteriorDeltoidProgress = String.valueOf(anteriorDeltoidProgressTimesTenFloat / 10.00);
        String anteriorDeltoidMax = String.valueOf(anteriorDeltoidMaxTimesTen / 10);
        sp.edit().remove(ANTERIORDELTOID_TALLY).apply();

        //ROTATOR CUFF
        int rotatorCuffTally = sp.getInt(ROTATORCUFF_TALLY, 0);
        int rotatorCuffMaxTimesTen = sp.getInt(ROTATORCUFFMAX, 120);
        int rotatorCuffProgressTimesTen = sp.getInt(ROTATORCUFFPROGRESS, 0);
        rotatorCuffProgressTimesTen = rotatorCuffProgressTimesTen + rotatorCuffTally;
        editor.putInt(ROTATORCUFFPROGRESS, rotatorCuffProgressTimesTen).apply();
        float rotatorCuffProgressTimesTenFloat = (float) rotatorCuffProgressTimesTen;
        String rotatorCuffProgress = String.valueOf(rotatorCuffProgressTimesTenFloat / 10.00);
        String rotatorCuffMax = String.valueOf(rotatorCuffMaxTimesTen / 10);
        sp.edit().remove(ROTATORCUFF_TALLY).apply();

        //Triceps
        int TricepsTally = sp.getInt(Triceps_TALLY, 0);
        int TricepsMaxTimesTen = sp.getInt(TricepsMAX, 100);
        int TricepsProgressTimesTen = sp.getInt(TricepsPROGRESS, 0);
        TricepsProgressTimesTen = TricepsProgressTimesTen + TricepsTally;
        editor.putInt(TricepsPROGRESS, TricepsProgressTimesTen).apply();
        float TricepsProgressTimesTenFloat = (float) TricepsProgressTimesTen;
        String TricepsProgress = String.valueOf(TricepsProgressTimesTenFloat / 10.00);
        String TricepsMax = String.valueOf(TricepsMaxTimesTen / 10);
        sp.edit().remove(Triceps_TALLY).apply();

        //ULNARFOREARM
        int ulnarForearmTally = sp.getInt(ULNARFOREARM_TALLY, 0);
        int ulnarForearmMaxTimesTen = sp.getInt(ULNARFOREARMMAX, 100);
        int ulnarForearmProgressTimesTen = sp.getInt(ULNARFOREARMPROGRESS, 0);
        ulnarForearmProgressTimesTen = ulnarForearmProgressTimesTen + ulnarForearmTally;
        editor.putInt(ULNARFOREARMPROGRESS, ulnarForearmProgressTimesTen).apply();
        float ulnarForearmProgressTimesTenFloat = (float) ulnarForearmProgressTimesTen;
        String ulnarForearmProgress = String.valueOf(ulnarForearmProgressTimesTenFloat / 10.00);
        String ulnarForearmMax = String.valueOf(ulnarForearmMaxTimesTen / 10);
        sp.edit().remove(ULNARFOREARM_TALLY).apply();

        //FOREARMEXTENSORS
        int forearmExtensorsTally = sp.getInt(FOREARMEXTENSORS_TALLY, 0);
        int forearmExtensorsMaxTimesTen = sp.getInt(FOREARMEXTENSORSMAX, 100);
        int forearmExtensorsProgressTimesTen = sp.getInt(FOREARMEXTENSORSPROGRESS, 0);
        forearmExtensorsProgressTimesTen = forearmExtensorsProgressTimesTen + forearmExtensorsTally;
        editor.putInt(FOREARMEXTENSORSPROGRESS, forearmExtensorsProgressTimesTen).apply();
        float forearmExtensorsProgressTimesTenFloat = (float) forearmExtensorsProgressTimesTen;
        String forearmExtensorsProgress = String.valueOf(forearmExtensorsProgressTimesTenFloat / 10.00);
        String forearmExtensorsMax = String.valueOf(forearmExtensorsMaxTimesTen / 10);
        sp.edit().remove(FOREARMEXTENSORS_TALLY).apply();

        //FOREARMFLEXORS
        int forearmFlexorsTally = sp.getInt(FOREARMFLEXORS_TALLY, 0);
        int forearmFlexorsMaxTimesTen = sp.getInt(FOREARMFLEXORSMAX, 100);
        int forearmFlexorsProgressTimesTen = sp.getInt(FOREARMFLEXORSPROGRESS, 0);
        forearmFlexorsProgressTimesTen = forearmFlexorsProgressTimesTen + forearmFlexorsTally;
        editor.putInt(FOREARMFLEXORSPROGRESS, forearmFlexorsProgressTimesTen).apply();
        float forearmFlexorsProgressTimesTenFloat = (float) forearmFlexorsProgressTimesTen;
        String forearmFlexorsProgress = String.valueOf(forearmFlexorsProgressTimesTenFloat / 10.00);
        String forearmFlexorsMax = String.valueOf(forearmFlexorsMaxTimesTen / 10);
        sp.edit().remove(FOREARMFLEXORS_TALLY).apply();

        //RADIALFOREARM
        int radialForearmTally = sp.getInt(RADIALFOREARM_TALLY, 0);
        int radialForearmMaxTimesTen = sp.getInt(RADIALFOREARMMAX, 100);
        int radialForearmProgressTimesTen = sp.getInt(RADIALFOREARMPROGRESS, 0);
        radialForearmProgressTimesTen = radialForearmProgressTimesTen + radialForearmTally;
        editor.putInt(RADIALFOREARMPROGRESS, radialForearmProgressTimesTen).apply();
        float radialForearmProgressTimesTenFloat = (float) radialForearmProgressTimesTen;
        String radialForearmProgress = String.valueOf(radialForearmProgressTimesTenFloat / 10.0);
        String radialForearmMax = String.valueOf(radialForearmMaxTimesTen / 10);
        sp.edit().remove(RADIALFOREARM_TALLY).apply();
        //LATS
        int latsTally = sp.getInt(LATS_TALLY, 0);
        int latsMaxTimesTen = sp.getInt(LATSMAX, 120);
        int latsProgressTimesTen = sp.getInt(LATSPROGRESS, 0);
        latsProgressTimesTen = latsProgressTimesTen + latsTally;
        editor.putInt(LATSPROGRESS, latsProgressTimesTen).apply();
        float latsProgressTimesTenFloat = (float) latsProgressTimesTen;
        String latsProgress = String.valueOf(latsProgressTimesTenFloat / 10.00);
        String latsMax = String.valueOf(latsMaxTimesTen / 10);
        sp.edit().remove(LATS_TALLY).apply();
        //ERECTORS
        int erectorsTally = sp.getInt(ERECTORS_TALLY, 0);
        int erectorsMaxTimesTen = sp.getInt(ERECTORSMAX, 100);
        int erectorsProgressTimesTen = sp.getInt(ERECTORSPROGRESS, 0);
        erectorsProgressTimesTen = erectorsProgressTimesTen + erectorsTally;
        editor.putInt(ERECTORSPROGRESS, erectorsProgressTimesTen).apply();
        float erectorsProgressTimesTenFloat = (float) erectorsProgressTimesTen;
        String erectorsProgress = String.valueOf(erectorsProgressTimesTenFloat / 10.00);
        String erectorsMax = String.valueOf(erectorsMaxTimesTen / 10);
        sp.edit().remove(ERECTORS_TALLY).apply();
        //GLUTES
        int glutesTally = sp.getInt(GLUTES_TALLY, 0);
        int glutesMaxTimesTen = sp.getInt(GLUTESMAX, 40);
        int glutesProgressTimesTen = sp.getInt(GLUTESPROGRESS, 0);
        glutesProgressTimesTen = glutesProgressTimesTen + glutesTally;
        editor.putInt(GLUTESPROGRESS, glutesProgressTimesTen).apply();
        float glutesProgressTimesTenFloat = (float) glutesProgressTimesTen;
        String glutesProgress = String.valueOf(glutesProgressTimesTenFloat / 10.00);
        String glutesMax = String.valueOf(glutesMaxTimesTen / 10);
        sp.edit().remove(GLUTES_TALLY).apply();
        //GLUTEMEDIUS
        int gluteMediusTally = sp.getInt(GLUTEMEDIUS_TALLY, 0);
        int gluteMediusMaxTimesTen = sp.getInt(GLUTEMEDIUSMAX, 120);
        int gluteMediusProgressTimesTen = sp.getInt(GLUTEMEDIUSPROGRESS, 0);
        gluteMediusProgressTimesTen = gluteMediusProgressTimesTen + gluteMediusTally;
        editor.putInt(GLUTEMEDIUSPROGRESS, gluteMediusProgressTimesTen).apply();
        float gluteMediusProgressTimesTenFloat = (float) gluteMediusProgressTimesTen;
        String gluteMediusProgress = String.valueOf(gluteMediusProgressTimesTenFloat / 10.00);
        String gluteMediusMax = String.valueOf(gluteMediusMaxTimesTen / 10);
        sp.edit().remove(GLUTEMEDIUS_TALLY).apply();
        //HAMSTRINGS
        int hamstringsTally = sp.getInt(HAMSTRINGS_TALLY, 0);
        int hamstringsMaxTimesTen = sp.getInt(HAMSTRINGSMAX, 100);
        int hamstringsProgressTimesTen = sp.getInt(HAMSTRINGSPROGRESS, 0);
        hamstringsProgressTimesTen = hamstringsProgressTimesTen + hamstringsTally;
        editor.putInt(HAMSTRINGSPROGRESS, hamstringsProgressTimesTen).apply();
        float hamstringsProgressTimesTenFloat = (float) hamstringsProgressTimesTen;
        String hamstringsProgress = String.valueOf(hamstringsProgressTimesTenFloat / 10.00);
        String hamstringsMax = String.valueOf(hamstringsMaxTimesTen / 10);
        sp.edit().remove(HAMSTRINGS_TALLY).apply();
        //CALVES
        int calvesTally = sp.getInt(CALVES_TALLY, 0);
        int calvesMaxTimesTen = sp.getInt(CALVESMAX, 120);
        int calvesProgressTimesTen = sp.getInt(CALVESPROGRESS, 0);
        calvesProgressTimesTen = calvesProgressTimesTen + calvesTally;
        editor.putInt(CALVESPROGRESS, calvesProgressTimesTen).apply();
        float calvesProgressTimesTenFloat = (float) calvesProgressTimesTen;
        String calvesProgress = String.valueOf(calvesProgressTimesTenFloat / 10.00);
        String calvesMax = String.valueOf(calvesMaxTimesTen / 10);
        sp.edit().remove(CALVES_TALLY).apply();
        //CHEST
        int chestTally = sp.getInt(CHEST_TALLY, 0);
        int chestMaxTimesTen = sp.getInt(CHESTMAX, 120);
        int chestProgressTimesTen = sp.getInt(CHESTPROGRESS, 0);
        chestProgressTimesTen = chestProgressTimesTen + chestTally;
        editor.putInt(CHESTPROGRESS, chestProgressTimesTen).apply();
        float chestProgressTimesTenFloat = (float) chestProgressTimesTen;
        String chestProgress = String.valueOf(chestProgressTimesTenFloat / 10.00);
        String chestMax = String.valueOf(chestMaxTimesTen / 10);
        sp.edit().remove(CHEST_TALLY).apply();
        //BICEPS
        int bicepsTally = sp.getInt(BICEPS_TALLY, 0);
        int bicepsMaxTimesTen = sp.getInt(BICEPSMAX, 140);
        int bicepsProgressTimesTen = sp.getInt(BICEPSPROGRESS, 0);
        bicepsProgressTimesTen = bicepsProgressTimesTen + bicepsTally;
        editor.putInt(BICEPSPROGRESS, bicepsProgressTimesTen).apply();
        float bicepsProgressTimesTenFloat = (float) bicepsProgressTimesTen;
        String bicepsProgress = String.valueOf(bicepsProgressTimesTenFloat / 10.00);
        String bicepsMax = String.valueOf(bicepsMaxTimesTen / 10);
        sp.edit().remove(BICEPS_TALLY).apply();
        //SERRATUS
        int serratusTally = sp.getInt(SERRATUS_TALLY, 0);
        int serratusMaxTimesTen = sp.getInt(SERRATUSMAX, 160);
        int serratusProgressTimesTen = sp.getInt(SERRATUSPROGRESS, 0);
        serratusProgressTimesTen = serratusProgressTimesTen + serratusTally;
        editor.putInt(SERRATUSPROGRESS, serratusProgressTimesTen).apply();
        float serratusProgressTimesTenFloat = (float) serratusProgressTimesTen;
        String serratusProgress = String.valueOf(serratusProgressTimesTenFloat / 10.00);
        String serratusMax = String.valueOf(serratusMaxTimesTen / 10);
        sp.edit().remove(SERRATUS_TALLY).apply();
        //ABS
        int absTally = sp.getInt(ABS_TALLY, 0);
        int absMaxTimesTen = sp.getInt(ABSMAX, 160);
        int absProgressTimesTen = sp.getInt(ABSPROGRESS, 0);
        absProgressTimesTen = absProgressTimesTen + absTally;
        editor.putInt(ABSPROGRESS, absProgressTimesTen).apply();
        float absProgressTimesTenFloat = (float) absProgressTimesTen;
        String absProgress = String.valueOf(absProgressTimesTenFloat / 10.00);
        String absMax = String.valueOf(absMaxTimesTen / 10);
        sp.edit().remove(ABS_TALLY).apply();
        //OBLIQUES
        int obliquesTally = sp.getInt(OBLIQUES_TALLY, 0);
        int obliquesMaxTimesTen = sp.getInt(OBLIQUESMAX, 160);
        int obliquesProgressTimesTen = sp.getInt(OBLIQUESPROGRESS, 0);
        obliquesProgressTimesTen = obliquesProgressTimesTen + obliquesTally;
        editor.putInt(OBLIQUESPROGRESS, obliquesProgressTimesTen).apply();
        float obliquesProgressTimesTenFloat = (float) obliquesProgressTimesTen;
        String obliquesProgress = String.valueOf(obliquesProgressTimesTenFloat / 10.00);
        String obliquesMax = String.valueOf(obliquesMaxTimesTen / 10);
        sp.edit().remove(OBLIQUES_TALLY).apply();
        //Transverse
        int TransverseTally = sp.getInt(Transverse_TALLY, 0);
        int TransverseMaxTimesTen = sp.getInt(TransverseMAX, 160);
        int TransverseProgressTimesTen = sp.getInt(TransversePROGRESS, 0);
        TransverseProgressTimesTen = TransverseProgressTimesTen + TransverseTally;
        editor.putInt(TransversePROGRESS, TransverseProgressTimesTen).apply();
        float TransverseProgressTimesTenFloat = (float) TransverseProgressTimesTen;
        String TransverseProgress = String.valueOf(TransverseProgressTimesTenFloat / 10.00);
        String TransverseMax = String.valueOf(TransverseMaxTimesTen / 10);
        sp.edit().remove(Transverse_TALLY).apply();
        //QUADS
        int quadsTally = sp.getInt(QUADS_TALLY, 0);
        int quadsMaxTimesTen = sp.getInt(QUADSMAX, 120);
        int quadsProgressTimesTen = sp.getInt(QUADSPROGRESS, 0);
        quadsProgressTimesTen = quadsProgressTimesTen + quadsTally;
        editor.putInt(QUADSPROGRESS, quadsProgressTimesTen).apply();
        float quadsProgressTimesTenFloat = (float) quadsProgressTimesTen;
        String quadsProgress = String.valueOf(quadsProgressTimesTenFloat / 10.00);
        String quadsMax = String.valueOf(quadsMaxTimesTen / 10);
        sp.edit().remove(QUADS_TALLY).apply();

        //ACTUAL PROGRAM
        //CreateList
        final ArrayList<MuscleList> muscleListList = new ArrayList<>();
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_white, "Neck", "MAV:10-16\nFREQ:2-3", neckProgress, neckMax, neckProgressTimesTen, neckMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_white, "Upper Traps", "MAV:12-20\nFREQ:2-6", upperTrapProgress, upperTrapMax, upperTrapProgressTimesTen, upperTrapMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Lower Traps", "MAV:12-20\nFREQ:2-6", lowerTrapProgress, lowerTrapMax, lowerTrapProgressTimesTen, lowerTrapMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Posterior Delt", "MAV:16-22\nFREQ:2-6", posteriorDeltoidProgress, posteriorDeltoidMax, posteriorDeltoidProgressTimesTen, posteriorDeltoidMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Medial Delt", "MAV:16-22\nFREQ:2-6", medialDeltoidProgress, medialDeltoidMax, medialDeltoidProgressTimesTen, medialDeltoidMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Anterior Delt", "MAV:16-22\nFREQ:1-2", anteriorDeltoidProgress, anteriorDeltoidMax, anteriorDeltoidProgressTimesTen, anteriorDeltoidMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Rotator Cuff", "MAV:12-20\nFREQ:3-6", rotatorCuffProgress, rotatorCuffMax, rotatorCuffProgressTimesTen, rotatorCuffMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Triceps", "MAV:10-14\nFREQ:2-4", TricepsProgress, TricepsMax, TricepsProgressTimesTen, TricepsMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Ulnar Forearm", "MAV:10-20\nFREQ:2-6", ulnarForearmProgress, ulnarForearmMax, ulnarForearmProgressTimesTen, ulnarForearmMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Forearm Extensors", "MAV:10-20\nFREQ:2-6", forearmExtensorsProgress, forearmExtensorsMax, forearmExtensorsProgressTimesTen, forearmExtensorsMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Forearm Flexors", "MAV:10-20\nFREQ:2-6", forearmFlexorsProgress, forearmFlexorsMax, forearmFlexorsProgressTimesTen, forearmFlexorsMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Radial Forearm", "MAV:10-20\nFREQ:2-6", radialForearmProgress, radialForearmMax, radialForearmProgressTimesTen, radialForearmMaxTimesTen));
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
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Transverse Ab", "MAV:16-20\nFREQ:3-5", TransverseProgress, TransverseMax, TransverseProgressTimesTen, TransverseMaxTimesTen));
        muscleListList.add(new MuscleList(R.drawable.ic_fitness_center_black_24dp, "Quads", "MAV:12-18\nFREQ:1.5-3", quadsProgress, quadsMax, quadsProgressTimesTen, quadsMaxTimesTen));

        //Create Recycler View
        RecyclerView mRecyclerView = v.findViewById(R.id.musclesRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        MuscleListAdapter mAdapter = new MuscleListAdapter(muscleListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy < 0 && !unifab.isShown())
                    unifab.show();
                else if (dy > 0 && unifab.isShown())
                    unifab.hide();
                if (dy < 0 && !bwfab.isShown())
                    bwfab.show();
                else if (dy > 0 && bwfab.isShown())
                    bwfab.hide();
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        //ADS
        unifab = v.findViewById(R.id.allexercisesfab);
        bwfab = v.findViewById(R.id.bodyweightexercisesfab);


        unifab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InterstitialAd ad = AdManager.getAd();

                Random rand = new Random(); //instance of random class
                int upperbound = 10;
                //generate random values from 0-24
                int int_random = rand.nextInt(upperbound);

                int x = int_random % 2;
                boolean even = true;
                even = x == 0;

                if (ad != null && showAds && even) {
                    ad.show();
                }
                startActivity(new Intent(getContext(), GlobalExercise.class));
            }
        });


        bwfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random rand = new Random(); //instance of random class
                int upperbound = 10;
                //generate random values from 0-24
                int int_random = rand.nextInt(upperbound);

                int x = int_random % 2;
                boolean even = true;
                even = x == 0;

                InterstitialAd ad = AdManager.getAd();
                if (ad != null && showAds && even) {
                    ad.show();
                }
                startActivity(new Intent(getContext(), BWExercise.class));
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
        Random rand = new Random(); //instance of random class
        int upperbound = 10;
//generate random values from 0-24
        int int_random = rand.nextInt(upperbound);

        int x = int_random % 2;
        boolean even = true;
        even = x == 0;


        switch (position) {
            case 0:
                Intent intent = new Intent(getContext(), NeckVolume.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent);

                InterstitialAd ad = AdManager.getAd();
                if (ad != null && showAds && even) {
                    ad.show();
                }
                break;

            case 1:
                Intent intent2 = new Intent(getContext(), UpperTrapVolume.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent2);

                InterstitialAd ad2 = AdManager.getAd();
                if (ad2 != null && showAds && even) {
                    ad2.show();}
                break;

            case 2:
                Intent intent3 = new Intent(getContext(), LowerTrapsVolume.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent3);

                InterstitialAd ad3 = AdManager.getAd();
                if (ad3 != null && showAds && even) {
                    ad3.show();}
                break;

            case 3:
                Intent intent4 = new Intent(getContext(), PosteriorDeltoidVolume.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(intent4);

                InterstitialAd ad4 = AdManager.getAd();
                if (ad4 != null && showAds && even) {
                    ad4.show();}
                break;

            case 4:
                Intent intent5 = new Intent(getContext(), MedialDeltoidVolume.class);
                startActivity(intent5);

                InterstitialAd ad5 = AdManager.getAd();
                if (ad5 != null && showAds && even) {
                    ad5.show();}
                break;

            case 5:
                Intent intent6 = new Intent(getContext(), AnteriorDeltoidVolume.class);
                startActivity(intent6);

                InterstitialAd ad6 = AdManager.getAd();
                if (ad6 != null && showAds && even) {
                    ad6.show();}
                break;

            case 6:
                Intent intent7 = new Intent(getContext(), RotatorCuffVolume.class);
                startActivity(intent7);

                InterstitialAd ad7 = AdManager.getAd();
                if (ad7 != null && showAds && even) {
                    ad7.show();}
                break;

            case 7:
                Intent intent8 = new Intent(getContext(), TricepsVolume.class);
                startActivity(intent8);

                InterstitialAd ad8 = AdManager.getAd();
                if (ad8 != null && showAds && even) {
                    ad8.show();}
                break;

            case 8:
                Intent intent9 = new Intent(getContext(), UlnarForearmVolume.class);
                startActivity(intent9);

                InterstitialAd ad9 = AdManager.getAd();
                if (ad9 != null && showAds && even) {
                    ad9.show();}
                break;

            case 9:
                Intent intent10 = new Intent(getContext(), ForearmExtensorsVolume.class);
                startActivity(intent10);

                InterstitialAd ad10 = AdManager.getAd();
                if (ad10 != null && showAds && even) {
                    ad10.show();}
                break;

            case 10:
                Intent intent11 = new Intent(getContext(), ForearmFlexorsVolume.class);
                startActivity(intent11);

                InterstitialAd ad11 = AdManager.getAd();
                if (ad11 != null && showAds && even) {
                    ad11.show();}
                break;

            case 11:
                Intent intent12 = new Intent(getContext(), RadialForearmVolume.class);
                startActivity(intent12);

                InterstitialAd ad12 = AdManager.getAd();
                if (ad12 != null && showAds && even) {
                    ad12.show();}
                break;

            case 12:
                Intent intent13 = new Intent(getContext(), LatsVolume.class);
                startActivity(intent13);

                InterstitialAd ad13 = AdManager.getAd();
                if (ad13 != null && showAds && even) {
                    ad13.show();}
                break;

            case 13:
                Intent intent14 = new Intent(getContext(), ErectorsVolume.class);
                startActivity(intent14);

                InterstitialAd ad14 = AdManager.getAd();
                if (ad14 != null && showAds && even) {
                    ad14.show();}
                break;

            case 14:
                Intent intent15 = new Intent(getContext(), GlutesVolume.class);
                startActivity(intent15);

                InterstitialAd ad15 = AdManager.getAd();
                if (ad15 != null && showAds && even) {
                    ad15.show();}
                break;

            case 15:
                Intent intent16 = new Intent(getContext(), GluteMediusVolume.class);
                startActivity(intent16);

                InterstitialAd ad16 = AdManager.getAd();
                if (ad16 != null && showAds && even) {
                    ad16.show();}
                break;

            case 16:
                Intent intent17 = new Intent(getContext(), HamstringsVolume.class);
                startActivity(intent17);

                InterstitialAd ad17 = AdManager.getAd();
                if (ad17 != null && showAds && even) {
                    ad17.show();}
                break;

            case 17:
                Intent intent18 = new Intent(getContext(), CalvesVolume.class);
                startActivity(intent18);

                InterstitialAd ad18 = AdManager.getAd();
                if (ad18 != null && showAds && even) {
                    ad18.show();}
                break;

            case 18:
                Intent intent19 = new Intent(getContext(), ChestVolume.class);
                startActivity(intent19);

                InterstitialAd ad19 = AdManager.getAd();
                if (ad19 != null && showAds && even) {
                    ad19.show();}
                break;

            case 19:
                Intent intent20 = new Intent(getContext(), BicepsVolume.class);
                startActivity(intent20);

                InterstitialAd ad20 = AdManager.getAd();
                if (ad20 != null && showAds && even) {
                    ad20.show();}
                break;

            case 20:
                Intent intent21 = new Intent(getContext(), SerratusVolume.class);
                startActivity(intent21);

                InterstitialAd ad21 = AdManager.getAd();
                if (ad21 != null && showAds && even) {
                    ad21.show();}
                break;

            case 21:
                Intent intent22 = new Intent(getContext(), AbsVolume.class);
                startActivity(intent22);

                InterstitialAd ad22 = AdManager.getAd();
                if (ad22 != null && showAds && even) {
                    ad22.show();}
                break;

            case 22:
                Intent intent23 = new Intent(getContext(), ObliquesVolume.class);
                startActivity(intent23);

                InterstitialAd ad23 = AdManager.getAd();
                if (ad23 != null && showAds && even) {
                    ad23.show();}
                break;

            case 23:
                Intent intent24 = new Intent(getContext(), DiaphragmVolume.class);
                startActivity(intent24);

                InterstitialAd ad24 = AdManager.getAd();
                if (ad24 != null && showAds && even) {
                    ad24.show();}
                break;

            case 24:
                Intent intent25 = new Intent(getContext(), QuadsVolume.class);
                startActivity(intent25);
                InterstitialAd ad25 = AdManager.getAd();
                if (ad25 != null && showAds && even) {
                    ad25.show();}
                break;

        }
    }


}




