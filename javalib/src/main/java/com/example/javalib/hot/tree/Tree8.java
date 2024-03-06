package com.example.javalib.hot.tree;

// 我们知道二叉搜索树中序遍历得到的值构成的序列一定是升序的的。因此我们可以对二叉树进行中序遍历，
// 判断当前节点是否大于中序遍历的前一个节点，如果大于，说明说明这个序列是升序的，整棵树是二叉搜索树，否则不是。
class Tree8 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    // 中序遍历的前一个节点值
    long pre = Long.MIN_VALUE;

    // 使用先序遍历
    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 先遍历左子树
        //判断当前节点的左子树是否满足二叉搜索树，如果不满足，直接返回false，无需递归右子树
        if (!dfs(root.left)) {
            return false;
        }

        // 如果当前的值小于上一个节点的值,直接返回false，无需递归右子树
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        // 访问右子树
        return dfs(root.right);
    }

}
