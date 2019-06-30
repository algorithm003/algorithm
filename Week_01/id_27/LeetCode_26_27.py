class Solution:

    '''
    此题用两个下标，遍历数组，只有当nums[i] != nums[j] 的时候j才加1，以此统计不重复个数
    nums[j] = nums[i]，因为是已排序数组，当有相等元素时，j下标并没有自增，只有当有不同的元素时，j加1后，将原来有重复的元素
    替换为新的元素
    '''

    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return len(nums)
        j = 0
        for i in range(1, len(nums)):
            if nums[i] != nums[j]:
                j += 1
            nums[j] = nums[i]

        return j + 1