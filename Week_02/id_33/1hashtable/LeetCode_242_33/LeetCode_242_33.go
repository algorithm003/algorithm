package main

import "fmt"

/**
242. 有效的字母异位词
*/

/**
使用map
将第一个词的字母个数存入map
*/
func isAnagram1(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	var maps = make(map[rune]int)
	for _, char := range s {
		maps[char]++
	}
	for _, char := range t {
		v := maps[char]
		if v < 1 {
			// 判断是否存在函数
			return false
		} else if v == 1 {
			// 判断是否相等
			delete(maps, char)
		} else {
			maps[char]--
		}
	}
	// 判断个数
	return len(maps) == 0
}

/**
使用26个组成的数组
*/
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	arr := make([]int, 26)

	for _, char := range s {
		arr[char-'a']++
	}
	for _, char := range t {
		count := arr[char-'a']
		if count == 0 {
			return false
		} else {
			arr[char-'a']--
		}
	}

	for _, v := range arr {
		if v != 0 {
			return false
		}
	}
	return true
}

func main() {
	fmt.Println(isAnagram1("anagram", "nagaram"))
}
