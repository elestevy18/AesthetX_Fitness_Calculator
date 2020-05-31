package Aesthet.X.adfree.Classes.Adapters;

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

import Aesthet.X.adfree.Classes.MuscleGroupObjects.BWList;

public class BWAdapter extends RecyclerView.Adapter<BWAdapter.ExampleViewHolder> implements Filterable {
    private final List<BWList> mBW;
    private final List<BWList> exampleListFull;
    private final OnItemClickListener mListener;
    private final Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<BWList> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (BWList item : exampleListFull) {
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
            mBW.clear();
            mBW.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
    private ProgressBar mProgressBar;

    public BWAdapter(List<BWList> mBW, OnItemClickListener mListener) {
        this.mBW = mBW;
        exampleListFull = new ArrayList<>(mBW);
        this.mListener = mListener;
    }

    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercises, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        BWList currentItem = mBW.get(position);
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mBW.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
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


}