# https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/submissions/

# 思路 1:迭代法
# 其实与 102 几乎完全相同,只是判断了一下层级的奇偶性,然后分别 append 或 insert 到列表中


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from queue import Queue
from typing import List

class Solution:
    def _m(self, root: TreeNode):

        ans = []
        if not root:
            return ans

        q = Queue()
        q.put((root, 1))

        ans.append([root.val])

        while not q.empty():
            node, lev = q.get()
            if len(ans) < lev:
                ans.append([])

            if lev > 1 and lev & 1 == 0:
                ans[lev - 1].insert(0, node.val)
            if lev > 1 and lev & 1 != 0:
                ans[lev - 1].append(node.val)

            if node.left:
                q.put((node.left, lev + 1))
            if node.right:
                q.put((node.right, lev + 1))

        return ans

    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        return self._m(root)

