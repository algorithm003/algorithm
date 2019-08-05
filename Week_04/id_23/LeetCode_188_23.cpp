class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        if (k >= prices.size()/2) {
            int ik1 = INT_MIN, ik0 = 0;
            for (int i = 0; i < prices.size(); ++i) {
                int t = max(ik1, ik0-prices[i]);
                ik0 = max(ik0, ik1+prices[i]);
                ik1 = t;
            }
            return ik0;
        }
        vector<int> dp1(k+1, INT_MIN);
        vector<int> dp0(k+1, 0);
        for (int i = 0; i < prices.size(); ++i)
            for (int j = k; j > 0; --j) {
                dp1[j] = max(dp1[j], dp0[j-1]-prices[i]);
                dp0[j] = max(dp0[j], dp1[j]+prices[i]);
            }
        return dp0[k];
    }
};
