class TrieNode{
public:
    TrieNode *child[26];
    bool isWord;
    
    TrieNode() : isWord(false){
        for(auto& c : child)
            c = NULL;
    }
};

class Trie {
public:
    
    /** Initialize your data structure here. */
    Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode *p = root;
        for(auto w : word){
            int i = w - 'a';
            if(!p->child[i])
                p->child[i] = new TrieNode();
            p = p->child[i];
        }
        
        p->isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode *p = root;
        for(auto w : word){
            int i = w - 'a';
            if(!p->child[i])
                return false;
            p = p->child[i];
        }
        
        return p->isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode *p  =root;
        for(auto w : prefix){
            int i = w - 'a';
            if(!p->child[i])
                return false;
            p = p->child[i];
        }
        
        return true;
    }
    
private:
    TrieNode *root;
};