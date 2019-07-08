class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        if (board[click[0]][click[1]] == 'E') {
            dfs(board, click[0], click[1]);
        }
        return board;
    }
    
    void dfs(vector<vector<char>> &board, int i, int j) {
        int mineCount = 0;
        for (auto &dir: dirs) {
            int ii = i + dir[0]; int jj = j + dir[1];
            if (isValidCoord(ii, jj, board) && board[ii][jj] == 'M') {
                ++ mineCount;
            }
        }
        
        if (mineCount > 0) {
            board[i][j] = '0' + mineCount;
            return;
        }
        
        board[i][j] = 'B';
        for (auto &dir: dirs) {
            int ii = i + dir[0]; int jj = j + dir[1];
            if (isValidCoord(ii, jj, board) && board[ii][jj] == 'E') {
                dfs(board, ii, jj);
            }
        }
    }
    
    bool isValidCoord(int i, int j, vector<vector<char>> &board) {
        return (i >= 0 && i < board.size() && j >= 0 && j < board[0].size());
    }
    
    vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
};
