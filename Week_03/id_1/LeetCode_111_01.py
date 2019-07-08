# @Author:Kilien
# @lc app=leetcode id=111 lang=python3
# [111] Minimum Depth of Binary Tree
# https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        chrinder = [root.left, root.right]
        if not any(chrinder):
            return 1
        
        minDepths = float('inf')
        
        for c in chrinder:
            if c:
                minDepths = min(self.minDepth(c),minDepths)
        return minDepths + 1  

class Solution1:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        if None in [root.left, root.right]:
            return max(self.minDepth(root.left), self.minDepth(root.right)) + 1
        else:
            return min(self.minDepth(root.left), self.minDepth(root.right)) + 1

#BFS
class Solution2:
    def minDepth(self, root):
        if not root:
            return 0
        queue = collections.deque([(root, 1)])
        while queue:
            node, level = queue.popleft()
            if node:
                if not node.left and not node.right:
                    return level
                else:
                    queue.append((node.left, level+1))
                    queue.append((node.right, level+1))
