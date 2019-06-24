#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#
# https://leetcode.com/problems/valid-parentheses/description/
'''
  思路：使用hashtable标记括号，拆分字符串
  若字符串不在hashtable中模拟入栈
  若栈不为空，出栈匹配括号则消除，不匹配则报错
'''
class Solution:
    def isValid(self, s: str) -> bool:
        if not s:
            return True
        stack = []
        smap = {')':'(', ']':'[', '}':'{'}
        for c in s:
            if c not in smap:
                stack.append(c)
            elif not stack or smap[c] != stack.pop():
                return False
        return not stack
