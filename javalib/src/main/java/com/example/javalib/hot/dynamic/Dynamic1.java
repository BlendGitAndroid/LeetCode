package com.example.javalib.hot.dynamic;

class Dynamic1 {

    public int climbStairs(int n) {
        return dfs(n, new int[n + 1]);
    }

    private int dfs(int n, int[] memo) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        if (memo[n] != 0) { // 记住
            return memo[n];
        }
        return memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo); // 记住
    }

    // 递归做法超时了
    public int climbStairs1(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }


}
