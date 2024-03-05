package com.example.javalib.hot;

import java.util.HashSet;

class Hot3 {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                int len = 0;
                while (set.contains(num++)) {
                    len++;
                }
                result = Math.max(result, len);
            }
        }
        return result;
    }
}
