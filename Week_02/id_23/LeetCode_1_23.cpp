class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        if (nums.size() <= 1)
            return vector<int>();
        
        map<int, int> mapping;
        for (int i = 0; i < nums.size(); ++i) {
            int diff = target - nums[i];
            if (mapping.find(diff) != mapping.end()) {
                return vector<int>{i, mapping[diff]};
            }
            mapping[nums[i]] = i;
        }
        
        return vector<int>();
    }
};
