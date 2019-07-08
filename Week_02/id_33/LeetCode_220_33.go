package main

import (
	"fmt"
	"math"
)

/**
220. 存在重复元素 III
*/

/**
暴力查找
判断 |i - j| <= k && |nums[i] - nums[j]| <= t
*/
//func containsNearbyAlmostDuplicate(nums []int, k int, t int) bool {
//	for i := 0; i < len(nums); i++ {
//		for j := i + 1; j < min(i+k+1, len(nums)); j++ {
//			if abs(nums[i]-nums[j]) <= t {
//				return true
//			}
//		}
//	}
//	return false
//}
//
//func abs(a int) int {
//	if a < 0 {
//		return -a
//	}
//	return a
//}
//
//func min(a, b int) int {
//	if a > b {
//		return b
//	}
//	return a
//}
//
//func max(a, b int) int {
//	if a > b {
//		return a
//	}
//	return b
//}

/**
构建大小区间为t+1的桶
那么查找范围在新值所在桶[-1, 1]
*/
func containsNearbyAlmostDuplicate(nums []int, k int, t int) bool {
	if k < 1 || t < 0 {
		return false
	}
	maps := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		// 偏移为正数
		remappedNum := nums[i] - math.MinInt32
		// 桶key值
		bucket := remappedNum / (t + 1)
		// 判断是否在3个桶中 (ps:go的map工具真的烂)
		if _, ok := maps[bucket]; ok {
			return true
		} else if v, ok := maps[bucket-1]; ok && remappedNum-v <= t {
			return true
		} else if v, ok := maps[bucket+1]; ok && v-remappedNum <= t {
			return true
		}
		// 移除超出范围的桶
		if len(maps) >= k {
			lastBucket := (nums[i-k] - math.MinInt32) / (t + 1)
			delete(maps, lastBucket)
		}
		// 更新桶
		maps[bucket] = remappedNum
	}
	return false
}
func main() {
	//fmt.Println(containsNearbyAlmostDuplicate([]int{1,5,99,1,5,9}, 2, 3))
	fmt.Println(containsNearbyAlmostDuplicate([]int{1, 5, 9, 1, 5, 9}, 2, 3))
}
