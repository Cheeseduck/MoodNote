package com.moodnote;

import java.util.HashMap;
import java.util.Map;

public class MoodInfoDao {

    private static long nextId = 0;
    private Map<Long, MoodInfo> map = new HashMap<Long, MoodInfo>();

    public MoodInfo selectById(long id) {
        return map.get(id);
    }

    public void insert(MoodInfo moodInfo) {
        moodInfo.setId(++nextId);
        map.put(moodInfo.getId(), moodInfo);
    }

    public void update(MoodInfo moodInfo) {
        map.put(moodInfo.getId(), moodInfo);
    }
}
