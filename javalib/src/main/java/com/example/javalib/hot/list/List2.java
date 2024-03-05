package com.example.javalib.hot.list;

class List2 {

    // 使用头插法来解决
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;    //设置反转链表后的头结点
        ListNode pre = head; // 设置当前链表的结点
        while (pre != null) {
            ListNode next = pre.next; //拿到当前节点的后一个节点
            pre.next = cur; // 断开pre的节点,给到头结点
            cur = pre;  // 把当前链表设置为头结点
            pre = next; // 把下一个节点设置为当前节点
        }
        return cur;
    }

}
