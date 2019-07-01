class Solution {
public:
    static bool _cmp(pair<string, int>& p1, pair<string, int>& p2) {
        return (p1.second != p2.second) ? (p1.second > p2.second) : (strcmp(p2.first.c_str(), p1.first.c_str()) >= 0);
    }
    
    void _sortMap(unordered_map<string, int> &m, vector<pair<string, int>>& v) {
        for (auto p : m) v.push_back(p);
        sort(v.begin(), v.end(), _cmp);
    }
    
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> wordsMap;
        for (auto word : words) wordsMap[word] += 1;
        vector<pair<string, int>> sortWords;
        _sortMap(wordsMap, sortWords);
        vector<string> topWords;
        if (k > sortWords.size()) k = sortWords.size();
        for (int i = 0; i < k; i++) topWords.push_back(sortWords[i].first);
        return topWords;
    }
};
