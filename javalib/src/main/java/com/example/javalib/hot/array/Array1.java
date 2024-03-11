package com.example.javalib.hot.array;

class Array1 {

    public int maxSubArray(int[] nums) {

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 1], 0);   // 前一个数字和0比
            res = Math.max(res, nums[i]);
        }

        return res;
    }

}
