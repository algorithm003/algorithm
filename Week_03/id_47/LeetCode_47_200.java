class Solution {
    public int numIslands(char[][] grid) {
        
        int iNumIslands = 0;
        for(int i = 0 ; i < grid.length; i++)
            for(int j = 0 ; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    iNumIslands++;
                    checkIslandArround(grid, i, j);
                }
            }
        return iNumIslands;
    }
    
    /**
     * recursion to fill the island's arrond box
     * @param grid
     * @param i
     * @param j
     */
    private void checkIslandArround(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if(i>0) {
            if(grid[i-1][j] == '1') {
                checkIslandArround(grid, i-1, j);
            }
        }
        
        if(j>0) {
            if(grid[i][j-1] == '1') {
                checkIslandArround(grid, i, j-1);
            }   
        }
        
        if(i<grid.length-1) {
             if(grid[i+1][j] == '1') {
                 checkIslandArround(grid, i+1, j);
             }
        }
        
        if(j<grid[i].length -1) {
            if(grid[i][j+1] == '1') {
                checkIslandArround(grid, i, j+1);
            }
        }
    }
}