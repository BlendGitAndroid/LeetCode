package com.example.javalib;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 做这个题目，理解错中位数的意思了，中位数就是排序后中间的数。
 * <p>
 * 使用一个大顶堆和一个小顶堆，小顶堆保存较大的一半，大顶堆保存较小的一半，
 * 当为奇数时，小顶堆的堆顶就是中位数，
 * 当为偶数时，小顶堆和大顶堆的堆顶的平均数。
 * <p>
 * 这道题真的很巧妙，厉害。
 */
class Offer41 {

    public static void main(String[] args) {
        Offer41 offer41 = new Offer41();
        offer41.addNum(2);
        offer41.addNum(3);
        offer41.addNum(4);
        System.out.println(offer41.findMedian());
    }

    Queue<Integer> A;
    Queue<Integer> B;

    //PriorityQueue底层使用的是堆排序，所以能用到这里
    public Offer41() {
        A = new PriorityQueue<>(); //小顶堆，保存较大的一半
        B = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        }); //大顶堆，保存较小的一半
    }

    //如此这样，才能保证A中的元素都比B中的大
    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);  //为奇数时，先放入A中进行调整
            B.add(A.poll());    //再从A中拿出最小的元素放入B这个大顶堆中
        } else {
            B.add(num); //为偶数时，将新元素先放入B中进行调整
            A.add(B.poll());    //然后再从B中拿到最大的元素放入A这个小顶堆中
        }
    }

    public double findMedian() {
        if (A.size() == B.size()) {
            return (A.peek() + B.peek()) / 2.0;
        } else {
            return A.peek();
        }
    }
}
