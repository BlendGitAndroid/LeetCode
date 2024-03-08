package com.example.javalib.hot.stack;

import java.util.Stack;

class Stack1 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] characters = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '(' || characters[i] == '{' || characters[i] == '[') {
                stack.push(characters[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (characters[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (characters[i] == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (characters[i] == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(characters[i]);
                }
            }
        }
        return stack.isEmpty();
    }
}
