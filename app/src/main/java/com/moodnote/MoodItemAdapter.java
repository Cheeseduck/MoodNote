package com.moodnote;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoodItemAdapter extends RecyclerView.Adapter<MoodItemAdapter.MoodItemViewHolder> {

    private ArrayList<Postit> items = new ArrayList<Postit>();
    private MoodInfoDao moodInfoDao;
    private Context context;

    MoodItemAdapter(Context context, MoodInfoDao moodInfoDao) {
        this.moodInfoDao = moodInfoDao;
        this.context = context;
    }

    @NonNull
    @Override
    public MoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mood_item, parent, false);
        return new MoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoodItemViewHolder holder, int position) {

        MoodInfo moodInfo = moodInfoDao.selectById(items.get(position).moodId);
        String iconStr = moodInfo.getIcon() + "_39";
        int icon = context.getResources().getIdentifier(iconStr, "drawable", context.getPackageName());

        holder.moodIcon.setImageResource(icon);
        holder.contents.setText(items.get(position).contents);
        holder.contents.setBackground(new ColorDrawable(Color.parseColor(moodInfo.getColor())));
        holder.mood.setText(moodInfo.getName());
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

    public void addItem(Postit item) { items.add(item); }
}


