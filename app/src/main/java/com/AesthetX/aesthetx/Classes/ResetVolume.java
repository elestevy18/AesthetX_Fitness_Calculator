package com.AesthetX.aesthetx.Classes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;

import com.AesthetX.aesthetx.DashBoardTabs.Dashboards;

public class ResetVolume extends AppCompatActivity {
    private static final String PREFS = Constants.PREFS;
    private static final String NECKPROGRESS = "NECKPROGRESS";
    private static final String UPPERTRAPPROGRESS = "UPPERTRAPPROGRESS";
    private static final String LOWERTRAPPROGRESS = "LOWERTRAPPROGRESS";
    private static final String POSTERIORDELTOIDPROGRESS = "POSTERIORDELTOIDPROGRESS";
    private static final String MEDIALDELTOIDPROGRESS = "MEDIALDELTOIDPROGRESS";
    private static final String ANTERIORDELTOIDPROGRESS = "ANTERIORDELTOIDPROGRESS";
    private static final String ROTATORCUFFPROGRESS = "ROTATORCUFFPROGRESS";
    private static final String TRICEPSPROGRESS = "TRICEPSPROGRESS";
    private static final String ULNARFOREARMPROGRESS = "ULNARFOREARMPROGRESS";
    private static final String FOREARMEXTENSORSPROGRESS = "FOREARMEXTENSORSPROGRESS";
    private static final String FOREARMFLEXORSPROGRESS = "FOREARMFLEXORSPROGRESS";
    private static final String RADIALFOREARMPROGRESS = "RADIALFOREARMPROGRESS";
    private static final String LATSPROGRESS = "LATSPROGRESS";
    private static final String ERECTORSPROGRESS = "ERECTORSPROGRESS";
    private static final String GLUTESPROGRESS = "GLUTESPROGRESS";
    private static final String GLUTEMEDIUSPROGRESS = "GLUTEMEDIUSPROGRESS";
    private static final String HAMSTRINGSPROGRESS = "HAMSTRINGSPROGRESS";
    private static final String CALVESPROGRESS = "CALVESPROGRESS";
    private static final String CHESTPROGRESS = "CHESTPROGRESS";
    private static final String BICEPSPROGRESS = "BICEPSPROGRESS";
    private static final String SERRATUSPROGRESS = "SERRATUSPROGRESS";
    private static final String ABSPROGRESS = "ABSPROGRESS";
    private static final String OBLIQUESPROGRESS = "OBLIQUESPROGRESS";
    private static final String TRANSVERSEPROGRESS = "TRANSVERSEPROGRESS";
    private static final String QUADSPROGRESS = "QUADSPROGRESS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_volume);

        SharedPreferences sp = getSharedPreferences(PREFS, Dashboards.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int neckProgress = 0;
        editor.putInt(NECKPROGRESS, neckProgress);

        int upperTrapProgress = 0;
        editor.putInt(UPPERTRAPPROGRESS, upperTrapProgress);

        int lowerTrapProgress = 0;
        editor.putInt(LOWERTRAPPROGRESS, lowerTrapProgress);

        int posteriorDeltoidProgress = 0;
        editor.putInt(POSTERIORDELTOIDPROGRESS, posteriorDeltoidProgress);

        int medialDeltoidProgress = 0;
        editor.putInt(MEDIALDELTOIDPROGRESS, medialDeltoidProgress);

        int anteriorDeltoidProgress = 0;
        editor.putInt(ANTERIORDELTOIDPROGRESS, anteriorDeltoidProgress);

        int rotatorCuffProgress = 0;
        editor.putInt(ROTATORCUFFPROGRESS, rotatorCuffProgress);

        int TricepsProgress = 0;
        editor.putInt(TRICEPSPROGRESS, TricepsProgress);

        int ulnarForearmProgress = 0;
        editor.putInt(ULNARFOREARMPROGRESS, ulnarForearmProgress);

        int forearmExtensorsProgress = 0;
        editor.putInt(FOREARMEXTENSORSPROGRESS, forearmExtensorsProgress);

        int forearmFlexorProgress = 0;
        editor.putInt(FOREARMFLEXORSPROGRESS, forearmFlexorProgress);

        int radialforearmProgress = 0;
        editor.putInt(RADIALFOREARMPROGRESS, radialforearmProgress);

        int latsProgress = 0;
        editor.putInt(LATSPROGRESS, latsProgress);

        int erectorsProgress = 0;
        editor.putInt(ERECTORSPROGRESS, erectorsProgress);

        int glutesProgress = 0;
        editor.putInt(GLUTESPROGRESS, glutesProgress);

        int gluteMediusProgress = 0;
        editor.putInt(GLUTEMEDIUSPROGRESS, gluteMediusProgress);

        int hamstringsProgress = 0;
        editor.putInt(HAMSTRINGSPROGRESS, hamstringsProgress);

        int calvesProgress = 0;
        editor.putInt(CALVESPROGRESS, calvesProgress);

        int chestProgress = 0;
        editor.putInt(CHESTPROGRESS, chestProgress);

        int bicepsProgress = 0;
        editor.putInt(BICEPSPROGRESS, bicepsProgress);

        int serratusProgress = 0;
        editor.putInt(SERRATUSPROGRESS, serratusProgress);

        int absProgress = 0;
        editor.putInt(ABSPROGRESS, absProgress);

        int obliquesProgress = 0;
        editor.putInt(OBLIQUESPROGRESS, obliquesProgress);

        int TransverseProgress = 0;
        editor.putInt(TRANSVERSEPROGRESS, TransverseProgress);

        int quadsProgress = 0;
        editor.putInt(QUADSPROGRESS, quadsProgress);

        editor.apply();

        Intent intent = new Intent(this, Dashboards.class);
        startActivity(intent);
    }
}
