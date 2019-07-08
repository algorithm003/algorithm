# 310. 最小高度树
对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-height-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

分析：这个题目思路比较简单，就是做BFS，以每个节点为根节点做一次  
我这里的这个实现超时了，作复杂了，应该可以直接通过edges进行BFS的，时间不够先贴这个了。= =

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.children = []
        
def generateTree(root, edges):
    for edge in edges:
        if root.val in edge:
            if edge[0] != root.val:
                child = TreeNode(edge[0])
            else:
                child = TreeNode(edge[1])
            tmp = edges[:]
            tmp.remove(edge)
            generateTree(child,tmp)
            root.children.append(child)
"""
def printTree(node,strval):
    if not node.children:
        print(strval)
    for child in node.children:
        printTree(child,strval+"->"+str(child.val))
"""
    
def getHeight(node):
    if not node.children:
        return 1
    res = []
    for next_node in node.children:
        res.append(getHeight(next_node)+1)
    return max(res)
                    
class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        res = []
        h = 0
        for i in range(n):
            root = TreeNode(i)
            generateTree(root,edges[:])
            #printTree(root,str(root.val))
            height = getHeight(root)
            if not res:
                res.append(i)
                h = height
            elif height < h:
                res = [i]
                h = height
            elif height == h:
                res.append(i)
        return res
