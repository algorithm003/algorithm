# 104. 二叉树的最大深度

给定一个二叉树，找出其最大深度。 

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。  

说明: 叶子节点是指没有子节点的节点。  

来源：力扣（LeetCode）  
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree  
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。  

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def bfs(queue,level):
            if not queue:
                return level-1
            next_queue=[]
            for node in queue:
                if node.left:
                    next_queue.append(node.left)
                if node.right:
                    next_queue.append(node.right)
            return bfs(next_queue,level+1)
        if not root:
            return 0
        queue=[root]
        return bfs(queue,1)

    之前做过一次，之前用的是DFS，这里尝试用BFS做了一遍
    
    时间复杂度：O（N），每个节点都访问了一次
    空间复杂度：O（N），每一层都有一个queue用来保存该层的节点
    
