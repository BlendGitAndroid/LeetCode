package com.example.javalib.hot.string_op;

import java.util.HashMap;

class String1 {

    public static void main(String[] args) {
        new String1().lengthOfLongestSubstring("abcabc");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int result = -1;

        int left = -1;  //这里要从-1开始,这个left是不包含在滑动窗口中的
        int right = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.containsKey(chars[i])) {
                left = Math.max(left, hashMap.get(chars[i]));
            }

            hashMap.put(chars[i], i);

            right = i;

            System.out.println("right: " + right + " left: " + left);

            result = Math.max(result, right - left);
        }
        return result;

    }

}
