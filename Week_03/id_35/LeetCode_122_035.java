package week3;

import java.util.Stack;

/**
 * @ author: Suhb
 * @ date: 2019/7/3 10:55
 * @ description: 122. 买卖股票的最佳时机 II
 */
public class LeetCode_122_035 {
    /*给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    示例 1:
        输入: [7,1,5,3,6,4]
        输出: 7
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
             随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
    示例 2:
        输入: [1,2,3,4,5]
        输出: 4
        解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
             注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
             因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
    示例 3:
        输入: [7,6,4,3,1]
        输出: 0
        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。*/

    /**
     * 栈
     * @param prices
     * @return
     */
    private int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }else if (prices.length == 2) {
            return prices[0] < prices [1] ? prices[1] - prices[0] : 0;
        }
        int length = prices.length;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(prices[0]);
        for (int i = 1; i < length; i++) {
            int stackSize = stack.size();
            if (prices[i] < stack.peek()) {     // 后进先出，如果当前值小于最后进的那个值，再判断是否符合买入卖出规则
                if (stackSize == 2) {
                    sum += stack.pop() - stack.pop();
                } else {
                    stack.pop();
                }
                stack.push(prices[i]);
            } else if (prices[i] >= stack.peek()) { // 后进先出，如果当前值大于最后进的那个值，那就替换，继续等待，直到最后一天才卖出
                if (stackSize == 2) {
                    stack.pop();
                }
                stack.push(prices[i]);
                if (i == length - 1) {
                    sum += stack.pop() - stack.pop();
                }
            }
        }
        return sum;
    }

    /**
     * 双指针
     * @param prices
     * @return
     */
    private int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }else if (prices.length == 2) {
            return prices[0] < prices [1] ? prices[1] - prices[0] : 0;
        }
        int length = prices.length;
        int begin = 0;
        int sum = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i] < prices[i - 1]) {
                sum += prices[i - 1] - prices[begin];
                begin = i;
            } else if (i == length - 1) {
                sum += prices[i] - prices[begin];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode_122_035 leetCode_122_035 = new LeetCode_122_035();
        int[] prices = new int[]{7,1,5,3,6,4};
        int result = leetCode_122_035.maxProfit(prices);
        System.out.println(result);
        result = leetCode_122_035.maxProfit2(prices);
        System.out.println(result);
    }
}
