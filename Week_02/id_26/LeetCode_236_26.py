class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # key for the current node, value for the parent node
        parentDict = {root: None}
        stack = [root]

        # begin iterate using stack until find p and q
        while not (p in parentDict and q in parentDict):
            parentNode = stack.pop()

            if parentNode.right:
                stack.append(parentNode.right)
                parentDict[parentNode.right] = parentNode

            if parentNode.left:
                stack.append(parentNode.left)
                parentDict[parentNode.left] = parentNode

        # put all the p's parentNode into set
        parentNodeSet = set()
        while p:
            parentNodeSet.add(p)
            p = parentDict[p]

        while q:
            if q in parentNodeSet:
                return q
            q = parentDict[q]
        return None
        


