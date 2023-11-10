package com.example.javalib.offer;

/**
 * 这个一开始都没有思路。
 * 文中说不使用运算符进行两个整数的加法计算，所以在这里我们就用把这两个整数当初二进制来进行加法计算。
 * a或b为无进位和
 * a与b为进位，然后使用左移1位<<1，来表示左进一位
 * 当没有进位的时候，表示已经完成了加法计算
 */
class Offer65 {

    public static void main(String[] args) {
        System.out.println(new Offer65().add(1, 2));
    }

    /**
     * 交换a和b的值
     */
    public void change(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + "--" + b);
    }


    public int add(int a, int b) {
        while (b != 0) { //当没有进位的时候，就代表已经相加完了
            int c = (a & b) << 1;   //先计算进位，c = 进位
            a = a ^ b;  //在计算非进位，a = 非进位
            b = c;  //将进位赋值给b
        }
        return a;
    }

    public int add1(int a, int b) {
        int sum;
        int carry;
        do {
            sum = a ^ b;    //不考虑进位
            carry = (a & b) << 1;   //考虑进位
            a = sum;
            b = carry;
        } while (b != 0);
        return a;
    }
}
