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

public class Fragment3 extends Fragment {

    RecyclerView recyclerView;
    MoodItemAdapter adapter;

    Context context;

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

        adapter = new MoodItemAdapter();

        adapter.addItem(new MoodItem(R.drawable.clouds_39, "안녕 나는 신지민 하늘하늘한 기분이지 안녕녕안안뇽", "하늘하늘해"));
        adapter.addItem(new MoodItem(R.drawable.flag_39, "주황주황주황", "주황주황해"));
        adapter.addItem(new MoodItem(R.drawable.ramen_39, "라면은 신라면 참깨라면도 먹고싶다", "라면먹을랭"));
        adapter.addItem(new MoodItem(R.drawable.ramen_39, "라면은 신라면 참깨라면도 먹고싶다", "라면먹을랭"));
        adapter.addItem(new MoodItem(R.drawable.ramen_39, "라면은 신라면 참깨라면도 먹고싶다", "라면먹을랭"));

        recyclerView.setAdapter(adapter);
    }
}