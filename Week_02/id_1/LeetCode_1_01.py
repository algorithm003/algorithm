# @Author：Kilien
# @lc app=leetcode id=1 lang=python3
# [1] Two Sum
# https://leetcode.com/problems/two-sum/description/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i,v in enumerate(nums):
            if target-v in map:
                return i, map[target-v]
            map[v] = i        

