//class Solution {
//public:
//    vector<vector<string>> groupAnagrams(vector<string>& strs) {
//        vector<vector<string>> res;
//        
//        map<string, vector<string>> ms;
//        int size = strs.size();
//        for (int i = 0; i < size; i++){
//            int tmp[26] = {0};
//            for (int j = 0; j < strs[i].size(); j++){
//                tmp[strs[i][j] - 'a']++;
//            }
//            
//            string s = "";
//            for (int k = 0; k < 26; k++)
//                s += to_string(tmp[k]) + ".";
//            ms[s].push_back(strs[i]);
//        }
//        
//        for (auto a : ms)
//            res.push_back(a.second);
//        
//        return res;
//    }
//};