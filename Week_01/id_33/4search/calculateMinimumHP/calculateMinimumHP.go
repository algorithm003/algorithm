package main

import (
	"fmt"
)

/**
174. 地下城游戏
*/

func calculateMinimumHP1(dungeon [][]int) int {
	xLen, yLen := len(dungeon)-1, len(dungeon[0])-1

	initHp := -int(^uint(0)>>1) - 1

	min := 0
	if dungeon[0][0] < 0 {
		min = dungeon[0][0]
	}
	var list [][]int
	list = append(list, []int{0, 0, dungeon[0][0], min})
	for len(list) > 0 {
		for length := len(list); length > 0; length-- {
			x, y, hp, min := list[0][0], list[0][1], list[0][2], list[0][3]
			list = list[1:]
			if x < xLen {
				hpTemp := hp + dungeon[x+1][y]
				minTemp := min
				if hpTemp < minTemp {
					minTemp = hpTemp
				}
				list = append(list, []int{x + 1, y, hpTemp, minTemp})
			}
			if y < yLen {
				hpTemp := hp + dungeon[x][y+1]
				minTemp := min
				if hpTemp < minTemp {
					minTemp = hpTemp
				}
				list = append(list, []int{x, y + 1, hpTemp, minTemp})
			}

			if x == xLen && y == yLen {
				if min > initHp {
					initHp = min
				}
			}
		}
	}

	return 1 - initHp
}

/**
关键是起点在哪里。这个问题要求我们在左上角找到最小的hp。
所以在最乐观的情况下，以右下角为起点，并且值为1
*/
func calculateMinimumHP(dungeon [][]int) int {
	nrow, ncol := len(dungeon), len(dungeon[0])
	row := make([]int, ncol+1)
	maxInt := int(^uint(0) >> 1)
	for k := range row {
		row[k] = maxInt
	}
	row[ncol-1] = 1
	for i := nrow - 1; i >= 0; i-- {
		for j := ncol - 1; j >= 0; j-- {
			t := min(row[j], row[j+1]) - dungeon[i][j]
			row[j] = max(t, 1)
		}
	}
	return row[0]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}

func main() {
	arr := [][]int{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}
	//arr := [][]int{{0, -3}}
	//arr := [][]int{{0}}
	fmt.Println(calculateMinimumHP(arr))
}
