package com.example.javalib.offer;

class Offer25 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = new Offer25().mergeTwoLists(listNode1, listNode4);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode head = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                root.next = l1;
                root = root.next;
                l1 = l1.next;
            } else {
                root.next = l2;
                root = root.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            root.next = l1;
        }
        if (l2 != null) {
            root.next = l2;
        }
        return head.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
