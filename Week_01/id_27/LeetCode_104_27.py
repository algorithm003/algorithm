class Solution:

    '''
    计算树的最高深度，用递归即可解决
    当为空节点的时候，返回0
    否则的话加上1，并递归左子树，右子树，取最大者
    '''

    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
    