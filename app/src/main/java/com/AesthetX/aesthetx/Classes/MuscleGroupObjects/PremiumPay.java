package com.AesthetX.aesthetx.Classes.MuscleGroupObjects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.Purchase;
import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.SkuDetails;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.example.scifit.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.AesthetX.aesthetx.Classes.SubscriptionAdapter;

public class PremiumPay extends AppCompatActivity implements BillingProcessor.IBillingHandler {

    BillingProcessor bp;
    RecyclerView rvList;
    SubscriptionAdapter adapter;
    ArrayList<String> listProductIds = new ArrayList<>();
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String SHOWADS = "com.example.application.scifit.showads";
    public SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;
    private static final String LOG_TAG = "iabv3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium_pay);

         sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        editor = sharedPreferences.edit();



        rvList = findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        listProductIds = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.subscriptions)));

        bp = new BillingProcessor(this, getResources().getString(R.string.licence_key_ad), this);
        bp.initialize();



    }

    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {

        if (pos!=-1){
            listData.get(pos).setStatus(true);
            adapter.notifyDataSetChanged();
           showToast(productId);

        }

    }

    @Override
    public void onPurchaseHistoryRestored() {

        showToast("onPurchaseHistoryRestored");
        for(String sku : bp.listOwnedProducts())
            Log.d(LOG_TAG, "Owned Managed Product: " + "------------------------------------------HERe--------------------" + sku);
        for(String sku : bp.listOwnedSubscriptions())
            Log.d(LOG_TAG, "Owned Subscription: " + "------------------------------------------HERe--------------------"+sku);


    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {
        Log.e("tttE",errorCode+"+"+error.getLocalizedMessage());
    }

    @Override
    public void onBillingInitialized() {

        initSubscriptions();
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

        adapter = new SubscriptionAdapter(PremiumPay.this,listData);
        rvList.setAdapter(adapter);

    }

    private  ArrayList<com.AesthetX.aesthetx.Classes.DataModel> listData;

    private int pos=-1;

    public void subscribe(final int position,final String id){
        pos = position;
        bp.subscribe(PremiumPay.this, id);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}