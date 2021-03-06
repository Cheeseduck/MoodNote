package com.moodnote;

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
}
