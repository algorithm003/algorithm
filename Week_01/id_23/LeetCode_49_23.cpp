class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, vector<string>> group;        
        for (int i = 0; i < strs.size(); ++i) {
            string hash = calHash(strs[i]);
            group[hash].push_back(strs[i]);
        }
        
        vector<vector<string>> res;
        for (auto &i : group)
            res.push_back(i.second);
        
        return res;
    }
    
    string calHash(const string &str) {
        int count[26] = {0};
        for (int i = 0; i < str.size(); ++i) {
            ++ count[str[i]-'a'];
        }
        
        stringstream ss;
        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0)
                ss << i << "^" << count[i] << ",";
        }
        
        return ss.str();
    }
};
