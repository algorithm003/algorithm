// ### 429. N叉树的层序遍历
// - 刷题进度:
//     - [x] 递归法(DFS).
//     - [x] 迭代法(DFS).
//     - [x] 递归法(BFS).
//     - [x] 迭代法(BFS).
// - 难度: easy
// - 题意解析: 类似 102.
// - 初始思路: 递归法(DFS).
//     - 思路: 用 level 记层级，用 res 存储结果.
//     - 复杂度分析:
//         - 时间: O(n). 遍历所有故 O(n).
//         - 空间: O(n). O(logn)->O(n).
//     - Leetcode 结果:
//         - 执行用时 : 964ms, 在所有 JavaScript 提交中击败了  85.21%的用户
//         - 内存消耗 : 86.2MB, 在所有 JavaScript 提交中击败  19.74%的用户
//     - 实现:
var levelOrder = function(root) {
    if (!root) return [];
    let level = 0;
    let res = [];
    recursion(level, root, res);
    return res;
};

function recursion (level, node, res) {
    // 1. terminate
    
    // 2. process
    if (!res[level]) res[level] = [];
    res[level].push(node.val);
    if (!node.children || node.children.length===0) return;
    
    // 3. drill down 
    for (let i=0, len = node.children.length; i<len; i++) {
        recursion(level+1, node.children[i], res);
    }
    
    // 4. recover
}


// - 第二思路: 迭代法(DFS).
//     - 思路: node 加上 level 标志，用 stack 存储未处理节点；
//     - 复杂度分析:
//         - 时间: O(n). 遍历所有故 O(n).
//         - 空间: O(n). O(logn)->O(n).
//     - Leetcode 结果:
//         - 执行用时 : 928ms, 在所有 JavaScript 提交中击败了  92.25%的用户
//         - 内存消耗 : 81.6MB, 在所有 JavaScript 提交中击败  38.16%的用户
//     - 实现:
var levelOrder = function(root) {
    if (!root) return [];
    root.level = 0;
    let stack = [root];
    let res = [];
    // 1. terminate
    while (stack.length > 0) {
        // 2. process
        let node = stack.pop();
        let currLevel = node.level;
        if (!res[currLevel]) res[currLevel] = [];
        res[currLevel].push(node.val);
        
        // 3. drill down
        if (!node.children || node.children.length===0) continue;
        let childLen = node.children.length;
        for (let i=childLen-1; i>=0; i--) {
            if (node.children[i]) {
                node.children[i].level = currLevel + 1;
                stack.push(node.children[i]);
            }
        }
        
        // 4. recover
    } 
    return res;
};


// - 第三思路: 递归法(BFS).
//     - 思路: 传递 level、queue、res 来递归, 一层处理完递归处理下一层.
//     - 复杂度分析:
//         - 时间: O(n). 遍历所有故 O(n).
//         - 空间: O(n). O(logn)->O(n).
//     - Leetcode 结果:
//         - 执行用时 : 888 ms, 在所有 JavaScript 提交中击败了 98.59 %的用户
//         - 内存消耗 : 77.5 MB, 在所有 JavaScript 提交中击败 81.58%的用户
//     - 实现:
var levelOrder = function(root) {
    if (!root) return [];
    let res = [];
    let queue = [root];
    recursion (0, queue, res);
    return res;
};


function recursion (level, queue, res) {
    // 1. terminate
    if (queue.length===0) return;
    
    // 2. process
    res[level] = [];
    for (let i=0, len=queue.length; i<len; i++) {
        let node = queue.shift();
        res[level].push(node.val);
        if (!node.children || node.children.length===0) continue;
        for (let j=0, cLen=node.children.length; j<cLen; j++) {
            queue.push(node.children[j]);
        }
    }
    
    // 3. drill down
    recursion(level+1, queue, res);
}

// - 第四思路: 迭代法(BFS).
//     - 思路: 每次处理一层，并用 queue 存储下一层节点.
//     - 复杂度分析:
//         - 时间: O(n). 遍历所有故 O(n).
//         - 空间: O(n). O(logn)->O(n).
//     - Leetcode 结果:
//         - 执行用时 : 924 ms, 在所有 JavaScript 提交中击败了 94.37%的用户
//         - 内存消耗 : 80.5 MB, 在所有 JavaScript 提交中击败  59.21%的用户
//     - 实现:

var levelOrder = function(root) {
    if (!root) return [];
    let level = 0;
    let res = [];
    let queue = [root];
    // 1. termimate
    while (queue.length > 0) {
        res[level] = [];
        for (let i=0, len=queue.length; i<len; i++) {
            // 2. process
            let node = queue.shift();
            res[level].push(node.val);
            // 3. drill down
            if (!node.children || node.children.length===0) continue;
            for (let j=0, cLen=node.children.length; j<cLen; j++) {
                queue.push(node.children[j]);
            }
        }
        level++;
    }
    return res;
};