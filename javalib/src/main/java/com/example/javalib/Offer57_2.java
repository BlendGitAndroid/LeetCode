package com.example.javalib;

import java.util.ArrayList;
import java.util.List;

/**
 * 做这道题的关键，看清题目是连续的，利用双指针构成滑动窗口
 */
class Offer57_2 {

    public static void main(String[] args) {
        int[][] res = new Offer57_2().findContinuousSequence(9);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int i = 1;
        int j = 2;
        int s = 3;
        while (i < j) { //判断条件为i < j，因为当相加的值大于target时，会将i++，当一直大的时候，就会加
            if (s == target) {
                int[] ans = new int[j - i + 1]; //构建数组
                for (int k = i; k <= j; k++) {  //数组的左下标是从i开始，从j结束，但是包括j
                    ans[k - i] = k;
                }
                list.add(ans);
            }
            if (s >= target) {  //当s的值大于target的时候，就将i右移
                s -= i;
                i++;
            }
            if (s < target) {   //当s的值小于target的时候，就将j右移
                j++;
                s += j;
            }
        }
        return list.toArray(new int[0][]);
    }

}
