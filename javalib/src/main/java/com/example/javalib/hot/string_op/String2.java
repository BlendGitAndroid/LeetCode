package com.example.javalib.hot.string_op;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class String2 {

    // 构造两个数组
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        if (s.length() < p.length()) {
            return list;
        }

        int[] ss = new int[26];
        int[] pp = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++ss[s.charAt(i) - 'a'];
            ++pp[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(ss, pp)) {
            list.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            --ss[s.charAt(i) - 'a'];
            ++ss[s.charAt(i + p.length()) - 'a'];
            if (Arrays.equals(ss, pp)) {
                list.add(i + 1);
            }
        }

        return list;
    }

    // 这种方式会超时
    public List<Integer> findAnagrams1(String s, String p) {

        List<Integer> list = new ArrayList<>();
        char[] p_char = p.toCharArray();
        Arrays.sort(p_char);
        int p_length = p.length();
        for (int i = 0; i < s.length() - p_length + 1; i++) {
            String ss = s.substring(i, i + p_length);
            char[] ssChar = ss.toCharArray();
            Arrays.sort(ssChar);
            if (Arrays.toString(ssChar).equals(Arrays.toString(p_char))) {
                list.add(i);
            }
        }
        return list;
    }

}
