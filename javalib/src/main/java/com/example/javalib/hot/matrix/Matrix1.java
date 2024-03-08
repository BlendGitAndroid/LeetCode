package com.example.javalib.hot.matrix;

class Matrix1 {

    public void setZeroes(int[][] matrix) {

        boolean[] row = new boolean[matrix.length];   // 行数
        boolean[] col = new boolean[matrix[0].length];   // 列数
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
