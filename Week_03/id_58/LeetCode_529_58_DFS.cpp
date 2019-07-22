class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
		/***************method1********************/
         if (board.empty()) 
             return {};
        
         int m = board.size(), n = board[0].size();
         int row = click[0], col = click[1];
         int cnt = 0;
        
         if (board[row][col] == 'M') {
             board[row][col] = 'X';
         } else {
             for (int i = -1; i < 2; ++i) {
                 for (int j = -1; j < 2; ++j) {
                     int x = row + i, y = col + j;
                     if (x < 0 || x >= m || y < 0 || y >= n) continue;
                     if (board[x][y] == 'M') ++cnt;
                 }
             }
             if (cnt > 0) {
                 board[row][col] = cnt + '0';
             } else {
                 board[row][col] = 'B';
                 for (int i = -1; i < 2; ++i) {
                     for (int j = -1; j < 2; ++j) {
                         int x = row + i, y = col + j;
                         if (x < 0 || x >= m || y < 0 || y >= n) continue;
                         if (board[x][y] == 'E') {
                             vector<int> nextPos{x, y};
                             updateBoard(board, nextPos);
                         }
                     }
                 }
             }
         }
         return board;
     }
        
        /***************method2********************/
         if (board.empty())
			 return {};

         int m = board.size(), n = board[0].size();
		 int row = click[0], col = click[1];
		 int cnt = 0;
         if (board[row][col] == 'M') {
             board[row][col] = 'X';
         } else {
             vector<vector<int>> neighbors;
             for (int i = -1; i < 2; ++i) {
                 for (int j = -1; j < 2; ++j) {
                     int x = row + i, y = col + j;
                     if (x < 0 || x >= m || y < 0 || y >= n) 
						 continue;
                     if (board[x][y] == 'M')
						 ++cnt;
                     else if (cnt == 0 && board[x][y] == 'E') 
						 neighbors.push_back({x, y});
                 }
             }
             if (cnt > 0) {
                 board[row][col] = cnt + '0';
             } else {
                 for (auto a : neighbors) {
                     board[a[0]][a[1]] = 'B';
                     updateBoard(board, a);
                 }
             }
         }
         return board;
     }
};