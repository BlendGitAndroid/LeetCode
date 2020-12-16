package com.example.javalib;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 在这个题目中，我使用的是Stack，而官方给出的答案是LinkedList，这两个有什么区别吗？
 * 这个需要我去好好的理解理解了。
 * 但是不管这两个，执行耗时和内存消耗都很大。
 */
class Offer09 {

    private Deque<Integer> in;
    private Deque<Integer> out;

    public static void main(String[] args) {
        Offer09 offer09 = new Offer09();
        offer09.appendTail(1);
        offer09.appendTail(2);
        offer09.appendTail(3);
        offer09.appendTail(4);
        System.out.println(offer09.deleteHead());
        System.out.println(offer09.deleteHead());
        System.out.println(offer09.deleteHead());
    }

    public Offer09() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()) {
            return out.pop();
        } else if (!in.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.pop();
        } else {
            return -1;
        }

    }

}
