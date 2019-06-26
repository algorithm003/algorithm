# https://leetcode-cn.com/problems/symmetric-tree/submissions/

# 老题新做.要搞清"对称"的定义

# 对称二叉树：
# 1. 根节点相同
# 2. A 的左子树与 B 的右子树对称
# 3. B 的左子树与 A 的右子树对称


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution1:
    
    def isMirror(self,node1,node2):
        if not node1 and not node2:
            return True
        
        if not node1 or not node2:
            return False
        
        return node1.val == node2.val and self.isMirror(node1.left,node2.right) and self.isMirror(node1.right,node2.left)
    
    
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root,root)

# 迭代法:

class Solution2:
    def isMirror(self,node1:TreeNode,node2:TreeNode)->bool:
        
        st1=[node1]
        st2=[node2]
        
        while st1 and st2:
            n1 = st1.pop()
            n2 = st2.pop()
            
            if not n1 and not n2:
                return continue # 易错点! 由于是在循环中,如果节点为空,可能只是临时为空,比如都遍历到了空的左/右子节点
            
            if not n1 or not n2:
                return False
            
            if n1.val != n2.val:
                return False
            
            st1.append(n1.right)
            st1.append(n1.left)

            st2.append(n2.left)
            st2.append(n2.right)
    
        
        return True
    
    
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root,root)
        