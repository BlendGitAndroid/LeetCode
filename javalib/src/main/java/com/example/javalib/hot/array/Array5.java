package com.example.javalib.hot.array;

import java.util.HashSet;

class Array5 {

    public int firstMissingPositive(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }

}
