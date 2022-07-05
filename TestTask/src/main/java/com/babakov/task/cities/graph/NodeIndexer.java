package com.babakov.task.cities.graph;

import java.util.HashMap;
import java.util.Map;


public class NodeIndexer {

    private final Map<String, Integer> map = new HashMap<>();
    private int lastIndex = 1;

    public void add(String name) {
        if (map.containsKey(name)) {
            throw new IllegalArgumentException("There are this name in nodes");
        }
        map.put(name, lastIndex);
        lastIndex++;
    }

    public int getIndex(String name) {
        if (!map.containsKey(name)) {
            throw new IllegalArgumentException("No such name");
        }
        return map.get(name);
    }
}
