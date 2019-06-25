# https://leetcode-cn.com/problems/valid-anagram/submissions/

# 题目比较简单,直接用数组统计各个字母出现的频率,最后比较两数组即可.
# 时间复杂度:O(n)
# 空间复杂度:O(1)

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        _dic1 = [0] * 26
        _dic2 = [0] * 26
        for i in range(len(s)):
            _dic1[ord(s[i]) - ord('a')] += 1
            _dic2[ord(t[i]) - ord('a')] += 1

        return _dic1 == _dic2
