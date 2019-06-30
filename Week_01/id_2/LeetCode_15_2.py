"""
    @author: Merlin 2019.06.23
    15.Three Sum
    思路: 先对数组进行排序，然后用两层遍历和哈希表去完成算法
    time: O(n^2) space: O(n) 因为额外开了一个set数据结构
"""
class Solution_1:
    def threeSum(self, nums):
        if len(nums) < 3:
            return []
        nums.sort()
        res = set()
        for i, v in enumerate(nums[:-2]):
            if i >= 1 and v == nums[i-1]:
                continue
            d = {}
            for x in nums[i+1:]:
                if x not in d:
                    d[-v-x] = 1
                else:
                    res.add((v, -v-x, x))
        return list(res)


"""
    @author: Merlin 2019.06.23
    15.Three Sum
    思路: 先对数组进行排序，对每个元素遍历，遍历当前元素的时候利用两个指针分别从当前元素的下一个元素和最后一个元素开始往中间夹
    time: O(n^2) space: O(1)
"""
class Solution_2:
    def threeSum(self, nums):
        if len(nums) < 3:
            return []
        res = []
        nums.sort()
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            l, r = i+1, len(nums)-1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if s < 0: l += 1
                elif s > 0: r -= 1
                else:
                    res.append((nums[i], nums[l], nums[r]))
                    while l < r and nums[l] == nums[l+1]:
                        l += 1
                    while l < r and nums[r] == nums[r-1]:
                        r -= 1
                    l += 1; r -= 1
        return res