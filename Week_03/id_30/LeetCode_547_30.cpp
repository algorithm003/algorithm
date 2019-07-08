class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        int row = M.size();
        if (row == 0) {
            return 0;
        }
        int ans = 0;
        int column = M[0].size();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (M[i][j] == 1) {
                    Marking(M, i, j);
                }
                ans++;
            }
        }
        return ans;
    }
    
    void Marking(vector<vector<int>>& M, int i, int j) {
        if (i < 0 || j < 0 || i >= M.size() || j >= M[0].size()) {
            return;
        }
        M[i][j] = 0;
        Marking(M, i+1, j);
        Marking(M, i-1, j);
        Marking(M, i, j-1);
        Marking(M, i, j+1);
    }
};