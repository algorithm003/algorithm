/*
 * @lc app=leetcode.cn id=200 lang=golang
 *
 * [200] 岛屿数量
 */
//  import (
// 	_ "fmt"
// 	"log"
// 	_ "sort"
// 	_ "strings"
// )

// func main() {
// 	log.Printf("hello")
// 	grid := [][]byte{
// 		{'1', '1', '0', '0', '0'},
// 		{'1', '1', '0', '0', '0'},
// 		{'0', '0', '1', '0', '0'},
// 		{'0', '0', '0', '1', '1'},
// 	}
// 	result := numIslands(grid)
// 	log.Println(result)
// }

var dx = [4]int{-1, 0, 1, 0}
var dy = [4]int{0, -1, 0, 1}

func border(grid [][]byte, x, y int) bool {
	if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) {
		return true
	}
	if grid[x][y] == '0' {
		return true
	}
	return false
}

func dfs(grid [][]byte, x, y int) {
	if border(grid, x, y) {
		return
	}
	grid[x][y] = '0'
	for i := 0; i < 4; i++ {
		dfs(grid, x+dx[i], y+dy[i])
	}
}

func numIslands(grid [][]byte) int {
	cnt := 0
	log.Println(len(grid))
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			log.Println(grid[i][j], i, j)
			if grid[i][j] == '1' {
				dfs(grid, i, j)
				cnt++
			}
		}
	}
	return cnt
}


