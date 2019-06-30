class Solution {
public:
    int lengthOfLongestSubstring(string s) {
		int res = 0;

        vector<int> m(256, -1);
		int left = -1;

		int n = s.size();
        for (int i = 0; i < n; ++i) {
            left = max(left, m[s[i]]);
            m[s[i]] = i;
            res = max(res, i - left);
        }
        return res;
    }
};