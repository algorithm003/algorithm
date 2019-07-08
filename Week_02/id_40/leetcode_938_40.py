# https://leetcode-cn.com/problems/range-sum-of-bst/
# 题目本身很简单,但是描述很不清楚,LR 之间的意思是,中序遍历之后的"之间"!


from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:

    def _r(self, root: TreeNode, L: int, R: int, l: List[int]) -> int:
        if not root:
            return

        self._r(root.left, L, R, l)
        if L <= root.val <= R:
            l.append(root.val)
        self._r(root.right, L, R, l)

    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        l = []
        self._r(root, L, R, l)
        return sum(l)
