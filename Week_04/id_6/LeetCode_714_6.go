package main

import "fmt"

/**
时间复杂度：O(n)
空间复杂度：O(1)
 */
func maxProfit(prices []int, fee int) int {
	empty := 0 // 不持有股票时最大利润
	hold := -prices[0] // 持有股票最大利润

	for i := 1; i < len(prices); i++ {
		empty = max(empty, hold + prices[i] - fee)
		hold = max(hold, empty - prices[i])
	}
	return empty
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func main()  {
	fmt.Println("结果是：", maxProfit([]int{1, 3, 2, 8, 4, 9}, 2))
}