//+build ignore

package main

import "fmt"

/**
189. 旋转数组
*/

/**
全体右移三次
*/
func rotate1(nums []int, k int) {
	len := len(nums)
	//lenLimit := len - k%len
	k %= len
	for i := 0; i < k; i++ {
		temp := nums[0]
		for j := 1; j < len; j++ {
			temp, nums[j] = nums[j], temp
		}
		nums[0] = temp
	}
}

/**
创建一个新切片，复制
*/
func rotate(nums []int, k int) {
	//k %= len(nums)
	//copy(nums, append(nums[len(nums) - k:], nums[:len(nums) - k]...))
	lenth := len(nums)
	k %= lenth
	index := lenth - k
	copy(nums, append(nums[index:], nums[:index]...))
}

/**
题库最佳解，三次翻转
*/
func rotate2(nums []int, k int) {
	lenth := len(nums)
	k %= lenth
	reverse(nums, 0, lenth-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, lenth-1)
}

func reverse(nums []int, start int, end int) {
	for start < end {
		nums[start], nums[end] = nums[end], nums[start]
		start++
		end--
	}
}

func main() {
	nums := []int{1, 2, 3, 4, 5, 6}
	k := 2
	rotate(nums, k)
	fmt.Println(nums)
}
