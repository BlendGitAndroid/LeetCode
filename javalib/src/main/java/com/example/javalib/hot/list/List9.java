package com.example.javalib.hot.list;

class List9 {

   public ListNode swapPairs(ListNode head) {
      if (head == null) {
         return null;
      }
      ListNode pre = new ListNode(-1);
      ListNode preNode = pre;
      pre.next = head;
      ListNode cur = head;
      while (cur != null && cur.next != null) {
         ListNode tmp = cur.next.next;
         pre.next = cur.next;
         pre.next.next = cur;
         cur.next = null;  //应该断开这个环,否则即使在cur = tmp,这个环还是在的
         pre = pre.next.next;
         cur = tmp;
      }

      if (cur != null) {
         pre.next = cur;
      }
      return preNode.next;
   }

}
