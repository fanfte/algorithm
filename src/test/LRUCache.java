package test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tianen on 2019/6/3
 *
 * @author fanfte
 * @date 2019/6/3
 **/
class LRUCache {

    private LinkedHashMap<Integer, Integer> map;

    private Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(2, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {

        map.put(key, value);
    }
}
