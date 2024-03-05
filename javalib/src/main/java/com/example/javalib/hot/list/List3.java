package com.example.javalib.hot.list;

class List3 {

    // 还不能使用上一个反转链表,因为链表的结构被破坏了,但是可以反转一半
    // 还有一个办法就是将数据放到数组中
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode half = endOfList(head);
        half = reverseList(half);
        while (head != null && half != null) {
            if (head.val != half.val) {
                return false;
            }
            head = head.next;
            half = half.next;
        }
        return true;
    }

    // 巧妙啊,快慢指针,找到一半
    private ListNode endOfList(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        // 应该基于一个变量
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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
