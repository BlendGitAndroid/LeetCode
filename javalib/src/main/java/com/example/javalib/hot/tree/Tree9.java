package com.example.javalib.hot.tree;

class Tree9 {

   int kVal;

   public int kthSmallest(TreeNode root, int k) {
      dfs(root, new int[]{k});
      return kVal;
   }

   private void dfs(TreeNode node, int[] k) {
      if (node == null) {
         return;
      }

      // 先左遍历
      dfs(node.left, k);

      k[0]--;
      if (k[0] == 0) {
         kVal = node.val;
         return;
      }
      dfs(node.right, k);

   }

}
