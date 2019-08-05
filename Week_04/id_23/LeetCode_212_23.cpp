struct Trie {
    Trie():chs({0}) {
    }
    Trie* chs[26];
    string word;
};

class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        Trie* root = buildTrie(words);
        vector<string> res;
        for (int i = 0; i < board.size(); ++i)
            for (int j = 0; j < board[0].size(); ++j)
                dfs(board, i, j, root, res);
        return res;
    }
    
    Trie* buildTrie(vector<string> &words) {
        Trie *root = new Trie;
        for (auto &word : words) {
            Trie *p = root;
            for (auto &ch : word) {
                int i = ch-'a';
                if (NULL == p->chs[i])
                    p->chs[i] = new Trie;
                p = p->chs[i];
            }
            p->word = word;
        }
        return root;
    }
    
    void dfs(vector<vector<char>> &board, int i, int j, Trie* root, vector<string> &res) {
        char ch = board[i][j];
        if (board[i][j] == '#' || !root->chs[ch-'a'])
            return;
        root = root->chs[ch-'a'];
        if (!root->word.empty()) {
            res.push_back(root->word);
            root->word = "";
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i-1, j, root, res);
        if (j > 0) dfs(board, i, j-1, root, res);
        if (i < board.size()-1) dfs(board, i+1, j, root, res);
        if (j < board[0].size()-1) dfs(board, i, j+1, root, res);
        board[i][j] = ch;
    }
};
