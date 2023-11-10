package com.example.javalib.offer;

/**
 * 利用分治思想。
 */
class Offer33 {

    public static void main(String[] args) {
        int[] postorder = {1, 3, 2, 6, 5};
        System.out.println(new Offer33().verifyPostorder(postorder));
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postOrder, int start, int end) {
        if (start >= end) { //如果start大于end，说明到达最后一个节点
            return true;
        }
        int i;
        for (i = start; i < end; i++) {
            if (postOrder[i] > postOrder[end]) {    //找到小于根节点的那个值，则是右子树的开始
                break;
            }
        }

        for (int j = i; j < end; j++) {
            if (postOrder[j] < postOrder[end]) {    //若右子树中有小于根节点的，返回false
                return false;
            }
        }
        return verify(postOrder, start, i - 1) && verify(postOrder, i, end - 1);    //分治左子树和右子树
    }

}
