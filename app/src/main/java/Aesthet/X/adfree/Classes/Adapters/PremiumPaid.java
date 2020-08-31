package Aesthet.X.adfree.Classes.Adapters;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.SkuDetails;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.example.scifit.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PremiumPaid extends AppCompatActivity implements BillingProcessor.IBillingHandler {

    BillingProcessor bp;
    RecyclerView rvList;
    SubscriptionAdapter adapter;
    ArrayList<String> listProductIds = new ArrayList<>();
    private ArrayList<DataModel> listData;
    private int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium_paid);

        rvList = findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        listProductIds = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.subscriptions)));

        bp = new BillingProcessor(this, getResources().getString(R.string.licence_key_ad), this);
        bp.initialize();

    }

    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {

        if (pos != -1) {
            listData.get(pos).setStatus(true);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {
        Log.e("tttE", errorCode + "+" + error.getLocalizedMessage());
    }

    @Override
    public void onBillingInitialized() {

        initSubscriptions();
    }

    private void initSubscriptions() {
        List<SkuDetails> listSku = bp.getSubscriptionListingDetails(listProductIds);
        List<String> listPaid = bp.listOwnedSubscriptions();

        listData = new ArrayList<>();

        for (int i = 0; i < listSku.size(); i++) {
            SkuDetails sd = listSku.get(i);
            DataModel data = new DataModel();
            data.setTitle(sd.title);
            data.setDescription(sd.description);
            data.setId(listProductIds.get(i));

            if (listPaid.contains(listProductIds.get(i))) {
                data.setStatus(true);
            } else {
                data.setStatus(false);
            }

            listData.add(data);

        }

        adapter = new SubscriptionAdapter(PremiumPaid.this, listData);
        rvList.setAdapter(adapter);
    }

    public void subscribe(final int position, final String id) {
        pos = position;
        bp.subscribe(PremiumPaid.this, id);
    }


}