# 104. 二叉树的最大深度

给定一个二叉树，找出其最大深度。 

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。  

说明: 叶子节点是指没有子节点的节点。  

来源：力扣（LeetCode）  
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree  
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。  


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        
        def travel_level(node_queue, level) -> int:
            if node_queue == []:
                return level-1
            next_node_queue = []
            for node in node_queue:
                if node.left != None:
                    next_node_queue.append(node.left)
                if node.right != None:
                    next_node_queue.append(node.right)
            return travel_level(next_node_queue, level+1)
        
        if root is None:
            return 0
        node_queue = []
        node_queue.append(root)
        
        return travel_level(node_queue, 1)
