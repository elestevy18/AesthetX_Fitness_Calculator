package com.AesthetX.aesthetx.Classes.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.R;

import java.util.ArrayList;

import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.AnteriorDeltoidList;

public class AnteriorDeltoidAdapter extends RecyclerView.Adapter<AnteriorDeltoidAdapter.ExampleViewHolder> {
    private final ArrayList<AnteriorDeltoidList> mAnteriorDeltoids;
    private final OnItemClickListener mListener;
    private ProgressBar mProgressBar;

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public AnteriorDeltoidAdapter(ArrayList<AnteriorDeltoidList> mAnteriorDeltoids, OnItemClickListener mListener) {
        this.mAnteriorDeltoids = mAnteriorDeltoids;
        this.mListener = mListener;
    }

    public interface OnItemClickListener {
        void onExerciseClick(int position);

        void onAddVolumeClick(int position);
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

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercises, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        AnteriorDeltoidList currentItem = mAnteriorDeltoids.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mAnteriorDeltoids.size();
    }

}