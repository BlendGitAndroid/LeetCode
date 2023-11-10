package com.example.javalib.offer;

/**
 * 这道题是计算上三角和下三角的值，循环两遍。
 */
class Offer66 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] result = new Offer66().constructArr(a);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] result = new int[a.length];
        result[0] = 1;
        int tmp = 1;
        for (int i = 1; i < a.length; i++) {    //先计算下三角
            result[i] = a[i - 1] * tmp;
            tmp = result[i];
        }
        tmp = 1;
        for (int length = a.length - 1; length >= 0; length--) { //再计算上三角
            result[length] = result[length] * tmp;
            tmp = tmp * a[length];
        }
        return result;
    }
}
