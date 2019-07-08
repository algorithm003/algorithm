class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int num = 0;
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[0].size(); ++j) {
                if (grid[i][j] == '1') {
                    ++ num;
                    sweepIsland(grid, i, j);
                }
            }
        }
        return num;
    }
    
    void sweepIsland(vector<vector<char>> &grid, int i, int j) {
        if (i < 0 || i >= grid.size() || 
            j < 0 || j >= grid[0].size() || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        sweepIsland(grid, i+1, j);
        sweepIsland(grid, i-1, j);
        sweepIsland(grid, i, j+1);
        sweepIsland(grid, i, j-1);
    }
};
