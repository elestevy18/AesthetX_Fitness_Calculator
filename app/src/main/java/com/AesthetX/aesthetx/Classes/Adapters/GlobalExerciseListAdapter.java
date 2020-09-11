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

import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.ExerciseList;

public class GlobalExerciseListAdapter extends RecyclerView.Adapter<GlobalExerciseListAdapter.ExampleViewHolder> {
    private final ArrayList<ExerciseList> mExercises;
    private final OnItemClickListener mListener;
    private ProgressBar mProgressBar;


    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public GlobalExerciseListAdapter(ArrayList<ExerciseList> mExercises, OnItemClickListener mListener) {
        this.mExercises = mExercises;
        this.mListener = mListener;
    }

    interface OnItemClickListener {
        void onExerciseClick(int position);

        void onAddExerciseClick(int position);
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
                    clickListener.onAddExerciseClick(getAdapterPosition());
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
        ExerciseList currentItem = mExercises.get(position);
        holder.mTextView1.setText(currentItem.getExerciseText1());
        holder.mTextView2.setText(currentItem.getExerciseText2());
    }

    @Override
    public int getItemCount() {
        return mExercises.size();
    }

}

