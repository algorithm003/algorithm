struct Trie {
    Trie():chs({0}), word(false){}
    Trie* chs[26];
    bool word;
};
class Solution {
public:
    string longestWord(vector<string>& words) {
        Trie *root = new Trie;
        for (auto &word : words)
            buildTrie(root, word);
        string s, res;
        getLongestWord(root, s, res);
        return res;
    }
    
    void buildTrie(Trie *root, string &word) {
        Trie *p = root;
        for (auto &ch : word) {
            int i = ch - 'a';
            if (NULL == p->chs[i])
                p->chs[i] = new Trie;
            p = p->chs[i];
        }
        p->word = true;
    }
    
    void getLongestWord(Trie *root, string &s, string &res) {
        for (int i = 0; i < 26; ++i) {
            Trie *p = root->chs[i];
            if (p && p->word) {
                s += ('a' + i);
                res = (res.size() < s.size()) ? s : (res.size() == s.size() && res > s) ? s : res;
                getLongestWord(p, s, res);
                s.erase(s.size()-1);
            }
        }
    }
};
