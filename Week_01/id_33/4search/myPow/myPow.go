package main

import "fmt"

/**
50. Pow(x, n)
*/

func myPow(x float64, n int) float64 {
	if n == 0 {
		// 0特殊处理
		return 1
	} else if n < 0 {
		// 负特殊处理，倒数的-n次方
		return 1 / myPow(x, -n)
	} else if n&1 == 1 {
		// 奇数， x * (x*x)^((n-1)/2) -> x * (x*x)^(n/2)
		return x * myPow(x*x, n/2)
	} else {
		// 偶数， (x*x)^(n/2)
		return myPow(x*x, n/2)
	}
}

func main() {
	fmt.Println(myPow(2, 10))
}
