from typing import List


"""
    @author: Merlin 2019.06.23
    26.Remove Duplicates from Sorted Array
    思路: 因为数组本身是排好序的，并且要求是原地算法(即空间复杂度为O(1))
    1.用快慢指针，i为慢指针，指向元素重复项的第一个元素。j遍历每个元素。
    2.当遇到nums[j] != nums[i]，跳过重复项的运行已经结束，因此把nums[j]的值赋给nums[i+1]
    3.重复相同过程直到j到达数组末尾
    time: O(n) space: O(1)
"""
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums: return 0
        i = 0
        for j in range(len(nums)):
            if nums[j] != nums[i]:
                i += 1
                nums[i] = nums[j]
        return i + 1
