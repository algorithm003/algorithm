struct Trie {
    Trie():chs({0}),word(false) {   
    }
    
    Trie* chs[26];
    bool word;
};

class WordDictionary {
public:
    /** Initialize your data structure here. */
    WordDictionary() {
        root = new Trie;
    }
    
    /** Adds a word into the data structure. */
    void addWord(string word) {
        Trie *p = root;
        for (auto &ch : word) {
            int i = ch - 'a';
            if (NULL == p->chs[i])
                p->chs[i] = new Trie;
            p = p->chs[i];
        }
        p->word = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    bool search(string word) {
        return dfs(root, word, 0);
    }
    
    bool dfs(Trie *root, string &word, int i) {
        char ch = word[i];
        if (ch != '.') {
            int ci = ch - 'a';
            if (NULL == root->chs[ci])
                return false;
            if (i == word.size()-1)
                return root->chs[ci]->word;
            return dfs(root->chs[ci], word, i+1);
        }
        
        for (int j = 0; j < 26; ++j)
            if (root->chs[j] != NULL) {
                if (i == word.size()-1) {
                    if (root->chs[j]->word)
                        return true;
                    continue;
                }
                if (dfs(root->chs[j], word, i+1))
                    return true;
            }
        return false;
    }
    
    Trie *root;
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */
