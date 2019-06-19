package main

import (
	"container/list"
	"fmt"
)

/**
84. 柱状图中最大的矩形
*/

/**
1. 栈底最小，栈顶最大，
2  若新元素小于栈顶，记录当前位置，依次出栈，高度为原栈顶，长度为当前-原栈顶前一个-1
*/
func largestRectangleArea(heights []int) int {
	length := len(heights)
	list := list.New()
	maxArea := 0
	for i := 0; i <= length; i++ {
		h := 0
		if i != length {
			h = heights[i]
		}
		if list.Len() == 0 || h >= heights[list.Front().Value.(int)] {
			list.PushFront(i)
		} else {
			top := list.Remove(list.Front()).(int)
			var l int
			if list.Len() == 0 {
				l = i
			} else {
				l = i - list.Front().Value.(int) - 1
			}
			maxArea = max(maxArea, heights[top]*l)
			i--
		}
	}
	return maxArea
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	//fmt.Println(largestRectangleArea([]int{2, 1, 5, 6, 2, 3}))
	fmt.Println(largestRectangleArea([]int{4, 2, 0, 3, 2, 5}))
}
