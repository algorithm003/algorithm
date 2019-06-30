class Solution:

    '''
    三数之和，先将数组排序，再用三个下标遍历，一个从0开始的递增i下标，加上左右两个下标l和r,分别为i+1,length-1
    如果nums[i]已经大于0，则没有继续遍历的必要，因为必然大于0
    因为不能用重复元素，所以当相邻是重复时，直接跳过本次遍历
    l， r下标不断向中间靠近，直到l == r，在这个过程，不断计算total值是否等于0，如果是则添加到sum数组中
    当total等于0的时候，因为不能有重复组合这个规定，所以也如同最开始判断num[i-1] == nums[i]就跳过本次循环一样
    如果相邻的是相同元素，则l或者r就直接自增自减来跳过
    最后返回sum数组
    '''

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        length = len(nums)
        sum = []

        for i in range(length - 2):
            if nums[i] > 0:
                break
            if i > 0 and nums[i-1] == nums[i]:
                continue
            l, r = i + 1, length - 1
            while l < r:
                total = nums[i] + nums[l]
                    l += 1
                elif total > 0:
                    r -= 1
                else:
                    sum.append([nums[i], nums[l], nums[r]])
                    while l < r and nums[l+1] == nums[l]:
                        l += 1
                    while l < r and nums[r+1] == nums[r]:
                        r -= 1
                    l += 1
                    r -= 1
        return sum