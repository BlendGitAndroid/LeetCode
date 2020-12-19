package com.example.javalib;

/**
 * 这道题刚开始第一步写错了，后来改了下才成功。
 * 但是在二分查找中，什么才有i <= j，还是都需要，这个需要看下。
 */
class Offer53_2 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(new Offer53_2().missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (m == nums[m]) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public int missingNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (m == nums[m]) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        if (nums[i] == i) {
            return i + 1;
        }
        return i;
    }

}
