class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        if (M.empty()) return 0;
        int n = M.size(), res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    res++;
                    _dfs(M, i, j);
                }
            }
        }
        return res;
    }
    
    void _dfs(vector<vector<int>>& M, int l, int c) {
        M[l][c] = 0, M[c][l] = 0;
        int n = M.size();
        for (int i = 0; i < n; i++) {
            if (M[c][i] == 1 && c != i) _dfs(M, c, i);
            if (l != i) M[c][i] = 0;
        }
    }
};