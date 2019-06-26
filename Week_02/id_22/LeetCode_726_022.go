//https://leetcode-cn.com/problems/number-of-atoms/
package main

import (
	"fmt"
	"strconv"
)

func recursion(formula string, index int, hashMap * map[string]int) int {
	//递归终止条件:
	// 1. 当index >= len(formula), 返回index + 1
	// 2. 当遇到')', 返回')'下一个字符的index + 1
	formulaSize := len(formula)

	if index >= formulaSize || formula[index] == ')' {
		return index + 1
	}

	//递归处理
	for ; index < formulaSize; {
		if formula[index] == '(' {
			levelMap := make(map[string]int)
			index = recursion(formula, index + 1, &levelMap)
			count := 0
			for ; index < formulaSize && formula[index] >= '0' && formula[index] <= '9'; index++ {
				count = count * 10 + int(formula[index]) - int('0')
			}

			if count > 0 {
				for key, value := range levelMap {
					levelMap[key] = value * count
				}
			}

			for key, value := range levelMap {
				(*hashMap)[key] += value
			}
		} else if formula[index] == ')' {
			return index + 1
		} else {
			key := string(formula[index])
			index = index + 1

			for ; index < formulaSize && formula[index] >= 'a' && formula[index] <= 'z'; index++ {
				key = key + string(formula[index])
			}

			count := 0
			for ; index < formulaSize && formula[index] >= '0' && formula[index] <= '9'; index++ {
				count = count * 10 + int(formula[index]) - int('0')
			}

			if count != 0 {
				(*hashMap)[key] += count
			} else {
				(*hashMap)[key] += 1
			}
		}
	}

	return index
}

func countOfAtoms(formula string) string {
	var result = ""
	index := 0
	hashMap := make(map[string]int)
	recursion(formula, index, &hashMap)

	for key, value := range hashMap {
		result += string(key)
		if value > 1 {
			result += strconv.Itoa(value)
		}
	}
	return result
}

func main() {
	formula := "K4(ON(SO3)2)2"
	result := countOfAtoms(formula)
	fmt.Println(result)
}


// 简化代码、 code redundancy

