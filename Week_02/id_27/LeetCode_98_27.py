# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
#
# 假设一个二叉搜索树具有如下特征：
#
# 节点的左子树只包含小于当前节点的数。
# 节点的右子树只包含大于当前节点的数。
# 所有左子树和右子树自身必须也是二叉搜索树。
# 示例 1:
#
# 输入:
#     2
#    / \
#   1   3
# 输出: true

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def dfs(root, lessthan = float('inf'), largerThan = float('-inf')):
            if not root:
                return True

            if root.val <= largerThan or root.val >= lessthan:
                return False
            return dfs(root.left, min(lessthan, root.val)) and dfs(root.right, max(root.val, largerThan))
        return dfs(root)

