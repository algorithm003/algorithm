//+build ignore

package main

import (
	"fmt"
	"math"
)

/**
441. 排列硬币
*/

/**
暴力
*/
func arrangeCoins1(n int) int {
	i := 1
	for n >= i {
		n = n - i
		i++
	}
	return i - 1
}

/**
公式 sum = (x + 1) * x / 2 -> x = (-1 + sqrt(8 * n + 1)) / 2
*/
func arrangeCoins(n int) int {
	return int(-1+math.Sqrt(float64(1+8*n))) / 2
}

func main() {
	fmt.Println(arrangeCoins(5))
}
