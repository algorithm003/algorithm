/*
 * @lc app=leetcode.cn id=26 lang=golang
 *
 * [26] 删除排序数组中的重复项
 */

// package main

// import (
// 	"log"
// )

// func main() {
// 	log.Printf("hello")
// 	nums := []int{1, 1, 2}
// 	i := removeDuplicates(nums)
// 	log.Printf(i)
// }
func removeDuplicates(nums []int) int {
	var str int
	for i := 0; i < len(nums); {
		if str != nums[i] || i == 0 {
			str = nums[i]
			i++
		} else {
			nums = append(nums[:i], nums[i+1:]...)
		}
	}
	return len(nums)
}

