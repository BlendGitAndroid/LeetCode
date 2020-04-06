package com.example.javalib;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = new TreeNode(preorder[0]);
        return node;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
