package com.moodnote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoodItemAdapter extends RecyclerView.Adapter<MoodItemAdapter.MoodItemViewHolder> {

    private ArrayList<MoodItem> items = new ArrayList<MoodItem>();


    @NonNull
    @Override
    public MoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mood_item, parent, false);
        return new MoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoodItemViewHolder holder, int position) {

        holder.moodIcon.setImageResource(items.get(position).moodIcon);
        holder.contents.setText(items.get(position).contents);
        holder.mood.setText(items.get(position).mood);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MoodItemViewHolder extends RecyclerView.ViewHolder {

        ImageView moodIcon;
        TextView contents;
        TextView mood;

        public MoodItemViewHolder(View itemView) {
            super(itemView);

            moodIcon = itemView.findViewById(R.id.moodIcon);
            contents = itemView.findViewById(R.id.contents);
            mood = itemView.findViewById(R.id.mood);
        }
    }

    public void addItem(MoodItem item) { items.add(item); }
}


