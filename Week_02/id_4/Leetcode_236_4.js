// 236. 二叉树的最近公共祖先 lowestCommonAncestor
//题意解析: 获取两个结点在一棵二叉树中的父节点. 前提: 两个结点都存在于给定的树中.

// 初始思路: 递归法.
// 思路: 递归
// 复杂度分析:
//    时间: O(N)，最好 O(1), 最坏 O(N)
//    空间: O(N)，最好 O(1), 最坏 O(N)
// Leetcode 结果:
//    执行用时 : 80ms, 在所有 JavaScript 提交中击败了 100%的用户
//    内存消耗 : 41.5MB, 在所有 JavaScript 提交中击败 34.56%的用户
// 实现:
var lowestCommonAncestor = function(root, p, q) {
  // 1. terminate
  if (!root || root.val===p.val || root.val===q.val) return root;

  // 3. drill down
  let left = lowestCommonAncestor(root.left, p, q);
  let right = lowestCommonAncestor(root.right, p, q);

  // 2. process
  if (left != null && right != null) {
    return root;
  } else if (left != null) {
    return left;
  } else if (right != null){
    return right;
  }
  return null;
};

// 练习使用三目运算符