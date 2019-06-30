# @Author：Kilien
# @lc app=leetcode id=111 lang=python3
# [111] Minimum Depth of Binary Tree
# https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
'''
DFS:
若没有左或右子树，则遍历对应缺失的子树并返回深度+1
若存在左右子树，则遍历左右子树并返回最小深度+1
'''
class Solution_1:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        if not root.left or not root.right:
            return max(self.minDepth(root.left), self.minDepth(root.right)) + 1
        else:
            return min(self.minDepth(root.left), self.minDepth(root.right)) + 1

'''
BFS: 双端队列（deque）
前置知识点：popleft（） 移去并且返回一个元素，deque最左侧的那一个。
初始化队列和层级，遍历队列：
更新队列node和level
若无左右叶子结点则返回当前level
存在左子树，drill down， level+1
存在右子树，drill down， level+1
'''
class Solution_2:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        queue, level = collections.deque([(root, 1)]), 0
        while queue:
            node, level = queue.popleft()
            if not node.left and not node.right:
                return level
            if node.left:
                queue.append((node.left, level+1))
            if node.right:
                queue.append((node.right, level+1))
