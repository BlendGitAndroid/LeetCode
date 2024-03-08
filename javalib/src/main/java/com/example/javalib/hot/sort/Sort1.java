package com.example.javalib.hot.sort;

import java.util.Arrays;

class Sort1 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
