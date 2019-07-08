class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        stack, res, temp, flag = [root], [], [], 1
        while stack:
            for i in range(len(stack)):
                node = stack.pop(0)
                temp += [node.val]
                if node.left:
                    stack.append(node.left)
                if node.right:
                    stack.append(node.right)

            res.append(temp[::flag])
            temp = []
            flag *= -1
        return res
