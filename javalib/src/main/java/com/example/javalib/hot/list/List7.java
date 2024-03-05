package com.example.javalib.hot.list;

class List7 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = new ListNode(-1);
        ListNode head = node;

        int cur = 0;

        while (l1 != null || l2 != null) {
            int sum = cur;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }

            node.next = new ListNode(sum % 10);
            node = node.next;

            cur = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        while (cur != 0) {
            node.next = new ListNode(cur % 10);
            node = node.next;
            cur = cur / 10;
        }
        return head.next;
    }
}
