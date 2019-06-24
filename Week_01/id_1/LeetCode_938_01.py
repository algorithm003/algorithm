#
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
DFS
判定条件：是否存在根结点
若根结点值小于左边界，遍历右子树 drill down
若根结点值大于右边界，遍历左子树 drill down
回溯结果集：将根结点和左右子树范围内值相加
'''
class Solution:
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        if not root:
            return 0
        if root.val < L:
            return self.rangeSumBST(root.right, L, R)
        if root.val > R:
            return self.rangeSumBST(root.left, L, R)
        return root.val + self.rangeSumBST(root.left, L, R) + self.rangeSumBST(root.right, L, R)
