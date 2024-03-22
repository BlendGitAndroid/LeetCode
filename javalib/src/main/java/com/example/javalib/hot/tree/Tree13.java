package com.example.javalib.hot.tree;

import java.util.HashMap;

class Tree13 {

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i); // value是位置
        }
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);   // 根据先序遍历的根节点，建立TreeNode
        int i = hashMap.get(preorder[root]);    // 找到中序遍历中root的位置
        node.left = recur(root + 1, left, i - 1);
        node.right = recur(root + i - left + 1, i + 1, right);
        return node;
    }

}
