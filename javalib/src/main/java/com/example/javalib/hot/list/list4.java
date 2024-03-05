package com.example.javalib.hot.list;

class list4 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == slow;
    }

}
