package com.example.javalib.offer;

import java.util.LinkedList;

/**
 * 做这个题的时候，我用的是层次遍历，还有后续遍历，也是可以的。
 */
class Offer55 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        System.out.println(new Offer55().maxDepth1(treeNode));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int index = 0;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            index++;
            for (int i = nodes.size() - 1; i >= 0; i--) {
                TreeNode node = nodes.pop();
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
        }
        return index;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }


}
