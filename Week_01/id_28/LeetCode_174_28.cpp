class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int r = dungeon.size();
        int c = dungeon[0].size();
        
        int dp[r][c];
        dp[r - 1][c - 1] = dungeon[r - 1][c - 1] >= 0 ? 1 : 1 - (dungeon[r - 1][c - 1]);
        
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if ((i == r - 1) && (j == c - 1)) continue;
                if (i == r - 1) {
                    dp[i][j] = dp[i][j + 1] - dungeon[i][j];
                } else if (j == c - 1) {
                    dp[i][j] = dp[i + 1][j] - dungeon[i][j];
                } else {
                    dp[i][j] = min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j];
                }
                if (dp[i][j] < 1) dp[i][j] = 1;
            }
        }
        
        return dp[0][0];
    }
};
