class Solution {
public:
    bool isAnagram(string s, string t) {        
        unordered_map<char, int> ms;
        unordered_map<char, int> mt;
        
        for (const auto& c : s) ms[c] += 1;
        
        for (const auto& c : t) mt[c] += 1;
        
        for (const auto& e : ms)
            if (e.second != mt[e.first]) return false;
        
        for (const auto& e : mt)
            if (e.second != ms[e.first]) return false;
        
        return true;
    }
};
