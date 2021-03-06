package com.moodnote;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Fragment3 extends Fragment {

    RecyclerView recyclerView;
    MoodItemAdapter adapter;

    Context context;

    MoodInfoDao moodInfoDao;
    PostitDao postitDao;

    Fragment3(MoodInfoDao moodInfoDao, PostitDao postitDao) {
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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_3, container, false);

        initUI(rootView);

        return rootView;
    }

    private void initUI(ViewGroup rootView) {

        recyclerView = rootView.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new MoodItemAdapter(context, moodInfoDao);

        ArrayList<Postit> postits = postitDao.selectAll();

        for (Postit postit : postits) {
            adapter.addItem(postit);
        }

        recyclerView.setAdapter(adapter);
    }
}