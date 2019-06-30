# @Author：kilien
# @lc app=leetcode id=102 lang=python3
# [102] Binary Tree Level Order Traversal
# https://leetcode.com/problems/binary-tree-level-order-traversal/description/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
'''
DFS：
若层级和当前层数一致，添加外围括号（空数组）
当前层操作：将当前结点值加入当前层级数组中
遍历左右子树， drill down， level+1
'''
class Solution_1:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        levels = []
        
        def getLevel(node, level):
            if len(levels) == level:
                levels.append([])

            levels[level].append(node.val)
            if node.left:
                getLevel(node.left, level + 1)
            if node.right:
                getLevel(node.right, level + 1)
            
        getLevel(root, 0)
        return levels    
'''
BFS: 双端队列（deque）
前置知识点：popleft（） 移去并且返回一个元素，deque最左侧的那一个。
初始化队列和层级结构，遍历队列：
更新队列node和level
若存在当前结点，将当前结点值置入字典所在层级位置
存在左子树，drill down， level+1
存在右子树，drill down， level+1
'''
class Solution_2:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
            queue = collections.deque([(root, 0)])
            res = collections.defaultdict(list)
            
            while queue:
                cur, level = queue.popleft()
                if cur:
                    res[level].append(cur.val)
                    if cur.left:
                        queue.append((cur.left,level+1))
                    if cur.right:
                        queue.append((cur.right,level+1))
                    
                
            return [res[k] for k in res]
