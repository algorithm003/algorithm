class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    '''
    使用前序遍历的方式递归去查找，当找到一个结点后，就不再向下寻找，直接返回当前结点。
    如果右边结点为None，则说明另一个结点也在找到的结点的下面，则无需再寻找，直接返回该结点为公共结点即可
    如果left， right结点都找到了，则返回root结点作为公共结点
    '''



    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root in (None, p ,q):
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root
        return left or right



if __name__ == "__main__":
    a = Solution()
    b = a.lowestCommonAncestor([3,5,1,6,2,0,8,None,None,7,4], 5, 1)
    print(b)
