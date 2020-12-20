package com.example.javalib;


/**
 * 看到这个题时，我的第一反应是利用排序数组的二分法，但是不能得出结果。
 * 看了一下结果，利用双指针法。
 */
class Offer57 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = new Offer57().twoSum(nums, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[2];
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int n = nums[i] + nums[j];
            if (n == target) {
                result[0] = nums[i];
                result[1] = nums[j];
                break;
            } else if (n > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
