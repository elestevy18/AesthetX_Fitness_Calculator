package com.AesthetX.aesthetx.Classes.Adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.HistoryList;
import com.example.scifit.R;

import java.util.ArrayList;


public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ExampleViewHolder> {
    private final ArrayList<HistoryList> mHistoryList;
    private final OnItemClickListener mListener;


    public HistoryListAdapter(ArrayList<HistoryList> mHistoryList, OnItemClickListener mListener) {
        this.mHistoryList = mHistoryList;
        this.mListener = mListener;
    }

    public interface OnItemClickListener {
        void onItemCLick(int position);


    }



    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_cell, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryListAdapter.ExampleViewHolder holder, int position) {
        HistoryList currentItem = mHistoryList.get(position);//Object that needs to be created
        //Below is code to get and dispplay data
        holder.exerciseTitleInit.setText(currentItem.setexerciseTitle());
        holder.dateTextInit.setText(currentItem.setDateText());
        holder.setsTextInit.setText(currentItem.setSetsText());
        holder.repsTextInit.setText(currentItem.setRepsText());
        holder.weightTextInit.setText(currentItem.setWeightText());
        holder.volumeTextInit.setText(currentItem.setVolumeText());
        holder.rpeTextInit.setText(currentItem.setRpeText());


        HistoryList item = mHistoryList.get(position);
    }

    public void refresh(int position, HistoryList item) {
        mHistoryList.set(position, item);
        notifyItemChanged(position);
    }

    public static class ExampleViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        final TextView exerciseTitleInit;
        final TextView dateTextInit;
        final TextView setsTextInit;
        final TextView repsTextInit;
        final TextView weightTextInit;
        final TextView volumeTextInit;
        final TextView rpeTextInit;


        final OnItemClickListener clickListener;

        ExampleViewHolder(View itemView, final OnItemClickListener clickListener) {
            super(itemView);
            exerciseTitleInit = itemView.findViewById(R.id.exerciseTitleTxt);//
            dateTextInit = itemView.findViewById(R.id.dateTxt);
            setsTextInit = itemView.findViewById(R.id.setsTxt);//
            repsTextInit = itemView.findViewById(R.id.repsTxt);
            weightTextInit = itemView.findViewById(R.id.weightTxt);
            volumeTextInit = itemView.findViewById(R.id.volumeTxts);
            rpeTextInit = itemView.findViewById(R.id.rpeTxts);

            this.clickListener = clickListener;


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemCLick(getAdapterPosition());
                }
            });

        }


        @Override
        public void onClick(View view) {
        }

    }


    @Override
    public int getItemCount() {
        return mHistoryList.size();
    }

}


