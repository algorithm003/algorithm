# https://leetcode-cn.com/problems/3sum/

# 思路:

# ** 错误写法 **
# 1. 多余判重
# 2. 易错点在于发现符合要求的值之后的调整

from typing import List

class Solution1:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        nums.sort()
        N = len(nums)
        for i in range(N-3):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            l, r = i+1, N-1
            while l < r:
                s = nums[i]+nums[l]+nums[r]
                if s < 0:
                    l += 1
                elif s > 0:
                    r -= 1
                elif s == 0 and [nums[i], nums[l], nums[r]] not in result:
                    result.append([nums[i], nums[l], nums[r]])
                    while l < r and nums[l] == nums[l-1]:
                        l += 1
                    while l < r and nums[r] == nums[r+1]:
                        r -= 1

        return result

# 正确解法:
# 时间复杂度:O(n^2)
# 空间复杂度:O(n)


class Solution2:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result=[]
        nums.sort()
        N = len(nums)
        for i in range(N-2):
            if i > 0 and nums[i]==nums[i-1]:
                continue
            l, r = i+1, N-1
            while l<r:
                s = nums[i]+nums[l]+nums[r]
                if s < 0:
                    l += 1
                elif s > 0:
                    r -= 1
                else:
                    result.append([nums[i],nums[l],nums[r]])
                    while l < r and nums[l] == nums[l+1]:
                        l+=1
                    while l < r and nums[r] == nums[r-1]:
                        r-=1
                l+=1
                r-=1
                        
                
        return result
                        
            
                
                

                    
                
                
                
                


                
            
            
                
        