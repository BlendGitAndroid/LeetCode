package com.example.javalib.hot.graph;

class Graph2 {

    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        // 没有新鲜橘子
        if (!hasGood(grid)) {
            return minutes;
        }
        // 有新鲜橘子，开始腐烂
        int num = 2; // 腐烂橘子的编号
        while (change(grid, num)) {
            minutes++; //分钟数加1
            num++; // 每腐烂一批，num+1
        }
        // 腐烂完后，还有新鲜橘子
        if (hasGood(grid)) {
            return -1;
        }
        return minutes;
    }

    // num是上次污染的橘子编号，这次新污染的橘子编号为num+1
    private boolean change(int[][] grid, int num) {
        boolean flag = false;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == num) {
                    if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                        grid[r - 1][c] = num + 1;
                        flag = true;
                    }
                    if (r + 1 < grid.length && grid[r + 1][c] == 1) {
                        grid[r + 1][c] = num + 1;
                        flag = true;
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                        grid[r][c - 1] = num + 1;
                        flag = true;
                    }
                    if (c + 1 < grid[0].length && grid[r][c + 1] == 1) {
                        grid[r][c + 1] = num + 1;
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    // 判断有无新鲜橘子
    private boolean hasGood(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
