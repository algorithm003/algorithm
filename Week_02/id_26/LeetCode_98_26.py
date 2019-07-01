
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isValidBST(self, root):
        def traverseBetweenSpan(root: TreeNode, lowLimit = float('-inf'), upperLimit = float('inf')):
            if not root:
                return True
            if root.val > lowLimit and root.val < upperLimit:
                return traverseBetweenSpan(root.right, root.val, upperLimit) and traverseBetweenSpan(root.left, lowLimit, root.val)
            else:
                return False    
        return traverseBetweenSpan(root)