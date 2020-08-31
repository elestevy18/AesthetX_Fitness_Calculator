package Aesthet.X.adfree.DashBoardTabs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Aesthet.X.adfree.Intro.Activity2;

public class GetPremium extends AppCompatActivity implements PurchasesUpdatedListener  {


    private BillingClient billingClient;
    private List skuList = new ArrayList();

    private String skuMonth = "1_month_premium";
    private String skuBiannually = "biannually";
    private String skuAnnually= "annually";

    private Button buttonBuyProduct;

    public SkuDetails mSkuDetails;
    private Purchase[] purchases;

    //Subscriptions current
    private static final String TAG = "InAppBilling";
    static final String ITEM_SKU_MONTHLY = "1_month_premium";
    static final String ITEM_SKU_BIANNUAL = "biannually";
    static final String ITEM_SKU_ANNUAL = "annually";

    private  SkuDetails mySkuDetails;

    private Button mBuyButton, testy;
    private String mAdRemovalPrice;
    private SharedPreferences mSharedPreferences;

    private BillingClient mBillingClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_premium);

        Boolean b = getBoolFromPref(this,"myPref", ITEM_SKU_MONTHLY);
        if (b)
        {
            Toast.makeText(this, "you are a premium user", Toast.LENGTH_SHORT).show();
        }


        mBillingClient = BillingClient.newBuilder(GetPremium.this).setListener(this).
                enablePendingPurchases().build();
        mBillingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(BillingResult billingResult) {
                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK)
                {
                    //the client is ready
                }
            }

            @Override
            public void onBillingServiceDisconnected() {
                //TODO implement your own retry policy
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
            }
        });
        testy = findViewById((R.id.testy));
        mBuyButton = findViewById(R.id.btnBuy);
        mBuyButton.setEnabled(true);

        List skuList = new ArrayList();
        skuList.add(ITEM_SKU_MONTHLY);
        //skuList.add(ITEM_SKU_BIANNUAL);
        //skuList.add(ITEM_SKU_ANNUAL);


        System.out.println("callList: " + Arrays.toString(skuList.toArray()));

        SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder();
        params.setSkusList(skuList).setType(BillingClient.SkuType.SUBS);
        mBillingClient.querySkuDetailsAsync(params.build(), new SkuDetailsResponseListener() {
            @Override
            public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> skuList) {
                int responseCode = billingResult.getResponseCode();
                if (responseCode == BillingClient.BillingResponseCode.OK
                        && skuList != null) {
                    for (Object skuDetailsObject : skuList) {
                        SkuDetails skuDetails = (SkuDetails) skuDetailsObject;
                        String sku = skuDetails.getSku();
                        String price = skuDetails.getPrice();
                        if (ITEM_SKU_MONTHLY.equals(sku)) {
                            mySkuDetails = skuDetails;
                            mBuyButton.setEnabled(true);
                            mAdRemovalPrice = price;
//                        } else if (ITEM_SKU_BIANNUAL.equals(sku)) {
//                            mySkuDetails = skuDetails;
//                            testy.setEnabled(true);
//                            mAdRemovalPrice = price;
                        } else if (ITEM_SKU_ANNUAL.equals(sku)) {
                            mySkuDetails = skuDetails;
                            testy.setEnabled(true);
                            mAdRemovalPrice = price;
                        }
                    }


                }
            }
        });


        mBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ///if (mySkuDetails == null) {
                 //   Toast.makeText(getApplicationContext(), "It's Null Bro", Toast.LENGTH_LONG);
               // } else {
                    BillingFlowParams flowParams = BillingFlowParams.newBuilder()
                            .setSkuDetails(mySkuDetails)
                            .build();
                    mBillingClient.launchBillingFlow(GetPremium.this, flowParams);
               // }
            }
        });
    }

    @Override
    public void onPurchasesUpdated(BillingResult billingResult, @Nullable List<Purchase> purchases) {
        if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK
                && purchases != null) {
            for (Purchase purchase : purchases) {
                handlePurchase(purchase);
            }
        }
        else
        if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED) {
            // Handle an error caused by a user cancelling the purchase flow.
            Log.d(TAG, "User Canceled " + billingResult.getResponseCode());
        } //TODO add other skus
        else if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED) {
            ///mSharedPreferences.edit().putBoolean(getResources().getString(R.string.pref_remove_ads_key), true).commit();
            ///setAdFree(true);
            setBoolInPref(this,"myPref",ITEM_SKU_MONTHLY, true );
            mBuyButton.setText(getResources().getString(R.string.pref_ad_removal_purchased));
            mBuyButton.setEnabled(false);
        }
        else {
            Log.d(TAG, "Other code " + billingResult.getResponseCode());
            // Handle any other error codes.
        }


    }

    private void handlePurchase(Purchase purchase) {
        if (purchase.getSku().equals(ITEM_SKU_MONTHLY)) {
            ///mSharedPreferences.edit().putBoolean(getResources().getString(R.string.pref_remove_ads_key), true).commit();
            ///setAdFree(true);
            setBoolInPref(this,"myPref",ITEM_SKU_MONTHLY, true );
            Toast.makeText(this, "Purchase done. you are now a premium member.", Toast.LENGTH_SHORT).show();
            mBuyButton.setText(getResources().getString(R.string.pref_ad_removal_purchased));
            mBuyButton.setEnabled(false);
        }
    }

    private Boolean getBoolFromPref(Context context, String prefName, String constantName) {
        SharedPreferences pref = context.getSharedPreferences(prefName, 0); // 0 - for private mode

        return pref.getBoolean(constantName, false);

    }

    private void setBoolInPref(Context context,String prefName, String constantName, Boolean val) {
        SharedPreferences pref = context.getSharedPreferences(prefName, 0); // 0 - for private mode

        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(constantName, val);
        editor.commit();
    }

}