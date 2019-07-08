package week3;

import java.util.Arrays;

/**
 * @ author: Suhb
 * @ date: 2019/7/2 11:14
 * @ description: 121. 买卖股票的最佳时机
 */
public class LeetCode_121_035 {
    /*给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    注意你不能在买入股票前卖出股票。
    示例 1:
        输入: [7,1,5,3,6,4]
        输出: 5
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
        注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
    示例 2:
        输入: [7,6,4,3,1]
        输出: 0
        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。*/

    /**
     * 暴力破解
     * @param prices
     * @return
     */
    private int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int maxValue = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (prices[i] < prices[j]) {
                    maxValue = Math.max(maxValue, prices[j] - prices[i]);
                }
            }
        }
        return maxValue;
    }

    /**
     * 一次循环
     * @param prices
     * @return
     */
    private int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxValue = 0, minValue = Integer.MAX_VALUE;
        for (int price : prices) {
            minValue = Math.min(minValue, price);   // 记录最小的买入
            maxValue = Math.max(maxValue, price - minValue);    // 当时买出与最小的买入的值判断是否最大
        }
        return maxValue;
    }

    public static void main(String[] args) {
        LeetCode_121_035 leetCode_121_035 = new LeetCode_121_035();
        int[] prices = new int[]{7,1,5,3,6,4};
        int result = leetCode_121_035.maxProfit(prices);
        System.out.println(result);
        result = leetCode_121_035.maxProfit2(prices);
        System.out.println(result);
    }
}
