//给定一个二叉树，检查它是否是镜像对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
// 说明:
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
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

// 递归判断左右对称
// 时间 O(n)，遍历节点
// 空间 O(n)：取决于树的高度（最糟糕的是线性的O(n)，平衡的是O(logn)）
var isSymmetric = function(root) {
  return recurseTree(root, root)

  function recurseTree(t1, t2) {
    if (!t1 && !t2) return true
    if (!t1 || !t2) return false
    // 父节点的左子节点的左子树等于右子节点的右子树的节点值
    // 且
    // 父节点的左子节点的右子树等于右子节点的左子树的节点值
    let left = recurseTree(t1.left, t2.right)
    let right = recurseTree(t1.right, t2.left)
    return t1.val === t2.val && left && right
  }
};
