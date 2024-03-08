package com.example.javalib.hot.matrix;

class Matrix3 {

    // 「第 i 行」元素旋转到「第 n−1−i列」元素；
    // 「第 j 列」元素旋转到「第 j 行」元素；
    public void rotate(int[][] matrix) {

        int n = matrix.length; // 列数

        int[][] tmp = new int[n][];

        for (int i = 0; i < n; i++) {
            tmp[i] = matrix[i].clone(); // 将行数保存下来
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
            }
        }

    }

}
