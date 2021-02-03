package com.example.javalib;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 该题就是一个全排列的过程，使用dfs加剪枝
 * 为什么这是一个dfs的过程呢？
 * 比如，首先访问第一个值，然后再访问第二个值，依次访问第三个值。
 * <p>
 * 巧妙
 */
class Offer38 {

    public static void main(String[] args) {
        String[] result = new Offer38().permutation("abc");
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0); //从第一位开始排列
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {    //某条路，从头到尾都排列好了，则添加上
            res.add(String.valueOf(c));
            return;
        }

        //用于剪枝，不能定义为全局，因为每次递归都需要创建一个新的set，因为这个set是对同一个位置的交换
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {    //使用循环，一次将第一个数和后面的数逐个循环交换
            if (set.contains(c[i])) {   //如果是重复元素，不要再排列一次
                continue;
            }
            set.add(c[i]);
            swap(i, x); //交换第一个元素和第二个元素
            dfs(x + 1); //开始向下一层递归
            swap(x, i); //再将交换的元素换回来，
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
