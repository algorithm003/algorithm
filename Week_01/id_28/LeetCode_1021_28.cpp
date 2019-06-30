class Solution {
public:
    string removeOuterParentheses(string S) {
        string s;
        int l = 0;
        for (char c : S) {
            if (c == '(') {
                if (l++ != 0) s.push_back(c);
            } else {
                if (l-- != 1) s.push_back(c);
            }
        }
        return s;
    }
};
