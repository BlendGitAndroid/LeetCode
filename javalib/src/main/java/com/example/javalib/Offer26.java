package com.example.javalib;

/**
 * 同样，做这道题也是想用先序遍历，但是不知道怎么做，看了答案，才明白，哎。
 */
class Offer26 {

    public static void main(String[] args) {
        TreeNode nodeA1 = new TreeNode(3);
        TreeNode nodeA2 = new TreeNode(4);
        TreeNode nodeA3 = new TreeNode(5);
        TreeNode nodeA4 = new TreeNode(1);
        TreeNode nodeA5 = new TreeNode(2);
        nodeA1.left = nodeA2;
        nodeA1.right = nodeA3;
        nodeA2.left = nodeA4;
        nodeA2.right = nodeA5;

        TreeNode nodeB1 = new TreeNode(4);
        TreeNode nodeB2 = new TreeNode(1);
        nodeB1.left = nodeB2;
        System.out.println(new Offer26().isSubStructure(nodeA1, nodeB1));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
