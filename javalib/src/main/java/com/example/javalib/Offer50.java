package com.example.javalib;

import java.util.HashMap;

/**
 * 这道题我的思路是用或，但是用或最后找不到第一个值了。
 * 所以这个题用HashMap来记录。
 */
class Offer50 {

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(new Offer50().firstUniqChar(s));
    }

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        HashMap<Character, Boolean> dic = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (dic.get(ch) == null) {
                dic.put(ch, true);
            } else {
                dic.put(ch, false);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (dic.get(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

}
