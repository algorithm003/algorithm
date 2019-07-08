//+build ignore

package main

import "fmt"

/**
26. 删除排序数组中的重复项
*/

func removeDuplicates(nums []int) int {
	// 当前最大数下标
	len := len(nums)
	if len < 2 {
		return len
	}
	pre := 0
	for i := 1; i < len; i++ {
		// 每当出现大于下标值的数，下标移动
		if nums[i] > nums[pre] {
			pre++
			nums[pre] = nums[i]
		}
	}
	return pre + 1
}

func main() {
	//nums := []int{1,1,2}
	nums := []int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	fmt.Println(removeDuplicates(nums))
}
