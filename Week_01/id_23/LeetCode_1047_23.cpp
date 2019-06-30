class Solution {
public:
    string removeDuplicates(string S) {
        deque<char> deq;
        for (int i = 0; i < S.size(); ++i) {
            if (!deq.empty() && deq.back() == S[i]) {
                deq.pop_back();
                continue;
            }
            
            deq.push_back(S[i]);
        }
        
        string res;
        while (!deq.empty()) {
            res += deq.front();
            deq.pop_front();
        }
        
        return res;
    }
};
