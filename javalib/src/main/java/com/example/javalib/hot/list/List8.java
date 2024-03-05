package com.example.javalib.hot.list;

class List8 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode preNode = pre;
        ListNode first = head;
        ListNode second = head;
        pre.next = first;

        while (n > 0) {
            first = first.next;
            n--;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
            pre = pre.next;
        }

        pre.next = second.next;
        return preNode.next;
    }

}
