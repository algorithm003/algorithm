# https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

# 2019年06月19日 1 刷

# 思路:双指针法.慢指针维护目标排序位置,快指针用于遍历整个原数组.遍历时比较两指针的值,若相同则说明对于当前的 i 位置,快指针经历的 j 位置仍处于重复值,不同则时说明此时 nums[j] 是刚好紧邻且比 nums[i] 大的值,应当写入 nums[i+1] .最后别忘了右移 i.最终的长度比 i 多 1,故返回 i+1 即可.

from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        i = 0
        for j in range(len(nums)):
            if nums[i] != nums[j]:
                nums[i+1] = nums[j]
                i+=1
                
        return i+1



