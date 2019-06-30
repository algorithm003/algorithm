class Solution:
    '''
    求树的最小深度，依然是递归计算深度即可，但是有一点要注意的是，当做左右子树不全的时候，要取max值
    '''
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        elif None in [root.left, root.right]:
            return max(self.minDepth(root.left), self.minDepth(root.right)) + 1
        else:
            return min(self.minDepth(root.left), self.minDepth(root.right)) + 1