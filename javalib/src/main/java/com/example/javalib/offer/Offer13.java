package com.example.javalib.offer;

/**
 * 这一类题目，都可以用回溯法.
 * 但是这道题，我那个计数位数相加，弄错了
 */
class Offer13 {

    public static void main(String[] args) {
        System.out.println(new Offer13().movingCount(38, 15, 9));
    }

    public int movingCount(int m, int n, int k) {
        if (k < 0) {
            return 0;
        }
        int[][] board = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[] count = new int[1];
        int row = 0;
        int col = 0;
        calCount(board, k, visited, row, col, count);
        return count[0];
    }

    private void calCount(int[][] board, int k, boolean[][] visited, int row, int col, int[] count) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col]) {
            visited[row][col] = true;
            if (cal(row, col) > k) {
                return;
            }
            System.out.println(row + "--" + col + "--" + k);
            if (cal(row, col) <= k) {
                count[0]++;
            }
            calCount(board, k, visited, row + 1, col, count);
            calCount(board, k, visited, row, col + 1, count);
            calCount(board, k, visited, row - 1, col, count);
            calCount(board, k, visited, row, col - 1, count);
        }
    }


    private int cal(int a, int b) {
        int num = 0;
        while (a != 0) {
            num += (a % 10);
            a = a / 10;
        }

        while (b != 0) {
            num += (b % 10);
            b = b / 10;
        }
        return num;
    }

}
