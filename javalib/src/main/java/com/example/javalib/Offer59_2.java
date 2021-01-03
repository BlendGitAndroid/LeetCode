package com.example.javalib;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 这道题以为和之前的30题一样，但是那个题是栈，这个题的辅助工具我也用的是栈，结果就出现问题了。
 * 这道题提交了好几次，最后是用双端队列解决的。
 * <p>
 * 均摊时间复杂度满足 O(1)。因为最坏情况是某一次插入操作有 n 次出队操作，且每个数字只出队一次，
 * 那么把这 n 次出队平摊到前面的 n 次插入操作的话，均摊到每一次的出队操作就是 O(1) 了。
 */
class Offer59_2 {

    public static void main(String[] args) {
        Offer59_2 offer59_2 = new Offer59_2();
        offer59_2.push_back(1);
        offer59_2.push_back(2);
        offer59_2.push_back(5);
        offer59_2.push_back(3);
        System.out.println(offer59_2.pop_front());
        System.out.println(offer59_2.pop_front());
        System.out.println(offer59_2.pop_front());
        System.out.println(offer59_2.max_value());
    }

    private Queue<Integer> mQueue;
    private Deque<Integer> mMax;

    public Offer59_2() {
        mQueue = new LinkedList<>();
        mMax = new LinkedList<>();
    }

    public int max_value() {
        if (mMax.isEmpty()) {
            return -1;
        }
        return mMax.peekFirst();
    }

    public void push_back(int value) {
        mQueue.offer(value);
        while (!mMax.isEmpty() && mMax.peekLast() < value) {
            mMax.pollLast();
        }
        mMax.offerLast(value);
    }

    public int pop_front() {
        if (mQueue.isEmpty()) {
            return -1;
        }
        int a = mQueue.poll();
        if (a == mMax.peekFirst()) {
            mMax.pollFirst();
        }
        return a;
    }
}
