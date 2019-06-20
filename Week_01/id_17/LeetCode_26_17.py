class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)
        cnt = 0
        for idx in range(0,len(nums)):
            if nums[idx] != nums[idx - 1]:
                nums[cnt] = nums[idx]
                cnt += 1
        return cnt
