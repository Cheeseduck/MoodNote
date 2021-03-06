package com.moodnote;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    Fragment3 fragment3;
    Fragment4 fragment4;

    MoodInfoDao moodInfoDao;
    PostitDao postitDao;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodInfoDao = new MoodInfoDao();
        postitDao = new PostitDao();

        fragment3 = new Fragment3(moodInfoDao, postitDao);
        fragment4 = new Fragment4(moodInfoDao, postitDao);

        // test color
        moodInfoDao.insert(new MoodInfo("#90D5D8", "@drawable/clouds", "하늘하늘해"));
        moodInfoDao.insert(new MoodInfo("#F5CE65", "@drawable/flag", "주황주황해"));
        moodInfoDao.insert(new MoodInfo("#F58865", "@drawable/ramen", "라면먹을랭"));

        // test Postit
        postitDao.insert(new Postit(LocalDateTime.now(), "하늘하늘하늘 하늘하늘하구나 날씨가 아주 하늘하늘해", "", 1));
        postitDao.insert(new Postit(LocalDateTime.now(), "주황주황주황", "", 2));
        postitDao.insert(new Postit(LocalDateTime.now(), "라면은 신라면 참깨라면도 먹고싶다", "", 3));
        postitDao.insert(new Postit(LocalDateTime.now(), "나는 방금 떡볶이를 먹었지", "", 2));
        postitDao.insert(new Postit(LocalDateTime.now(), "안드로이드는 너무 어려워", "", 3));
        postitDao.insert(new Postit(LocalDateTime.now(), "크롬크롬 구글구글 크롬크롬", "", 1));

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment4).commit();
    }
}