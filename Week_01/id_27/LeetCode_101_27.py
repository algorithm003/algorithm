class Solution:
    '''
    用递归的思路判断是否为对称树
    递归判断左子树的左节点和右子树的右节点是否相等，左子树的右节点和右子树的左节点是否相等
    并且要在最后判断左子树和右子树是否同时存在或不存在
    '''


    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        def dfs(l, r):
            if l and r:
                return l.val == r.val and dfs(l.left, r.right) and dfs(l.right, r.left)
            return l == r
        return dfs(root.left, root.right)