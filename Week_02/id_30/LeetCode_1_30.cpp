class Solution {
public:
    /*
    // 空间复杂度O(1)，时间复杂度是O(n^2)
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = i+1; j < nums.size(); ++j) {
                if (target == nums[i] + nums[j]) {
                    ans.push_back(i);
                    ans.push_back(j);
                    return ans;
                }
            }
        }
        return ans;
    }*/
    // 空间复杂度O(n), 时间复杂度是O(n)
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        map<int, int> dict;
        for (int i = 0; i < nums.size(); ++i) {
            int tmp = target - nums[i]; 
            if (dict.find(tmp) != dict.end()) {
                ans.push_back(i);
                ans.push_back(dict[tmp]);
                return ans;
            }
            else {
                dict[nums[i]] = i;
            }
        }
        return ans;
    }
};
