# https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

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


# 思路 2: 递归形式的层序遍历?
# 官方给出的递归形式的遍历,其实并非真正的层序遍历,而是 DFS 加上层级信息而已


class Solution2:
    def levelOrder(self, root):
        levels = []

        if not root:
            return levels

        def helper(node, level):
            if len(levels) == level:
                levels.append([])

            levels[level].append([node.val])

            if node.left:
                helper(node.left, level + 1)
            if node.right:
                helper(node.right, level + 1)

        helper(root, 0)
        return levels