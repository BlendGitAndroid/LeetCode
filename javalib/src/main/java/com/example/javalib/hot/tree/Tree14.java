package com.example.javalib.hot.tree;

class Tree14 {

    int ans, t;

    public int pathSum(TreeNode root, int targetSum) {
        t = targetSum;
        dfs1(root);
        return ans;
    }

    void dfs1(TreeNode root) {
        if (root == null) return;
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    void dfs2(TreeNode root, long val) {
        if (val == t) ans++;
        if (root.left != null) dfs2(root.left, val + root.left.val);
        if (root.right != null) dfs2(root.right, val + root.right.val);
    }

}
