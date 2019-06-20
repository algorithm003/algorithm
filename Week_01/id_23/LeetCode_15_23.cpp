class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        int count = nums.size();
        
        if (count < 3)
            return res;
        
        sort(nums.begin(), nums.end());
        for (int i = 0; i < count-2 && nums[i] <= 0; ++i) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            
            int j = i + 1, k = count-1;
            while (j < k) {
                if (j != i + 1 && nums[j] == nums[j-1]) {
                    ++j;
                    continue;
                }
                
                if (k != count - 1 && nums[k] == nums[k+1]) {
                    --k;
                    continue;
                }
                
                if (nums[j] + nums[k] == -nums[i]) {
                    res.push_back(vector<int>{nums[i], nums[j++], nums[k--]});
                    continue;
                }
                
                if (nums[j] + nums[k] > -nums[i]) {
                    --k;
                    continue;
                }
                
                ++j;
            }
        }
        
        return res;
    }
};
