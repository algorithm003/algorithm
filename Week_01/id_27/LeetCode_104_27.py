class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


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

    def maxDepth2(self, root: TreeNode) -> int:
        def dfs(root):
            if not root:
                return 0
            if root.left and root.right:
                return max(dfs(root.left), dfs(root.right)) + 1
            elif root.left:
                return 1 + dfs(root.left)
            elif root.right:
                return 1 + dfs(root.right)

        return dfs(root)

if __name__ == "__main__":
    a = Solution()
    print (a.maxDepth2([3,9,20,None,None,15,7]))
