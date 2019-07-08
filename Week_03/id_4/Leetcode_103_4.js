// ### 103. 二叉树的锯齿形层次遍历
// - 刷题进度:
//     - [x] 102递归法(BFS).
//     - [x] 102迭代法(BFS).
//     - [ ] 本题专属套路解法.
// - 难度: medium
// - 题意解析: 同 102，奇数层反转. **切勿调换插入队列顺序!**.
// - 初始思路: 递归法(BFS).
//     - 思路: 同 102递归法(BFS).
//     - 复杂度分析:
//         - 时间: O(n). 遍历所有故 O(n).
//         - 空间: O(n). O(logn)->O(n).
//     - Leetcode 结果:
//         - 执行用时 : 76ms, 在所有 JavaScript 提交中击败了 90.44 %的用户
//         - 内存消耗 : 32MB, 在所有 JavaScript 提交中击败 43.75 %的用户
//     - 实现:
function recursion (level, queue, res) {
    // 1. terminate
    if (queue.length === 0) return;
    
    res[level] = [];
    // 2. process
    for (let i=0, len=queue.length; i<len; i++) {
        let node = queue.shift();
        res[level].push(node.val);
        
        if (node.left) queue.push(node.left);
        if (node.right) queue.push(node.right);
    }
    if(level%2===1) res[level].reverse();
    
    // 3. drill down 
    recursion(level+1, queue, res);
    
    // 4. recover
}
// - 第二思路: 迭代法(BFS).
//     - 思路: 同 102迭代法(BFS).
//     - 复杂度分析:
//         - 时间: O(n). 遍历所有故 O(n).
//         - 空间: O(n). O(logn)->O(n).
//     - Leetcode 结果:
//         - 执行用时 : 68ms, 在所有 JavaScript 提交中击败了  98.53%的用户
//         - 内存消耗 : 34.4MB, 在所有 JavaScript 提交中击败  6.25%的用户
//     - 实现:
var zigzagLevelOrder = function(root) {
    if (!root) return [];
    let level = 0;
    let queue = [root];
    let res = [];
    // 1.terminate
    while (queue.length > 0) {
        res[level] = [];
        for (let i=0, len=queue.length; i<len; i++) {
            // 2. process
            let node = queue.shift();
            res[level].push(node.val);
            // 3.drill down
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
            // 4. recover
        }
        if (level%2===1) res[level].reverse();
        level++;
    }
    return res;
};