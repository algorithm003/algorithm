class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}
        for index in range(len(nums)):
            if nums[index] in dic:
                return dic[nums[index]], index
            else:
                dic[target - nums[index]] = index
        return -1, -1

