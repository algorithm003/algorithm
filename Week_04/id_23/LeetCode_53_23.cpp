class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if (nums.empty())
            return 0;
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.size(); ++i) {
            dp = nums[i] + (dp > 0 ? dp : 0);
            max = (dp > max) ? dp : max;
        }
        return max;
    }
};
