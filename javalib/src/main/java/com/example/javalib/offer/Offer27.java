package com.example.javalib.offer;

import java.util.LinkedList;

/**
 * 这道题一开始思路不是很明显，后来看了解题思路。
 * 思路一：利用层次遍历的思想，从上到下一次反转。
 * 思路二：利用递归思想。
 */
class Offer27 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        TreeNode treeNode = new Offer27().mirrorTree1(treeNode1);
        TreeNode.printLevel(treeNode);
    }


    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            TreeNode node = list.pop();
            if (node.left != null) {
                list.offer(node.left);
            }
            if (node.right != null) {
                list.offer(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.left;
        root.left = mirrorTree1(root.right);
        root.right = mirrorTree1(node);
        return root;
    }


}
