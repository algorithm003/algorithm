/*
 * @lc app=leetcode.cn id=692 lang=golang
 *
 * [692] 前K个高频单词
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
 
// 	 //	result := lengthOfLongestSubstring("ab")
 
// 	 //["i", "love", "leetcode", "i", "love", "coding"] K = 2
// 	 words := []string{"i", "love", "leetcode", "i", "love", "coding"}
// 	 result := topKFrequent(words, 2)
// 	 log.Println(result)
//  }
 
func topKFrequent(words []string, k int) []string {
	var tempMap = map[string]interface{}{}
	for i := 0; i < len(words); i++ {
		tempWord := words[i]
		if tempMap[tempWord] == nil {
			tempMap[tempWord] = 1
		} else {
			tempMap[tempWord] = tempMap[tempWord].(int) + 1
		}
	}
	//	var timesValue int
	var valueArr []int
	for _, value := range tempMap {
		valueArr = append(valueArr, value.(int))
	}
	sort.Ints(valueArr)
	timesValue := valueArr[len(valueArr)-k]
	var valueBigArray []int
	for j := len(valueArr) - 1; j >= 0; j-- {
		if valueArr[j] >= timesValue {
			valueBigArray = append(valueBigArray, valueArr[j])
		}
	}
	returnWord := []string{}
	var repeatTimes int
	for m := 0; m < len(valueBigArray); m++ {
		tempTimes := valueBigArray[m]
		if repeatTimes == tempTimes {
			continue
		}
		repeatTimes = tempTimes
		tempReturnWord := []string{}
		for key, value := range tempMap {
			if value.(int) == tempTimes {
				tempReturnWord = append(tempReturnWord, key)
			}
		}
		if len(tempReturnWord) > 1 {
			sort.Strings(tempReturnWord)
		}
		returnWord = append(returnWord, tempReturnWord...)
	}
	if len(valueBigArray) > k {
		returnWord = returnWord[0:k]
	}
	return returnWord
}

