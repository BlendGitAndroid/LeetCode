package com.example.javalib.hot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Hot1 {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(target - nums[i])) {
                hashMap.put(nums[i], i);
            } else {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
        }
        return new int[]{};
    }

}
