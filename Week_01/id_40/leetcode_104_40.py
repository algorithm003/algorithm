# https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/

# 思路 1:递归法
# 时间复杂度: O(n)
# 空间复杂度: O(log(n))

'''
maxDepth(node)  = 0 , node is None
                = max(maxDepth(node.left), maxDepth(node.right)) + 1
''' 

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution1:
    
    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        
        ld = self.maxDepth(root.left)
        rd = self.maxDepth(root.right)
        return max(ld,rd)+1
        
# 思路 2:迭代法
# 用栈进行深度优先遍历, 保存栈的深度技巧是将节点与深度值**绑定在一起**压到栈中

class Solution2:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        
        s = [(root,1)]
        maxd = 0
        while s:
            node,curd = s.pop()
            if curd>maxd:
                maxd = curd
            if node.right:
                s.append((node.right,curd+1))
            if node.left:
                s.append((node.left,curd+1))
                
        return maxd