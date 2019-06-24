class Solution {
public:
    string removeDuplicates(string S) {
        stack<char> st;
        for (auto s : S){
            if (!st.empty() && st.top() == s)
                st.pop();
            else
                st.push(s);
        }
        
        string res;
        const int n = st.size();
        char tmp[n + 1];
        int i = n - 1;
        while (!st.empty()){
            tmp[i] = st.top();
            st.pop();
            i--;
        }
        tmp[n] = '\0';      
        res = tmp;
        
        return res;
    }