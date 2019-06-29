class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> m;
        for (int i = 0; i < nums.size(); i++) {
            if (m.find(target - nums[i]) != m.end()) return {m.find(target - nums[i])->second, i};
            m.insert(pair<int, int>(nums[i], i));
        }
        return {};
    }  
};