package com.example.javalib.offer;

/**
 * 遇到有序的数组，先想到二分。
 */
class Offer11 {

    public static void main(String[] args) {
        int[] array = {-1, -1, -1, -1};
        System.out.println(new Offer11().minArray(array));
    }

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        if (numbers.length == 1) {  //注意区分长度为1，否则死循环
            return numbers[0];
        }
        int p1 = 0;
        int p2 = numbers.length - 1;
        int middle = p1;
        while (numbers[p1] >= numbers[p2]) {
            if (p2 - p1 == 1) {
                return Math.min(numbers[p1], numbers[p2]);
            }
            middle = (p1 + p2) / 2;
            if (numbers[p1] == numbers[middle] && numbers[middle] == numbers[p2]) {
                int result = numbers[p1];
                for (int i = p1 + 1; i < p2; i++) {
                    if (result > numbers[i]) {
                        result = numbers[i];
                    }
                }
                return result;
            } else if (numbers[middle] >= numbers[p1]) {
                p1 = middle;
            } else {
                p2 = middle;
            }
        }
        return numbers[middle];
    }

}
