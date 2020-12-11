package com.example.javalib;

/**
 * 这道题就是回溯法，遇到一个坑，就是我把二维数组的长和宽搞反了，出现数组越界。
 * 还有就是a+1和++a的区别。
 */
public class Offer12 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCEQ";
        System.out.println(new Offer12().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[] pathLength = {0};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (hasPath(board, word, visited, i, j, pathLength)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param board   原始矩阵
     * @param word    原始路径
     * @param visited 节点是否访问标识
     * @param row     当前行
     * @param col     当前列
     * @param length  已经找到的字符长度
     * @return 结果
     */
    private boolean hasPath(char[][] board, String word, boolean[][] visited, int row, int col, int[] length) {
        if (length[0] == word.length()) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length
                && !visited[row][col] && board[row][col] == word.charAt(length[0])) {
            visited[row][col] = true;
            length[0]++;
            hasPath = hasPath(board, word, visited, row + 1, col, length)
                    || hasPath(board, word, visited, row - 1, col, length)
                    || hasPath(board, word, visited, row, col + 1, length)
                    || hasPath(board, word, visited, row, col - 1, length);
            if (!hasPath) {
                visited[row][col] = false;
                length[0]--;
            }
        }
        return hasPath;
    }

}
