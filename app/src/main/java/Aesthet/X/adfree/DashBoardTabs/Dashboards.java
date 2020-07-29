package Aesthet.X.adfree.DashBoardTabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.scifit.R;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Aesthet.X.adfree.Classes.Adapters.MuscleListAdapter;
import Aesthet.X.adfree.Classes.Fragments.DashboardFragment;
import Aesthet.X.adfree.Classes.Fragments.MealPlanFragment;
import Aesthet.X.adfree.Classes.Fragments.SectionsPageAdapter;
import Aesthet.X.adfree.Classes.Fragments.VolumeTrackerFragment;
import Aesthet.X.adfree.Classes.ResetVolume;

public class Dashboards extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String ADS = "com.example.application.scifit.ads";
    public static final String CURRENTDATE = "com.example.application.scifit.currentdate";
    public static final String ADSDATE = "com.example.application.scifit.adsdate";
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String FIRSTRUN = "firstrun";
    private static final String SHOWADS = "com.example.application.scifit.showads";
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private MuscleListAdapter mAdapter;
    boolean ads;
    String currentDate, adsDate;
    InterstitialAd ad;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboards);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SectionsPageAdapter mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout = findViewById(R.id.tablayout);
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

        } else {
            tabLayout.getTabAt(1).select();
        }
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.inflateMenu(R.menu.options_menu);
        setSupportActionBar(toolbar);
        // setSupportActionBar(toolbar);

        //CLICKABLE LOGO

        ImageView logo = findViewById(R.id.aesthetxlogo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.aesthet-x.com/shop/"));
                startActivity(i);
            }
        });

        //ADS


        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String installDate = preferences.getString("InstallDate", null);
        if (installDate == null) {
            // First run, so save the current date
            Date now = new Date();
            String dateString = formatter.format(now);
            editor.putString("InstallDate", dateString);
            // Commit the edits!
            editor.apply();
        } else {
            // This is not the 1st run, check install date
            Date before = null;
            try {
                before = formatter.parse(installDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date now = new Date();
            long diff = now.getTime() - before.getTime();
            long ONE_DAY = 24 * 60 * 60 * 1000;
            long days = diff / ONE_DAY;
            if (days > 4) {
                boolean showAds = true;
                editor.putBoolean(SHOWADS, showAds);
            }
        }

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

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Intent intent = new Intent(this, UpdateData.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(this, ResetVolume.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.aesthet-x.com/faqs/"));
            startActivity(i);
        } else if (id == R.id.item4) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://www.youtube.com/playlist?list=PLdsCUIkYpuc6LefqJmUbWzJDReoVOv6oU"));
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



