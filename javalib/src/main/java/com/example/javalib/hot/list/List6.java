package com.example.javalib.hot.list;

class List6 {

    // 这个题需要构建一个前置节点
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        ListNode headA = list1;
        ListNode headB = list2;
        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                cur.next = headA;
                cur = cur.next;
                headA = headA.next;
            } else {
                ListNode tmp = headB;
                headB = headB.next;
                cur.next = tmp;
                cur = cur.next;
            }
        }
        if (headA == null) {
            cur.next = headB;
        } else {
            cur.next = headA;
        }
        return head.next;
    }

}
