package com.moodnote;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;
import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PostItemAdapter extends RecyclerView.Adapter<PostItemAdapter.PostItemViewHolder> {

    private ArrayList<Postit> items = new ArrayList<Postit>();
    private MoodInfoDao moodInfoDao;
    private PostitDao postInfoDao;
    private Context context;
    private PopupWindow mPopupWindow;

    PostItemAdapter(Context context, MoodInfoDao moodInfoDao, PostitDao postitDao) {
        this.moodInfoDao = moodInfoDao;
        this.postInfoDao = postitDao;
        this.context = context;
    }

    @NonNull
    @Override
    public PostItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostItemViewHolder holder, int position) {
        MoodInfo moodInfo = moodInfoDao.selectById(items.get(position).getMoodId());

        holder.contents.setText(items.get(position).getContents());
        holder.contents.setBackground(new ColorDrawable(Color.parseColor(moodInfo.getColor())));
        holder.contents.setTag(items.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class PostItemViewHolder extends RecyclerView.ViewHolder {
        ImageView moodIcon;
        TextView contents;
        TextView mood;

        public PostItemViewHolder(View itemView) {
            super(itemView);

            moodIcon = itemView.findViewById(R.id.moodIcon);
            contents = itemView.findViewById(R.id.contents);
            mood = itemView.findViewById(R.id.mood);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    long contentId = (long)contents.getTag();
                    CustomDialog oDialog = new CustomDialog(context, moodInfoDao, postInfoDao, contentId);
                    oDialog.setCancelable(false);
                    oDialog.show();
                }
            });
        }
    }

    public void addItem(Postit item) { items.add(item); }
}