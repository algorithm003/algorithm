// ### 122. 买卖股票的最佳时机 II
// - 刷题进度: 
//     - [x] 模板动态规划.
//     - [x] 模板动态规划(优化).
//     - [ ] xxx
// - 难度: easy.
// - 题意解析: 将 121 的最多交易 1 次改为，允许交易任意多次.
// - 初始思路: 模板动态规划.
//     - 思路: 
//         - 初始状态转移方程(k无限制之后，考虑 k 无意义)：
//             - dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
//             - dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i]) = max(dp[i-1][k][1], dp[i-1][k][0]-prices[i])
//         - 去掉 k：
//             - dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
//             - dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])
//     - 复杂度分析:
//         - 时间: O(n). 循环耗时.
//         - 空间: O(n). dp 数组占空间 n*2.
//     - Leetcode 结果:
//         - 执行用时 : 84ms, 在所有 JavaScript 提交中击败了  80%的用户
//         - 内存消耗 : 40.7MB, 在所有 JavaScript 提交中击败  5%的用户
//     - 实现:
var maxProfit = function(prices) {
    if (prices.length < 2) return 0;
    let len = prices.length;
    let dp = Array.from({length: len}, ()=> []);
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (let i=1; i<len; i++) {
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
        dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
    }
    return dp[len-1][0];
};
// - 第二思路:
//     - 思路:
//     - 复杂度分析:
//         - 时间: O(n). 循环耗时.
//         - 空间: O(1). 忽略不计.
//     - Leetcode 结果:
//         - 执行用时 : 72ms, 在所有 JavaScript 提交中击败了  98%的用户
//         - 内存消耗 : 35MB, 在所有 JavaScript 提交中击败  24%的用户
//     - 实现:
var maxProfit = function(prices) {
    if (prices.length < 2) return 0;
    let len = prices.length;
    let [dp_i_0, dp_i_1] = [0, -prices[0]];
    for (let i=1; i<len; i++) {
        let temp =  dp_i_0;
        dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]);
        dp_i_1 = Math.max(dp_i_1, dp_i_0-prices[i])
    }
    return dp_i_0;
};