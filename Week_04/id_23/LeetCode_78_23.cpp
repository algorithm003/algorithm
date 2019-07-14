class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> v;
        subset(nums, 0, v, res);
        return res;
    }
    
    void subset(vector<int> &nums, int i, vector<int> &v, vector<vector<int>> &res) {
        res.push_back(v);
        for (int j = i; j < nums.size(); ++j) {
            v.push_back(nums[j]);
            subset(nums, j+1, v, res);
            v.pop_back();
        }
    }
};
