# 70. 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0,1,2]
        if n in dp:
            return n
        for i in range(3,n+1):
            dp.append(dp[i-1] + dp[i-2])
        return dp[-1]
