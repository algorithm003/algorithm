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

var maxDepth = function(root) {
  if (!root) return 0
  let leftDep = maxDepth(root.left)
  let rightDep = maxDepth(root.right)
  return Math.max(leftDep, rightDep) + 1
};
