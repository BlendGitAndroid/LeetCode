package com.example.javalib;

/**
 * 刚做这道题的时候，我想到的是两次反转,第一次将整个字符串反转，第二次反转每个字符，
 * 但是没有做，后面看了下解析，用的是双指针。
 * 但是这道题的两次反转字符还是比双指针快。
 * <p>
 * 做这道题的时候，需要注意两个地方：
 * 1.reverse是StringBuilder的方法。
 * 2.String#split方法的使用，我还是有点需要注意的地方，就是对于两个空格或者多个空格，split(" ")生成的String数组
 * 中的值为""，而不是我以为的" "，这个是为什么呢？
 * 还可以使用正则表达式：split("\\s+")来区分一个或者多个空格。
 * \s表示用来匹配任何空白字符，包括空格、制表符、换页符等。
 * \s+表示匹配任意多个上面的字符。
 */
class Offer58 {

    public static void main(String[] args) {
        String s = "the sky is  blue";
        System.out.println(new Offer58().reverseWords1(s));
    }

    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {  //定位到每个单词最右边的字符
                i--;
            }
            j = i;
            while (i >= 0 && s.charAt(i) != ' ') {//找到每个单词的左空格
                i--;
            }
            //由于substring是左开右闭的，
            stringBuilder.append(s.substring(i + 1, j + 1) + " ");
        }
        return stringBuilder.toString().trim();
    }

    public String reverseWords1(String s) {
        StringBuilder newStr = new StringBuilder();
        s = new StringBuilder(s).reverse().toString();
        String[] str = s.split("\\s+");
        for (int i = 0; i < str.length; i++) {
            // if (str[i].equals("")) { //这里刚开始我使用的s.split(" ");导致我的数组里面就有""
            //     continue;
            // }
            newStr.append(new StringBuilder(str[i]).reverse().append(" "));
        }
        return newStr.toString().trim();
    }

}
