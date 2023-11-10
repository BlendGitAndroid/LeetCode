package com.example.javalib.offer.pre;

public class FrogJumps {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 设青蛙跳上n级台阶有f(n)总方法，f(n)总方法分为两种：
     *
     * 最后一次跳了一级台阶，这类方法共有f(n-1)种；
     * 最后一次跳了两级台阶，这类方法共有f(n-2)种。
     * 因此，可以得出公式：f(n)=f(n-1)+f(n-2)，类似斐波那契数列
     */

    public int numWays(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 2, b = 1;
        for (int i = 2; i < n; i++) {
            a = a + b;
            b = a - b;
            a %= 1000000007;
        }
        return a;
    }

}
