/*
 * @lc app=leetcode.cn id=242 lang=golang
 *
 * [242] 有效的字母异位词
 */

// package main

// import (
// 	"log"
// 	"reflect"
// )

// func main() {
// 	log.Printf("hello")
	
// 	result := isAnagram("anagram", "nagaram")
// 	log.Println(result)
// }

func isAnagram(s string, t string) bool {
	// for(int i = 0;)
		if len(s) != len(t) {
			return false
		}
		mark := map[rune]int{}
		for _, s1 := range s {
			mark[s1] += 1
		}
		for _, t1 := range t {
			_, ok := mark[t1]
			if !ok {
				return false
			} else {
				mark[t1] -= 1
			}
		}
		for _, v := range mark {
			if v != 0 {
				return false
			}
		}
		return true
}

