# @Author：Kilien
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
# https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

'''
 思路：使用哈希表+初始标志位：
      若子串不存在字典中则添加对应值
      若子串存在，比较当前子串所在位置是否大于初始标志位start：
      当子串所在位置大于标志位时，更新初始标志位及当前位置
      若当前子串长度大于初始长度lens,更新子串总长度
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s: return 0
        dic = {}
        start ,lens = 0, 0
        for i,val in enumerate(s):
            if val not in dic:
                dic[val] = i
            else:
                if dic[val] + 1 > start:
                    start = dic[val] + 1
                dic[val] = i
            if i - start + 1 > lens:
                lens = i - start + 1
        return lens


#优化：可以把更新初始标志位的判定合并，同步更新子串长度；
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s: return 0
        dic = {}
        start, lens = 0, 0
        for i, val in enumerate(s):
            if val in dic and start <= dic[val]:
                start = dic[val] + 1
            else:
                lens = max(lens, i - start + 1)
            dic[val] = i
        return lens


QC:
写得非常好，代码基本没有瑕疵