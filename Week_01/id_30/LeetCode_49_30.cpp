class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        unordered_map<string, vector<string>> group;
        for (auto str : strs) {
            string key = str;
            sort(key.begin(), key.end());
            group[key].push_back(str);
        }
        
        for (auto &it : group) {
            ans.push_back(it.second);
        }
        return ans;
    }
};
