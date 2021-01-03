package com.example.javalib;

/**
 * 看错了，不能使用乘除法，后面又用了A?B:C，所以才有下面的这样
 */
class Offer64 {

    public static void main(String[] args) {
        System.out.println(new Offer64().sumNums(9));
    }

    public int sumNums(int n) {
        return n == 0 ? n : n + sumNums(n - 1);
    }
}
