package com.example.javalib;

import java.util.LinkedList;
import java.util.List;

/**
 * 层次遍历：需要for (int i = queue.size() - 1; i >= 0; i--)这里开始。
 */
class Offer32_3 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node.left = node9;
        node.right = node20;
        node20.left = node15;
        node20.right = node7;
        List<List<Integer>> lists = new Offer32_3().levelOrder(node);
        for (int i = 0; i < lists.size(); i++) {
            for (int i1 = 0; i1 < lists.get(i).size(); i1++) {
                System.out.print(lists.get(i).get(i1) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = false;
        while (!queue.isEmpty()) {
            isLeft = !isLeft;
            LinkedList<Integer> nodeList = new LinkedList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                if (isLeft) {
                    nodeList.addLast(node.val);
                } else {
                    nodeList.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(nodeList);
        }
        return result;
    }
}
