# 111. 二叉树的最小深度

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

思路：使用BFS，终止条件是搜索结束或者该层有叶子节点
复杂度分析：O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        def isleaf(node):
            return not node.left and not node.right
        
        def bfs(queue,level):
            if not queue:
                return level-1
            next_queue = []
            for node in queue:
                if isleaf(node):
                    return level
                if node.left:
                    next_queue.append(node.left)
                if node.right:
                    next_queue.append(node.right)
            
            return bfs(next_queue,level+1)
            
        if not root:
            return 0
        queue = [root]
        return bfs(queue,1)

