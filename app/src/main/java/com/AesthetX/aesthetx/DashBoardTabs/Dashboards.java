package com.AesthetX.aesthetx.DashBoardTabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.AesthetX.aesthetx.Classes.Constants;
import com.AesthetX.aesthetx.Classes.SubscriptionAdapter;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.SkuDetails;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.example.scifit.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.AesthetX.aesthetx.Classes.AdManager;
import com.AesthetX.aesthetx.Classes.Adapters.MuscleListAdapter;
import com.AesthetX.aesthetx.Classes.Fragments.DashboardFragment;
import com.AesthetX.aesthetx.Classes.Fragments.MealPlanFragment;
import com.AesthetX.aesthetx.Classes.Fragments.SectionsPageAdapter;
import com.AesthetX.aesthetx.Classes.Fragments.VolumeTrackerFragment;
import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.PremiumPay;
import com.AesthetX.aesthetx.Classes.ResetVolume;


public class Dashboards extends AppCompatActivity  implements BillingProcessor.IBillingHandler{

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
   // InterstitialAd ad;
    private InterstitialAd mInterstitialAd;
    BillingProcessor bp;
    private BillingClient mBillingClient;
    public SharedPreferences sharedPreferences ;
    private static final String LOG_TAG = "iabv3";
    boolean isPremiumActive;
    ArrayList<String> listProductIds = new ArrayList<>();
    SharedPreferences.Editor editor;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboards);


        //REGULAR CODE
        //Intialize memory, load Premium info and displayh ads accordingly

        preferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        editor = preferences.edit();
        Boolean showAds = preferences.getBoolean(SHOWADS, true);

        Random rand = new Random(); //instance of random class
        int upperbound = 10;
//generate random values from 0-24
        int int_random = rand.nextInt(upperbound);

        int x = int_random % 2;
        boolean even = true;
        even = x == 0;

        if (even && showAds){
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-3950672419252348/5345333086");
            mInterstitialAd.loadAd(new AdRequest.Builder().build());

            mInterstitialAd.setAdListener(new AdListener(){
                @Override
                public void onAdLoaded(){
                    mInterstitialAd.show();
                }
            });
        }



                //View pager code
                SectionsPageAdapter mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                // Set up the ViewPager with the sections adapter.
                ViewPager mViewPager = findViewById(R.id.container);
                setupViewPager(mViewPager);
                TabLayout tabLayout = findViewById(R.id.tablayout);
                tabLayout.setupWithViewPager(mViewPager);
                int color = Color.parseColor("#f5f5f5");
                int color2 = Color.parseColor("#BAF833");
                boolean firstrun = preferences.getBoolean(FIRSTRUN, true);

                Objects.requireNonNull(tabLayout.getTabAt(0)).setText(getResources().getText(R.string.Dashboard));
                Objects.requireNonNull(tabLayout.getTabAt(1)).setText(getResources().getText(R.string.volumetracker));
                Objects.requireNonNull(tabLayout.getTabAt(2)).setText(getResources().getText(R.string.mealplan));
                // tabLayout.getTabAt(3).setText(getResources().getText(R.string.resources));
                tabLayout.setTabTextColors(color, color2);

                if (firstrun) {
                    preferences.edit().putBoolean(FIRSTRUN, false).apply();
                    Objects.requireNonNull(tabLayout.getTabAt(0)).select();

                } else {
                    Objects.requireNonNull(tabLayout.getTabAt(1)).select();
                }
                Toolbar toolbar = findViewById(R.id.toolbar);

                toolbar.inflateMenu(R.menu.options_menu);
                setSupportActionBar(toolbar);


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


                //Intialize Billing to see ads

                listProductIds = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.subscriptions)));


                    bp = new BillingProcessor(this, getResources().getString(R.string.licence_key_ad), this);
                    bp.initialize();



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
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.aesthet-x.com/faqs/"));
                    startActivity(i);
                } else if (id == R.id.item3) {
                    Intent intent = new Intent(this, ResetVolume.class);
                    startActivity(intent);
                    return true;
                } else if (id == R.id.item4) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.youtube.com/playlist?list=PLdsCUIkYpuc6LefqJmUbWzJDReoVOv6oU"));
                    startActivity(i);
                    return true;
                } else if (id == R.id.item5) {
                    Intent intent = new Intent(this, PremiumPay.class);
                    startActivity(intent);
                    return true;
                }


                return super.onOptionsItemSelected(item);
            }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {

    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {

    }

    @Override
    public void onBillingInitialized() {
        try {
            initSubscriptions();
        }catch (Exception e){

        }
    }

    private void initSubscriptions(){
        Log.d("INIT: ","-----------------------============");
        List<SkuDetails> listSku = bp.getSubscriptionListingDetails(listProductIds);
        List<String> listPaid = bp.listOwnedSubscriptions();



        listData = new ArrayList<>();

        for(int i=0;i<listSku.size();i++){
            int notsubbed = 0;
            SkuDetails sd = listSku.get(i);
            com.AesthetX.aesthetx.Classes.DataModel data = new com.AesthetX.aesthetx.Classes.DataModel();
            data.setTitle(sd.title);
            data.setDescription(sd.description);
            data.setId(listProductIds.get(i));

            if (listPaid.contains(listProductIds.get(i))){
                data.setStatus(true);
                editor.putBoolean(SHOWADS, false).apply();
                Log.d("OWNED: ","-----------------------============"+i);
            } else {
                notsubbed +=1;
                if (notsubbed == 3){
                    editor.putBoolean(SHOWADS, true).apply();
                }
                data.setStatus(false);
                Log.d("NOT OWNED: ","-----------------------============"+i);
            }


            listData.add(data);

        }

}
    private ArrayList<com.AesthetX.aesthetx.Classes.DataModel> listData;
}



