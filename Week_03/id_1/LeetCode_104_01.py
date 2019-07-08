# @Author：Kilien
# @lc app=leetcode id=104 lang=python3
# [104] Maximum Depth of Binary Tree
# https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

class Solution1:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        left = self.maxDepth(root.left)
        right = self.maxDepth(root.right)
        return max(left, right) + 1       

class Solution:
    def maxDepth(self, root: TreeNode) -> int:        
        stack = []
        if root is not None:
            stack.append((1, root))
        
        depth = 0
        while stack != []:
            current_depth, root = stack.pop()
            if root is not None:
                depth = max(depth, current_depth)
                stack.append((current_depth + 1, root.left))
                stack.append((current_depth + 1, root.right))
        
        return depth


