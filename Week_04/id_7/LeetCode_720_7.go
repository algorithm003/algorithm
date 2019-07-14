/*
 * @lc app=leetcode.cn id=720 lang=golang
 *
 * [720] 词典中最长的单词
 */
//  package main

//  import (
// 	 _ "fmt"
// 	 "log"
// 	 "sort"
// 	 _ "strings"
//  )
 
//  func main() {
// 	 log.Printf("hello")
 
// 	 worlds := []string{"w", "wo", "wor", "worl", "world"}
// 	 result := longestWord(worlds)
// 	 log.Println(result)
//  }
 
 func longestWord(words []string) string {
	 if len(words) == 0 {
		 return ""
	 } else if len(words) == 1 {
		 if len(words[0]) > 1 {
			 return ""
		 }
		 return words[0]
	 }
	 sort.Strings(words)
	 longest := ""
	 last := ""
	 set := make(map[string]int)
	 for i := range words {
		 if len(words[i]) == 1 {
			 if longest == "" {
				 longest = words[i]
			 }
			 last = words[i]
			 set[last] = 0
		 } else if words[i][0:len(words[i])-1] == last {
			 if len(words[i]) > len(longest) {
				 longest = words[i]
			 }
			 last = words[i]
			 set[last] = 0
		 } else if _, ok := set[words[i][0:len(words[i])-1]]; ok {
			 last = words[i]
			 set[last] = 0
		 }
	 }
	 return longest
 }
 

