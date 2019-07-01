//https://leetcode-cn.com/problems/valid-anagram/
package main

import "fmt"

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	counter := make([]int, 26)
	for i := 0; i < len(s); i++ {
		counter[s[i] - 'a']++
		counter[t[i] - 'a']--
	}

	for i := 0; i < len(counter); i++ {
		if counter[i] != 0 {
			return false
		}
	}

	return true
}

func main() {
	s := "anagram"
	t := "nagaram"
	result := isAnagram(s, t)
	fmt.Print(result)
}