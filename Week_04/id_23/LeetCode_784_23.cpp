class Solution {
public:
    vector<string> letterCasePermutation(string S) {
        vector<string> res;
        letterCasePermutation(S, 0, res);
        return res;
    }
    
    void letterCasePermutation(string &S, int i, vector<string> &res) {
        if (i == S.size()) {
            res.push_back(S);
            return;
        }
        letterCasePermutation(S, i+1, res);
        if ((S[i] >= 'a' && S[i] <= 'z') || (S[i] >= 'A' && S[i] <= 'Z')) {
            S[i] ^= 0x20;
            letterCasePermutation(S, i+1, res);
        }
    }
};
