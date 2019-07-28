class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = INT_MIN;
        int curSum = 0;
        for (auto num : nums) {
            curSum = max(num, num + curSum);
            res = max(res, curSum);
        }
        
        return res;
    }
};