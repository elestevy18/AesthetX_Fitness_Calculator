package com.AesthetX.aesthetx.Classes.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;
import java.util.List;

import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.GlobalList;

public class GlobalAdapter extends RecyclerView.Adapter<GlobalAdapter.ExampleViewHolder> implements Filterable {
    private final List<GlobalList> mGlobal;
    private final List<GlobalList> exampleListFull;
    private final OnItemClickListener mListener;
    private final Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<GlobalList> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (GlobalList item : exampleListFull) {
                    if (item.getText1().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mGlobal.clear();
            mGlobal.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    private ProgressBar mProgressBar;

    public GlobalAdapter(List<GlobalList> mGlobal, OnItemClickListener mListener) {
        this.mGlobal = mGlobal;
        exampleListFull = new ArrayList<>(mGlobal);
        this.mListener = mListener;
    }

    public interface OnItemClickListener {
        void onExerciseClick(int position);

        void onAddVolumeClick(int position);
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercises, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        GlobalList currentItem = mGlobal.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mGlobal.size();
    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView mTextView1;
        final TextView mTextView2;
        final Button mAddButton;
        final OnItemClickListener clickListener;

        ExampleViewHolder(View itemView, final OnItemClickListener clickListener) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.exercise);
            mTextView2 = itemView.findViewById(R.id.exerciseNotes);
            mAddButton = itemView.findViewById(R.id.add);
            this.clickListener = clickListener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onExerciseClick(getAdapterPosition());
                }
            });
            mAddButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onAddVolumeClick(getAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View view) {
        }
    }


}