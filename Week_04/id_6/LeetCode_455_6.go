package main

import (
	"fmt"
	"sort"
)

func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)

	var i, j, res int
	for i < len(g) && j < len(s)  {
		if s[j] >= g[i] {
			i++
			res++
		}
		j++
	}
	return res
}

func main()  {
	fmt.Println("结果是：", findContentChildren([]int{1,2,3}, []int{1,1}))
}