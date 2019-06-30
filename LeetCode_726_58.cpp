class Solution {
public:
    string countOfAtoms(string formula) {
		string res = "";
        
        stack<map<string, int>> st;
        map<string, int> cur;
        
        int n = formula.size(), pos = 0;
        while (pos < n){
            if (formula[pos] == '('){
                ++pos;
                st.push(move(cur));
            } else if (formula[pos] == ')'){
                int i = ++pos;
                
                while (pos < n && isdigit(formula[pos]))
                    ++pos;
                int multiple = stoi(formula.substr(i, pos - i));
                for (auto a : cur) 
                    st.top()[a.first] += a.second * multiple;
                
                cur = move(st.top());
                st.pop();
            } else {
                int i = pos++;
                while (pos < n && islower(formula[pos]))
                    ++pos;
                string elem = formula.substr(i, pos - i);
                
                i = pos;
                while (pos < n && isdigit(formula[pos]))
                    ++pos;
                string cnt = formula.substr(i, pos - i);
                cur[elem] += cnt.empty() ? 1 : stoi(cnt);
            }
        }
        for (auto a : cur) {
            res += a.first + (a.second == 1 ? "" : to_string(a.second));
        }
        return res;
    }
};