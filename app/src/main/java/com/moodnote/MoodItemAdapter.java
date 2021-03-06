package com.moodnote;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoodItemAdapter extends RecyclerView.Adapter<MoodItemAdapter.MoodItemViewHolder> {

    private ArrayList<MoodInfo> items = new ArrayList<MoodInfo>();
    private PostitDao postitDao;
    private MoodInfoDao moodInfoDao;
    private Context context;

    MoodItemAdapter(Context context, PostitDao postitDao, MoodInfoDao moodInfoDao) {
        this.postitDao = postitDao;
        this.context = context;
        this.moodInfoDao = moodInfoDao;
    }

    @NonNull
    @Override
    public MoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mood_item, parent, false);
        return new MoodItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoodItemViewHolder holder, int position) {

        String iconStr = items.get(position).getIcon() + "_39";
        int icon = context.getResources().getIdentifier(iconStr, "drawable", context.getPackageName());

        holder.moodIcon.setImageResource(icon);
        holder.contents.setText(postitDao.selectRecentPostitByMoodId(items.get(position).getId()).getContents());
        holder.contents.setBackground(new ColorDrawable(Color.parseColor(items.get(position).getColor())));
        holder.mood.setText(items.get(position).getName());

        holder.mood.setTag(items.get(position).getId());
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    long moodId = (long) mood.getTag();
                    Bundle bundle = new Bundle();
                    bundle.putLong("moodId", moodId);

                    Fragment fragment = new Fragment4(moodInfoDao, postitDao);
                    fragment.setArguments(bundle);
                    replaceFragment(fragment);
                }
            });
        }
    }

    public void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void addItem(MoodInfo moodInfo) { items.add(moodInfo); }
}


