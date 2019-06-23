from typing import List


"""
    @author: Merlin 2019.06.23
    189.Rotate Array
    思路: 将数组nums的最后一个元素放在数组nums索引为0的位置，循环k次，每次循环都会消耗O(n)去将数组元素往后退
    time: O(k*n) space: O(1)
"""
class Solution_1:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # nums[-(k % len(nums)):], nums[:0] = [], nums[-(k % len(nums)):]
        k = k % len(nums)
        for i in range(k):
            nums.insert(0, nums.pop())


"""
    @author: Merlin 2019.06.23
    189.Rotate Array
    思路: 利用Python切片暴力将数组根据k的位置分成两部分并交换位置，利用一个临时变量temp完成
    time: O(n) space: O(k)
"""
class Solution_2:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        temp = nums[-k:]
        nums[k:] = nums[:-k]
        nums[:k] = temp


"""
    @author: Merlin 2019.06.23
    189.Rotate Array
    思路: 正常做法就是反转三次，先把原数组翻转一遍，根据k分成两部分各自翻转
    time: O(n) space: O(1)
"""
class Solution_3:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k = k % n
        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)

    def reverse(self, nums, start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1



if __name__ == "__main__":
    test = Solution_1()
    test.rotate([1,2,3,4,5,6,7], 3)
