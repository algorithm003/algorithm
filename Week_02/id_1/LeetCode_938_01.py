# @Author：Kilien
# @lc app=leetcode id=938 lang=python3
# [938] Range Sum of BST
# https://leetcode.com/problems/range-sum-of-bst/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
定义边界：当前结点为空时返回0
当前结点小于左边界时返回右子树之和
当前结点大于右边界时返回左子树之和
当前结点在范围之内时返回左右子树之和+当前结点值
'''
class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        if not root: return 0
        if root.val < L:
            return self.rangeSumBST(root.right, L, R)
        if root.val > R:
            return self.rangeSumBST(root.left, L, R)
        return root.val + self.rangeSumBST(root.left, L, R) + self.rangeSumBST(root.right, L, R)
