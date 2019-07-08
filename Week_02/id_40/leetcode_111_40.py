# https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/

# 刷过很多遍的题.
# 最小深度=左右子树的最小深度+1,如果左右节点均不为空
# 最小深度=左子树深度+1,如果右节点为空
# 最小深度=右子树深度+1,如果左节点为空

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution1:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0

        if not root.left:
            return self.minDepth(root.right) + 1

        if not root.right:
            return self.minDepth(root.left) + 1

        return min(self.minDepth(root.left), self.minDepth(root.right)) + 1

# 迭代法:
# 把每个节点和其深度用一个栈维护起来
# 写的时候还是犯了错误.注意更新迭代值的条件,是叶子节点

class Solution2:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        st = [(root,1)]
        mindepth = 10000
        while st:
            node, d = st.pop()
            if not node.left and not node.right:
                if d < mindepth:
                    mindepth = d
            if node.right:
                st.append((node.right,d+1))
            if node.left:
                st.append((node.left,d+1))
        return mindepth
