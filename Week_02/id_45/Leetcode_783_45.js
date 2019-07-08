/**
  *    @answer jhwong
  * 
  *   783. 二叉搜索树结点最小距离
  *   给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。

      示例：

      输入: root = [4,2,6,1,3,null,null]
      输出: 1
      解释:
      注意，root是树结点对象(TreeNode object)，而不是数组。

      给定的树 [4,2,6,1,3,null,null] 可表示为下图:

                4
              /   \
            2      6
          / \    
        1   3  

      最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
      注意：

      二叉树的大小范围在 2 到 100。
      二叉树总是有效的，每个节点的值都是整数，且不重复。

  *
  *    学号：045
  *
  * */


/**
 * 中序遍历二叉树，比较当前节点和上一节点的值得差值，最后取最小即可
 * 
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 * 
 * @param {TreeNode} root
 * @return {number}
 */

const minDiffInBST = root => {
  let pre = Number.MIN_SAFE_INTEGER, min = Number.MAX_SAFE_INTEGER
  const fn = (node) => {
    if(node.left != null) fn(node.left)
    min = Math.min(min, Math.abs(node.val - pre)), pre = node.val
    if(node.right != null) fn(node.right)
    return min
  }
  return fn(root)
};