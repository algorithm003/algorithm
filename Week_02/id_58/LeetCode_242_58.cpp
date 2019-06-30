class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size())
            return false;
        
        int m[26] = {0};
        for (int i = 0; i < s.size(); i++)
            m[s[i] - 'a']++;
        
        for (int i = 0; i < t.size(); i++){
            if(--m[t[i] - 'a'] < 0)
                return false;
            
            // if (m[t[i] - 'a'] == 0)
            //     return false;
            // m[t[i] - 'a']--;
        }
        
        return true;
    }
};