package com.example.javalib.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 这道题，第一步就做错了，我的做法是当发现有重复的字符时，就清空从0开始计数，这样是不对的。如"dvdf"，我得到的答案是2，而标准答案是3。
 * <p>
 * 正确做法还是动态规划，这个解体步骤很巧妙
 */
class Offer48 {
    public static void main(String[] args) {
        System.out.println(new Offer48().lengthOfLongestSubstring2("dvdf"));
    }

    //动态规划，利用HashMap来记录各字符最后一次出现的位置
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> dic = new HashMap<>();  //用来存放字符和其对应的位置
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            //获取该字符最后一次出现的位置，没有返回-1(其实不用-1，只要是一个负数就行，负多少无所谓)，不能返回0，因为0也是有意义的位置
            int index = dic.getOrDefault(s.charAt(i), -4);
            dic.put(s.charAt(i), i);    //将该字符和它的位置存入HashMap中
            //tmp中保存的是上一个位置的最大值，而i - index得到的是当前位置减去前面字符出现的位置
            //若都是不同的字符，则tmp < i - index永远都是成立的，
            //若有相同的字符，则i - index就能得到从当前位置到相同字符处的距离，若这个距离在tmp内，说明有重复元素，将tmp重新赋值
            //若不在这个距离内，说明没有相同元素，tmp继续增加
            tmp = tmp < i - index ? tmp + 1 : i - index;
            //res中则保存的是最大值
            res = Math.max(res, tmp);
        }
        return res;
    }

    //动态规划，利用数组遍历
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            int index = i - 1;
            while (index >= 0 && s.charAt(i) != s.charAt(index)) {  //从0到前面一个字符遍历，看能否找到相同的元素
                index--;
            }
            tmp = tmp < i - index ? tmp + 1 : i - index;
            res = Math.max(tmp, res);
        }
        return res;
    }
}
