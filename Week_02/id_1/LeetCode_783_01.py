# @Author：Kilien
# @lc app=leetcode id=783 lang=python3
# [783] Minimum Distance Between BST Nodes
# https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
由于是二叉搜索树可以使用中序遍历
在遍历过程中将相邻结点之差与前一结点值记录下来，遍历结束即可求出高度差
'''
class Solution:
    pre = -float('inf')
    res = float('inf')

    def minDiffInBST(self, root):
        if root.left:
            self.minDiffInBST(root.left)
        self.res = min(self.res, root.val - self.pre)
        self.pre = root.val
        if root.right:
            self.minDiffInBST(root.right)
        return self.res

