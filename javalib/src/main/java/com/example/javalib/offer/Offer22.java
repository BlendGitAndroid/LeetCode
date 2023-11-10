package com.example.javalib.offer;

class Offer22 {

    public static void main(String[] args) {
        ListNode listNode1 = new Offer22.ListNode(1);
        ListNode listNode2 = new Offer22.ListNode(2);
        ListNode listNode3 = new Offer22.ListNode(3);
        ListNode listNode4 = new Offer22.ListNode(4);
        ListNode listNode5 = new Offer22.ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = new Offer22().getKthFromEnd(listNode1, 5);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        int num = 0;
        ListNode root = head;
        while (root != null) {
            ++num;
            root = root.next;
        }
        int result = num - k;
        if (result < 0) {
            return null;
        }
        while (result != 0) {
            head = head.next;
            --result;
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
