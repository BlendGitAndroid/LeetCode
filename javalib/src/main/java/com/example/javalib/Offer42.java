package com.example.javalib;

/**
 * 动态规划：分析是从大到小，写代码是从小到大计算过程中会把结果都记录下，最终结果在记录中找到。
 * 这道题就使用的是动态规划，这个数组的原始值随着遍历的增加而改变，必须改变，因为为了比较，
 * 而result里面始终保持的是连续数组的最大值。
 */
class Offer42 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Offer42().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result = nums[0];   //result的值始终保持最高
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 1], 0);   //若前一个值是一个小于等于0的值，则还是原来的nums[i]
            result = Math.max(result, nums[i]); //然后将result和现在这个值对比，若是现在这个值大，则result为现在这个值
        }
        return result;

    }

}
