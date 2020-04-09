package com.example.javalib;

import javax.swing.tree.TreeNode;

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
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length < 1) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 重建二叉树
     *
     * @param preorder 先序遍历
     * @param ps       先序遍历的开始位置
     * @param pe       先序遍历的结束位置
     * @param inorder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return
     */
    private TreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        int value = preorder[ps];
        int index = is;
        while (index <= ie && inorder[index] != value) {
            index++;
        }
        if (index > ie) {
            throw new RuntimeException("it is not a build tree");
        }
        TreeNode treeNode = new TreeNode(value);
        treeNode.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        treeNode.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    中序遍历二叉树
     */
    private void printTree(TreeNode treeNode) {
        if (treeNode != null) {
            printTree(treeNode.left);
            System.out.print(treeNode.val + " ");
            printTree(treeNode.right);
        }
    }

    public void test() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        printTree(treeNode);
    }

}


