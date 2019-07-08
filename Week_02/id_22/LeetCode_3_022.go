//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
package main

import (
	"fmt"
)

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func lengthOfLongestSubstring(s string) int {
	i, j, result := 0, 0, 0
	set := make(map[uint8]int)
	for ; j < len(s); j++ {
		if value, ok := set[s[j]]; ok {
			i = max(value, i)
		}
		result = max(result, j - i + 1)
		set[s[j]] = j + 1
	}
	return result
}

func main() {
	s := "abcdefaghjxyz"
	result := lengthOfLongestSubstring(s)
	fmt.Print(result)
}