class Solution {
public:
    // dp[i, 0] = max(dp[i-1, 1] + prices[i], d[i-1, 0]);
    // dp[i, 1] = max(dp[i-1, 1], dp[i-2, 0] - prices[i]);
    int maxProfit(vector<int>& prices) {
        int i11 = -INT_MAX, i10 = 0, i20 = 0;
        for (int i = 0; i < prices.size(); ++i) {
            int i0 = max(i11 + prices[i], i10);
            int t1 = max(i11, i20 - prices[i]);
            i20 = i10;
            i11 = t1;
            i10 = i0;
        }
        return i10;
    }
};
