#
# @lc app=leetcode id=242 lang=python3
# [242] Valid Anagram
# https://leetcode.com/problems/valid-anagram/description/

class Solution:

# 思路：手动模拟hashtable，将字符串”a-z“的ASCII码作key，计数求差异
    def isAnagram(self, s: str, t: str) -> bool:
        arr1, arr2 = [0]*26, [0]*26
        for i in s:
            arr1[ord(i) - ord('a')] += 1
        for i in t:
            arr2[ord(i) - ord('a')] += 1
        return arr1 == arr2

"""
# 思路：map计数，对比计数差异
    def isAnagram(self, s: str, t: str) -> bool:
        dict1, dict2 = {}, {}
        for item in s:
            dict1[item] = dict1.get(item,0) + 1
        for item in t:
            dict2[item] = dict2.get(item,0) + 1
        return dict1 == dict2
"""

"""
# 思路：数组排序后比较差异
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)
"""
