package com.example.javalib.hot.greedy;

class Greedy1 {

    class Solution {
        public int maxProfit(int[] prices) {
            int cost = Integer.MAX_VALUE;   // 最低买入成本
            int profit = 0;
            for (int price : prices) {
                cost = Math.min(cost, price);   // 最低买入成本和价格做对比
                profit = Math.max(profit, price - cost); // 最高利润和当前利润做对比
            }
            return profit;
        }
    }

}
