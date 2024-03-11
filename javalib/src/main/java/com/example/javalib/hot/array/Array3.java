package com.example.javalib.hot.array;

class Array3 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;    // 关键是要加上这个代码
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int nums[], int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            ++start;
            --end;
        }
    }

}
