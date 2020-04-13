package com.example.javalib;

public class Fibonacci {

    /**
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * <p>
     * 这道题目注意一个是取模，另外一个就是不能用递归，递归会超时。
     */

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 1;
        int b = 0;
        for (int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
            a %= 1000000007;
        }
        return a;
    }

}
