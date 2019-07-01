# https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/

# 思路:几乎与二叉树的层序优先遍历一模一样


from queue import Queue

from typing import List
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        ans = []
        q = Queue()
        q.put((root, 1))
        while not q.empty():
            node, lev = q.get()
            if not node:
                continue
            if lev > len(ans):
                ans.append([])
            ans[-1].append(node.val)
            for n in node.children:
                q.put((n, lev + 1))
        return ans
