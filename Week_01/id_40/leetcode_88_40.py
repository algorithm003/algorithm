# https://leetcode-cn.com/problems/merge-sorted-array/

# 思路 1: 普通归并

from typing import List

class Solution1:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        _m = []
        p1,p2 = 0,0
        while p1 < m and p2 < n:
            if nums1[p1]<=nums2[p2]:
                _m.append(nums1[p1])
                p1 += 1
            else:
                _m.append(nums2[p2])
                p2 += 1
        while p1 < m:
            _m.append(nums1[p1])
            p1 += 1
        while p2<n:
            _m.append(nums2[p2])
            p2 += 1

        nums1[:]=_m[:]


# 思路 2: 逆序归并
# 观察到 nums1 从 m 到最后一个位置都是 0 值, 或者我们不关心的值. 这就给归并带来了可利用的空间: 
# 普通归并需要第三个数组来暂存归并数据, 而现在的 nums1 本身就可以承担此角色, 只需倒过来, 
# 从 m+n-1 的位置倒序归并即可. 但是要注意, 倒序处理的大小比较与正序是相反的.

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        p0 = m + n - 1
        p1 = m - 1
        p2 = n - 1

        while p1 >= 0 and p2 >=0:
            if nums1[p1]>=nums2[p2]:
                nums1[p0] = nums1[p1]
                p1 -= 1
            else:
                nums1[p0] = nums2[p2]
                p2 -= 1
            p0 -= 1

        if p1>=0:
            nums1[:p0+1] = nums1[:p1+1]

        if p2>=0:
            nums1[:p0+1] = nums2[:p2+1]




