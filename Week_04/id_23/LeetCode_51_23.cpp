class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        size = (1 << n) - 1;
        vector<string> v(n, string(n, '.'));
        vector<vector<string>> res;
        dfs(0, 0, 0, 0, n, v, res);
        return res;
    }
    
    void dfs(int c, int l, int r, int k, int n, vector<string> &v, vector<vector<string>> &res) {
        if (k == n) {
            res.push_back(v);
            return;
        }
        
        int pos = size & ~(c|l|r);
        while (pos != 0) {
            int m = pos & (-pos);
            pos &= (pos-1);
            int p = getpos(m);
            v[k][p] = 'Q';
            dfs(c|m, (l|m)<<1, (r|m)>>1, k+1, n, v, res);
            v[k][p] = '.';
        }
    }
    
    int getpos(int v) {
        int count = 0;
        while (v != 1) {
            v >>= 1;
            ++ count;
        }
        return count;
    }
    
    int size;
};
