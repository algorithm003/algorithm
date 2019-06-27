# https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/
# 思路 1:中序遍历验证大小关系.丑陋但有效

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.lastv = float('-inf')
        self.v = True

    def _v(self, node: TreeNode):
        if not node:
            return

        self._v(node.left)

        if node.val <= self.lastv:
            self.v = False

        self.lastv = node.val

        self._v(node.right)

    def isValidBST(self, root: TreeNode) -> bool:
        self._v(root)
        return self.v
