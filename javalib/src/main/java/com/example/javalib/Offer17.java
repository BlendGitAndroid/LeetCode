package com.example.javalib;

class Offer17 {

    public static void main(String[] args) {
        int[] nums = new Offer17().printNumbers(3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int[] printNumbers(int n) {
        int num = 1;
        while (n != 0) {
            num = num * 10;
            --n;
        }
        int[] nums = new int[--num];
        for (int i = 1; i <= num; i++) {
            nums[i - 1] = i;
        }
        return nums;
    }

}
