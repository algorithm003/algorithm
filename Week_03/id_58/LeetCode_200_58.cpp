class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
		/*********************method11**************/
         if(grid.empty())
             return 0;
        
         int res = 0;
        
         int m = grid.size(), n = grid[0].size();
         vector<vector<bool>> visited(m, vector<bool>(n, false));
        
         for(int i = 0; i < m; i++)
             for(int j = 0; j < n; j++){
                 if(grid[i][j] == '1' && !visited[i][j]){
                     solve(grid, visited, i, j);
                     res++;
                 }
             }
        
         return res;  
     }
    
     void solve(vector<vector<char>> &grid, vector<vector<bool>> &visited, int i, int j){
         if(i < 0 || i >= grid.size())
             return;
         if(j < 0 || j >= grid[0].size())
             return;
         if(grid[i][j] != '1' || visited[i][j])
             return;
        
         visited[i][j] = true;
         solve(grid, visited, i + 1, j);
         solve(grid, visited, i - 1, j);
         solve(grid, visited, i, j - 1);
         solve(grid, visited, i, j + 1);
     }
    
    
     /*********************method12**************/ 
     int nx[4] = {1, -1, 0, 0}, ny[4] = {0, 0, -1, 1};
     void solve(vector<vector<char>> grid, vector<vector<bool>> &visited, int x, int y){
         visited[x][y] = true;
        
         int m = grid.size(), n = grid[0].size();
         for(int k = 0; k < 4; k++){
             int dx = x + nx[k];
             int dy = y + ny[k];
             if(dx >= 0 && dx < m && dy >= 0 && dy < n 
                && !visited[dx][dy] && grid[dx][dy] == '1')
                 solve(grid, visited, dx, dy);
         }
     }
    
      /*********************method2**************/ 
        if (grid.empty())
            return 0;
        
        int res = 0;
        vector<int> dirX{-1, 0, 1, 0}, dirY{0, 1, 0, -1};
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '0' || visited[i][j]) 
                    continue;
                
                queue<int> q{{i * n + j}};
                while (!q.empty()) {
                    int t = q.front(); q.pop();
                    for (int k = 0; k < 4; ++k) {
                        int x = t / n + dirX[k];
						int y = t % n + dirY[k];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0' || visited[x][y])
							continue;
                        visited[x][y] = true;
                        q.push(x * n + y);
                    }
                }
                ++res;
            }
        }
        return res;
    }
};