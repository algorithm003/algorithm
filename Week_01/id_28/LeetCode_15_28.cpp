class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> vv;
        if (nums.size() < 3) return vv;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < (nums.size() - 2); i++) {
            if ((i > 0) && (nums[i] == nums[i - 1])) continue;
            int l = i + 1, r = nums.size() - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    vv.push_back(vector<int> {nums[i], nums[l], nums[r]});
                    while ((l < (nums.size() - 1)) && nums[l] == nums[l + 1]) l++;
                    while ((r > 0) && nums[r] == nums[r - 1]) r--;
                    l++; r--;
                }
            }
        }
        return vv;
    }
};
