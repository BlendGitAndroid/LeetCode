package com.example.javalib.offer;

/**
 * 这个题使用的是动态规划，在我刚开始做的时候，我就理解错题意了。
 */
class Offer63 {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(new Offer63().maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        int result = 0; //股票的最大利润值
        int min = Integer.MAX_VALUE;    //记录前i个股票的最小值
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            //用股票的最大利润值和当前股票的值减去前i个股票的值作比较，取最大值
            result = Math.max(result, prices[i] - min);
        }
        return result;
    }
}
