package com.example.javalib.offer;

/**
 * 刚看这道题的时候，知道使用递归，但还是试了好几次才写出来。
 */
class Offer54 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(new Offer54().kthLargest(treeNode, 2));
    }

    public int kthLargest(TreeNode root, int k) {
        int[] node = new int[1];
        node[0] = -1;
        middle(root, node, k);
        return node[0];
    }

    int index = 0;

    private void middle(TreeNode root, int[] node, int k) {
        if (root == null) {
            return;
        }
        middle(root.right, node, k);
        ++index;
        if (k == index) {
            node[0] = root.val;
        }
        middle(root.left, node, k);
    }
}
