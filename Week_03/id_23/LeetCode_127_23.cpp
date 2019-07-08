class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> words;
        for_each(wordList.begin(), wordList.end(), [&](auto&val){words.insert(val);});
        deque<string> deq;
        deq.push_back(beginWord);
        int level = 1;
        while (!deq.empty()) {
            int levelSize = deq.size();
            for (int i = 0; i < levelSize; ++i) {
                string word = deq.front(); deq.pop_front();
                if (word == endWord)
                    return level;
                for (int i = 0; i < word.size(); ++i) {
                    char ch = word[i];
                    for (int j = 0; j < 26; ++j) {
                        word[i] = 'a'+j;
                        if (words.find(word) != words.end()) {
                            deq.push_back(word);
                            words.erase(word);
                        }
                    }
                    word[i] = ch;
                }
            }
            ++level;
        }
        return 0;
    }
};
