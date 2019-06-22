package main

import "fmt"

/**
88. 合并两个有序数组
*/

/**
从后开始放置
*/
func merge(nums1 []int, m int, nums2 []int, n int) {
	i1, i2, i := m-1, n-1, m+n-1
	for i1 >= 0 && i2 >= 0 {
		if nums2[i2] > nums1[i1] {
			nums1[i] = nums2[i2]
			i2--
		} else {
			nums1[i] = nums1[i1]
			i1--
		}
		i--
	}
	// i2存在剩余更小的，
	for i2 >= 0 {
		nums1[i] = nums2[i2]
		i--
		i2--
	}
}

func main() {
	nums1, nums2 := []int{1, 2, 3, 0, 0, 0}, []int{2, 5, 6}
	m, n := 3, 3
	merge(nums1, m, nums2, n)
	fmt.Println(nums1)
}
