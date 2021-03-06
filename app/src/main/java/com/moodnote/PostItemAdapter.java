package com.moodnote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostItemAdapter extends RecyclerView.Adapter<PostItemAdapter.PostItemViewHolder> {

    private ArrayList<PostItem> items = new ArrayList<PostItem>();

    @NonNull
    @Override
    public PostItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostItemViewHolder holder, int position) {
        holder.contents.setText(items.get(position).contents);
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

    public void addItem(PostItem item) { items.add(item); }
}
