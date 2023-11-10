package com.example.javalib.offer;

/**
 *  二进制中1的个数
 *  题目中说要无符号数，所以要用无符号数的右移
 *  还有这里要判断最后一位是否是1，所以用&运算来判断
 */
class Offer15 {

    public static void main(String[] args) {
        System.out.println(new Offer15().hammingWeight(111));
    }

    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            num += n & 1;
            n >>>= 1;
        }
        return num;
    }

}
