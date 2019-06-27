# https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/submissions/

# 老题二刷,二叉搜索树,中序遍历的结果是升序数列

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def __init__(self):
        self.c = 1000
        self.lastv = -1000

    def _m(self, root: TreeNode):
        if not root:
            return

        self._m(root.left)

        if root.val - self.lastv < self.c:
            self.c = root.val-self.lastv

        self.lastv = root.val

        self._m(root.right)

    def minDiffInBST(self, root: TreeNode) -> int:
        self._m(root)
        return self.c
