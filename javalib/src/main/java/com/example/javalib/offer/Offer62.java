package com.example.javalib.offer;

import java.util.ArrayList;

/**
 * 这道题用暴力解法，超时了，我服了。
 * <p>
 * 这个问题也叫作约瑟夫环问题。
 * 在看这道题的解答时，有一种答案是由于数到末尾会从头开始继续，就要想到取模，然后使用LinkedList，超时了。因为LinkedList
 * 虽然删除指定节点的时间复杂度是 O(1)的，但是在remove时间复杂度仍然是 O(n)的，因为需要从头遍历到需要删除的位置。
 * 换成ArrayList勉强没有超时，索引到需要删除的位置，时间复杂度是 O(1)，删除元素时间复杂度是 O(n)，这样它的时间复杂度和
 * 控件复杂度与LinkedList都是相同的，但是没有超时，其实是内存连续空间的拷贝的！所以相比于LinkedList大量非连续性地址访问，
 * ArrayList的性能是很 OK 的！
 * <p>
 * 最优的解法思路就是利用递归的思想来看，思路还是比较复杂的。
 */
class Offer62 {

    public static void main(String[] args) {
        System.out.println(new Offer62().lastRemaining2(5, 3));
    }

    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n];
        int length = n;
        int index = 0;
        while (length != 1) {
            for (int i = 0; i < m; ) {
                if (nums[index] != -1) {
                    i++;
                }
                if (i != m) {
                    if (index == nums.length - 1) {
                        index = 0;
                    } else {
                        index++;
                    }
                }
            }
            nums[index] = -1;
            if (index == nums.length - 1) {
                index = 0;
            } else {
                index++;
            }
            length--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            // 假设当前删除的位置是 idx，下一个删除的数字的位置是 idx + m -1 。由于数到末尾会从头继续数，所以最后取模一下，
            // 就是(idx + m - 1)(mod n)。
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining2(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

}
