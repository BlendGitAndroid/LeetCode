package com.example.javalib.hot.stack;

import java.util.Objects;
import java.util.Stack;

class Stack2 {

    private Stack<Integer> mStack = new Stack<>();
    private Stack<Integer> mMinStack = new Stack<>();

    public Stack2() {

    }

    public void push(int val) {
        if (mMinStack.isEmpty() || mMinStack.peek() >= val) {
            mMinStack.push(val);
        }
        mStack.push(val);
    }

    public void pop() {
        if (Objects.equals(mStack.peek(), mMinStack.peek())) {
            mMinStack.pop();
        }
        mStack.pop();
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return mMinStack.peek();
    }

}
