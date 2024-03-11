package com.example.javalib.hot.array;

class Array4 {

    public int[] productExceptSelf(int[] nums) {

        int result[] = new int[nums.length];

        // 计算下三角的值
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 计算上三角的值
        int tmp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            tmp = tmp * nums[i + 1];
            result[i] = result[i] * tmp;
        }

        return result;
    }

}
