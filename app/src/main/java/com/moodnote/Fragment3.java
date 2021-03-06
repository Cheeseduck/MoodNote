package com.moodnote;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.time.LocalDateTime;

public class Fragment3 extends Fragment {

    RecyclerView recyclerView;
    MoodItemAdapter adapter;

    Context context;

    MoodInfoDao moodInfoDao;

    Fragment3(MoodInfoDao moodInfoDao) {
        this.moodInfoDao = moodInfoDao;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_3, container, false);

        initUI(rootView);

        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initUI(ViewGroup rootView) {

        recyclerView = rootView.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new MoodItemAdapter(context, moodInfoDao);

        adapter.addItem(new Postit(LocalDateTime.now(), "하늘하늘하늘 하늘하늘하구나 날씨가 아주 하늘하늘해", "", 1));
        adapter.addItem(new Postit(LocalDateTime.now(), "주황주황주황", "", 2));
        adapter.addItem(new Postit(LocalDateTime.now(), "라면은 신라면 참깨라면도 먹고싶다", "", 3));
        adapter.addItem(new Postit(LocalDateTime.now(), "나는 방금 떡볶이를 먹었지", "", 2));
        adapter.addItem(new Postit(LocalDateTime.now(), "안드로이드는 너무 어려워", "", 3));
        adapter.addItem(new Postit(LocalDateTime.now(), "크롬크롬 구글구글 크롬크롬", "", 1));

        recyclerView.setAdapter(adapter);
    }
}