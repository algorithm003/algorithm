/*
 * @lc app=leetcode.cn id=3 lang=golang
 *
 * [3] 无重复字符的最长子串
 */

//  package main

// import (
// 	"log"
// 	"strings"
// )

// func main() {
// 	log.Printf("hello")
	
// 	result := lengthOfLongestSubstring("abcabcbb")
// 	log.Println(result)
// }

func lengthOfLongestSubstring(s string) int {
	var subs string
	var count int
	if len(s) == 0 {
		return 0
	}
	subs = s[0:1]
	count = len(subs)
	var tempindex int
	for i := 2; i <= len(s); i++ {
		sub2 := s[i-1 : i]
		index := strings.LastIndex(subs, sub2)
		if index != -1 {
			tempindex = tempindex + index + 1
		}
		if tempindex < len(s) {
			subs = s[tempindex:i]
		}
		if count < len(subs) {
			count = len(subs)
		}
	}
	return count
}

