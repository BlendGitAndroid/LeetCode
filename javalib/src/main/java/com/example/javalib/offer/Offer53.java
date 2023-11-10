package com.example.javalib.offer;

import java.util.HashMap;

/**
 * 这道题我用的是HashMap，但是更简单的是用直接每一个数字比较，得出结果。
 * 还有这是一个排序数组，可以使用二分查找，但是代码写起来还是比较麻烦的。
 */
class Offer53 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(new Offer53().search1(nums, 8));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashMap.get(num) == null) {
                hashMap.put(num, 1);
            } else {
                int n = hashMap.get(num);
                hashMap.put(num, ++n);
            }
        }
        return hashMap.get(target) == null ? 0 : hashMap.get(target);
    }

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {    //寻找右边界
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        if (j >= 0 && nums[j] != target) return 0;  //i是右边界，j是i的左边一个，用j来判断
        i = 0;
        j = nums.length - 1;
        while (i <= j) {    //寻找左边界
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }
}
