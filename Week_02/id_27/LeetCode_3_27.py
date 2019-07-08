# 3. Longest Substring Without Repeating Characters
# Medium

# Given a string, find the length of the longest substring without repeating characters.
#
# Example 1:
#
# Input: "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", with the length of 3.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = cur_len = maxV = 0
        strSet = set()

        for st in s:
            cur_len += 1
            while st in strSet:
                strSet.remove(s[left])
                left += 1
                cur_len -= 1
            strSet.add(st)
            maxV = max(maxV, cur_len)
        return maxV