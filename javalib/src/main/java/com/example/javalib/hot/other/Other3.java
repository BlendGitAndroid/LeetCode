package com.example.javalib.hot.other;

import java.util.HashMap;

class Other3 {

    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        hashMap.put(1, 0);
        hashMap.put(2, 0);
        for (int num : nums) {
            int value = hashMap.get(num);
            hashMap.put(num, ++value);
        }
        int index = 0;
        for (int i = 0; i < hashMap.get(0); i++) {
            nums[index] = 0;
            index++;
        }
        for (int i = 0; i < hashMap.get(1); i++) {
            nums[index] = 1;
            index++;
        }
        for (int i = 0; i < hashMap.get(2); i++) {
            nums[index] = 2;
            index++;
        }
    }

}
