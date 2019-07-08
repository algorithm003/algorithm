# @Author：Kilien
# @lc app=leetcode id=429 lang=python3
# [429] N-ary Tree Level Order Traversal
# https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/

"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        queue = [root] if root else []
        result = []

        while queue:
            result.append([node.val for node in queue])
            queue = [child for node in queue for child in node.children]
        
        return result

