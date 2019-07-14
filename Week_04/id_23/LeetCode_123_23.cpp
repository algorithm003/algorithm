class Solution {
public:
    // dp[i,2,0] = max(dp[i-1,2,0], dp[i-1,2,1+prices[i]])
    // dp[i,2,1] = max(dp[i-1,2,1], dp[i-1,1,0]-prices[i])
    // dp[i,1,0] = max(dp[i-1,1,0], dp[i-1,1,1]+prices[i])
    // dp[i,1,1] = max(dp[i-1,1,1], -prices[i])
    int maxProfit(vector<int>& prices) {
        int i11 = -INT_MAX, i10 = 0, i20 = 0, i21 = -INT_MAX;
        for (int i = 0; i < prices.size(); ++i) {
            i20 = max(i20, i21+prices[i]);
            i21 = max(i21, i10-prices[i]);
            i10 = max(i10, i11+prices[i]);
            i11 = max(i11, -prices[i]);
        }
        return i20;
    }
};
