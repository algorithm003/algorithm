# @Author：kilie
# @lc app=leetcode id=101 lang=python3
# [101] Symmetric Tree
# https://leetcode.com/problems/symmetric-tree/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
DFS:
构建dfs函数：
    定义边界：无叶子结点则返回True
    左右子树 drill down
    判定左右结点值有值且一致
'''
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.isSym(root.left, root.right)

    def isSym(self, l, r):
        if not l and not r:
            return True
        if not l or not r:
            return False

        l = self.isSym(l.left, r.right)
        r = self.isSym(l.right, r.left)

        return l.val == r.val and l and r


#优化：合并左右子树判定
    def isSymmetric(self, root: TreeNode) -> bool:
        def isSym(L,R):
            #if not L and not R: return True
            if L and R and L.val == R.val:
                return isSym(L.left, R.right) and isSym(L.right, R.left)
            return L == R
        return isSym(root, root)


QC:
代码很漂亮！！！