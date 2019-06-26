# https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/

# 思路 仍然是二叉树的中序遍历,只需 1)借助队列 2)将每个节点与其层级数(作为元组)关联起来

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from queue import Queue
from typing import List


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        ans = []
        q = Queue()
        q.put((root, 1))
        while not q.empty():
            node, lev = q.get()
            if lev > len(ans):
                ans.append([])
            ans[lev - 1].append(node.val)
            if node.left:
                q.put((node.left, lev + 1))
            if node.right:
                q.put((node.right, lev + 1))
        return ans
