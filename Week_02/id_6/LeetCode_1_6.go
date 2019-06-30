package main

import "fmt"

/**
暴力法
时间复杂度：O(n^2)
空间复杂度：O(1)
*/
func twoSum(nums []int, target int) []int {
	for i := 0; i < len(nums); i++ {
		for j := i+1; j < len(nums); j++ {
			if nums[i] + nums[j] == target {
				return []int{i, j}
			}
		}
	}
	return nil
}

/**
借用一个map
时间负责度：O(n)
空间复杂度：O(n)
*/
func twoSum1(nums []int, target int) []int {
	// index 负责保存对应值得下标
	index := make(map[int]int, len(nums))
	for i, b := range nums {
		if j, ok := index[target-b]; ok {
			// ok 为 true ，说明在 i 之前存在 num[j] == a
			return []int{j, i}
		}
		index[b] = i
	}

	return nil
}

func main() {
	nums := []int{2, 7, 11, 15}
	target := 9
	fmt.Println("结果是：", twoSum(nums, target))
	fmt.Println("结果是：", twoSum1(nums, target))
}
