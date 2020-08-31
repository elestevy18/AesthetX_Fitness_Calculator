package Aesthet.X.adfree.DashBoardTabs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.android.billingclient.api.BillingClient;

import com.example.scifit.R;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import Aesthet.X.adfree.Classes.AdManager;
import Aesthet.X.adfree.Classes.Adapters.MuscleListAdapter;
import Aesthet.X.adfree.Classes.Fragments.DashboardFragment;
import Aesthet.X.adfree.Classes.Fragments.MealPlanFragment;
import Aesthet.X.adfree.Classes.Fragments.SectionsPageAdapter;
import Aesthet.X.adfree.Classes.Fragments.VolumeTrackerFragment;
import Aesthet.X.adfree.Classes.ResetVolume;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;



public class Dashboards extends AppCompatActivity {

    //Constants for sharedPrefereneces
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

    //REGULAR CODE
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        //ADS
        AdManager adManager = new AdManager(this,"ca-app-pub-3950672419252348/1631156309");
        adManager.createAd();


        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //View pager code
        SectionsPageAdapter mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);
        int color = Color.parseColor("#f5f5f5");
        int color2 = Color.parseColor("#BAF833");
        boolean firstrun = sharedPreferences.getBoolean(FIRSTRUN, true);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setText(getResources().getText(R.string.Dashboard));
        Objects.requireNonNull(tabLayout.getTabAt(1)).setText(getResources().getText(R.string.volumetracker));
        Objects.requireNonNull(tabLayout.getTabAt(2)).setText(getResources().getText(R.string.mealplan));
        // tabLayout.getTabAt(3).setText(getResources().getText(R.string.resources));
        tabLayout.setTabTextColors(color, color2);

        if (firstrun) {
            sharedPreferences.edit().putBoolean(FIRSTRUN, false).apply();
            Objects.requireNonNull(tabLayout.getTabAt(0)).select();

        } else {
            Objects.requireNonNull(tabLayout.getTabAt(1)).select();
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
        }else if (id == R.id.item5) {
            Intent intent = new Intent(this, GetPremium.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.item6) {
            Intent intent = new Intent(this, RemoveAds.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



