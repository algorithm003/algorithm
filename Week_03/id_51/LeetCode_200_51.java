class Solution {
    private static int[][] connected = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numIslands = 0; 
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    numIslands++;
                    gridDFS(grid, x, y);
                }
            }
        }
        return numIslands;
    }
    
    private void gridDFS(char[][] grid, int x, int y) {
        if (grid[x][y] == '0') {            
            return;
        }
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nextX = x + connected[i][0];
            int nextY = y + connected[i][1]; 
            if (withinGrid(grid, nextX, nextY)) {
                gridDFS(grid, nextX, nextY);    
            }            
        }
    }
    
    private boolean withinGrid(char[][] grid, int x, int y) {
        return x >=0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
