class Solution:
    '''
    括号题目，使用栈来解决,第一种方法，维护一个数组和一个计数器opend，只有当opend > 0 和 > 1时，才将st装入数组
    维护这个计数器的目的就是保证装入数组的括号不是最外层的， 最后返回数组拼接的字符即可

    或者是纯粹用栈，遇到左括号就append，右括号就pop，只有当statck不为空的时候，才记录字符
    '''
    def removeOuterParentheses(self, S: str) -> str:
        statck, opend = [], 0
        for st in S:
            if opend > 0 and st == "(":
                statck.append(st)
            elif opend > 1 and st == ")":
                statck.append(st)
            if st == "(":
                opend += 1
            else:
                opend -= 1
        return ''.join(statck)

    def removeOuterParentheses2(self, S: str) -> str:
        statck = []
        res = ''
        for st in S:
            if st == ")":
                statck.pop()
            if statck:
               res += st
            if st == "(":
                statck.append(st)
        return res