package com.example.javalib.hot.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import jdk.nashorn.api.tree.Tree;

class Tree10 {

   public List<Integer> rightSideView(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      if (root == null) {
         return list;
      }
      Deque<TreeNode> deque = new ArrayDeque<>();
      deque.add(root);
      while (!deque.isEmpty()) {
         int n = deque.size();
         for (int i = 0; i < n; i ++) {
            TreeNode node = deque.poll();
            if (node.left != null) {
               deque.add(node.left);
            }
            if (node.right != null) {
               deque.add(node.right);
            }
            if (i == n - 1) {
               list.add(node.val);
            }
         }
      }
      return list;
   }

}
