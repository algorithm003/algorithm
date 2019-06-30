class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


"""
    递归解法
    @author: Merlin 2019.06.30
    236.Lowest Common Ancestor of a Binary Tree
    思路: 检查二叉树是否镜像对称即检查一棵树的左子树和右子树是否对称，问题就可以转换成检查两棵树是否互为镜像
    1.两个根节点具有相同的值
    2.每棵树的右子树与另一棵树的左子树镜像对称
    做法: 将题目给的根节点root看成两棵树的根节点，分别从两棵树的根节点开始递归，根据上面的情况写好递归函数
    time: O(n) 需要遍历整棵树一次，n是树中结点的总数
    space: O(n) 递归调用需要压入栈，递归次数受树的高度影响，最坏情况下递归一直往下达到线性效果，所以造成的空间复杂度为O(n)
"""
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root, root)

    def isMirror(self, t1, t2):
        if not t1 and not t2: return True
        if not t1 or not t2: return False
        return t1.val == t2.val and self.isMirror(t1.right, t2.left) and self.isMirror(t1.left, t2.right)