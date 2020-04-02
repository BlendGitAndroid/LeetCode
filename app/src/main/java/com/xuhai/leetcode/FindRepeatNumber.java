package com.xuhai.leetcode;

public class FindRepeatNumber {

    /*
     找出数组中重复的数字。
     */
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        for (int i : nums) {
            if (i < 0 || i >= nums.length) {
                return -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                } else {
                    swap(nums, i, nums[i]);
                }
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
