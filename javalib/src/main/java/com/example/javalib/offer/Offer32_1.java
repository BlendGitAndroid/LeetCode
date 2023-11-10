package com.example.javalib.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Offer32_1 {

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
        int[] ints = new Offer32_1().levelOrder(node);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i] + " ");
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        List<Integer> val = new ArrayList<>();
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            val.add(node.val);
            if (node.left != null) {
                list.offer(node.left);
            }
            if (node.right != null) {
                list.offer(node.right);
            }
        }
        int[] res = new int[val.size()];
        for (int i = 0; i < val.size(); i++) {
            res[i] = val.get(i);
        }
        return res;
    }

}
