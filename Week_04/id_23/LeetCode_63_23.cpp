class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& grid) {
        long dp[grid.size()][grid[0].size()];
        dp[0][0] = (grid[0][0] == 1) ? 0 : 1;
        for (long i = 1; i < grid.size(); ++i)
            dp[i][0] = (dp[i-1][0] == 0 || grid[i][0] == 1) ? 0 : 1;
        for (long i = 1; i < grid[0].size(); ++i)
            dp[0][i] = (dp[0][i-1] == 0 || grid[0][i] == 1) ? 0 : 1;
        for (long i = 1; i < grid.size(); ++i)
            for (long j = 1; j < grid[0].size(); ++j)
                dp[i][j] = (grid[i][j] == 1) ? 0 : dp[i-1][j] + dp[i][j-1];
        return dp[grid.size()-1][grid[0].size()-1];
    }
};
