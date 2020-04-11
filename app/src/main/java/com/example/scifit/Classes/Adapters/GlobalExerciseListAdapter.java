package com.example.scifit.Classes.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.MuscleGroupObjects.ExerciseList;

import com.example.scifit.R;

import java.util.ArrayList;

public class GlobalExerciseListAdapter extends RecyclerView.Adapter<GlobalExerciseListAdapter.ExampleViewHolder> {
    private ArrayList<ExerciseList> mExercises;
    private OnItemClickListener mListener;
    ProgressBar mProgressBar;


    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public GlobalExerciseListAdapter(ArrayList<ExerciseList> mExercises, OnItemClickListener mListener){
        this.mExercises = mExercises;
        this.mListener = mListener;
    }

    public interface OnItemClickListener {
        void onExerciseClick(int position);
        void onAddExerciseClick(int position);
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextView1;
        public TextView mTextView2;
        public Button mAddButton;

        OnItemClickListener clickListener;

        public ExampleViewHolder(View itemView, final OnItemClickListener clickListener) {
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

