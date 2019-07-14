class Solution {
public:
    int majorityElement(vector<int>& nums) {
        return majority(nums, 0, nums.size()-1);
    }
    
    int majority(vector<int> &nums, int l, int r) {
        if (l == r)
            return nums[l];
        int m = l + (r-l)/2;
        int lm = majority(nums, l, m);
        int rm = majority(nums, m+1, r);
        if (lm == rm)
            return lm;
        int lm_count = 0, rm_count = 0;
        for (int i = l; i <= r; ++i) {
            if (nums[i] == lm)
                ++ lm_count;
            else if (nums[i] == rm)
                ++ rm_count;
        }
        return (lm_count > rm_count) ? lm : rm;
    }
};
