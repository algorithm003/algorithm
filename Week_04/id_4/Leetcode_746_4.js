
// ### 746. 使用最小花费爬楼梯
// - 刷题进度:
//     - [x] 动态规划.
//     - [x] 动态规划(优化).
//     - [ ] xxx
// - 难度: easy
// - 题意解析: 有一段阶梯，行走每步的体力消耗用数组存储，走到数组末位(下标=数组长度)即视为走完. 每次可以走一步或者两步，求最低花费.
// - 初始思路: 动态规划.
//     - 思路: 
//         - 状态定义：题目要求求解走楼梯的最低花费，故 dp[n] 指每一步的最低花费;
//         - 初始状态：
//             - dp[0]: 第一步走index=0的阶梯，最小花费为 cost[0];
//             - dp[1]: 第一步走index=1的阶梯，最小花费为 Math.min(cost[0], cost[0]+cost[1]), 故为 cost[1];
//         - 状态转移方程：
//             - dp[n]: 每一步的最小花费 = 当前这一步的花费 + 最小值(上一步最小花费, 上上步最小花费)
//             - 上面文字的实现: dp[n] = cost[n] + Math.min(dp[n-1], dp[n-2]);
//         - Tip: 边界定义：可以在倒数第一位或者倒数第二位停下来, 所以我们**要计算的是 dp[cost.length]的值, 而不是dp[cost.length-1]的值！**;
//     - 复杂度分析: 
//         - 时间: O(n). 循环耗时.
//         - 空间: O(n). 存储 dp 状态消耗.
//     - Leetcode 结果:
//         - 执行用时 : 92ms, 在所有 JavaScript 提交中击败了  76.16%的用户.
//         - 内存消耗 : 35.5MB, 在所有 JavaScript 提交中击败  47.83%的用户.
//     - 实现:
var minCostClimbingStairs = function(cost) {
    cost.push(0);
    let dp = [cost[0], cost[1]];
    let len = cost.length;
    for (let i=2; i<len; i++) {
        dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
    }
    return dp[len-1];
};


// - 第二思路: 动态规划(优化).
//     - 思路: 思路同上，不过只存储最近所需两个 dp 状态，减少了空间消耗和数组查询的时间.
//     - 复杂度分析:
//         - 时间: O(n). 循环耗时.
//         - 空间: O(1). 只用到数个变量.
//     - Leetcode 结果:
//         - 执行用时 : 88 ms, 在所有 JavaScript 提交中击败了 89.40 %的用户
//         - 内存消耗 : 36.1 MB, 在所有 JavaScript 提交中击败 14.49 %的用户
//     - 实现:
var minCostClimbingStairs = function(cost) {
    cost.push(0);
    let [dp1, dp2] = [cost[0], cost[1]];
    for (let i=2, len = cost.length; i<len; i++) {
        [dp1, dp2] = [dp2, cost[i]+Math.min(dp1,dp2)];
    }
    return dp2;
};