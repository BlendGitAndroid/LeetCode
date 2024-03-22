package com.example.javalib.hot.list;

import java.util.Comparator;
import java.util.PriorityQueue;

class List11 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        new List11().mergeKLists(new ListNode[]{listNode1});
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(comparator);

        ListNode pre = new ListNode(0);
        ListNode preTmp = pre;
        for (ListNode listNode : lists) {   // 按照头结点从小到大进行排序
            if (listNode != null) {
                queue.add(listNode);
            }
        }

        while (!queue.isEmpty()) {
            preTmp.next = queue.poll();
            preTmp = preTmp.next;
            if (preTmp.next != null) {
                queue.add(preTmp.next);
            }
        }
        return pre.next;
    }

}
