package com.moodnote;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostitDao {

    private static long nextId = 0;
    private Map<Long, Postit> map = new HashMap<Long, Postit>();

    public Postit selectById(long id) {
        return map.get(id);
    }

    public void insert(Postit postit) {
        postit.setId(++nextId);
        map.put(postit.getId(), postit);
    }

    public void update(Postit postit) {
        map.put(postit.getId(), postit);
    }

    public ArrayList<Postit> selectAll() { return new ArrayList<Postit>(map.values()); }

    public Postit selectRecentPostitByMoodId(Long moodId) {
        ArrayList<Postit> postits = selectAll();
        for (Postit postit : postits) {
            if (postit.getMoodId() == moodId) {
                return postit;
            }
        }

        throw new PostitNotFoundException("no postit having moodId" + String.valueOf(moodId));
    }

    public ArrayList<Postit> selectByMood(long moodId) {
        ArrayList<Postit> postits = new ArrayList<Postit>();

        for (Map.Entry<Long, Postit> entry : map.entrySet()) {
            if (entry.getValue().getMoodId() == moodId) {
                postits.add(entry.getValue());
            }
        }

        if (postits.isEmpty()) {
            throw new PostitNotFoundException("no postit having moodId" + String.valueOf(moodId));
        }

        return postits;
    }
}
