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