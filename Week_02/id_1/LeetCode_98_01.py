# @Author：Kilien
# @lc app=leetcode id=98 lang=python3
# [98] Validate Binary Search Tree
# https://leetcode.com/problems/validate-binary-search-tree/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
 思路：中序遍历，先遍历左子树，遍历后保留前一个节点的值（prev）；
 prev节点与当前节点比较：
 若prev节点大于当前节点则非BST，否则当前节点赋值给prev，继续遍历右子树
'''
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        self.prev = None
        return self.inorder(root)
    
    def inorder(self, root):
        if root is None:
            return True
        if not self.inorder(root.left):
            return False
        if self.prev and self.prev.val >= root.val:
            return False
        self.prev = root
        return self.inorder(root.right)  

