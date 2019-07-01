import collections

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:
    
    def serialize(self, root):
        def doit(node):
            if node:
                vals.append(str(node.val))
                doit(node.left)
                doit(node.right)
            else:
                vals.append('#')
        vals = []
        doit(root)
        return ' '.join(vals)

    def deserialize(self, data):
        def doit():
            val = next(vals)
            if val == '#':
                return None
            node = TreeNode(int(val))
            node.left = doit()
            node.right = doit()
            return node
        vals = iter(data.split())
        return doit()

# class Codec:

#     def serialize(self, root):
#         queue = collections.deque()
#         queue.append(root)

#         resultList = list()
#         while queue:
#             last = queue.pop()
#             if last:
#                 queue.append(last.left)
#                 queue.append(last.right)
#                 resultList.append(str(last.val))
#             else:
#                 resultList.append("NULL")

#         return ",".join(resultList)

#     def deserialize(self, data):
#         dataList: list = data.split(",")
#         rootIndex = 0
#         valueIndex = 1
#         root = TreeNode(dataList[0])
#         for rootIndex in range(len(dataList)):
#             parentNode = self.createNode(dataList[rootIndex])
#             rootIndex += 1
#             if valueIndex < len(dataList):
#                 parentNode.left = self.createNode(dataList[valueIndex])
#                 valueIndex += 1
#                 parentNode.right = self.createNode(dataList[valueIndex])
#                 valueIndex += 1
#         return root

#     def createNode(self, dataStr: str) -> TreeNode:
#         if not dataStr:
#             return None
#         if dataStr == "NULL":
#             return None
#         return TreeNode(int(dataStr))
        