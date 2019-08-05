class Solution {
public:
    int rob(vector<int>& nums) {
        int size = nums.size();
        if (size < 2)
            return (size) ? nums[0] : 0;
        return max(rob(nums, 0, size-1), rob(nums, 1, size));
    }
    
    int rob(vector<int>& nums, int f, int t) {
        int p1 = 0;
        int p2 = nums[f];
        for (int i = f+1; i < t; ++i) {
            p1 = max(p1 + nums[i], p2);
            swap(p1, p2);
        }
        return p2;
    }
};
