class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.empty())
            return 0;
        int p1 = 0;
        int p2 = nums[0];
        for (int i = 2; i <= nums.size(); ++i) {
            p1 = max(p1 + nums[i-1], p2);
            swap(p1, p2);
        }
        return p2;
    }
};
