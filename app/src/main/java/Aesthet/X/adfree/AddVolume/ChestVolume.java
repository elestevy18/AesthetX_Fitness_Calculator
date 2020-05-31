package Aesthet.X.adfree.AddVolume;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Aesthet.X.adfree.Classes.Adapters.ChestAdapter;
import Aesthet.X.adfree.Classes.MuscleGroupObjects.ChestList;
import Aesthet.X.adfree.PopUpDialogs.AddChestDeltVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddChestPressDialog;
import Aesthet.X.adfree.PopUpDialogs.AddChestVolumeDialog;
import Aesthet.X.adfree.PopUpDialogs.AddDipDialog;
import Aesthet.X.adfree.PopUpDialogs.AddPullOverDialog;


public class ChestVolume extends AppCompatActivity implements ChestAdapter.OnItemClickListener, AddChestVolumeDialog.ExampleDialogListener,
        AddPullOverDialog.ExampleDialogListener, AddChestDeltVolumeDialog.ExampleDialogListener, AddDipDialog.ExampleDialogListener, AddChestPressDialog.ExampleDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_volume);

        //CreateList
        final ArrayList<ChestList> ChestExerciseListList = new ArrayList<>();

        ChestExerciseListList.add(new ChestList("Chest", "One set towards chest"));
        ChestExerciseListList.add(new ChestList("Bench Press", "Chest, Triceps Secondary: Anterior Delt"));
        ChestExerciseListList.add(new ChestList("Dumbbell Chest Press", "Chest, Triceps Secondary: Anterior Delt"));
        ChestExerciseListList.add(new ChestList("Machine Chest Press", "Chest, Triceps Secondary: Anterior Delt"));
        ChestExerciseListList.add(new ChestList("Neutral Cable Press", "Chest, Triceps Secondary: Anterior Delt"));
        ChestExerciseListList.add(new ChestList("Incline Cable Press", "Upper Pectoral, Triceps Anterior Delt"));
        ChestExerciseListList.add(new ChestList("Incline Dumbbell Press", "Upper Pectoral, Triceps Anterior Delt"));
        ChestExerciseListList.add(new ChestList("Incline Bench Press", "Upper Pectoral, Triceps Anterior Delt"));
        ChestExerciseListList.add(new ChestList("Decline Cable Press", "Lower Pectoral, Triceps"));
        ChestExerciseListList.add(new ChestList("Decline Bench Press", "Lower Pectoral, Triceps"));
        ChestExerciseListList.add(new ChestList("Decline Dumbbell Press", "Lower Pectoral, Triceps"));
        ChestExerciseListList.add(new ChestList("Chest Pullover", "Upper Pectoral, Triceps Secondary: Lats"));
        ChestExerciseListList.add(new ChestList("Incline Crossover Flyes", "Upper Pectoral, Anterior Deltoid"));
        ChestExerciseListList.add(new ChestList("Horizontal Crossover Flyes", "Middle Pectoral"));
        ChestExerciseListList.add(new ChestList("Decline Crossover Flyes", "Lower Pectoral"));
        ChestExerciseListList.add(new ChestList("Pushups", "Chest, Triceps, Anterior Delt"));
        ChestExerciseListList.add(new ChestList("Wide Dip", "Lower Pectoral, Triceps Secondary: Anterior Delt"));


        //Create Recycler View
        RecyclerView mRecyclerView = findViewById(R.id.chestRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        ChestAdapter mAdapter = new ChestAdapter(ChestExerciseListList, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void addVolume() {

    }

    private void stringcomparison(Integer position) {
        // GET TEXT FROM RECYCLER VIEW ITEM CLICKED
        RecyclerView recyclerView = findViewById(R.id.chestRecyclerView);
        TextView text = recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.exercise);
        String exercise = text.getText().toString();
        String[] chestPressExercises = {"Incline Cable Press", "Incline Dumbbell Press", "Incline Bench Press", "Pushups",
                "Neutral Cable Press", "Machine Chest Press", "Dumbbell Chest Press", "Bench Press"};
        List<String> chestPressList = Arrays.asList(chestPressExercises);
        String[] dipExercises = {"Narrow Dip", "Wide Dip", "Decline Cable Press", "Decline Bench Press", "Decline Dumbbell Press"};
        List<String> dipList = Arrays.asList(dipExercises);
        String[] chestExercises = {"Horizontal Crossover Flyes", "Decline Crossover Flyes", "Chest"};
        List<String> chestList = Arrays.asList(chestExercises);
        if (chestPressList.contains(exercise)) {
            AddChestPressDialog exampleDialog = new AddChestPressDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (dipList.contains(exercise)) {
            AddDipDialog exampleDialog = new AddDipDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        } else if (chestList.contains(exercise)) {
            AddChestVolumeDialog exampleDialog = new AddChestVolumeDialog(this);
            exampleDialog.show(getSupportFragmentManager(), "example dialog");
        }
    }

    @Override
    public void onExerciseClick(int position) {
    }

    @Override
    public void onAddVolumeClick(int position) {
        stringcomparison(position);
       /*  switch (position) {


            case 0:
                AddDipDialog exampleDialog = new AddDipDialog(this);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                break;
            case 1:
                AddDipDialog exampleDialog2 = new AddDipDialog(this);
                exampleDialog2.show(getSupportFragmentManager(), "example dialog");

                break;
            case 2:
                AddDipDialog exampleDialog3 = new AddDipDialog(this);
                exampleDialog3.show(getSupportFragmentManager(), "example dialog");

                break;
            case 3:
                //Chest Press == Incline press
                AddChestPressDialog exampleDialog4 = new AddChestPressDialog(this);
                exampleDialog4.show(getSupportFragmentManager(), "example dialog");

                break;
            case 4:
                AddChestPressDialog exampleDialog5 = new AddChestPressDialog(this);
                exampleDialog5.show(getSupportFragmentManager(), "example dialog");
                break;
            case 5:
                AddDipDialog exampleDialog6 = new AddDipDialog(this);
                exampleDialog6.show(getSupportFragmentManager(), "example dialog");
                break;
            case 6:
                AddPullOverDialog exampleDialog7 = new AddPullOverDialog(this);
                exampleDialog7.show(getSupportFragmentManager(), "example dialog");
                break;
            case 7:
                AddChestDeltVolumeDialog exampleDialog8 = new AddChestDeltVolumeDialog(this);
                exampleDialog8.show(getSupportFragmentManager(), "example dialog");

                break;
            case 8:
                AddChestVolumeDialog exampleDialog9 = new AddChestVolumeDialog(this);
                exampleDialog9.show(getSupportFragmentManager(), "example dialog");

                break;

                case 9:

                    AddChestVolumeDialog exampleDialog10 = new AddChestVolumeDialog(this);
                exampleDialog10.show(getSupportFragmentManager(), "example dialog");
                break;
            case 10:
                AddDipDialog exampleDialog11 = new AddDipDialog(this);
                exampleDialog11.show(getSupportFragmentManager(), "example dialog");

                break;
            case 11:
                AddDipDialog exampleDialog12 = new AddDipDialog(this);
                exampleDialog12.show(getSupportFragmentManager(), "example dialog");

                break;

        }*/
    }
}

