package Aesthet.X.adfree.Classes.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.example.scifit.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Aesthet.X.adfree.Intro.Activity2;
import Aesthet.X.adfree.PopUpDialogs.DashCMGDialog;
import Aesthet.X.adfree.PopUpDialogs.DashFLDialog;
import Aesthet.X.adfree.PopUpDialogs.DashIdealBodyWeight;
import Aesthet.X.adfree.PopUpDialogs.DashPMGDialog;

import static android.content.Context.MODE_PRIVATE;

public class DashboardFragment extends Fragment implements View.OnClickListener{

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String IDEAL_BODYWEIGHT = "ideal bodyweight";
    private static final String FATLOSS = "fatloss";
    private static final String CURRENT_GROWTH = "current growth";
    private static final String POTENTIAL_GROWTH = "potential growth";
    private static final String GROWTH_RATE = "growth rate";
    private static final String CALORIES = "calories";
    private static final String PMG = "muscle";

    private float pmgf;



    public DashboardFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Log.v("loaded","loaded");
        Button ibw = v.findViewById(R.id.ibwbutton);
        Button ibw2 = v.findViewById(R.id.ibwbutton2);
        Button pmg = v.findViewById(R.id.pmgbutton);
        Button pfl = v.findViewById(R.id.pflbutton);
        // Button dcd = v.findViewById(R.id.dcdbutton);
        Button cp = v.findViewById(R.id.cpbutton);
        TextView gRtv = v.findViewById(R.id.pmgtxt);
        TextView fLtv = v.findViewById(R.id.pfltxt);
        //TextView caLtv = v.findViewById(R.id.dcdtxt);
        TextView currentprogresstxt = v.findViewById(R.id.progresstxt);
        // TextView progress = v.findViewById(R.id.progress);
        ProgressBar prog = v.findViewById(R.id.growthprogress);

        //Download from shared preferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        float idealBodyweight = sharedPreferences.getFloat(IDEAL_BODYWEIGHT, 0);
        float fatloss = sharedPreferences.getFloat(FATLOSS, 0);
        float currentGrowth = sharedPreferences.getFloat(CURRENT_GROWTH, 0);
        float potentialGrowth = sharedPreferences.getFloat(POTENTIAL_GROWTH, 0);
        float growthRate = sharedPreferences.getFloat(GROWTH_RATE, 0);
        float calories = sharedPreferences.getFloat(CALORIES, 0);
        int pmgf = (int) sharedPreferences.getFloat(PMG, 0);
        String pmgs = Integer.toString(pmgf);

        //Logic
        prog.setMax(pmgf);
        prog.setProgress((int) currentGrowth);

        ibw2.setText(df.format(idealBodyweight));

        gRtv.setText(getString(R.string.lbsin, df.format(growthRate)));

        fLtv.setText(getString(R.string.lbsin, df.format(fatloss)));
        //caLtv.setText(df.format(calories));
        currentprogresstxt.setText(df.format(currentGrowth));
        currentprogresstxt.append("/\n");
        currentprogresstxt.append(df.format(pmgf));
        currentprogresstxt.append("lbs");


        ibw2.setOnClickListener(this);
        ibw.setOnClickListener(this);
        pmg.setOnClickListener(this);
        pfl.setOnClickListener(this);
//        dcd.setOnClickListener(this);
        cp.setOnClickListener(this);

        // progress.setText(getString(R.string.ind, df.format(currentGrowth), pmgs));

        return v;
    }




    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibwbutton:
                Intent intent = new Intent(getContext(), DashIdealBodyWeight.class);
                startActivity(intent);
                break;
            case R.id.ibwbutton2:
                intent = new Intent(getContext(), DashIdealBodyWeight.class);
                startActivity(intent);
                break;
            case R.id.pmgbutton:
                PMGDialog();
                break;
            case R.id.pflbutton:
                FLDialog();
                break;
//            case R.id.dcdbutton:
//                Intent intcal = new Intent(getContext(), DashCalories.class);
//                startActivity(intcal);
//                break;
            case R.id.cpbutton:
                 CMGDialog();
                break;


        }
    }

    private void CMGDialog() {
        DashCMGDialog dialog = new DashCMGDialog();
        dialog.show((getFragmentManager()), "substance free");
    }


    private void FLDialog() {
        DashFLDialog dialog = new DashFLDialog();
        dialog.show((getFragmentManager()), "substance free");
    }

    private void PMGDialog() {
        DashPMGDialog dialog = new DashPMGDialog();
        dialog.show((getFragmentManager()), "substance free");
    }


}
