// ### 309. 买卖股票的最佳时机含冷冻期
// - 刷题进度:
//     - [x] 模板动态规划.
//     - [x] 模板动态规划(优化).
//     - [ ] xxx
// - 难度: medium.
// - 题意解析: 同 122，买卖次数不限，增加限制：卖完之后要过一天才能买.
// - 初始思路: 模板动态规划.
//     - 思路:
//         - 初始状态转移方程(直接去k,dp[i][1]需要有所改变)：
//             - dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices(i))
//             - dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices(i))
//     - 复杂度分析:
//         - 时间: O(n). 循环消耗.
//         - 空间: O(2n). dp 数组占空间 n*2.
//     - Leetcode 结果:
//         - 执行用时 : 92ms, 在所有 JavaScript 提交中击败了  74%的用户
//         - 内存消耗 : 36.3MB, 在所有 JavaScript 提交中击败  11%的用户
//     - 实现:
var maxProfit = function(prices) {
    if (prices.length < 2) return 0;
    let len = prices.length;
    let dp = Array.from({length: len}, ()=>[]);
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (let i=1; i<len; i++) {
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
        dp[i][1] = i>1? Math.max(dp[i-1][1], dp[i-2][0]-prices[i]): 
            Math.max(dp[i-1][1], -prices[i]);
    }
    return dp[len-1][0];
};
// - 第二思路: 模板动态规划(优化).
//     - 思路: 用三个变量存储所需状态.
//     - 复杂度分析: 
//         - 时间: O(n). 循环消耗.
//         - 空间: O(1). 忽略不计.
//     - Leetcode 结果:
//         - 执行用时 : 76ms, 在所有 JavaScript 提交中击败了  98%的用户
//         - 内存消耗 : 35MB, 在所有 JavaScript 提交中击败  55.56%的用户
//     - 实现:
var maxProfit = function(prices) {
    if (prices.length < 2) return 0;
    let len = prices.length;
    dp_i_0 = 0;
    dp_i_1 = -prices[0];
    dp_pre_0 = 0;
    for (let i=1; i<len; i++) {
        let temp = dp_i_0;
        dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]);
        dp_i_1 = Math.max(dp_i_1, dp_pre_0-prices[i]);
        dp_pre_0 = temp;
    }
    return dp_i_0;
};