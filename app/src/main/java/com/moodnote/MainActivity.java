package com.moodnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Fragment3 fragment3;
    Fragment4 fragment4;

    MoodInfoDao moodInfoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodInfoDao = new MoodInfoDao();

        fragment3 = new Fragment3(moodInfoDao);
        fragment4 = new Fragment4();

        // test color
        moodInfoDao.insert(new MoodInfo("#90D5D8", "@drawable/clouds", "하늘하늘해"));
        moodInfoDao.insert(new MoodInfo("#F5CE65", "@drawable/flag", "주황주황해"));
        moodInfoDao.insert(new MoodInfo("#F58865", "@drawable/ramen", "라면먹을랭"));

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
    }
}