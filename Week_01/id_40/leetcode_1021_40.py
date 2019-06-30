# https://leetcode-cn.com/problems/remove-outermost-parentheses/submissions/

# 思路 1: 栈
# 借助一个栈,碰撞消减,在每次增减时判空,若为空则说明是一个"周期",不在结果中操作.
# 时间复杂度: O(N)
# 空间复杂度: O(N)


class Solution1:
    def removeOuterParentheses(self, S: str) -> str:
        result = ""
        stack = []
        for s in S:
            if s == "(":
                if stack:
                    result += "("
                stack.append(s)
            else:
                stack.pop()
                if stack:
                    result += ")"
        return result

# 思路 2: 纯计数
# 时间复杂度: O(N)
# 空间复杂度: O(N)

class Solution2:
    def removeOuterParentheses(self, S: str) -> str:
        result = ''
        flag = 0
        for s in S:
            if s == '(':
                flag +=1
                if flag > 1 :
                    result += '('
            else:
                if flag >1:
                    result += ')'
                flag -=1
        return result