package com.example.javalib.offer;

import java.util.Stack;

/**
 * 普通栈的 push() 和 pop() 函数的复杂度为 O(1)O(1) ；而获取栈最小值 min() 函数需要遍历整个栈，复杂度为 O(N)O(N) 。
 * 将 min() 函数复杂度降为 O(1)O(1) ，可通过建立辅助栈实现；
 * 数据栈 A：栈 A 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
 * 辅助栈 B：栈 B 中存储栈 A 中所有 非严格降序 的元素，则栈 A 中的最小元素始终对应栈 B 的栈顶元素，即 min() 函数只需返回栈 B 的栈顶元素即可。
 *
 */
class Offer30 {

    public static void main(String[] args) {
        Offer30 offer30 = new Offer30();
        offer30.push(4);
        offer30.push(2);
        offer30.push(1);
        offer30.push(5);
        offer30.push(2);
        offer30.pop();
        System.out.println(offer30.top() + "---" + offer30.min());
        offer30.pop();
        System.out.println(offer30.top() + "---" + offer30.min());
        offer30.pop();
        System.out.println(offer30.top() + "---" + offer30.min());
    }

    private Stack<Integer> A;
    private Stack<Integer> B;

    /**
     * initialize your data structure here.
     */
    public Offer30() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.isEmpty() || B.peek() >= x) { //存入数据的时候，若存的数据比B的栈顶数据小，则存入辅助栈
            B.add(x);
        }
    }

    public void pop() { //取数据的时候，首先A出栈，若A的值和B的栈顶值相同，则同时出栈B
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
