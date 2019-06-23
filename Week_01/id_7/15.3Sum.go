/*
 * @lc app=leetcode.cn id=15 lang=golang
 *
 * [15] 三数之和
 */

//  package main

// import (
// 	"log"
// 	"sort"
// )

// func main() {
// 	log.Printf("hello")
// 	nums := []int{-1, 0, 1, 2, -1, -4}
// 	result := threeSum(nums)
// 	log.Println(result)
// }
func threeSum(nums []int) [][]int {
	sort.Slice(nums, func(i, j int) bool {
        return nums[i] < nums[j]
    })
    
    out := make([][]int, 0)
    for i := 0; i < len(nums) - 1; i++ {
        if i != 0 && nums[i] == nums[i-1] {
            continue
        }
        
        l := i + 1
        r := len(nums) - 1
        
        target := -nums[i]
        for l < r {
            n := nums[l] + nums[r]
            if n == target {
                out = append(out, []int{nums[i], nums[l], nums[r]})
                l++
                r--
                for l < len(nums) && nums[l] == nums[l-1] {
                    l++
                }
                for r > 0 && nums[r] == nums[r+1] {
                    r--
                }
            } else if n < target {
                l++
            } else {
                r--
            }
        }
    }
    return out
}

