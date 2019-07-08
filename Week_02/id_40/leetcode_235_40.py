# https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/

# 这道题是一道非常经典的题,在<<剑指offer>>中就作为一道面试案例来进行了讲解和拓展.
# 思路 1:由于是二叉搜索树,那么有  左子节点<小于此节点<右子节点,因此对于给出的 p 和 q 两个节点,在遍历这棵树每个节点的时候,有四种可能:当前节点小于 pq,当前节点大于 pq,当前节点等于 pq中的一个,当前节点位于 pq 之间.对于前两种可能,只要分别向右/左迭代节点即可;后两种可能,当前节点就是符合要求的节点.
# 本题将进行拓展.


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None

        while True:
            if root.val < p.val and root.val < q.val:
                root = root.right
            elif root.val > p.val and root.val > q.val:
                root = root.left
            else:
                return root

