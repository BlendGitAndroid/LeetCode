package com.example.javalib.hot.tree;

class Tree7 {

    // 知道这个题用递归,但是一下子没有想出来
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int low, int height) {
        if (low > height) { //这里是大于,不能等于,因为等于也是一个节点
            return null;
        }
        int mid = low + (height - low) / 2; // 算出中点
        TreeNode node = new TreeNode(nums[mid]);    //这里是nums[i]的值
        node.left = dfs(nums, low, mid - 1);
        node.right = dfs(nums, mid + 1, height);
        return node;
    }

}
