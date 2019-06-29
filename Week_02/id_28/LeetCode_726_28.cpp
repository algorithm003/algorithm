class Solution {
public:
    string countOfAtoms(string formula) {
        map<string, int> m;
        stack<int> st_times, st_word;
        st_times.push(1);
        int num = 1;
        bool lastCharIsDigit = false;
        string s;
        for (int i = formula.size() - 1; i >= 0; i--) {
            if (isdigit(formula[i])) {
                num = lastCharIsDigit ? num + ((formula[i] - '0') * 10) : (formula[i] - '0');
                lastCharIsDigit = true;
            } else {
                if ('a' <= formula[i] && formula[i] <= 'z') st_word.push(formula[i]);
                else {
                    if (formula[i] == ')') st_times.push(st_times.top() * num);
                    else if (formula[i] == '(') st_times.pop();
                    else if (formula[i] < 'a') {
                        s.push_back(formula[i]);
                        while (!st_word.empty()) {
                            s.push_back(st_word.top());
                            st_word.pop();
                        }
                        m[s] += num * st_times.top();
                        s.clear();
                    }
                    num = 1;
                }
                lastCharIsDigit = false;
            }
        }
        for (auto p : m) {
            s.append(p.first);
            if (p.second != 1) s.append(to_string(p.second));
        }
        return s;
    }
};
