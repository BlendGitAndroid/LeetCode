package com.example.javalib;

import java.util.LinkedList;
import java.util.List;

/**
 * 首先，题目没有看清楚，是从根节点到叶子节点的值。
 */
class Offer34 {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node42 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node52 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node42;
        node42.left = node52;
        node42.right = node1;
        List<List<Integer>> result = new Offer34().pathSum(node5, 22);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    //使用先序遍历
    private void recur(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        path.add(root.val); //将值添加到节点
        tar -= root.val;    //tar减去该值
        if (tar == 0 && root.left == null && root.right == null) {  //tar==0并且是叶子节点
            res.add(new LinkedList<Integer>(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();  //将最后一个节点移除
    }
}
