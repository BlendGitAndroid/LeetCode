package com.example.javalib.hot.tree;

class Tree12 {

    // 根据以上定义，若 rootrootroot 是 p,qp, qp,q 的 最近公共祖先 ，则只可能为以下情况之一：
    // p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
    // p=root ，且 q 在 root 的左或右子树中；
    // q=root，且 p 在 root 的左或右子树中；
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 如果越过了叶子节点，或者根节点和某个节点相同，则直接返回root
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

}
