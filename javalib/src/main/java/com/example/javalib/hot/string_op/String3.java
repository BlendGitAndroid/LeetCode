package com.example.javalib.hot.string_op;

import java.util.HashMap;

class String3 {

    public static void main(String[] args) {
        subarraySum(new int[]{1, 1, 1}, 2);
    }

    // 使用前缀和
    public static int subarraySum(int[] nums, int k) {

        int result = 0;

        // 构造前缀和
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int sum0_i = 0;
        for (int i = 0; i < nums.length; i++) {
            sum0_i += nums[i];

            // 这是我们想找的前缀和 nums[0..j]
            int sum0_j = sum0_i - k;

            // 如果前面有这个前缀和，则直接更新答案
            if (hashMap.containsKey(sum0_j)) {
                result = result + hashMap.get(sum0_j);
            }

            // 把前缀和 nums[0..i] 加入并记录出现次数
            hashMap.put(sum0_i, hashMap.getOrDefault(sum0_i, 0) + 1);
        }

        return result;
    }

    // 使用前缀和
    public static int subarraySum2(int[] nums, int k) {

        int result = 0;

        // 构造前缀和
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sums[i] - sums[j] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int subarraySum1(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

}
