/**
  *    @answer jhwong
  * 
  *   429. N叉树的层序遍历
  *   

给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

           1    
        /  \   \
       3   2    4   
     /  \
    5   6

    返回其层序遍历:

    [
        [1],
        [3,2,4],
        [5,6]
    ]
     

    说明:

    树的深度不会超过 1000。
    树的节点总数不会超过 5000。


  *
  *    学号：045
  *
  * */


/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * BFS
 * @param {Node} root
 * @return {number[][]}
 */
const levelOrder = root => {
  if (!root) return []
  let queue = [root], res = []
  while (queue.length > 0) {
    let tierArr = [],
      len = queue.length
    for (let i = 0; i < len; i++) {
      tierArr.push(queue[0].val)
      let node = queue.shift()
      node.children && queue.push(...node.children)
    }
    res.push(tierArr)
  }
  return res
};