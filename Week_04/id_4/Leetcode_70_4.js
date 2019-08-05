// ### 70. 爬楼梯
// - 刷题进度:
//     - [x] 递推(DFS).
//     - [x] 递归+记忆化(DFS).
//     - [x] 动态规划.
//     - [ ] 斐波那契(特殊题目契合).
//     - [ ] Binets(矩阵).
// - 难度: easy.
// - 题意解析: 目标是爬 n 步， 每步可以走 1 或者走 2, 求走法总数.
// - 初始思路: 将每次的目标分为"走一步情况" & "走两步情况"，当计数刚好等于 n 时通过，走法总数+1.
//     - 思路: 递归法(DFS).
//     - 复杂度分析:
//         - 时间: O(2^n). 该解法可视为生成树的过程，总数每加一，层数也随之加一，故时间复杂度为O(2^n).
//         - 空间: O(n). 树深度为n.
//     - Leetcode 结果: 超时, 需要借助 memory 去掉重复计算.
//     - 实现:
var climbStairs = function(n) {
    return recursion(0, n);
};

function recursion (curr, target) {
    if (curr > target) return 0;
    if (curr === target) return 1;
    return recursion(curr+1, target) + recursion(curr+2, target);
}


// - 第二思路: 递归+记忆化(DFS).
//     - 思路: 思路同上，用 memory 数据去掉重复计算.
//     - 复杂度分析: 
//         - 时间: O(n). memory将题目简化为树形递归.
//         - 空间: O(n). 树深度为n.
//     - Leetcode 结果:
//         - 执行用时 : 72ms, 在所有 JavaScript 提交中击败了  89.09%的用户
//         - 内存消耗 : 33.6MB, 在所有 JavaScript 提交中击败  62.77%的用户
//     - 实现:
var climbStairs = function(n) {
    return recursion(0, n, []);
};

function recursion (curr, target, memory) {
    if (curr > target) return 0;
    if (curr === target) return 1;
    if (memory[curr] > 0) return memory[curr];
    memory[curr] =  recursion(curr+1, target, memory) + recursion(curr+2, target, memory);
    return memory[curr];
}


// - 第三思路: 动态规划.
//     - 思路: 定义 dp[n] 为：到达 n 的走法总数, 故易得 dp[n] = dp[n-1] + dp[n-2].
//     - 复杂度分析:
//         - 时间: O(n). 循环 3->n.
//         - 空间: O(n). dp 数组所用的空间.
//     - Leetcode 结果:
//         - 执行用时 : 72ms, 在所有 JavaScript 提交中击败了  89.09%的用户
//         - 内存消耗 : 33.7MB, 在所有 JavaScript 提交中击败  41.12%的用户
//     - 实现:
var climbStairs = function(n) {
    let dp = ['', 1, 2];
    for (let i=3; i<=n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
};