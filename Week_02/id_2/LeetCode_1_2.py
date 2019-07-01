"""
    @author: Merlin 2019.06.30 哈希表解法
    1.Two Sum
    思路: 哈希表按值: 索引来存储，对哈希表的访问是O(1)，所以只需要遍历数组一次，每次遍历访问哈希表中的值是否存在
    time: O(n) space: O(n)
"""
class Solution_1:
    def twoSum(self, nums, target):
        dic = {}
        for i, x in enumerate(nums):
            if target - x in dic:
                return [i,dic[target - x]]
            dic[x] = i


"""
    @author: Merlin 2019.06.30 暴力求解
    1.Two Sum
    思路: 两次循环解决，这种为暴力流解法
    time: O(n) space: O(1)
"""
class Solution_2:
    def twoSum(self, nums, target):
        for i in range(0,len(nums) - 1):
            for j in range(i + 1,len(nums)):
                if nums[i] + nums[j] == target:
                    return [i,j]