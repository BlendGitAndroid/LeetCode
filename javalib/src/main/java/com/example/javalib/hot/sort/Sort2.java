package com.example.javalib.hot.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Sort2 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                int count = hashMap.get(nums[i]) + 1;
                hashMap.put(nums[i], count);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        // 创建一个自定义Comparator，使得PriorityQueue按照从大到小的顺序排列
        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hashMap.get(o1) - hashMap.get(o2); // 自定义排序,使用Hashmap实现从小到大排列
            }
        };

        // 排序类
        PriorityQueue<Integer> queue = new PriorityQueue<>(customComparator);

        for (Integer key : hashMap.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (hashMap.get(key) > hashMap.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.remove();
        }
        return result;
    }

}
