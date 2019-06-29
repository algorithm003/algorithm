//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
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
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */

/*
以下是递归中遵循的节点序列：
  1 --> 2 --> 4 --> 8
  回溯 8 --> 4
  4 --> 9 (找到一个节点，返回true)
  回溯 9 --> 4 --> 2
  2 --> 5 --> 10
  回溯 10 --> 5
  5 --> 11 (找到另一个节点，返回true)
  回溯 --> 5 --> 2
  在2节点这里我们有左边=true，右边=true，因此 2 节点是它们的最近公共祖先
 */

// 时间复杂度：O(n)
// 空间复杂度：O(n)，由递归栈产生
let ans = 0
function lowestCommonAncestor (root, p, q) {
  recurseTree(root, p, q)
  return ans
}
function recurseTree (currentNode, p, q) {
  if (!currentNode) return false
  // 回溯（往父节点回退）的过程中左、右是否都为true
  let left = recurseTree(currentNode.left, p, q) ? 1 : 0
  let right = recurseTree(currentNode.right, p, q) ? 1 : 0
  // 找到了其中之一的目标节点 mid = 1
  let mid = currentNode === p || currentNode === q ? 1 : 0
  if (mid + left + right >= 2) {
    ans = currentNode
  }
  // 找到了其中之一的目标节点，mid=1则return 1
  return (mid + left + right > 0)
}
