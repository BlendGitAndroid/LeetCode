package com.example.javalib;

import java.util.Stack;

class Offer06 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node.next = node2;
        node2.next = node3;
        int[] result = new Offer06().reversePrint2(node);
        for (int i : result) {
            System.out.println(i);
        }
    }

    boolean ss = true;
    int[] nums;
    int count = 0;
    int n = 0;

    //这个例子说明了方法的调用是栈
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        while (ss && node != null) {
            count++;
            node = node.next;
        }
        if (ss) {
            ss = false;
            nums = new int[count];
        }
        if (head != null) {
            reversePrint(head.next);
            nums[n] = head.val;
            n++;
        }
        return nums;
    }

    public int[] reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] size = new int[stack.size()];
        for (int i = 0; !stack.isEmpty(); i++) {
            size[i] = stack.pop();
        }
        return size;
    }
}
