package com.AesthetX.aesthetx.DashBoardTabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.AesthetX.aesthetx.Classes.Adapters.HistoryListAdapter;
import com.AesthetX.aesthetx.Classes.Constants;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.HistoryList;
import com.AesthetX.aesthetx.Classes.NotesAndRPE;
import com.example.scifit.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;


public class HistoryFragment extends Fragment implements HistoryListAdapter.OnItemClickListener{

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static final String PREFS = Constants.PREFS;
    private static final String IDEAL_BODYWEIGHT = "ideal bodyweight";
    private static final String FATLOSS = "fatloss";
    private static final String CURRENT_GROWTH = "current growth";
    private static final String POTENTIAL_GROWTH = "potential growth";
    private static final String GROWTH_RATE = "growth rate";
    private static final String CALORIES = "calories";
    private static final String PMG = "muscle";
    private View v;

    private float pmgf;
    private static final String UNITS = "com.example.application.scifit.units";

    String [] titles, dates, sets, reps, weights, volumes, rpes, notes;


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.history, container, false);


        //Download from shared preferences
        SharedPreferences sp = Objects.requireNonNull(getActivity()).getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        //Arrays for all data
        titles = sp.getString(Constants.EXERCISE_HISTORY_LIST, "Try adding sets first.").split("`");
        dates = sp.getString(Constants.DATES_HISTORY_LIST, "--`").split("`");
        sets = sp.getString(Constants.SETS_HISTORY_LIST, "--`").split("`");
        reps = sp.getString(Constants.REPS_HISTORY_LIST, "--`").split("`");
        weights = sp.getString(Constants.WEIGHT_HISTORY_LIST, "--`").split("`");
        rpes  = sp.getString(Constants.RPE_HISTORY_LIST, "--`").split("`");
        volumes = sp.getString(Constants.VOLUME_HISTORY_LIST, "--`").split("`");





        volumes = sp.getString(Constants.VOLUME_HISTORY_LIST, "--`").split("`");
        //Logic to retrieve arrays and iterate thorough them too append data
        // to a List to display on the RecyclerView
        int titlesLength = titles.length;
        int datesLength = dates.length;
        int setsLength = sets.length;
        int repsLength = reps.length;
        int weightsLength = weights.length;
        int RPESLength = rpes.length;
        int volumesLength =volumes.length;
        int maxTitlesLength = titlesLength;

       // Log.e("---------VALUES--------", "\ntitles length:" + Integer.toString(titlesLength));// + titles[0] + "\ndates:" + Integer.toString(datesLength) + dates[0]
              //  +"\nsets" + Integer.toString(setsLength) + sets[0] + "\nreps" + Integer.toString(repsLength) + reps[0] +"\nweights" + Integer.toString(weightsLength) + weights[0] +
                 //       "\nRPE" + Integer.toString(RPESLength) + rpes[0] +"\nvolume" + Integer.toString(volumesLength) + volumes[0]);
        Log.e("\ndates:", Integer.toString(datesLength));
        Log.e("\nsets", Integer.toString(setsLength));
        Log.e("\nreps", Integer.toString(repsLength));
        Log.e("\nweights", Integer.toString(weightsLength));
        Log.e("\nRPE", Integer.toString(RPESLength));
        Log.e("\nvolume", Integer.toString(volumesLength));


        if (titlesLength > 100){
            maxTitlesLength = 100;
        }

        if (titlesLength > 0){

            final ArrayList<HistoryList> historyListList = new ArrayList<>();
            for (int i = 0; i<= maxTitlesLength-1; i++){
                historyListList.add(new HistoryList(titles[titlesLength - 1 - i], dates[titlesLength - 1 -i], sets[titlesLength - 1 -i],
                        reps[titlesLength - 1 -i], weights[titlesLength - 1 - i], volumes[titlesLength - 1 -i], rpes[titlesLength - 1 -i]));

            }
            //Create and populateRecycler View
            RecyclerView mRecyclerView = v.findViewById(R.id.historyRecyclerView);
            mRecyclerView.setHasFixedSize(false);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            HistoryListAdapter mAdapter = new HistoryListAdapter(historyListList, this);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);


            //TODO add the load more or calendar view feature

//            if
//
//            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//                @Override
//                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                    if (dy < 0 && !unifab.isShown())
//                        unifab.show();
//                    else if (dy > 0 && unifab.isShown())
//                        unifab.hide();
//                    if (dy < 0 && !bwfab.isShown())
//                        bwfab.show();
//                    else if (dy > 0 && bwfab.isShown())
//                        bwfab.hide();
//                }
//
//                @Override
//                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                    super.onScrollStateChanged(recyclerView, newState);
//                }
//            });
        }








        return v;
    }





    @Override
    public void onItemCLick(int position) {
        RecyclerView recyclerView = v.findViewById(R.id.historyRecyclerView);
        TextView text = Objects.requireNonNull(recyclerView.findViewHolderForAdapterPosition(position)).itemView.findViewById(R.id.exerciseTitleTxt);
        String titleForExerciseNote = text.getText().toString();
        SharedPreferences sp = Objects.requireNonNull(getActivity()).getSharedPreferences(PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Constants.TITLE_FOR_NOTES, titleForExerciseNote).apply();
        editor.putInt(Constants.NOTE_POSITION, position).apply();

        Intent intent = new Intent(getContext(), NotesAndRPE.class);
        startActivity(intent);
        
    }
}

