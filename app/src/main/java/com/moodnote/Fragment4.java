package com.moodnote;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment4 extends Fragment {
    RecyclerView recyclerView;
    PostItemAdapter adapter;

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

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_4, container, false);

        initUI(rootView);

        return rootView;
    }

    private void initUI(ViewGroup rootView) {

        recyclerView = rootView.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new PostItemAdapter();

        adapter.addItem(new PostItem("안녕 나는 신지민 하늘하늘한 기분이지 안녕녕안안뇽"));
        adapter.addItem(new PostItem("주황주황주황"));
        adapter.addItem(new PostItem("라면은 신라면 참깨라면도 먹고싶다"));
        adapter.addItem(new PostItem("라면은 신라면 참깨라면도 먹고싶다"));
        adapter.addItem(new PostItem("라면은 신라면 참깨라면도 먹고싶다"));

        recyclerView.setAdapter(adapter);
    }
}
