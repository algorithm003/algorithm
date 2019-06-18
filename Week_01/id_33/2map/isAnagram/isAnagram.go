package main

import "fmt"

/**
242. 有效的字母异位词
*/

/**
存入前一个字母的个数
*/
func isAnagram(s string, t string) bool {
	maps := make(map[rune]int)

	for _, char := range s {
		maps[char] = maps[char] + 1
	}

	for _, char := range t {
		value := maps[char] - 1
		switch {
		case value == 0:
			delete(maps, char)
		case value < 0:
			return false
		default:
			maps[char] = value
		}
	}
	return len(maps) == 0
}

func main() {
	fmt.Println(isAnagram("anagram",
		"nagaram"))
}
