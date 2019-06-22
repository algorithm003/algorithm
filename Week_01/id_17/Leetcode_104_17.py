# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        length = []
        
        def recur(root:TreeNode, dep:int)->int:
            if root== None:
                length.append(dep)
                return
            recur(root.left,dep+1)
            recur(root.right,dep+1)
                
        recur(root,0)
        return max(length)
        
