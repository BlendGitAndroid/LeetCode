package com.example.javalib;

/**
 * 做这个题的时候没有思路，知道是用二叉搜索树的性质，但是不知道怎么做，后来看了解析明白。
 * 公共节点的两个指定节点一个位于左边，一个位于右边，那肯定是最近的公共节点。
 */
class Offer68 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node8;
        node5.right = node9;
        node3.left = node6;
        node3.right = node7;
        System.out.println(new Offer68().lowestCommonAncestor(node1, node5, node7).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val < p.val && root.val < q.val) { //说明在右子树中
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) { //说明在左子树中
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor1(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        }
        return root;
    }
}
