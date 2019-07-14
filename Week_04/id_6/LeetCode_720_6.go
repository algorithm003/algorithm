package main

import (
	"fmt"
	"sort"
)

/**
时间复杂度：O(n)
空间复杂度：O(n)
 */
func longestWord(words []string) string {
	if len(words) == 0 {
		return ""
	}

	sort.Strings(words)
	// 初始化 m 存放"合格"的单词
	m := make(map[string]bool, len(words))

	res := words[0]

	for _, w := range words {
		n := len(w)
		if n == 1 {
			m[w] = true
		}else if m[w[:(n-1)]] {
			m[w] = true
			if n > len(res) {
				res = w
			}
		}
	}
	return res
}

func main()  {
	words := []string{"a", "banana", "app", "appl", "ap", "apply", "apple"}
	fmt.Println("结果是：", longestWord(words))
}
