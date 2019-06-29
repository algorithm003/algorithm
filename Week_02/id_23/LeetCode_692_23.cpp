// using map&set
class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        // count string
        map<string, int> wordsCount;
        for (auto &str : words) {
            ++ wordsCount[str];
        }
        
        map<int, set<string>, greater<int>> count2Words;
        for (auto &item : wordsCount) {
            count2Words[item.second].insert(item.first);
        }
        
        // pick first k string
        vector<string> res;
        for (auto &count : count2Words) {
            for (auto &str : count.second) {
                if (k--) {
                    res.push_back(str);
                    continue;
                }
                return res;
            }
        }
        
        return res;
    }
};

// using priority_queue
class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        // count string
        map<string, int> wordsCount;
        for_each(words.begin(), words.end(), [&](const string &str){++wordsCount[str];});
        
        auto cmp = [](pair<string, int> &lhs, pair<string, int> &rhs) {
            return (lhs.second > rhs.second || (lhs.second == rhs.second && lhs.first < rhs.first));
        };
        priority_queue<pair<string, int>, vector<pair<string, int>>, decltype(cmp)> q(cmp);
        for_each(wordsCount.begin(), wordsCount.end(), [&](auto &val){
            q.emplace(val.first, val.second);
            if (q.size() > k)
                q.pop();
        });
        
        vector<string> res;
        while (!q.empty()) {
            res.insert(res.begin(), q.top().first);
            q.pop();
        }
        return res;
    }
};
