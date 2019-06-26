//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
//
//
// 示例 2:
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉搜索树中。
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

// 暴力后续遍历
// 时间复杂度：O(n)
// 空间复杂度：O(n)，由递归栈产生
let ansLowest = null
var lowestCommonAncestor = function(root, p, q) {
  recurseTree(root, p, q)
  return ansLowest
};

var recurseTree = function (root, p ,q) {
  if (!root) return
  let left = recurseTree(root.left, p ,q) ? 1 : 0
  let right = recurseTree(root.right, p ,q) ? 1 : 0
  let mid = (root === p || root === q) ? 1 : 0
  if (left + right + mid >= 2) {
    ansLowest = root
  }
  return (left + right + mid > 0)
}

// 利用二叉搜索树特点DFS
// 时间复杂度：O(n)
// 空间复杂度：O(n)，由递归栈产生
var lowestCommonAncestor = function(root, p, q) {
  let parentVal = root.val
  let pVal = p.val
  let qVal = q.val

  // 三目表达式
  if (pVal < parentVal && qVal < parentVal) {
    return lowestCommonAncestor(root.left, p, q)
  } else if (pVal > parentVal && qVal > parentVal) {
    return lowestCommonAncestor(root.right, p, q)
  } else {
    return root
  }
}

// 迭代
var lowestCommonAncestor = function(root, p, q) {
  let node = root
  let pVal = p.val
  let qVal = q.val
  while (node) {
    let parentVal = node.val
    if (pVal < parentVal && qVal < parentVal) {
      node = node.left
    } else if (pVal > parentVal && qVal > parentVal) {
      node = node.right
    } else {
      return node
    }
  }
  return null
}
