//给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
//
// 你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
//
// 返回获得利润的最大值。
//
// 示例 1:
//
// 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出: 8
//解释: 能够达到的最大利润:
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
//
// 注意:
//
//
// 0 < prices.length <= 50000.
// 0 < prices[i] < 50000.
// 0 <= fee < 50000.
//
//

/**
 * @param {number[]} prices
 * @param {number} fee
 * @return {number}
 */

// 动态规划算法
// 时间复杂度：O(n)
// 空间复杂度：O(1)
var maxProfit = function(prices, fee) {
  let cash = 0 // 未持有股票时候的利润
  let hold = -prices[0] // 持有股票时候的利润
  for (let i = 0; i < prices.length; i++) {
    // 从持有hold变为未持有cash时，hold要加上卖掉的利润并减去手续费
    cash = Math.max(cash, hold + prices[i] - fee)
    // 从未持有cash变为持有hold时，cash要减去买入的手续费
    hold = Math.max(hold, cash - prices[i])
  }
  return cash
};

const prices = [1, 3, 2, 8, 4, 9]
const fee = 2
console.log(maxProfit(prices, fee));
