# @Author：Kilien
# @lc app=leetcode id=236 lang=python3
# [236] Lowest Common Ancestor of a Binary Tree
# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
DFS:
若左、右叶子结点为root，或root为空则返回root
遍历左右子树：
若左子树为空，返回右子树LCA
若右子树为空，返回左子树LCA
否则返回root
'''

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if (root is None or p == root or q == root):
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        # QC: 试试三目
        if left is None:
            return right
        elif right is None:
            return left
        else:
            return root


#优化：合并左右子树判定，优化返回值表达式
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root in (None, p, q): return root
        left, right = (self.lowestCommonAncestor(kid, p, q)
                    for kid in (root.left, root.right))

        # 非常好！@！！！
        return root if left and right else left or right

