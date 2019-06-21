# https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/

# 递推关系:
# 最小深度      = min(左子树的最小深度, 右子树的最小深度)+1, 如果有左右子树
#           = 右子树的最小深度 + 1, 如果没有左子树
#           = 左子树的最小深度 + 1, 如果没有右子树
#           = 0 没有左右子树

# 时间复杂度: O(n)
# 空间复杂度: O(n)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0

        if not root.left:
            return self.minDepth(root.right)+1
        if not root.right:
            return self.minDepth(root.left)+1

        lm = self.minDepth(root.left)
        rm = self.minDepth(root.right)

        return min(lm,rm)+1



