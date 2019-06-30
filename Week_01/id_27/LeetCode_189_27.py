class Solution:

    '''
    对数组进行k位的翻转，可以使用三次数组翻转达到此目的
    首先对0 到 end-k部分进行翻转
    再对end-k+1到end部分进行翻转
    最后对0到end进行翻转，即可完成题目要求
    '''

    def rotate(self, nums: List[int], k: int) -> None:
        if k < 1:
            return
        k = k % len(nums)
        end = len(nums) - 1

        def reserve(nums, start, end):
            if start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1

        reserve(nums, 0, end - k)
        reserve(nums, end - k + 1, end)
        reserve(nums, 0, end)
