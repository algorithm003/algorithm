# https://leetcode-cn.com/problems/rotate-array/

# 思路:首先把 k 按数组长度取余, 这样可以简化题目.

# 思路 1: 直接法
# 分别复制前半段和后半段,并倒换复制到原数组.时间和空间复杂度是 O(n),不严格符合要求.

from typing import List

class Solution1:
    def rotate(self, nums: List[int], k: int) -> None:
        if not nums:
            return []
        
        k%=len(nums)
        
        nums[:] = nums[-k:] + nums[:-k]

# 思路 2: 循环法
# 循环 k 次,每次从数组末尾移除放至头部.

class Solution2:
    def rotate(self, nums: List[int], k: int) -> None:
        if not nums:
            return []
        
        k%=len(nums)
        
        for i in range(k):
            nums.insert(0, nums.pop())

# 时间复杂度: O(n)
# 空间复杂度: O(1)