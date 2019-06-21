# https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/

# 思路 1:递归法
# 时间复杂度: O(n)
# 空间复杂度: O(log(n))

'''
maxDepth(node)  = 0 , node is None
                = max(maxDepth(node.left), maxDepth(node.right)) + 1
''' 

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    
    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        
        ld = self.maxDepth(root.left)
        rd = self.maxDepth(root.right)
        return max(ld,rd)+1
        
        