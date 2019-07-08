/*
 * @lc app=leetcode.cn id=703 lang=golang
 *
 * [703] 数据流中的第K大元素
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
// 	 k := 3
// 	 arr := []int{4, 5, 8, 2}
// 	 obj := Constructor(k, arr)
// 	 //	log.Println(obj)
// 	 //	param_1 := obj.Add(4)
// 	 log.Println(obj.Add(3))
// 	 log.Println(obj.Add(5))
// 	 log.Println(obj.Add(10))
// 	 log.Println(obj.Add(9))
// 	 log.Println(obj.Add(4))
 
// 	 //	log.Println(obj)
// 	 //	log.Println(param_1)
//  }
 
//  type KthLargest struct {
// 	 k    int
// 	 nums []int
//  }
 
//  func Constructor(k int, nums []int) KthLargest {
// 	 var obj KthLargest
// 	 obj.k = k
// 	 obj.nums = nums
// 	 return obj
//  }
 
//  func (this *KthLargest) Add(val int) int {
// 	 this.nums = append(this.nums, val)
// 	 sort.Sort(sort.Reverse(sort.IntSlice(this.nums)))
// 	 return this.nums[this.k-1]
//  }
 
type KthLargest struct {
	k    int
	nums []int
}

func Constructor(k int, nums []int) KthLargest {
	var obj KthLargest
	obj.k = k
	sort.Sort(sort.Reverse(sort.IntSlice(nums)))
	obj.nums = nums
	return obj
}

func (this *KthLargest) Add(val int) int {
	if len(this.nums) == 0 || len(this.nums) == 1 || len(this.nums) == 2 {
		this.nums = append(this.nums, val)
		sort.Sort(sort.Reverse(sort.IntSlice(this.nums)))
	} else {
		for index := 0; index < len(this.nums); index++ {
			if val > this.nums[index] {
				rear := append([]int{}, this.nums[index:]...)
				this.nums = append(this.nums[0:index], val)
				this.nums = append(this.nums, rear...)
				break
			}
		}
	}
	//	sort.Sort(sort.Reverse(sort.IntSlice(this.nums)))
	return this.nums[this.k-1]
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * obj := Constructor(k, nums);
 * param_1 := obj.Add(val);
 */

