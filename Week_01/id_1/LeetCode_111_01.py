#
# @lc app=leetcode id=111 lang=python3
# [111] Minimum Depth of Binary Tree
# https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
DFS:
判定条件：是否存在根结点，子结点
递归遍历每个结点，返回最小深度值
回溯结果集，返回最小深度+1（本层）
'''
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        chrinder = [root.left, root.right]
        if not any(chrinder):
            return 1
        
        minDepths = float('inf')
        
        for c in chrinder:
            if c:
                minDepths = min(self.minDepth(c),minDepths)
        return minDepths + 1       

