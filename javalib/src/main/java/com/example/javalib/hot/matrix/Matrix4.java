package com.example.javalib.hot.matrix;

class Matrix4 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int right = matrix[0].length - 1;
        while (top < matrix.length && right >= 0) {
            if (matrix[top][right] == target) {
                return true;
            }
            if (matrix[top][right] > target) {
                --right;
            } else {
                ++top;
            }
        }
        return false;
    }

}
