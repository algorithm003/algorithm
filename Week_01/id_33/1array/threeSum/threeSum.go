package main

import (
	"fmt"
	"sort"
)

/**
排序后，先取a值，通过从两边逼近去b,c
*/
func threeSum(nums []int) [][]int {
	var results [][]int
	n := len(nums)
	if n < 3 {
		return results
	}
	// 排序后防止重复
	sort.Ints(nums)
	for i := 0; i < n-2; i++ {
		a := nums[i]
		if i > 0 && nums[i-1] == a {
			continue
		}
		left := i + 1
		right := n - 1
		for left < right {
			b := nums[left]
			c := nums[right]
			if a+b+c == 0 {
				results = append(results, []int{a, b, c})
				left++
				right--
				for left < right && nums[left] == nums[left-1] {
					left++
				}
				for left < right && nums[right] == nums[right+1] {
					right--
				}
			} else if a+b+c < 0 {
				left++
			} else {
				right--
			}
		}
	}
	return results
}

func main() {
	//nums := []int{-1, 0, 1, 2, -1, -4}
	nums := []int{0, 0, 0, 0}
	fmt.Println(threeSum(nums))
}
