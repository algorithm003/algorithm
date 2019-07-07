//+build ignore

package main

import "fmt"

/**
210. 课程表 II
*/

/**
构造环，从底层进行开始进行搜索
*/
func findOrder(numCourses int, prerequisites [][]int) []int {
	// 结果
	result := make([]int, 0, numCourses)
	// 学习的前置数量, 全部初始化为0
	inCountMap := make([]int, numCourses)
	// 环，从底层指向高层
	graph := make(map[int][]int)
	// 初始化
	for _, arr := range prerequisites {
		from, to := arr[1], arr[0]
		inCountMap[to]++
		graph[from] = append(graph[from], to)
	}
	// 放入最底层
	for k, v := range inCountMap {
		if v == 0 {
			result = append(result, k)
		}
	}
	for i := 0; i < numCourses; i++ {
		// i + 1 > len(result) -> i >= len(result)
		// 当结果小于已遍历的个数，有环
		if i >= len(result) {
			return []int{}
		}
		course := result[i]
		nextCourses := graph[course]
		for _, v := range nextCourses {
			inCountMap[v]--
			// 前置条件已经学完
			if inCountMap[v] == 0 {
				result = append(result, v)
			}
		}

	}
	return result
}

func main() {
	fmt.Println(findOrder(4, [][]int{{1, 0}, {2, 0}, {3, 1}, {3, 2}}))
	fmt.Println(findOrder(2, [][]int{{1, 0}}))
}
