class Solution {
public:
    bool isAnagram(string s, string t) {
        int ssize = s.size();
        int tsize = t.size();
        
        if (ssize != tsize)
            return false;
        
        int count[26] = {0};
        for (int i = 0; i < ssize; ++i) {
            ++count[s[i]-'a'];
        }
        
        for (int j = 0; j < tsize; ++j) {
            if (count[t[j]-'a']-- <= 0) {
                return false;
            }
        }
        
        return true;
    }
};
