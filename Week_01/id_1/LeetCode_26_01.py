#
# @lc app=leetcode id=26 lang=python3
# [26] Remove Duplicates from Sorted Array
# https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
'''
思路：由于数组已排序，只需两个指针即可：
使用快慢指针遍历数组，若前后指针对应值一致则略过；
若前后指针对应值不一致则慢指针计数+1，将快指针对应值赋值给慢指针对应值；
最终返回计数值+1（本身次数）
'''
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:return 0
        i = 0
        for j in range(1,len(nums)):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
        return i + 1 

