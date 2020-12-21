package com.example.javalib;

class Offer40 {

    public static void main(String[] args) {

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                result[i] = arr[i];
                if (result[i] > max) {
                    max = result[i];
                    maxIndex = i;
                }
            }
            if (max > arr[i]) {
                result[maxIndex] = arr[i];

            }
        }
        return result;
    }

}
