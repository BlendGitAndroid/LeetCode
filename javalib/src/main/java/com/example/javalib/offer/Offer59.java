package com.example.javalib.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 这道题我刚开始写的时候，思路是从头到尾遍历数组，用一个数字来记录当前窗口的最大值，这也是暴力算法，但是在我调试的过程中，
 * 遇到了各种问题，提交了四次才通过，根本问题就是理不清楚数组的下标什么时候该设置什么的值。
 * 最后还遇到一个问题就是不知道怎么将List转化为int数组，用了笨办法。
 * 方法二是对方法一的改进，但也是暴力解决。改进的地方在于能够知道最后生成数组的大小，为nums.length - k + 1个大小。
 * <p>
 * 看了解题思路，这道题和我之前做的一个题思路很像，包含min函数的栈，这里使用一个双端队列，始终保持队头的元素是最大的。
 */
class Offer59 {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

        int[] result = new Offer59().maxSlidingWindow2(nums, 3);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        List<Integer> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (j < k) {
                if (nums[i] > max) {
                    max = nums[i];
                }
                j++;
            } else {
                list.add(max);
                if (max != nums[i]) {
                    max = Integer.MIN_VALUE;
                    for (int n = i - k + 1; n <= i; n++) {
                        if (nums[n] > max) {
                            max = nums[n];
                        }
                    }
                }
            }
        }
        list.add(max);  //将最后一个加入
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int length = nums.length - k + 1;
        int[] result = new int[length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            }
        }
        result[0] = max;
        for (int i = 1; i < length; i++) {
            max = Integer.MIN_VALUE;
            for (int n = i; n < i + k; n++) {
                if (nums[n] > max) {
                    max = nums[n];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();  //使用一个双端队列，始终保持队头的元素是最大的
        int[] res = new int[nums.length - k + 1];   //最后返回的数组
        for (int i = 0; i < k; i++) {   //未形成窗口
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) { //如果队尾元素小于nums[i]
                deque.removeLast(); //从队尾移除
            }
            deque.addLast(nums[i]); //从队尾插入
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) { //形成窗口后
            if (deque.peekFirst() == nums[i - k]) { //如果队头第一个元素等于被移出的元素，则移出队头
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {    //队尾元素小于当前值，则不断移除
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
