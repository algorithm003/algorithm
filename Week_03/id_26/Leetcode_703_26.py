#
# @lc app=leetcode id=703 lang=python3
#
# [703] Kth Largest Element in a Stream
#
import heapq

class KthLargest:

    def __init__(self, k, nums):
        self.nums = nums
        self.k = k
        heapq.heapify(self.nums)
        while len(self.nums) > k:
            heapq.heappop(self.nums)
        
    def add(self, val):
        if len(self.nums) < self.k:
            heapq.heappush(self.nums, val)
        elif val > self.nums[0]:
            heapq.heapreplace(self.nums, val)
        return self.nums[0]







# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(3, [4, 5, 8, 2])
# param_1 = obj.add(3)

