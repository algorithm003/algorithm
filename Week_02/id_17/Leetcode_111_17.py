#  111. 二叉树的最小深度

> 给定一个二叉树，找出其最小深度。
>
> 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
>
> 说明: 叶子节点是指没有子节点的节点。
>
> 示例:
> 
> 给定二叉树 [3,9,20,null,null,15,7],
>
>    3  
>   / \  
>  9  20  
>    /  \  
>   15   7  
>返回它的最小深度  2.  
>
>来源：力扣（LeetCode）  
>链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree  
>著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。  

### 思路1

层序遍历，如果当前有一个叶子节点没有子节点的话，说明当前遍历的深度就是最小深度

```
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        
        if root == None:
            return 0
        
        def getDepth(nodes: List[TreeNode],depth:int) -> int:
            next_nodes = []
            for node in nodes:
                if node.left == None and node.right == None:
                    return depth
                else:
                    if node.left != None:
                        next_nodes.append(node.left)
                    if node.right != None:
                        next_nodes.append(node.right)
            return getDepth(next_nodes, depth + 1)
        
        return getDepth([root],1)
                 
```
#### 分析

执行用时 :64 ms, 在所有 Python3 提交中击败了93.74%的用户  
内存消耗 :15.7 MB, 在所有 Python3 提交中击败了36.13%的用户

时间复杂度：找到第一个节点就会停，所以最多每个节点访问一次，O(N)  
空间复杂度：每一层的访问下层节点的时候需要缓存下层所有节点，O(N)
