package main

import "fmt"

/**
时间复杂度：O(n)
空间复杂度：O(1)
 */
func maxSubArray(nums []int) int {
	answer := nums[0]
	sum := 0
	for _, v := range nums{
		if sum > 0 {
			sum += v
		}else {
			// 如果 sum 小于 0 那还不如从当前位置开始计算
			sum = v
		}
		answer = maxInt(sum, answer)
	}
	return answer
}

func maxInt(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func main()  {
	fmt.Println("结果是：", maxSubArray([]int{-2,1,-3,4,-1,2,1,-5,4}))
}