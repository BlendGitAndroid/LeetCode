package com.example.javalib.offer;

/**
 * 异或值:
 * 任何相等的两个数异或都是0。
 * 任何和0异或的数结果都等于本身。
 * 这道题知道是用异或，但是不知道怎么用，看了题解才知道，根据位来异或。
 */
class Offer56 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        int[] res = new Offer56().singleNumbers(nums);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int exo = 0;
        for (int i = 0; i < nums.length; i++) {
            exo = exo ^ nums[i];    //取到两个值的异或值
        }
        int div = 1;
        while ((div & exo) == 0) {  //从右向左，找到第一个1的值
            div = div << 1; //div左移
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((div & num) == 0) { //根据与结果是否等于0，进行二分
                a = a ^ num;
            } else {
                b = b ^ num;
            }
        }
        return new int[]{a, b};
    }
}
