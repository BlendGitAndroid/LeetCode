package com.example.javalib;

import java.util.Arrays;

/**
 * 这道题刚看的时候，我就想到了投票法，但是不知道怎么写代码，
 * 后面我就想了中位数的方法。
 */
class Offer39 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Offer39().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count++;
                }
            }
        }
        return candidate;
    }
}
