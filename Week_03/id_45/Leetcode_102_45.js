/**
  *    @answer jhwong
  * 
  *   102. 二叉树的层次遍历

      给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

      例如:
      给定二叉树: [3,9,20,null,null,15,7],

          3
        / \
        9  20
          /  \
        15   7
      返回其层次遍历结果：

      [
        [3],
        [9,20],
        [15,7]
      ]


  *
  *    学号：045
  *
  * */

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * DFS
 * @param {TreeNode} root
 * @return {number[][]}
 */
const levelOrder = root => {
  let res = []
  const dfs = (node,level) => {
    if(!node) return 
    res[level] ? res[level].push(node.val) : res[level] = [node.val]
    dfs(node.left, level + 1)
    dfs(node.right, level + 1)
  }
  dfs(root, 0)
  return res
}