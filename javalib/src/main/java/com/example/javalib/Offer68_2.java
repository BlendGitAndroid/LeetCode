package com.example.javalib;

/**
 * 看到这道题的时候，知道是用回溯法，但是怎么用，没有思路，还是得看答案解析，用后续遍历递归。
 */
class Offer68_2 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node8;
        node5.right = node9;
        node3.left = node6;
        node3.right = node7;
        System.out.println(new Offer68_2().lowestCommonAncestor(node1, node2, node3).val);
        // new Offer68_2().lrd(node1);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {   //中止条件
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null){ //当left和right都为null
            return null;
        }
        if (left == null) { //当left为空
            return right;
        }
        if (right == null) {    //当right为空
            return left;
        }
        return root;    //当left和right都不为空
    }

    public void lrd(TreeNode node) {
        if (node == null) {
            return;
        }
        lrd(node.left);
        lrd(node.right);
        System.out.print(node.val + " ");
    }

}
