# 198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 每个房子有两个状态：偷或没偷
        STEAL = 0
        NOTSTEAL = 1
        if not nums:
            return 0
        
        dp = [[0,0] for i in range(len(nums))]
        dp[0][STEAL] = nums[0]
        dp[0][NOTSTEAL] = 0
        for i in range(1,len(nums)):
            dp[i][STEAL] = dp[i-1][NOTSTEAL] + nums[i]
            dp[i][NOTSTEAL] = max([dp[i-1][STEAL],dp[i-1][NOTSTEAL]])
        return max([dp[-1][STEAL], dp[-1][NOTSTEAL]])

执行结果：
通过
执行用时 :24 ms, 在所有 Python 提交中击败了79.42%的用户
内存消耗 :11.8 MB, 在所有 Python 提交中击败了16.21%的用户
