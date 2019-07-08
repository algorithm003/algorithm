//+build ignore

package main

import "fmt"

/**
200. 岛屿数量
*/

/**
每次遇到'1',向上下左右四个方向一直查找'1'，并将'1'置'0'，遇到0和边界返回
*/
func numIslands(grid [][]byte) int {
	count := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				count++
				dfs(grid, i, j)
			}
		}
	}
	return count
}

func dfs(grid [][]byte, x, y int) {
	if x >= 0 && x < len(grid) && y >= 0 && y < len(grid[0]) && grid[x][y] == '1' {
		grid[x][y] = '0'
		dfs(grid, x-1, y)
		dfs(grid, x+1, y)
		dfs(grid, x, y-1)
		dfs(grid, x, y+1)
	}
}

func main() {
	fmt.Println(numIslands([][]byte{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}))
}
