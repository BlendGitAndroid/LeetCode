package com.example.javalib.hot.tree;

import java.util.ArrayList;
import java.util.List;

class Tree1 {

    private List<Integer> mList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return mList;
        }
        middle(root);
        return mList;
    }

    private void middle(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        middle(treeNode.left);
        mList.add(treeNode.val);
        middle(treeNode.right);
    }

}
