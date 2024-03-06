package com.example.javalib.hot.tree;

class Tree2 {

   public int maxDepth(TreeNode root) {
      if (root == null) {
         return 0;
      }
      return first(root);
   }

   private int first(TreeNode treeNode) {
      if (treeNode == null) {
         return 0;
      }
      int left =  first(treeNode.left);
      int right = first(treeNode.right);
      return Math.max(left, right) + 1;
   }

}
