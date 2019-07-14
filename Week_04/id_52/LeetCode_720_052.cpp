class Solution {
public:
    //Trie datastructure:
    static const int ALPHABET_SIZE = 26; 
  
    // trie node 
    struct TrieNode 
    { 
        struct TrieNode *children[ALPHABET_SIZE]; 

        // isEndOfWord is true if the node represents 
        // end of a word 
        bool isEndOfWord; 
    }; 

    // Returns new trie node (initialized to NULLs) 
    struct TrieNode *getNode(void) 
    { 
        struct TrieNode *pNode =  new TrieNode; 

        pNode->isEndOfWord = false; 

        for (int i = 0; i < ALPHABET_SIZE; i++) 
            pNode->children[i] = NULL; 

        return pNode; 
    } 

    // If not present, inserts key into trie 
    // If the key is prefix of trie node, just 
    // marks leaf node 
    void insert(struct TrieNode *root, string key) 
    { 
        struct TrieNode *pCrawl = root; 

        for (int i = 0; i < key.length(); i++) 
        { 
            int index = key[i] - 'a'; 
            if (!pCrawl->children[index]) 
                pCrawl->children[index] = getNode(); 

            pCrawl = pCrawl->children[index]; 
        } 

        // mark last node as leaf 
        pCrawl->isEndOfWord = true; 
    } 

    // Returns true if key presents in trie, else 
    // false 
    bool search(struct TrieNode *root, string key) 
    { 
        struct TrieNode *pCrawl = root; 

        for (int i = 0; i < key.length(); i++) 
        { 
            int index = key[i] - 'a'; 
            if (!pCrawl->children[index]) 
                return false; 

            pCrawl = pCrawl->children[index]; 
        } 

        return (pCrawl != NULL && pCrawl->isEndOfWord); 
    } 
    ///////
    
    
    //start of the program
    string ans="";
    
    void dfs(struct TrieNode *root, string key){
        //process node
        if(key.length()>ans.length())
            ans= key;
        
        //For every child of node
        for (int i = 0; i < ALPHABET_SIZE; i++) 
            if(root->children[i] != NULL && root->children[i]->isEndOfWord)
                dfs(root->children[i],key+char('a'+i)  );
        
         
    }
    
    string longestWord(vector<string>& words) {
        //build up a trie
        struct TrieNode *root = getNode(); 
        for(int i=0 ; i<words.size(); i++)
            insert(root,words[i]);
        
        //DFS
        dfs(root,"");
        cout<<ans<<endl;
        
        return ans;
    }
    
    
    
    
    
};