package com.AesthetX.aesthetx.Classes;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.PremiumPay;

public class SubscriptionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<com.AesthetX.aesthetx.Classes.DataModel> list;
    private int selPos = -1;
    private static final String SHARED_PREFS = "com.example.application.scifit.sharedPrefs";
    private static final String SHOWADS = "com.example.application.scifit.showads";
    public SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor;

    public SubscriptionAdapter(Context mContext, ArrayList<com.AesthetX.aesthetx.Classes.DataModel> list) {
        this.mContext = mContext;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.row_list_subscription, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder) holder).bindData(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class LoadHolder extends RecyclerView.ViewHolder {
        public LoadHolder(View itemView) {
            super(itemView);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView tvTitle,tvDes,tvStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDes = itemView.findViewById(R.id.tvDes);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }

        public void bindData(final com.AesthetX.aesthetx.Classes.DataModel result, final int position) {

            tvTitle.setText(result.getTitle());
            tvDes.setText(result.getDescription());

            if (result.getStatus()){
                tvStatus.setText("Subscribed");
                tvStatus .setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent2));


            } else {
                tvStatus.setText("Subscribe");
                tvStatus .setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent2));
            }

            tvStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!result.getStatus()){
                        ((PremiumPay)mContext).subscribe(position,list.get(position).getId());
                    }
                }
            });

        }
    }


}
