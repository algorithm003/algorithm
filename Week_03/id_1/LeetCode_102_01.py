# @Author：Kilien
# @lc app=leetcode id=102 lang=python3
# [102] Binary Tree Level Order Traversal
# https://leetcode.com/problems/binary-tree-level-order-traversal/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result, level = [], [root]
        
        while root and level:
            result.append([node.val for node in level])
            level = [child for node in level for child in (node.left, node.right) if child]
        return result

