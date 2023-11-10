package com.example.javalib.offer;

/**
 * 在这个例子中，我只会第一个方法，但是更好的方法是双指针，没有想到。
 */
class Offer52 {

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(4);
        ListNode listNodeA1 = new ListNode(1);
        ListNode listNodeA2 = new ListNode(8);
        ListNode listNodeA3 = new ListNode(4);
        ListNode listNodeA4 = new ListNode(5);
        listNodeA.next = listNodeA1;
        listNodeA1.next = listNodeA2;
        listNodeA2.next = listNodeA3;
        listNodeA3.next = listNodeA4;

        ListNode listNodeB = new ListNode(5);
        ListNode listNodeB1 = new ListNode(0);
        ListNode listNodeB2 = new ListNode(1);

        listNodeB.next = listNodeB1;
        listNodeB1.next = listNodeB2;
        listNodeB2.next = listNodeA2;
        listNodeA2.next = listNodeA3;
        listNodeA3.next = listNodeA4;

        ListNode root = new Offer52().getIntersectionNode1(listNodeA, listNodeB);
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int length = 0;
        int aLength = 0;
        int bLength = 0;
        ListNode aNode = headA;
        ListNode bNode = headB;
        while (aNode != null) {
            aLength++;
            aNode = aNode.next;
        }
        while (bNode != null) {
            bLength++;
            bNode = bNode.next;
        }

        if (aLength - bLength > 0) {
            length = aLength - bLength;
            while (length != 0) {
                headA = headA.next;
                length--;
            }
        } else {
            length = bLength - aLength;
            while (length != 0) {
                headB = headB.next;
                length--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode aRoot = headA;
        ListNode bRoot = headB;
        while (aRoot != bRoot) {
            aRoot = aRoot == null ? headB : aRoot.next;
            bRoot = bRoot == null ? headA : bRoot.next;
        }
        return aRoot;
    }

}
