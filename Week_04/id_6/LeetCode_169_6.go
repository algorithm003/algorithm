package main

import "fmt"

/**
暴力法
时间复杂度：O(n^2)
空间复杂度：O(1)
 */
func majorityElement(nums []int) int {
	majorityCount := len(nums)/2
	for _, v := range nums {
		count := 0
		for _, num := range nums {
			if v == num {
				count++
			}
		}
		if count > majorityCount {
			return v
		}
	}
	return -1
}

/**
哈希表
时间复杂度：O(n)
空间复杂度：O(n)
 */
func majorityElement1(nums []int) int {
	majorityCount := len(nums)/2
	m := make(map[int]int, len(nums))
	for _, num := range nums {
		if _, ok := m[num]; ok {
			m[num]++
		}else {
			m[num] = 1
		}
	}
	for k := range m {
		if m[k] > majorityCount {
			return k
		}
	}
	return -1
}

/**
Boyer-Moore 投票算法 (当不存在众数的时候此方法不适合)
时间复杂度：O(n)
空间复杂度：O(1)
*/
func majorityElement2(nums []int) int {
	count := 0
	var candidate int

	for _, num := range nums {
		if count == 0 {
			candidate = num
		}
		if num == candidate {
			count += 1
		}else {
			count -= 1
		}
	}
	return candidate
}

func main()  {
	nums := []int{3,2,3}
	fmt.Println("结果是：", majorityElement(nums))

	nums1 := []int{3,2,3}
	fmt.Println("结果是：", majorityElement1(nums1))

	nums2 := []int{3,2,3}
	fmt.Println("结果是：", majorityElement2(nums2))
}