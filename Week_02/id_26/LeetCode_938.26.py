class Solution(object):
    def rangeSumBST(self, root, L, R):
        def dfs(node):
            if node:
                if L <= node.val <= R:
                    self.ans += node.val
                    dfs(node.left)
                    dfs(node.right)
                if L > node.val:
                    dfs(node.right)
                if node.val > R:
                    dfs(node.left)

        self.ans = 0
        dfs(root)
        return self.ans