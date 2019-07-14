package main

import "fmt"

/**
暴力法
时间复杂度：O(m*n)
空间复杂度：O(1)
 */
func searchMatrix(matrix [][]int, target int) bool {
	for _, v := range matrix {
		for _, vv := range v {
			if vv == target {
				return true
			}
		}
	}
	return false
}


/**
暴力法 优化版 （利用矩阵  左到右升序  上到下 升序 的特性）
空间复杂度：O(1)
*/
func searchMatrix1(matrix [][]int, target int) bool {
	m := len(matrix)
	if m == 0 {
		return false
	}
	n := len(matrix[0])
	if n == 0 {
		return false
	}

	i, j := m-1, 0
	for i >= 0 && j < n  {
		if matrix[i][j] == target {
			return true
		}
		if matrix[i][j] > target {
			// 排除 右侧元素，往上找
			i--
		}else {
			// 继续往右找
			j++
		}
	}

	return false
}


func main()  {
	//matrix := [][]int{
	//	{1,   4,  7, 11, 15},
	//	{2,   5,  8, 12, 19},
	//	{3,   6,  9, 16, 22},
	//	{10, 13, 14, 17, 24},
	//	{18, 21, 23, 26, 30},
	//}

	matrix := [][]int{
		{5},
		{6},
	}
	fmt.Println("结果是：", searchMatrix(matrix, 5))
	fmt.Println("结果是：", searchMatrix1(matrix, 5))
}