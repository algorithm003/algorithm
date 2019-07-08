/**
  *    @answer jhwong
  * 
  *   111. 二叉树的最小深度
  *   
  *
      给定一个二叉树，找出其最小深度。

      最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

      说明: 叶子节点是指没有子节点的节点。

      示例:

      给定二叉树 [3,9,20,null,null,15,7],

          3
        / \
        9  20
          /  \
        15   7
      返回它的最小深度  2.

  *
  *    学号：045
  *
  * */

/**
 * DFS 遍历树
 * 当前节点root为空时，说明此处树的高度为0，0也是最小值、
 * 当前节点root的左子树和右子树都为空时，说明此处树的高度为1，1也是最小值
 * 如果为其他情况，则说明当前节点有值，且需要分别计算其左右子树的最小深度，返回最小深度+1，+1表示当前节点存在有1个深度
 * 时间复杂度：O(n)，n为树的节点数量
 * 
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
const minDepth = node => {
  if(node == null) return 0                                             // root节点都为空返回  0
  if(node.left == null && node.right == null) return 1                  // 左右子节点都为空返回 1
  let min = Number.MAX_SAFE_INTEGER
  if(node.left != null) min = Math.min( minDepth(node.left), min )     // 递归取左节点取最小深度 
  if(node.right != null) min = Math.min( minDepth(node.right), min )   // 递归取右节点取最小深度 
  return min + 1                                                       // 返回root节点本身的深度 + 1
};