//https://leetcode-cn.com/problems/two-sum/
package main

import "fmt"

func twoSum(nums []int, target int) []int {
	m := make(map[int]int, len(nums))
	for i := 0; i < len(nums); i++ {
		complement := target - nums[i]
		if  value, ok := m[complement]; ok {
			return []int {value, i}
		}
		m[nums[i]] = i
	}
	return []int {}
}

func main() {
	target := 9
	nums := []int {2, 7, 11, 15}
	result := twoSum(nums, target)
	fmt.Print(result)
}