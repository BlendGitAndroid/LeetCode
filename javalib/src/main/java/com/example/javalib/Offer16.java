package com.example.javalib;

/**
 * 位运算能够加快运算速度
 * <p>
 * 做这道题，没有考虑小数点，也忘记了小数点，但是这不是重点，重点是超时了，常规做法肯定不行了。
 * 常规做法的时间复杂度是n。
 * 而快速幂法的时间复杂度是log2n。
 * <p>
 * <p>
 * 二分推导：快速幂实际上是二分推导的一种应用。
 * 当exponent是0的时候，直接返回1即可，
 * 当exponent小于0的时候，需要把它转化为正数才能更方便计算，同时base要变为1/base。
 * 当exponent大于0的时候要分为两种情况，一种是偶数，一种是奇数。
 * 1：如果exponent是偶数我们只需要计算
 * Power(base*base, exponent/2)。举个例子，比如我们要计算Power（3，8），我们可以改为
 * Power（3*3，8/2），也就是Power（9，4）。
 * 2：如果exponent是奇数，我们只需要计算
 * base*Power(base*base, exponent/2)，比如Power（3，9），我们只需要计算3*Power（3*3，9/2），也就是3*Power（9，4）。
 */
class Offer16 {

    public static void main(String[] args) {
        System.out.println(new Offer16().myPow2(2.0000, 6));
    }

    //超时
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = 1;
        double e = n >= 0 ? n : -n;
        while (e > 0) {
            res = res * x;
            e--;
        }
        if (n < 0) {
            return 1 / res;
        }
        return res;
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = 1.0;
        // Java代码中int32变量n范围n∈[−2147483648,2147483647] ，因此当n=-2147483648时执行n=-n会因越界而赋值出错。
        // 解决方法是先将n存入long变量b，后面用b操作即可。
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        while (b > 0) {
            if ((b & 1) == 1) {    //若出现奇数的情况，则将其变成偶数运算，而且最后一位运行当b == 1时也成立
                res = res * x;
            }
            x = x * x;  //是偶数的是自身相乘
            b = b >> 1; //b除以2
        }
        return res;
    }

}
