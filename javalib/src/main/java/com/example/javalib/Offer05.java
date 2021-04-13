package com.example.javalib;

class Offer05 {

    public static void main(String[] args) {
        System.out.println(new Offer05().replaceSpace2("We are happy."));
    }

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        for (char aChar : chars) {
            if (aChar == ' ') {
                num++;
            }
        }
        char[] str = new char[chars.length + num * 2];
        for (int i = 0, j = 0; i < chars.length; i++, j++) {
            if (chars[i] == ' ') {
                str[j++] = '%';
                str[j++] = '2';
                str[j] = '0';
            } else {
                str[j] = chars[i];
            }
        }
        return String.valueOf(str);
    }

    public String replaceSpace2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ss : s.toCharArray()) {
            if (ss == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(ss);
            }
        }
        return stringBuilder.toString();
    }
}
