class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> m;
        int longest = 0, b = 0, i = 0;
        for (; i < s.size(); i++) {
            if (m.find(s[i]) != m.end()) {
                longest = max(longest, i - b);
                b = max(b, m[s[i]] + 1);
            }
            m[s[i]] = i;
        }
        return max(longest, i - b);
    }
};