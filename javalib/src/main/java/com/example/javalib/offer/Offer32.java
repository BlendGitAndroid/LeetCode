package com.example.javalib.offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 这道题是二叉树的层次遍历，但是这道题目中需要按照层次打印，我最开始想的也是利用队列，但是不知道怎么记录每一行有几个节点，
 * 看了答案，明白了。利用队列，每次都是拿到先队列的长度，这个长度就是每一层的数量，然后出队列，就和之前的层次遍历一样了。
 */
class Offer32 {

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
        List<List<Integer>> nodes = new Offer32().levelOrder(treeNode1);
        for (int i = 0; i < nodes.size(); i++) {
            for (int i1 = 0; i1 < nodes.get(i).size(); i1++) {
                System.out.print(nodes.get(i).get(i1) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> values = new LinkedList<>();
        if (root == null) {
            return values;
        }
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            for (int i = level.size(); i > 0; i--) {
                TreeNode node = level.poll();
                list.add(node.val);
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                }
            }
            values.add(list);
        }
        return values;
    }

}
