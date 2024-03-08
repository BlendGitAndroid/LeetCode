package com.example.javalib.hot.stack;

import java.util.Stack;

class Stack3 {

    // 真的是巧妙啊，使用两个栈，一个字母栈，一个数字栈
    // 数字栈用于保存遇到的数字
    // 字母栈用于保存[之前的字符
    // StringBuilder用于保存
    public String decodeString(String s) {

        // 字母栈
        Stack<StringBuilder> mWordStack = new Stack<>();
        // 数字栈
        Stack<Integer> mNumStack = new Stack<>();
        StringBuilder curString = new StringBuilder();

        int sum = 0;

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            // 如果遇到了[
            if (aChar == '[') {
                mNumStack.add(sum);
                mWordStack.add(curString);  //将之前的数据保存在栈中
                sum = 0;
                curString = new StringBuilder();
            } else if (aChar == ']') {
                StringBuilder tmpStr = mWordStack.pop(); //出栈
                int num = mNumStack.pop();
                for (int j = 0; j < num; j++) {
                    tmpStr.append(curString);
                }
                curString = tmpStr;
            } else if ((aChar - '0') >= 0 && (aChar - '0') <= 9) {
                sum = sum * 10 + aChar - '0';
            } else {
                curString.append(aChar);
            }
        }
        return curString.toString();
    }

}
