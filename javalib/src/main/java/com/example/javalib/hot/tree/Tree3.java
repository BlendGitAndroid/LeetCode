package com.example.javalib.hot.tree;

class Tree3 {

   public TreeNode invertTree(TreeNode root) {
      if (root == null) {
         return null;
      }
      invert(root);
      return root;
   }

   private void invert(TreeNode node) {
      if (node == null) {
         return;
      }
      TreeNode left = node.left;
      TreeNode right = node.right;
      node.left = right;
      node.right = left;
      invert(left);
      invert(right);
   }

}
