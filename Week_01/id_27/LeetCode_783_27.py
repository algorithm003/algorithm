class Solution:
    '''
    因为已经是二叉搜索树，所以可以用中序遍历的思路去解题，中序遍历会让元素有序输出，不断的求解两结点的差值，找到最小的即可。
    '''
    pre = -float('inf')
    res = float('inf')

    def minDiffInBST(self, root: TreeNode) -> int:
        if not root:
            return 0
        if root.left:
            self.minDiffInBST(root.left)
        self.res = min(self.res, root.val - self.pre)
        self.pre = root.val
        if root.right:
            self.minDiffInBST(root.right)

        return self.res

