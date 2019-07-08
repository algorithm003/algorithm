func numIslands(grid [][]byte) int {
    
    visited := make([][]bool, len(grid))
    for i := range visited {
        visited[i] = make([]bool, len(grid[0]))
    }
    
    res := 0
    for i := range grid {
        for j := range grid[i] {
            if grid[i][j] == '1' && !visited[i][j] {
                dfs(grid, i, j, visited)
                res++
            }
        }
    }
    
    return res
}

func dfs(grid [][]byte, i, j int, visited [][]bool) {
    
    if i < 0 || i+1 > len(grid) || j < 0 || j+1 > len(grid[0]) || grid[i][j] == '0'{
        return 
    }
    
    x := [4]int{-1, 1, 0, 0}
    y := [4]int{0, 0, -1, 1}
    
    if !visited[i][j] {
        visited[i][j] = true
        for k := 0; k < 4; k++ {
            dfs(grid, i+x[k], j+y[k], visited)
        }
    }
}
