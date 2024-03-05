package com.example.javalib.hot.list;

class List1 {

   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      int lenA = 0;
      int lenB = 0;
      int len = 0;
      ListNode lenHeadA = headA;
      ListNode lenHeadB = headB;
      while (lenHeadA != null) {
         lenA++;
         lenHeadA = lenHeadA.next;
      }
      while (lenHeadB != null) {
         lenB++;
         lenHeadB = lenHeadB.next;
      }
      if (lenA > lenB) {
         len = lenA - lenB;
         while (len != 0) {
            headA = headA.next;
            len--;
         }
      } else if (lenB > lenA) {
         len = lenB - lenA;
         while (len != 0) {
            headB = headB.next;
            len--;
         }
      } else {
         return headA;
      }
      while (headA != null) {
         if (headA.val != headB.val) {
            headA = headA.next;
            headB = headB.next;
         } else {
            break;
         }
      }
      return headA;
   }

}
