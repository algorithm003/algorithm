package main

import (
	"container/list"
	"fmt"
)

/**
42. 接雨水
*/

/**
从左向右，小值压入栈，大值弹出，当栈为0时，累计一次
循环完毕处理剩余数据
*/
func trap1(height []int) int {
	area1, area2 := 0, 0
	list := list.New()
	for k, v := range height {
		area2 += v
		if list.Len() == 0 || v <= height[list.Front().Value.(int)] {
			list.PushFront(k)
		} else {
			left := 0
			for list.Len() > 0 && v > height[list.Front().Value.(int)] {
				left = list.Remove(list.Front()).(int)
			}
			if list.Len() == 0 {
				area1 += (k - left) * height[left]
			}
			list.PushFront(k)
		}
	}

	indexOld := -1
	for list.Len() > 0 {
		index := list.Remove(list.Front()).(int)
		if indexOld == -1 {
		} else {
			area1 += (indexOld - index) * height[indexOld]
		}
		indexOld = index
	}

	if indexOld != -1 {
		area1 += height[indexOld]
	}

	return area1 - area2
}

/**
两边逼近
每当当前值小于极大值，加上差值，否则赋值极大值
*/
func trap(height []int) int {
	left, right, leftMax, rightMax, area := 0, len(height)-1, 0, 0, 0
	for left <= right {
		if height[left] < height[right] {
			if height[left] >= leftMax {
				leftMax = height[left]
			} else {
				area += leftMax - height[left]
			}
			left++
		} else {
			if height[right] >= rightMax {
				rightMax = height[right]
			} else {
				area += rightMax - height[right]
			}
			right--

		}
	}

	return area
}

func main() {
	fmt.Println(trap([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
}
