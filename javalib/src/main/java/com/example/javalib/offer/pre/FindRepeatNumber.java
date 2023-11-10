package com.example.javalib.offer.pre;

/**
 * 这个题目是长度为n的数组，nums里所有的元素都在0 - n-1之间，如果没有重复，调整数组位置后，正好 i == nums[i]。
 * 解体方法是：进行原地交换。
 */
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
