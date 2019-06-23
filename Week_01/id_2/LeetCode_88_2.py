from typing import List


"""
    @author: Merlin 2019.06.23
    88.Merge Sorted Array
    思路: 用两个指针m和n指向nums1和nums2的最后一个元素(题目假设nums1有足够的空间来保存nums2的元素)
    1.如果nums1的m指向的元素大于等于nums2的n指向的元素，把nums1的m指向的元素放到nums[m+n-1]的位置，然后m减一
    2.反之，则把nums2的n指向的元素放在nums[m+n-1]的位置，然后n减一
    已知数组nums1总长度为m，数组nums2总长度为n
    time: O(m + n) space: O(1)
"""
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        while m > 0 and n > 0:
            if nums1[m-1] >= nums2[n-1]:
                nums1[m+n-1] = nums1[m-1]
                m -= 1
            else:
                nums1[m+n-1] = nums2[n-1]
                n -= 1
        if n > 0:
            nums1[:n] = nums2[:n]