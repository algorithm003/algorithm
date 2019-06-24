class Solution {
public:
    string removeOuterParentheses(string S) {
        // record parentheses to be removed
        deque<int> deq;
        string res;
        
        for (int i = 0; i < S.size(); ++i) {
            if (S[i] == '(') {
                deq.push_back(i);
                continue;
            }
            
            if (deq.size() == 1) {
                res += S.substr(deq.back()+1, i - deq.back() - 1);
            }
            deq.pop_back();
        }
        
        return res;
    }
    
};
