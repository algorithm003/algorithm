package main

import "fmt"

/**
时间复杂度：O(n)
空间复杂度：O(1)
*/
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	sr := []rune(s)
	tr := []rune(t)

	// count 用来统计指定字母出现的次数
	count := make(map[rune]int, len(sr))

	for i := range s {
		count[sr[i]]++
		count[tr[i]]--
	}

	for _, v := range count {
		if v != 0 {
			return false
		}
	}
	return true
}

func main() {
	s, t := "anagram", "nagaram"
	fmt.Println("结果是：", isAnagram(s, t))
}
