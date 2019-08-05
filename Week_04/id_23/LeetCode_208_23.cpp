class Trie {
public:
    /** Initialize your data structure here. */
    Trie():chs({0}),word(false) {
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie *p = this;
        for (int i = 0; i < word.size(); ++i) {
            int c = word[i]-'a';
            if (NULL == p->chs[c])
                p->chs[c] = new Trie;
            p = p->chs[c];
        }
        p->word = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie *p = this;
        for (int i = 0; p && i < word.size(); ++i) {
            p = p->chs[word[i]-'a'];
        }
        return (p && p->word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie *p = this;
        for (int i = 0; p && i < prefix.size(); ++i) {
            p = p->chs[prefix[i]-'a'];
        }
        return (p);
    }
    
    Trie *chs[26];
    bool word;
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
