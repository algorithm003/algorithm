# https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/

# 思路: 题目很简单,直接使用栈,碰撞消失即可.
# 时间复杂度: O(n)
# 空间复杂度: O(n)

class Solution:
    def removeDuplicates(self, S: str) -> str:
        stack = [',']
        for c in S:
            if c==stack[-1]:
                stack.pop()
            else:
                stack.append(c)
        return ''.join(stack[1:])