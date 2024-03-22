package com.example.javalib.hot.tree;

class Tree15 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);  // 左子树的最大路径和
        int right = dfs(root.right); // 右子树的最大路径和
        int t = root.val;
        if (left >= 0) t += left;   // 如果左子树的最大路径和大于0，那么加上左子树的最大路径和
        if (right >= 0) t += right; // 如果右子树的最大路径和大于0，那么加上右子树的最大路径和
        ans = Math.max(ans, t);    // 更新最大路径和
        return Math.max(root.val, Math.max(left, right) + root.val); // 返回当前节点的最大路径和
    }

}
