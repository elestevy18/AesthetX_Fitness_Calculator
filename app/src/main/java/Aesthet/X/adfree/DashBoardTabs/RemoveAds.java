package Aesthet.X.adfree.DashBoardTabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.example.scifit.R;

import java.util.ArrayList;
import java.util.List;

public class RemoveAds extends AppCompatActivity {

    static final String ITEM_SKU_MONTHLY = "1_month_premium";
    static final String ITEM_SKU_BIANNUAL = "biannually";
    static final String ITEM_SKU_ANNUAL = "annually";

    private  SkuDetails mySkuDetails;
    private String mAdRemovalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_ads);



        //Initialize billing client
        PurchasesUpdatedListener purchaseUpdateListener = new PurchasesUpdatedListener() {
            @Override
            public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> purchases) {
                // To be implemented in a later section.
            }
        };

        BillingClient billingClient = BillingClient.newBuilder(RemoveAds.this)
                .setListener(purchaseUpdateListener)
                .enablePendingPurchases()
                .build();

        //Connect to play store
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(BillingResult billingResult) {
                if (billingResult.getResponseCode() ==  BillingClient.BillingResponseCode.OK) {
                    // The BillingClient is ready. You can query purchases here.

                }
            }
            @Override
            public void onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.

            }
        });

        //Show available products
        List<String> skuList = new ArrayList<>();
        skuList.add("1_month_premium");
        skuList.add("annually");
        SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder();
        params.setSkusList(skuList).setType(BillingClient.SkuType.SUBS);

        billingClient.querySkuDetailsAsync(params.build(),
                new SkuDetailsResponseListener() {
                    @Override
                    public void onSkuDetailsResponse( BillingResult billingResult,
                                                     List<SkuDetails> skuDetailsList) {

                        // Process the result.// TODO FUGURE OOUT WHY THIS NOT NOT RETURNING VALUE AKA NOT RUNNING AND RETURNING NULL
                        if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK && skuDetailsList != null){
                            //Iterates item in list, assigns to variable and ??????TODO
                            //The Google Play Billing Library stores the query results in a List of SkuDetails
                            for (Object skuDetailsObject : skuDetailsList){
                                Log.v("LOG WORKING", "<--------------------------Hello--------------------------------->");
                                SkuDetails skuDetails = (SkuDetails) skuDetailsObject;
                                String sku = skuDetails.getSku();
                                String price = skuDetails.getPrice();
                                if (ITEM_SKU_MONTHLY.equals(sku)) {
                                    Log.v("MONTHLY FROM GGOGLE", "<--------------------------H" + skuDetails.getDescription() + "---------->");
                                    mySkuDetails = skuDetails;
                                   // mBuyButton.setEnabled(true);
                                    Log.v("MONTHLY: mySKUDETAILS 1", mySkuDetails.getDescription());
                                    mAdRemovalPrice = price;
                                } else if (ITEM_SKU_BIANNUAL.equals(sku)) {
                                    mySkuDetails = skuDetails;
                                  //  mBuyButton.setEnabled(true);
                                    mAdRemovalPrice = price;
                                } else if (ITEM_SKU_ANNUAL.equals(sku)) {
                                    mySkuDetails = skuDetails;
                                 //   mBuyButton.setEnabled(true);
                                    mAdRemovalPrice = price;
                                }

                            }
                        }
                    }
                });
    }
}