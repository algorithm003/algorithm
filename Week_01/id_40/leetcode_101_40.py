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

class Solution1:
    
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
    
# 思路 2:迭代法
# 借助栈实现深度优先遍历.由于是镜面比较,所以务必注意在两棵树压栈的顺序是相反的
# 时间复杂度: O(n)
# 空间复杂度: O(n)

class Solution2:
    def isMirror(self, root1: TreeNode, root2: TreeNode):

        s1, s2 = [root1], [root2]
        while s1 and s2:
            n1 = s1.pop()
            n2 = s2.pop()

            # 均为空 是对称
            if not n1 and not n2:
                continue

            # 存在一个为空 则不对称
            if not n1 or not n2:
                return False

            if n1.val != n2.val:
                return False

            s1.append(n1.right)
            s1.append(n1.left)

            s2.append(n2.left)
            s2.append(n2.right)

        return True

    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root, root)
