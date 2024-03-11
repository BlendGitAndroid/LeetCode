package com.example.javalib.hot.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Graph3 {

    Map<String, Boolean> map;

    public Graph3() {
        map = new HashMap<String, Boolean>();
    }

    public void insert(String word) {
        map.put(word, true);
    }

    public boolean search(String word) {
        return map.getOrDefault(word, false);
    }

    public boolean startsWith(String prefix) {
        Set<String> keys = map.keySet();
        boolean res = false;
        for (String key : keys) {
            if (key.length() >= prefix.length()) {
                String temp = key.substring(0, prefix.length());
                if (temp.equals(prefix)) {
                    res = true;
                }
            }
            // res = key.startsWith(prefix);
        }
        return res;
    }

}
