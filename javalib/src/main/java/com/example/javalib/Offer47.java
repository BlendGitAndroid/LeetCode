package com.example.javalib;

/**
 * 礼物的最大值，我一看到这个题，就像做机器人那个题一样，又开始走，但是这个设计到数字相加，所以不行。
 * 之所以不行，是因为不管向下走还是像右走，同一个格子可能会被重复的走，所以相加会重复计算，而机器人问题是不能重复走的。
 * 所以，这个题还是得用动态规划。
 */
class Offer47 {

    public static void main(String[] args) {
        int[][] board = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Offer47().maxValue2(board));
    }

    public int maxValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j > 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0 && i > 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (i > 0 && j > 0) {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    //也可以单独将第一行和第一列拿出来，当i,j很大时，可提高效率
    public int maxValue2(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[0][i - 1];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
