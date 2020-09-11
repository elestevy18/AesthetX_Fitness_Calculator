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

import com.AesthetX.aesthetx.Classes.MuscleGroupObjects.MedialDeltoidList;

public class MedialDeltoidAdapter extends RecyclerView.Adapter<MedialDeltoidAdapter.ExampleViewHolder> {
    private final ArrayList<MedialDeltoidList> mMedialDeltoids;
    private final MedialDeltoidAdapter.OnItemClickListener mListener;
    private ProgressBar mProgressBar;

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public MedialDeltoidAdapter(ArrayList<MedialDeltoidList> mMedialDeltoids, MedialDeltoidAdapter.OnItemClickListener mListener) {
        this.mMedialDeltoids = mMedialDeltoids;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public MedialDeltoidAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercises, parent, false);
        return new MedialDeltoidAdapter.ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(MedialDeltoidAdapter.ExampleViewHolder holder, int position) {
        MedialDeltoidList currentItem = mMedialDeltoids.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    public interface OnItemClickListener {
        void onExerciseClick(int position);

        void onAddVolumeClick(int position);
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView mTextView1;
        final TextView mTextView2;
        final Button mAddButton;

        final MedialDeltoidAdapter.OnItemClickListener clickListener;

        ExampleViewHolder(View itemView, final MedialDeltoidAdapter.OnItemClickListener clickListener) {
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

    @Override
    public int getItemCount() {
        return mMedialDeltoids.size();
    }

}