package com.example.scifit.DashBoardTabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.scifit.Classes.Adapters.MuscleListAdapter;
import com.example.scifit.Classes.Fragments.DashboardFragment;
import com.example.scifit.Classes.Fragments.MealPlanFragment;
import com.example.scifit.Classes.Fragments.ResourcesFragment;
import com.example.scifit.Classes.Fragments.SectionsPageAdapter;
import com.example.scifit.Classes.Fragments.VolumeTrackerFragment;
import com.example.scifit.Intro.MainActivity;
import com.example.scifit.R;
import com.google.android.material.tabs.TabLayout;

public class Dashboards extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String FIRSTRUN = "firstrun";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    SharedPreferences sharedPreferences = null;
    private MuscleListAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboards);
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);
        int color = Color.parseColor("#f5f5f5");
        int color2 = Color.parseColor("#BAF833");
        boolean firstrun = sharedPreferences.getBoolean(FIRSTRUN, true);

        tabLayout.getTabAt(0).setText(getResources().getText(R.string.Dashboard));
        tabLayout.getTabAt(1).setText(getResources().getText(R.string.volumetracker));
        tabLayout.getTabAt(2).setText(getResources().getText(R.string.mealplan));
       // tabLayout.getTabAt(3).setText(getResources().getText(R.string.resources));
        tabLayout.setTabTextColors(color, color2);

        if (firstrun) {
            sharedPreferences.edit().putBoolean(FIRSTRUN, false).apply();
            tabLayout.getTabAt(0).select();

        }
        else {
            tabLayout.getTabAt(1).select();
        }
        Toolbar toolbar =  findViewById(R.id.toolbar);

       toolbar.inflateMenu(R.menu.options_menu);
       setSupportActionBar(toolbar);
      // setSupportActionBar(toolbar);
        }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new DashboardFragment(), "Dashboard");
        adapter.addFragment(new VolumeTrackerFragment(), "Volume\nTracker");

            adapter.addFragment(new MealPlanFragment(), "Meal\nPlan");

       // adapter.addFragment(new ResourcesFragment(), "Resources");
        viewPager.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        final Menu m = menu;
        final MenuItem item = menu.findItem(R.id.item1);
//        item.getActionView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), UpdateData.class);
//                startActivity(intent);
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Intent intent = new Intent(this, UpdateData.class);
            startActivity(intent);
            return true;
        }
                return super.onOptionsItemSelected(item);


    }



}
