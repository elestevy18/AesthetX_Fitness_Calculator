package com.example.scifit.Classes.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.scifit.Classes.MuscleGroupObjects.MedialDeltoidList;
import com.example.scifit.R;
import java.util.ArrayList;

public class MedialDeltoidAdapter extends RecyclerView.Adapter<com.example.scifit.Classes.Adapters.MedialDeltoidAdapter.ExampleViewHolder> {
    private ArrayList<MedialDeltoidList> mMedialDeltoids;
    private com.example.scifit.Classes.Adapters.MedialDeltoidAdapter.OnItemClickListener mListener;
    ProgressBar mProgressBar;

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public MedialDeltoidAdapter(ArrayList<MedialDeltoidList> mMedialDeltoids, com.example.scifit.Classes.Adapters.MedialDeltoidAdapter.OnItemClickListener mListener){
        this.mMedialDeltoids = mMedialDeltoids;
        this.mListener = mListener;
    }

    public interface OnItemClickListener {
        void onExerciseClick(int position);
        void onAddVolumeClick(int position);
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextView1;
        public TextView mTextView2;
        public Button mAddButton;

        com.example.scifit.Classes.Adapters.MedialDeltoidAdapter.OnItemClickListener clickListener;

        public ExampleViewHolder(View itemView, final com.example.scifit.Classes.Adapters.MedialDeltoidAdapter.OnItemClickListener clickListener) {
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
    public com.example.scifit.Classes.Adapters.MedialDeltoidAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercises, parent, false);
        return new com.example.scifit.Classes.Adapters.MedialDeltoidAdapter.ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(com.example.scifit.Classes.Adapters.MedialDeltoidAdapter.ExampleViewHolder holder, int position) {
        MedialDeltoidList currentItem = mMedialDeltoids.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mMedialDeltoids.size();
    }

}