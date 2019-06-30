class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        if (dungeon.empty() || dungeon[0].empty()) {
            return 1;
        }
        
        // DP[i, j]
        int width = dungeon[0].size();
        int height = dungeon.size();
        int dp[width][height] = {1};
        
        dp[width-1][height-1] = max(1, 1-dungeon[height-1][width-1]);
        
        for (int i = width - 2; i >= 0; --i) {
            dp[i][height-1] = max(1, dp[i+1][height-1]-dungeon[height-1][i]);
        }
        
        for (int i = height - 2; i >= 0; --i) {
            dp[width-1][i] = max(1, dp[width-1][i+1]-dungeon[i][width-1]);
        }
        
        for (int i = width - 2; i >= 0; --i) {
            for (int j = height - 2; j >= 0; --j) {
                dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1])-dungeon[j][i]);
            }
        }
        
        return dp[0][0];
    }
};
