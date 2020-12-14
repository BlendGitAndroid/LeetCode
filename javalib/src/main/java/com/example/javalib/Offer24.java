package com.example.javalib;

class Offer24 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = new Offer24().reverseList(listNode1);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;    //将cur的下一个值赋值给next
            cur.next = pre;     //将pre指向cur的下一个值，也就是断开cur的指向链，将cur的下一个值指向pre
            pre = cur;          //将cur赋值给pre，也就是把cur表示的节点，现在用pre表示
            cur = next;         //将next赋值给cur，也就是把next表示的节点，现在用cur表示
        }
        return pre;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
