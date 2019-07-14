/*
 * @lc app=leetcode.cn id=70 lang=golang
 *
 * [70] 爬楼梯
 */
//  package main

//  import (
// 	 _ "fmt"
// 	 "log"
// 	 _ "sort"
// 	 _ "strings"
//  )
 
//  func main() {
// 	 log.Printf("hello")
 
// 	 result := climbStairs(10)
 
// 	 log.Println(result)
//  }
 func climbStairs(n int) int {
	 switch n {
	 case 1:
		 return 1
	 case 2:
		 return 2
	 default:
		 dp1, dp2 := 1, 2
		 for i := 2; i < n; i++ {
			 dp1, dp2 = dp2, dp1+dp2
		 }
		 return dp2
	 }
 }



