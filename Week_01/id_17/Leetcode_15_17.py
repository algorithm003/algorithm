class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        length = len(nums)
        if length < 3:
            return []

        nums.sort()
        res = []

        for i in range(0,length - 2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            left = i + 1
            right = length - 1
            if left + 1 < right - 1 and not nums[left] + nums[left+1] <= -nums[i] <= nums[right] + nums[right-1]:
                continue
            while left < right:
                s = nums[i] + nums[left] + nums[right]
                if s > 0:
                    right -= 1
                elif s < 0:
                    left += 1
                else:
                    res.append([nums[i],nums[left],nums[right]])
                    while left < right and nums[left] == nums[left+1]:
                        left += 1
                    while left < right and nums[right] == nums[right-1]:
                        right -= 1
                    left += 1
                    right -= 1
        return res

# 简化代码逻辑