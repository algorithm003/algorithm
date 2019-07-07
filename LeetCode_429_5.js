/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  let result = []
  bfs(root, 0)
  return result

  function bfs(node, level) {
    if (!node) return
    // 数组初始化
    if (!result[level]) {
      // 初始化数组结构
      result[level] = [node.val]
    } else {
      result[level].push(node.val)
    }
    level++
    // 遍历每一层的节点
    for (let index in node.children) {
      bfs(node.children[index], level)
    }
  }
};