class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

"""
    递归解法
    @author: Merlin 2019.06.30
    236.Lowest Common Ancestor of a Binary Tree
    思路: 由于是普通的二叉树，不是二叉搜索树那样有规律，所以只能每个节点都遍历一遍
    time: O(n) space: O(n)
"""
class Solution_1:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root in (None, p, q): return root
        left, right = (self.lowestCommonAncestor(kid, p, q)
                       for kid in (root.left, root.right))


        # 非常好！
        return root if left and right else left or right