class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size())
            return false;
        
        int count[26] = {0};
        for (auto &ch : s) { ++count[ch-'a']; }
        for (auto &ch : t) {
            if (count[ch-'a']-- <= 0)
                return false;
        }
        
        return true;
    }
};
