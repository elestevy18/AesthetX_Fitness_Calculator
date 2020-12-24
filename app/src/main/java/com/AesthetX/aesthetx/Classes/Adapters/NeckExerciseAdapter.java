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

import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.ExerciseListByMuscleGroup;

public class NeckExerciseAdapter extends RecyclerView.Adapter<NeckExerciseAdapter.ExampleViewHolder> {
    private final ArrayList<ExerciseListByMuscleGroup> mNeckExercises;
    private final OnItemClickListener mListener;
    private ProgressBar mProgressBar;

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public NeckExerciseAdapter(ArrayList<ExerciseListByMuscleGroup> mNeckExercises, OnItemClickListener mListener) {
        this.mNeckExercises = mNeckExercises;
        this.mListener = mListener;
    }

    public interface OnItemClickListener {
        void onNeckClick(int position);

        void onAddNeckClick(int position);
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
                    clickListener.onNeckClick(getAdapterPosition());
                }
            });
            mAddButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onAddNeckClick(getAdapterPosition());
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
        ExerciseListByMuscleGroup currentItem = mNeckExercises.get(position);
        holder.mTextView1.setText(currentItem.getNeckText1());
        holder.mTextView2.setText(currentItem.getNeckText2());
    }

    @Override
    public int getItemCount() {
        return mNeckExercises.size();
    }

}