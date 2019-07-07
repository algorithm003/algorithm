# @Author：Kilien
# @lc app=leetcode id=703 lang=python3
# [703] Kth Largest Element in a Stream
# https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
'''
  将列表转化为小顶堆，保证第k个大的元素在堆顶，
  若堆中元素个数小于k，则后续元素入堆，重新排序，直至堆满足k个元素
  若后续加入元素比堆顶大则剔除堆顶元素，该元素加入小顶堆，重新排序
  若后续加入元素比堆顶小则忽略
'''
class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.pool = nums
        self.k = k
        heapq.heapify(self.pool)
        while len(self.pool) > k:
            heapq.heappop(self.pool)

    def add(self, val: int) -> int:
        if len(self.pool) < self.k:
            heapq.heappush(self.pool, val)
        elif val > self.pool[0]:
            heapq.heapreplace(self.pool, val)
        return self.pool[0]
        

