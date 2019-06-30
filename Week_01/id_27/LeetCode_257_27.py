class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        if not root:
            return
        res = []

        def dfs(root, st, res):
            st += str(root.val)
            if root.left:
                dfs(root, st + '->', res)
            if root.right:
                dfs(root, st + '->', res)
            if not root.left and root.right:
                res.append(st)

        dfs(root, "", res)
        return res
