# https://leetcode-cn.com/problems/symmetric-tree/submissions/

# 思路 1:递归法
# 如果有两棵二叉树A,B,那么它们如何才是对称的?
# 1. 根节点相同
# 2. A 树的左子树与 B 树的右子树是对称的,A 的右子树与 B 的左子树是对称的

# 这是一个递归定义.


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    
    def isMirror(self, left: TreeNode,right:TreeNode)->bool:
        if not left and not right:
            return True
        if (not left and right) or (not right and left):
            return False
        return left.val == right.val and self.isMirror(left.left,right.right) and self.isMirror(left.right,right.left)
    
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        return self.isMirror(root.left,root.right)
        
        
        
        
        
        

            