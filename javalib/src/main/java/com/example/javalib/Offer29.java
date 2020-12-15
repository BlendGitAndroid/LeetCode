package com.example.javalib;

/**
 * 遇到这个问题，就是按照每一圈都循环一遍，设定好上下左右边界。
 * 遇到数组问题，注意num.length == 0;返回一个空数组。
 */
class Offer29 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[] result = new Offer29().spiralOrder(matrix);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int[] nums = new int[matrix.length * matrix[0].length];
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int k = 0;
        while (left <= right && top <= bottom) {    //每次都是循环一圈
            for (int i = left; i <= right; i++) {   //从左到右
                nums[k++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= bottom; i++) {   //从上到下
                nums[k++] = matrix[i][right];
            }
            right--;
            for (int i = right; i >= left && bottom >= top; i--) {    //从右到左
                nums[k++] = matrix[bottom][i];
            }
            bottom--;
            for (int i = bottom; i >= top && left <= right; i--) {   //从下到上
                nums[k++] = matrix[i][left];
            }
            left++;
        }
        return nums;
    }

}
