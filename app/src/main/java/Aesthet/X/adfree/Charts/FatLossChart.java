package Aesthet.X.adfree.Charts;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scifit.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class FatLossChart extends AppCompatActivity {
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String MAXLOSSRATE = "MAXLOSSRATE";
    private static final String MINLOSSRATE = "MINLOSSRATE";
    private static final String DEFICIT = "DEFICIT";
    private static final String EXTRA_BODYWEIGHT = "com.example.application.scifit.EXTRA_ BODYWEIGHT";
    private static final String IDEAL_BODYWEIGHT = "ideal bodyweight";
    static float newWeightMax, maxFatLossRate, minFatLossRate, selectedFatLossRate;
    static double newWeightMaxD;
    int maxWeek, minWeek, selectedWeek;
    int counter;
    ArrayList lineEntries3, lineEntries2, lineEntries;
    LineData lineData, lineData2, lineData3;
    LineDataSet lineDataSet, lineDataSet2, lineDataSet3;
    LineChart lineChart;
    TextView one, two, three, four, five, six, seven, eight, nine, ten;
    private boolean table_flg = false;
    private float bodyweight, idealBodyweight, maxWeekFloat, minWeekFloat, selectedWeekFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_loss_chart);

        //IMPORT DATA
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        bodyweight = sharedPreferences.getFloat(EXTRA_BODYWEIGHT, 0);
        maxFatLossRate = sharedPreferences.getFloat(MAXLOSSRATE, 0);
        minFatLossRate = sharedPreferences.getFloat(MINLOSSRATE, 0);
        selectedFatLossRate = sharedPreferences.getFloat(DEFICIT, 0);
        idealBodyweight = sharedPreferences.getFloat(IDEAL_BODYWEIGHT, 0);

        //MAX WEIGHT LOSS MATH  maxfatloss rae is calories per week

        float FLCals = ((bodyweight - idealBodyweight) * 3500);
        maxWeekFloat = ((bodyweight - idealBodyweight) * 3500) / (maxFatLossRate * 7);
        maxWeek = Math.round(maxWeekFloat);

        minWeekFloat = ((bodyweight - idealBodyweight) * 3500) / (minFatLossRate * 7);
        minWeek = Math.round(minWeekFloat);

        selectedWeekFloat = ((bodyweight - idealBodyweight) * 3500) / ((selectedFatLossRate + minFatLossRate) * 7);
        selectedWeek = Math.round(selectedWeekFloat);

        //TABLE
        TableLayout table = findViewById(R.id.table);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);

        one.setText("Fastest");
        two.setText(Float.toString(maxWeek));
        three.setText(Float.toString(maxFatLossRate));
        four.setText("Slowest");
        five.setText(Float.toString(minWeek));
        six.setText(Float.toString(minFatLossRate));
        seven.setText("Selected");
        eight.setText(Float.toString(selectedWeek));
        nine.setText(Float.toString(selectedFatLossRate));

    /*    test.append(Integer.toString(maxWeek)+"Weeks at your fastest rate."+ maxFatLossRate + "calorie deficit.");
        test2.append(Integer.toString(minWeek)+"Weeks at your fastest rate."+ minFatLossRate + "calorie deficit.");
        test3.append(Integer.toString(selectedWeek)+"Weeks at your fastest rate."+ selectedFatLossRate + "calorie deficit.");
*/


        //CREATE GRAPH
        lineChart = findViewById(R.id.lineChart);
        lineDataSet = new LineDataSet(dataValues1(), "Data Set 1");
        lineDataSet2 = new LineDataSet(dataValues2(), "Data Set 1");
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);

        lineData = new LineData((ILineDataSet) dataSets);
        lineChart.setData(lineData);


        //Styling
        lineDataSet.setColors(Color.parseColor("#BAF833"));
        lineDataSet.setValueTextColor(Color.WHITE);
        lineDataSet.setValueTextSize(18f);
        Color.parseColor("#BAF833");
        YAxis yAxisRight = lineChart.getAxisRight();
        YAxis yAxisLeft = lineChart.getAxisLeft();
        XAxis xAxis = lineChart.getXAxis();
        yAxisLeft.setTextColor(Color.WHITE);
        yAxisRight.setTextColor(Color.WHITE);
        xAxis.setTextColor(Color.WHITE);




        /* getEntries1();
        lineDataSet = new LineDataSet(lineEntries, "");
        lineData = new LineData(lineDataSet);
       getEntries2();
        lineDataSet2 = new LineDataSet(lineEntries2, "");
        lineData2 = new LineData(lineDataSet2);
        getEntries3();
        lineDataSet3 = new LineDataSet(lineEntries, "");
        lineData3 = new LineData(lineDataSet3);
        lineChart = findViewById(R.id.lineChart);
        lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet.setValueTextColor(Color.WHITE);
        lineDataSet.setValueTextSize(18f);*/


    }

    private ArrayList<Entry> dataValues1() {
//        lineEntries = new ArrayList<>();
//        lineEntries.add(new Entry(0, bodyweight));
//        lineEntries.add(new Entry(maxWeek, idealBodyweight));
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, bodyweight));
        dataVals.add(new Entry(maxWeek, idealBodyweight));
        return dataVals;

    }

    private ArrayList<Entry> dataValues2() {
//        lineEntries = new ArrayList<>();
//        lineEntries.add(new Entry(0, bodyweight));
//        lineEntries.add(new Entry(maxWeek, idealBodyweight));
        ArrayList<Entry> dataVals = new ArrayList<>();
        dataVals.add(new Entry(0, bodyweight));
        dataVals.add(new Entry(minWeek, idealBodyweight));
        return dataVals;

    }
}
