package com.example.javalib.hot.matrix;

import java.util.Arrays;
import java.util.List;

class Matrix2 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        int x = 0;

        // 这里得是Integer,要不然下面的Arrays.asList会出问题
        Integer[] array = new Integer[(right + 1) * (bottom + 1)];

        while (true) {
            for (int i = left; i <= right; i++) {
                array[x++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                array[x++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                array[x++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                array[x++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return Arrays.asList(array);
    }

}
