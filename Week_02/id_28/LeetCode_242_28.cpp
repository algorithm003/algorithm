class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> ms, mt;
        for (auto c : s) ms[c] += 1;
        for (auto c : t) mt[c] += 1;
        for (auto p : ms) {
            if (p.second != mt[p.first]) return false;
            mt.erase(p.first);
        }
        return mt.empty();
    }
};