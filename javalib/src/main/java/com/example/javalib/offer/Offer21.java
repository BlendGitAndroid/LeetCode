package com.example.javalib.offer;

/**
 * 在这个题目中，我没有判断出a < b，而是a <= b，导致时间多运行2ms
 * 这是因为我把最后一个数也加上了，但是其实最后一个数不用判断。
 */
class Offer21 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        int[] result = new Offer21().exchange(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public int[] exchange(int[] nums) {
        int a = 0;
        int b = nums.length - 1;
        int temp;
        while (a < b) {
            while (a < b && nums[a] % 2 != 0) {    //是奇数
                ++a;
            }
            while (a < b && nums[b] % 2 == 0) { //是偶数
                --b;
            }
            if (a < b) {
                temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;
                ++a;
                --b;
            }
        }
        return nums;
    }

}
