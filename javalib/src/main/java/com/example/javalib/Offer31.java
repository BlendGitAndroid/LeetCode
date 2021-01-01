package com.example.javalib;

import java.util.Stack;

/**
 * 看了一眼题目，乍一看没有思路，后来看了题解，借用栈，自己写出来了。
 */
class Offer31 {

    public static void main(String[] args) {
        int[] pushedA = {1, 2, 3, 4, 5};
        int[] poppedA = {4, 3, 5, 1, 2};
        System.out.println(new Offer31().validateStackSequences2(pushedA, poppedA));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (j < popped.length) {
                if (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                } else {
                    break;
                }
            }
        }
        return j == popped.length;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
