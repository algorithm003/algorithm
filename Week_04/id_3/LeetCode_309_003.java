package com.zzm.leetCode;

/**
 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 示例:

 输入: [1,2,3,0,2]
 输出: 3
 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 */
public class LeetCode_309_003 {
    public static void main(String[] args) {
        int[] arr =  {1,2,3,0,2};
        System.out.println(maxProfit(arr));

    }

    public static int maxProfit(int[] p){
        if (p.length == 0) return 0;

        int[][] dp = new int[p.length][3];

        // 0:买入 1:卖出 2:冷东期
        dp[0][0] = -p[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1 ; i < p.length ; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-p[i]);
            dp[i][1] = dp[i-1][0] + p[i];
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
        }
        return Math.max(dp[p.length-1][1],dp[p.length-1][2]);
    }
}
