package com.example.javalib.hot.tree;

class Tree11 {

   // 这道题说是按照先序遍历展示,但是解决的过程中,确实用后序遍历来解决
   // 这道题其实是把右子树,接到左子树最右边的节点上
   public void flatten(TreeNode root) {
      if (root == null) {
         return;
      }

      flatten(root.left); // 将根节点的左子树变成链表
      flatten(root.right); // 将根节点的左子树变成链表

      // 记录树的右边
      TreeNode temp = root.right;

      root.right = root.left; // 将树的左子树换成右子树
      root.left = null;
      while (root.right != null) {
         root = root.right;
      }
      root.right = temp;
   }

}
