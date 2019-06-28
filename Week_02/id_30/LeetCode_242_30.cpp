class Solution {
public:
     
    // 空间复杂度O(n), 时间复杂度O(n)
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) 
            return false;
        // 将count 从map改成unordered_map提升了4ms
        unordered_map<char, int> count;
        for (int i = 0; i < s.length(); ++i) {
            count[s[i]]++;
            count[t[i]]--;
        }
        for (auto & it : count) {
            if (it.second != 0) {
                return false;
            }
        }
        return true;
    }
    
    /*
    // 空间复杂度为O(1),取决于sort的实现, 时间复杂度 O(nlogn)
    bool isAnagram(string s, string t) {
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        return s == t;
    }*/
    
};