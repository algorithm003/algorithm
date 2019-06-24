class Solution {
public:
    string removeDuplicates(string S) {
        deque<char> d;
        for (char c : S)
            (!d.empty() && d.back() == c) ? d.pop_back() : d.push_back(c);
        string str;
        while (!d.empty()) {
            str.push_back(d.front());
            d.pop_front();
        }
        return str;
    }
};
