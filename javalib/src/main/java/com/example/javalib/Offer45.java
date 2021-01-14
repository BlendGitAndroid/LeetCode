package com.example.javalib;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 做这道题，有两个注意点：
 * 1.比较。
 * 2.要比较两个String值加起来，其原理是快排。
 *
 * 但是手写快排我会，这个题没有理解。还是使用Arrays.sort来进行排序的。
 */
class Offer45 {

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 9, 5};
        System.out.println(new Offer45().minNumber2(nums));
    }

    public String minNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public void quickSort(String[] strs, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        String tmp = strs[i];
        while (i < j) {
            while (i < j && ((strs[j] + strs[start]).compareTo(strs[start] + strs[j])) >= 0) {  //最后一个值和开始值相加判断
                j--;
            }
            while (i < j && ((strs[i] + strs[start]).compareTo(strs[start] + strs[i])) <= 0) {  //开始一个值和开始值相加判断
                i++;
            }
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[start];
        strs[start] = tmp;
        quickSort(strs, start, i - 1);
        quickSort(strs, i + 1, end);
    }

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return (s + t1).compareTo(t1 + s);  //调用的Comparable接口的compareTo方法
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
