//+build ignores

package main

import "fmt"

/**
1. 两数之和
*/

/**
一次遍历，遍历的同时将元素插入map
*/
func twoSum(nums []int, target int) []int {
	numMap := make(map[int]int, len(nums))
	for k, v := range nums {
		if val, ok := numMap[target-v]; ok {
			return []int{val, k}
		}
		numMap[v] = k
	}
	return nil
}

func main() {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
}
