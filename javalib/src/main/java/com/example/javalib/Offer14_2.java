package com.example.javalib;

/**
 * 因为这个是大数求解，所以要使用long型，而不是int型。
 */
class Offer14_2 {

    public static void main(String[] args) {
        System.out.println(new Offer14_2().cuttingRope2(120));
    }


    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        if (n == 4) {
            return 4;
        }
        long res = 1;
        while (n > 4) {
            res = res * 3;
            res = res % 1000000007;
            n = n - 3;
        }
        //最后n的值只有可能是：2、3、4。而2、3、4能得到的最大乘积恰恰就是自身值
        return (int) (res * n % 1000000007);
    }

}
