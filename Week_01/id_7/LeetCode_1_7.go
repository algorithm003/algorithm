/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */



// package main

// import (
// 	"log"
// )

// func main() {
// 	log.Printf("hello")
// 	nums := []int{2, 7, 11, 15}
// 	twoSum(nums, 9)
// 	// log.Printf(result)
// }
func twoSum(nums []int, target int) []int {
    for i := 0; i < len(nums); i++ {
		for j := i +1; j < len(nums); j++ {
			tempTarget := nums[i] + nums[j]
			if tempTarget == target {
				return []int{i, j}
			}
		}
	}
    return nil
}

