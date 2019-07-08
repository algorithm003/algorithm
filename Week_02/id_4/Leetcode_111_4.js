// 111. 二叉树最小深度 minDepth
// 难度: easy
// 题意解析: 计算根节点到最近叶子节点的最短路径上的节点数.
// 二次读题: 注意说明**"叶子节点是指没有子节点的节点"**.
// 初始思路: 递归法.
// 思路: 自递归。思路和二叉树最大深度一样。
// 遇到问题: Leetcode刷题者普遍遇到的问题。 问题 由题意可知"最小深度是从根节点到最近叶子节点的最短路径上的节点数量"，并且题目中有说明"叶子节点是指没有子节点的节点", 所以问题出自没有好好看题。
// 复杂度分析:
//    时间: O(n). 同节点数n.
//    空间: O(n). 最好O(logn), 最坏O(n).
// Leetcode 结果:
//    执行用时 : 96ms, 在所有 JavaScript 提交中击败了 85.52%的用户
//    内存消耗 : 37.5MB, 在所有 JavaScript 提交中击败 24.69%的用户
// 实现:
var minDepth = function(root) {
    if (!root || root.val===null) return 0;
    let [left, right] = [minDepth(root.left), minDepth(root.right)];
    return left&&right? 1+Math.min(left, right): 1+left+right;
};

// 第二思路: 迭代法.
// 思路: 每个节点加入 level 属性，向下查找所有叶子节点（即左右子树为空）,对比并返回最小 level.
// 复杂度分析:
//    时间: O(n). 遍历树所有节点即 n.
//    空间: O(n). 最好 logn，最坏 n.
// Leetcode 结果:
//    执行用时 : 92ms, 在所有 JavaScript 提交中击败了 91.36%的用户
//    内存消耗 : 37.9MB, 在所有 JavaScript 提交中击败 5.55%的用户
// 实现:
var minDepth = function(root) {
  if (!root || root.val===null) return 0;
  let res = Number.POSITIVE_INFINITY;
  root.level = 1;
  let stack = [root];
  while (stack.length > 0) {
    let node = stack.pop();
    let level = node.level;
    if (node.left || node.right) {
      if (node.right) { 
        node.right.level = level + 1;
        stack.push(node.right); 
      }
      if (node.left) {
        node.left.level = level + 1;
        stack.push(node.left); 
      }
    } else {
      res = Math.min(res, level);
    }
  }
  return res;
};

