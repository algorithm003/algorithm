/**
 * 200. Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

 *
 */




char** creategrid(int gridSize, int* gridColSize){
    char** grid;
    int i, j;
    if ( gridSize <= 0 ) return NULL;
    grid = malloc(gridSize*sizeof(char*));

    for(i=0; i<gridSize; i++) {
        if ( gridColSize[i] > 0)
            grid[i] = malloc(gridColSize[i]*sizeof(char));
        else
            grid[i] = NULL;
    }
    for(i=0; i<gridSize; i++)
        for(j=0; j<gridColSize[i]; j++)
            grid[i][j] = '0';

    return grid;
}



int visit(char** grid, char** visited, int gridSize, int* gridColSize, int i, int j) {
    if (  grid[i][j] == '0' || visited[i][j] == '1' ) return 0;

    visited[i][j] = '1';

    // visit left
    if (j-1 >= 0 && grid[i][j-1] == '1' && visited[i][j-1] == '0')
        visit(grid, visited, gridSize, gridColSize, i, j-1);

    // visit down
    if (i+1 < gridSize && grid[i+1][j] == '1' && visited[i+1][j] == '0')
        visit(grid, visited, gridSize, gridColSize, i+1, j);

    // visit right
    if (j+1 < gridColSize[i] && grid[i][j+1] == '1' && visited[i][j+1] == '0')
        visit(grid, visited, gridSize, gridColSize, i, j+1);

    // visit up
    if (i-1 >= 0 && grid[i-1][j] == '1' && visited[i-1][j] == '0')
        visit(grid, visited, gridSize, gridColSize, i-1, j);

    return 1;
}


int numIslands(char** grid, int gridSize, int* gridColSize){
    char** visited = creategrid(gridSize, gridColSize);
    int i, j, islands;

    if ( ! grid || gridSize <= 0 ) return 0;

    for(i=0, islands=0; i<gridSize; i++)
        for(j=0; j<gridColSize[i]; j++)
            islands += visit(grid, visited, gridSize, gridColSize, i, j);

    return islands;
}

