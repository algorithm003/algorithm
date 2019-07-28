class Solution {
public:
    int maxProfit(vector<int>& prices) {   
        if (prices.empty())
            return 0;
        
        const int max_k = 2;
        int n = prices.size();
        int dp[n][max_k + 1][2];
        
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) { 
                    dp[i][k][0] = dp[i][0][0] = 0;
                    dp[i][k][1] = dp[i][0][1] = INT_MIN;
                    continue;
                }
                dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
    }
}
        return dp[n - 1][max_k][0];
    }
};