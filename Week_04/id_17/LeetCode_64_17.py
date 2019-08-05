# 64. 最小路径和

给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        dp = []
        for i in range(len(grid)):
            dp.append([0 for i in range(len(grid[0]))])
        dp[0][0] = grid[0][0]
        for i in range(1,len(grid)):
            dp[i][0] = grid[i][0] + dp[i-1][0]
        for i in range(1,len(grid[0])):
            dp[0][i] = grid[0][i] + dp[0][i-1]
        for i in range(1,len(grid)):
            for j in range(1,len(grid[0])):
                dp[i][j] = min([dp[i-1][j], dp[i][j-1]]) + grid[i][j]
        return dp[-1][-1]
        
