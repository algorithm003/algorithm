/*class Solution {
public:
    string removeDuplicates(string S) {
        stack<char> stack;
        for (auto &c : S) {
            if (!stack.empty() && stack.top() == c) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        
        S.clear();
        while(!stack.empty()) {
            S = stack.top() + S;
            stack.pop();
        }
        return S;
    }
};*/

class Solution {
public: 
    string removeDuplicates(string S) {
        string result = "";
        for (auto &c : S) {
            if (result.size() && result.back() == c) {
                result.pop_back();
            }
            else {
                result.push_back(c);
            }
        }
        return result;
    }
};