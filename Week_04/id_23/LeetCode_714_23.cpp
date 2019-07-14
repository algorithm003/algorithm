class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        if (prices.empty())
            return 0;
        int rp = -prices[0]-fee;
        int up = 0;
        for (int i = 1; i < prices.size(); ++i) {
            int tup = max(rp + prices[i], up);
            rp = max(rp, up - prices[i] - fee);
            up = tup;
        }
        return up;
    }
};
