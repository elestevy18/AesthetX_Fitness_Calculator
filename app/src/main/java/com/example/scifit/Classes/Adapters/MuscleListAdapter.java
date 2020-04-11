package com.example.scifit.Classes.Adapters;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scifit.Classes.MuscleGroupObjects.MuscleList;
import com.example.scifit.R;

import java.util.ArrayList;

public class MuscleListAdapter extends RecyclerView.Adapter<MuscleListAdapter.ExampleViewHolder> {
    private ArrayList<MuscleList> mMuscleList;
    private OnItemClickListener mListener;

    public MuscleListAdapter(ArrayList<MuscleList> mMuscleList, OnItemClickListener mListener){
        this.mMuscleList = mMuscleList;
        this.mListener = mListener;
    }

    public interface OnItemClickListener {
        void onItemCLick(int position);

        void onAddVolumeClick(int position);
    }




    public static class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;
        TextView mProgresstxt;
        TextView mMax;
        ProgressBar mProgress;
        //ProgressBar mProgress2;
        Button mNeckButton;

        OnItemClickListener clickListener;

        public ProgressBar getProgressBar() {
            return mProgress;
        }

        ExampleViewHolder(View itemView, final OnItemClickListener clickListener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.muscleVector);
            mTextView1 = itemView.findViewById(R.id.muscle);
            mTextView2 = itemView.findViewById(R.id.Neck_volume);
            mProgress = itemView.findViewById(R.id.neck_progress_bar);
            //mProgress2 = itemView.findViewById(R.id.neck_progress_bar);

            mProgresstxt = itemView.findViewById(R.id.progresstxt);
            mMax = itemView.findViewById(R.id.maxtxt);
            mNeckButton = itemView.findViewById(R.id.addVolume);
            this.clickListener = clickListener;


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemCLick(getAdapterPosition());
                }
            });


            mNeckButton.setOnClickListener(new View.OnClickListener() {
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.neck, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

        MuscleList currentItem = mMuscleList.get(position);
        holder.mProgress.setMax(currentItem.getMax());
        holder.mImageView.setImageResource(currentItem.getImageResourceNeck());
        holder.mTextView1.setText(currentItem.getNeckText1());
        holder.mTextView2.setText(currentItem.getNeckText2());
        holder.mProgresstxt.setText(currentItem.getprogresstxt());
        holder.mMax.setText(currentItem.getmaxtxt());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.mProgress.setProgress(currentItem.getProgress(), true);
        }else holder.mProgress.setProgress(currentItem.getProgress());

        MuscleList item = mMuscleList.get(position);
    }
    public void refresh(int position, MuscleList item){
        mMuscleList.set(position, item);
        notifyItemChanged(position);
    }


    @Override
    public int getItemCount() {
        return mMuscleList.size();
    }

}


