// ### 121. 买卖股票的最佳时机
// - 刷题进度:
//     - [x] 暴力解.
//     - [x] 一次遍历.
//     - [x] 模板动态规划.
//     - [x] 模板动态规划优化.
// - 难度: easy
// - 题意解析: 将数日的股价存在数组中，只能做一次买入和一次卖出操作，求最大利益.
// - 初始思路: 暴力解.
//     - 思路: 双重循环对比出最大利润结果.
//     - 复杂度分析:
//         - 时间: O(n^2). 双重循环.
//         - 空间: O(1). 忽略.
//     - Leetcode 结果:
//         - 执行用时 : 536 ms, 在所有 JavaScript 提交中击败了  20%的用户
//         - 内存消耗 : 35.7MB, 在所有 JavaScript 提交中击败  24%的用户
//     - 实现:
var maxProfit = function(prices) {
    let res = 0;
    for (let i=0, len=prices.length; i<len; i++) {
        for (let j=i+1; j<len; j++) {
            let profit = prices[j] - prices[i];
            res = Math.max(profit, res);
        }
    }
    return res;
};


// - 第二思路: 一次遍历.
//     - 思路: 由于买入要在卖出之前，于是通过存储最小买入值和当前最大利润，单次遍历即可完成计算.
//     - 复杂度分析:
//         - 时间: O(n). 遍历消耗.
//         - 空间: O(1). 忽略.
//     - Leetcode 结果:
//         - 执行用时 : 80ms, 在所有 JavaScript 提交中击败了  92%的用户
//         - 内存消耗 : 35.4MB, 在所有 JavaScript 提交中击败  47%的用户
//     - 实现:
var maxProfit = function(prices) {
    let min = Number.POSITIVE_INFINITY;
    let profit = 0;
    for (let i=0, len=prices.length; i<len; i++) {
        min = Math.min(min, prices[i]);
        profit = Math.max(profit, prices[i] - min);
    }
    return profit;
};


// - 第三思路: 模板动态规划.
//     - 思路: "[一个方法团灭 6 道股票问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3)"解法.
//         - 状态定义: 
//             - 方式: 穷举所有状态，找出每种状态对应的选择.
//             - 状态: 天数、允许的最大交易次数(买卖算一次)、当前状态:持有、卖出.
//             - 选择: 买入、卖出、无操作.
//             - 构建状态定义: dp[天数][买卖次数][当前状态] =》 第 X 天，最多进行 Y 次交易，手头有无股票（0-无，1-有）
//                 - 目标结果 dp[n-1][k][0], 即最后一天，最多进行了 k 次交易，手头无股票.
//             - 状态转移: 
//                 - 某天空仓: dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+price[i])
//                     - 上面情况可分为两种选择：一种是昨天也空仓今天继续，一种是昨天持仓今天卖了，所以到某天为止的最高利润为 max(昨日利润, 昨日利润+今日股价)
//                 - 某日持仓: dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-price[i])
//                     - 上面情况可以分两种选择：一种是做题也持仓今天继续，一种是昨天空仓今日买入，所以到某天为止的最高利润为 max(昨日利润，昨日利润-今日股价)
//                     - Tip: 注意，这里的** 昨天空仓今日买入情况，昨日交易次数为 k-1, 故今日发生交易后变为 k **.
//             - 基础状态：
//                 - dp[-1][k][0] = 0      =>  日期未开始前无利润；
//                 - dp[-1][k][1] = 负无穷  =>  日期未开始必定无持仓；
//                 - dp[i][0][0] = 0       =>  最大交易次数为 0即不允许交易；
//                 - dp[i][0][1] = 负无穷   =>  不允许交易时必定无持仓；

//         - 本题分析:
//             - 本题限制： n 天内允许最多一次交易，即 k=1;
//                 - 初始状态转移方程如下(借助基础状态做简化)：
//                     - dp[i][1][0] = max(dp[i-1][1][0] + dp[i-1][1][1] + prices[i])
//                     - dp[i][1][1] = max(dp[i-1][1][1] + dp[i-1][0][0] - prices[i]) = max(dp[i-1][1][1] - prices[i])
//                 - k=1，可以简化掉：
//                     - dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
//                     - dp[i][1] = max(dp[i-1][1], - prices[i])
//     - 复杂度分析:
//         - 时间: O(n). 循环耗时.
//         - 空间: O(n). dp 数组占空间 n*2.
//     - Leetcode 结果:
//         - 执行用时 : 88ms, 在所有 JavaScript 提交中击败了  80%的用户
//         - 内存消耗 : 41MB, 在所有 JavaScript 提交中击败  20%的用户
//     - 实现:
var maxProfit = function(prices) {
    let len = prices.length;
    if (len < 2) return 0;
    // 1. dp
    let dp = Array.from({length: len}, ()=>[]);
    // 2. init 
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    // 3. calc
    for (let i=1; i<len; i++) {
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
    }
    return dp[len-1][0];
};


// - 第四思路: 模板动态规划(优化).
//     - 思路: 思路同上，微调：不用数组存储每个 dp 状态，只用变量存储两个状态.
//     - 复杂度分析:
//         - 时间: O(n). 循环耗时.
//         - 空间: O(1). 数组存储改为变量存储.
//     - Leetcode 结果:
//         - 执行用时 : 88ms, 在所有 JavaScript 提交中击败了  80%的用户
//         - 内存消耗 : 35.4MB, 在所有 JavaScript 提交中击败  40%的用户
//     - 实现:
var maxProfit = function(prices) {
    if (prices.length < 2) return 0;
    // 1. init
    let [dp_i_0, dp_i_1] = [0, -prices[0]];
    // 2. calc
    for (let i=1,len=prices.length; i<len; i++) {
        dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
        dp_i_1 = Math.max(dp_i_1, -prices[i]);
    }
    return dp_i_0;
};
