# https://leetcode-cn.com/problems/arranging-coins/

# 思路 1: 暴力迭代法
# 时间复杂度:
# 空间复杂度:


class Solution1:
    def arrangeCoins(self, n: int) -> int:
        k=0
        while n > k:
            k+=1
            n-=k
        
        return k

# 思路 2: 数学法
# 找到一个最大值 k,使得 k * (k + 1)/2 < n.
# 1. 解数学公式
# 2. 二分查找



