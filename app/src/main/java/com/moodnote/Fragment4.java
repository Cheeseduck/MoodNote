package com.moodnote;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment4 extends Fragment {
    private static final String TAG = "Fragment4";

    private RecyclerView recyclerView;
    private PostItemAdapter adapter;

    private Context context;

    private MoodInfoDao moodInfoDao;
    private PostitDao postitDao;

    MoodInfo moodInfo;

    Fragment4(MoodInfoDao moodInfoDao, PostitDao postitDao) {
        this.moodInfoDao = moodInfoDao;
        this.postitDao = postitDao;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (context != null) {
            context = null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_4, container, false);

        if (getArguments() != null) {
            long moodId = getArguments().getLong("moodId");
            moodInfo = moodInfoDao.selectById(moodId);
        }

        initUI(rootView);

        return rootView;
    }

    private void initUI(ViewGroup rootView) {

        setMoodIconAndName(rootView);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new PostItemAdapter(context, moodInfoDao);

        try {
            ArrayList<Postit> postits = postitDao.selectByMood(moodInfo.getId());

            for (Postit postit : postits) {
                adapter.addItem(postit);
            }
        } catch (PostitNotFoundException e) {
            Log.d(TAG, e.getMessage());
        }

        recyclerView.setAdapter(adapter);
    }

    void setMoodIconAndName(ViewGroup rootView) {
        setMoodIcon(rootView.findViewById(R.id.moodIcon));
        setMoodName(rootView.findViewById(R.id.mood));
    }

    void setMoodIcon(ImageView v) {
        String iconStr = moodInfo.getIcon() + "_25";
        int icon = context.getResources().getIdentifier(iconStr, "drawable", context.getPackageName());

        v.setImageResource(icon);
    }

    void setMoodName(TextView v) {
        v.setText(moodInfo.getName());
    }
}
