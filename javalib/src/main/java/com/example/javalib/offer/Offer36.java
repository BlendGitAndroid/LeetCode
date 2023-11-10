package com.example.javalib.offer;

/**
 * 做这道题目的时候，知道是用先序遍历，但是写到一半不会写了，还是看了答案。
 */
class Offer36 {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        TreeNode node = new Offer36().treeToDoublyList(node4);
        System.out.println(node.val);
    }

    TreeNode head;
    TreeNode pre;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        recur(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        recur(root.left);   //先找左子树
        if (pre != null) {
            pre.right = root;   //若pre已经存在，pre的后驱指向root
        } else {
            head = root;    //若pre还不存在，说明是第一个节点，将root赋值给head
        }
        root.left = pre;    //root的前驱指向pre，哪怕pre是null，这个最后处理
        pre = root;         //root指向前驱
        recur(root.right);  //再找右子树
    }

}
