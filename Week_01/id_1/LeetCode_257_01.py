#
# @lc app=leetcode id=257 lang=python3
# [257] Binary Tree Paths
# https://leetcode.com/problems/binary-tree-paths/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
思路：DFS（
判定条件：树是否为空
构造子函数：
查询左右子结点是否为空，是则添加该值；
查询左子树，drill down
查询右子树，drill down
返回结果
）
'''
class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        if not root:
            return []
        res = []
        def _dfs(root, s, res):
            if not root.left and not root.right:
                res.append(s + str(root.val))
            
            if root.left:
                _dfs(root.left, s + str(root.val) + '->', res)
            
            if root.right:
                _dfs(root.right, s + str(root.val) + '->', res)
            
        _dfs(root, '', res)
        return res     
   
