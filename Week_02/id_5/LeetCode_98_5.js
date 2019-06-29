//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
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
 * @return {boolean}
 */

// 递归中序遍历
// 时间 O(n)，遍历节点
// 空间 O(n)：取决于树的高度（最糟糕的是线性的O(n)，平衡的是O(logn)）
var isValidBST = function(root) {
  let prev = null
  return recurseTree(root)

  function recurseTree (root) {
    if (!root) return true
    // 如果有一个子树不满足则逐层返回false
    if(!recurseTree(root.left)) return false
    // 如果中序遍历出现小于等于0的情况，则不是二叉树
    if (prev && root.val - prev.val <= 0) return false
    // 记录其前一个节点
    prev = root
    return recurseTree(root.right)
  }
};
