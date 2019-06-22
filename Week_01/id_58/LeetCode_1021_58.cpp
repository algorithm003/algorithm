class Solution {
public:
    string removeOuterParentheses(string S) {
        if(S.empty())
            return S;
        
        stack<char> sc;
        const int n = S.size();
        char tmp[n + 1];
        int j = 0;
        for (int i = 0; i < n; i++){
            char ch = S[i];
            if (ch == '('){
                sc.push(ch);
                if (sc.size() != 1){
                    tmp[j++] = ch;
                }
            }else if (ch == ')' && !sc.empty()){
                sc.pop();
                if (sc.size() != 0){
                    tmp[j++] = ch;
                }
            }
        }
        tmp[j] = '\0';
        
        string res = tmp;
        return res;
    }