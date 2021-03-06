package com.moodnote;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostItemAdapter extends RecyclerView.Adapter<PostItemAdapter.PostItemViewHolder> {

    private ArrayList<Postit> items = new ArrayList<Postit>();
    private MoodInfoDao moodInfoDao;
    private Context context;

    PostItemAdapter(Context context, MoodInfoDao moodInfoDao) {
        this.moodInfoDao = moodInfoDao;
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
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class PostItemViewHolder extends  RecyclerView.ViewHolder {
        TextView contents;

        public PostItemViewHolder(View itemView) {
            super(itemView);

            contents = itemView.findViewById(R.id.contents);
        }
    }

    public void addItem(Postit item) { items.add(item); }
}
