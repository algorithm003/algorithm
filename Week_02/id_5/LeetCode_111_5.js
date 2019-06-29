//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
//

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */

// 递归深度遍历DFS
// 时间：O(n)，即节点数
// 空间：最坏 O(n)，最好O(logN)，即树的高度，取决于是否平衡
// var minDepth = function(root) {
//   if (!root) return 0
//   if (!root.left && !root.right) return 1
//   let res = Infinity
//   if (root.left) {
//     res = Math.min(res, minDepth(root.left))
//   }
//   if (root.right) {
//     res = Math.min(res, minDepth(root.right))
//   }
//   return res + 1
// };


// 循环广度遍历BFS
// 时间：O(n)，即节点数
// 空间：最坏 O(n)，最好O(logN)，即树的高度，取决于是否平衡
// var minDepth = function(root) {
//   if (!root) return 0
//   let stack = []
//   stack.push([root, 1])
//   let res = Infinity
//   while (stack.length) {
//     let current = stack.pop()
//     let currentDept = current[1]
//     root = current[0]
//     if (!root.left && !root.right) {
//       res = Math.min(res, currentDept)
//     }
//     if (root.left) {
//       stack.push([root.left, currentDept + 1])
//     }
//     if (root.right) {
//       stack.push([root.right, currentDept + 1])
//     }
//   }
//   return res
// };


// 优化循环广度遍历BFS
// 时间复杂度：访问了n/2个节点（最后一层的节点不用遍历），即为O(n)
// 空间复杂度：同时间复杂度，即为O(n)
var minDepth = function(root) {
  if (!root) return 0
  let stack = []
  let currentDept
  stack.push([root, 1])
  while (stack.length) {
    let current = stack.shift()
    currentDept = current[1]
    root = current[0]
    if (!root.left && !root.right) {
      break
    }
    if (root.left) {
      stack.push([root.left, currentDept + 1])
    }
    if (root.right) {
      stack.push([root.right, currentDept + 1])
    }
  }
  return currentDept
};
