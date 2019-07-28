class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<int> pos(n, -1);
        solve(res, pos, 0);
        
        return res;    
    }
    
    void solve(vector<vector<string>> &res, vector<int> pos, int row){
        int n = pos.size();
        if(row == n){
            vector<string> cur(n, string(n, '.'));
            for(int i = 0; i < n; i++)
                cur[i][pos[i]] = 'Q';
            
            res.push_back(cur);
        }else{
            for(int col = 0; col < n; col++){
                if(isValid(pos, row, col)){
                    pos[row] = col;
                    solve(res, pos, row + 1);
                    pos[row] = -1;
                }
            }
        }
    }
    
    bool isValid(vector<int> pos, int row, int col){
        for(int i = 0; i < row; i++)
            if(col == pos[i] || abs(i - row) == abs(pos[i] - col))
                return false;
        return true;
    }
};