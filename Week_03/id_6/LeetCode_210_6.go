package main

import "fmt"

func findOrder(numCourses int, prerequisites [][]int) []int {
	next, pre := build(numCourses, prerequisites)
	return search(next, pre)
}

func search(next [][]int, pre []int) []int {
	n := len(pre)
	res := make([]int, n)
	var i, j int
	// 第 i 个完成的课程的代号是 j
	for i = 0; i < n; i++ {
		// 完成首先遇到的，先修课程为 0 的课程
		for j = 0; j < n; j++ {
			if pre[j] == 0 {
				break
			}
		}
		// 每个课程都需要先修课
		// 出现了环路
		if j == n {
			return nil
		}

		// 修改 pres[j] 为负数
		// 避免重修
		pre[j] = -1

		// 完成 j 课程后
		// j 的后续课程的，先修课程数量都可以 -1
		for _, c := range next[j] {
			pre[c]--
		}

		// 把课程代号放入答案
		res[i] = j
	}

	return res
}

/**
构造出 课程 i 的先修课 next，课程 i 的先修课的个数 pre
*/
func build(numCourses int, prerequisites [][]int) (next [][]int, pre []int) {
	// next[i][j] : i -> next[i]... ，i 是 next[i] 的先修课
	next = make([][]int, numCourses)
	// pres[i] : i 的先修课程的"个数"
	pre = make([]int, numCourses)

	for _, r := range prerequisites {
		next[r[1]] = append(next[r[1]], r[0])
		pre[r[0]]++
	}
	return
}

func main()  {
	numCourses := 4
	prerequisites := [][]int{
		[]int{1,0},
		[]int{2,0},
		[]int{3,1},
		[]int{3,2},
	}
	fmt.Println("结果是：", findOrder(numCourses, prerequisites))
}
