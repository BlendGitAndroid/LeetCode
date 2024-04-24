package com.example.javalib.hot.back_tracking;

import java.util.ArrayList;
import java.util.List;

class BackTracking2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>());
        for (int num : nums) {
            int size = lists.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<>(lists.get(i));
                newSub.add(num);
                lists.add(newSub);
            }
        }
        return lists;
    }

}
