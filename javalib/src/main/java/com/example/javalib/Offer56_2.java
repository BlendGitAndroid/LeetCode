package com.example.javalib;

/**
 * 看了这个题，没有一点思路。
 * 看了解析，使用位运算，只有一个数是单个的，其余的都是三个的，那么将其转换为二进制话，所有二进制加起来，能被3整除的，
 * 说明剩下的那一位是0，不能被整除的，说明是1。
 * 因为int最大的值到2^31，所以二进制最大就是32位。
 */
class Offer56_2 {

    public static void main(String[] args) {
        int[] nums = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(new Offer56_2().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {  //将所有的数字按位相加
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;   //位运算，每一位和1相与
                num >>>= 1; //无符号数右移
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (counts[i] % 3 != 0) {
                res += Math.pow(2, i);
            }
        }
        return res;
    }
}
