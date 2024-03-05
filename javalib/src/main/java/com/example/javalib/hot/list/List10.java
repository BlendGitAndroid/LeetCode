package com.example.javalib.hot.list;

class List10 {

    // 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    // 这个题使用了归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;

        // 找到中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 将中间节点赋值给tmp
        ListNode tmp = slow.next;
        slow.next = null;

        // 进行递归处理
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);


        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
