package com.example.javalib;

/**
 *这道题的方法二比方法一更简单，我服了
 */
class Offer58_2 {

    public static void main(String[] args) {
        String s = "lrloseumgh";
        System.out.println(new Offer58_2().reverseLeftWords1(s, 6));
    }

    public String reverseLeftWords(String s, int n) {
        char[] ch = new char[s.length()];
        int j = s.length() - n;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < s.length()) {
                ch[j] = s.charAt(i);
                j++;
            } else {
                ch[k] = s.charAt(i);
                k++;
            }
        }
        return String.valueOf(ch);
    }

    public String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
