class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        map<char, int> chIndex;
        int maxSubStrLen = 0;
        int start = -1;
        for (int i = 0; i < s.size(); ++i) {
            if (chIndex.find(s[i]) != chIndex.end()) {
                start = max(start, chIndex[s[i]]);
            }
            chIndex[s[i]] = i;
            maxSubStrLen = max(maxSubStrLen, i - start);
        }
        return maxSubStrLen;
    }
};
