# https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/submissions/

# 二叉搜索树 中序遍历(左根右)的结果是升序数组

from typing import List

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# 思路 1: 递归暴力采集
# 中序遍历收集排序的节点,然后再求最小差值
# 时间复杂度: O(n)
# 空间复杂度: O(n)


class Solution:

    def _minDiffInBST(self, root: TreeNode, l: List[int]) -> int:
        if not root:
            return

        self._minDiffInBST(root.left, l)
        l.append(root.val)
        self._minDiffInBST(root.right, l)

    def minDiffInBST(self, root: TreeNode) -> int:
        l = []
        self._minDiffInBST(root, l)
        m = l[1]-l[0]
        if len(l) > 2:
            for i, v in enumerate(l[2:]):
                if v - l[i+1] < m:
                    m = v-l[i+1]
        return m
