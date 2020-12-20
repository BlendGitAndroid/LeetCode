package com.example.javalib;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 在这道题中只要最大值 - 最小值 < 5就行，就是不使用排序，使用集合+遍历。
 */
class Offer61 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new Offer61().isStraight(nums));
    }

    public boolean isStraight1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
        }
        return max - min < 5;
    }

    public boolean isStraight(int[] nums) {
        int zero = 0;
        int index = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i + 1] - nums[i] == 0) {
                return false;
            } else {
                index = nums[i + 1] - nums[i] == 1 ? index : nums[i + 1] - nums[i] - 1 + index;
            }
        }
        return zero >= index;
    }

}
