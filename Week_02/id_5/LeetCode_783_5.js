//给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
//
// 示例：
//
//
//输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树结点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \
//    1   3
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
//
// 注意：
//
//
// 二叉树的大小范围在 2 到 100。
// 二叉树总是有效的，每个节点的值都是整数，且不重复。
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
 * @return {number}
 */

// 递归中序遍历
// 时间 O(n)，遍历节点
// 空间 O(n)：取决于树的高度（最糟糕的是线性的O(n)，平衡的是O(logn)）
var minDiffInBST = function(root) {
  let ansMinDiff = Infinity
  let prevMinDiff = Infinity
  recursion(root)
  return ansMinDiff

  function recursion(root) {
    if (!root) return
    // 中序遍历，左中右，是一个升序的过程
    // 左边压到底
    recursion(root.left)
    // 运行过程：
    // 1. 压左子节点，Infinity退出，prevMinDiff赋值左节点值
    // 2. 压父节点，root.val当前为父节点值，prevMinDiff为左节点值
    // 3. 压右子节点，root.val当前为右子节点值，prevMinDiff为父节点值
    if (prevMinDiff != Infinity) {
      ansMinDiff = Math.min(ansMinDiff, root.val - prevMinDiff)
    }
    // 赋值前一个节点值
    prevMinDiff = root.val
    // 压右边
    recursion(root.right)
  }
};
