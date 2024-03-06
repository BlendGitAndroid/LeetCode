package com.example.javalib.hot.tree;

class Tree5 {

    int length = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        diameter(root);
        return length - 1;
    }

    // 统计节点个数
    private int diameter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = diameter(node.left);
        int right = diameter(node.right);
        length = Math.max(length, left + right + 1);    // 记录最大的节点个数,左节点的个数+右节点的个数+根节点
        return Math.max(left, right) + 1;   // 返回该节点为根节点的子树的深度
    }

}
