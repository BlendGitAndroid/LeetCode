package com.example.javalib.hot.binary_search;

class Search2 {

    // int rows = array.length;//行数
    // int columns = array[0].length;//列数

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int l = 0, r = matrix.length - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (matrix[mid][0] < target && matrix[mid + 1][0] <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int left = 0, right = matrix[l].length - 1;
            while (left < right) {
                int m = (left + right) >> 1;
                if (matrix[l][m] >= target) {
                    right = m;
                } else {
                    left = m + 1;
                }
            }
            return matrix[l][left] == target;
        }
    }

}
