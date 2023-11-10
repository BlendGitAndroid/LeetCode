package com.example.javalib.offer;

class Offer03 {

    /**
     * 找出数组中重复的数字。
     * <p>
     * <p>
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     */
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Offer03().find2(array));
    }

    //对于这道题，我这多使用了一个空间数组，初始化赋值为-1，浪费了空间
    public int find(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result = -1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (res[nums[i]] == -1) {
                res[nums[i]] = nums[i];
            } else {
                result = nums[i];
                break;
            }
        }
        return result;
    }

    private int find2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    //还能利用Set的没有重复值的特性

}
