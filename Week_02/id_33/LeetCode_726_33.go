//+build ignored

package main

import (
	"fmt"
	"sort"
	"strconv"
)

/**
726. 原子的数量
*/
// ( 40, ) 41, 0-9 48-57, A-Z 65-90, a-z 97-122
// 从右边开始，遇到数字缓存数字
// 遇到)添加倍数列表，同时清空缓存数字
// 遇到(减少倍数列表
// 遇到小写缓存字符
// 遇到大写输出个数，同时清空缓存字符、缓存数字
func countOfAtoms(formula string) string {
	// 输出maps
	var maps = make(map[string]int)
	// 倍数列表
	var multiple []int
	// 缓存字符，缓存数字
	str, count := "", ""
	for i := len(formula) - 1; i >= 0; i-- {
		char := formula[i]
		if char >= 48 && char <= 57 {
			count = string(char) + count
		} else {
			if char == 41 {
				atoi, _ := strconv.Atoi(count)
				if len(multiple) > 0 {
					atoi = atoi * multiple[len(multiple)-1]
				}
				multiple = append(multiple, atoi)
				count = ""
			} else if char == 40 {
				multiple = multiple[:len(multiple)-1]
			} else if char >= 97 && char <= 122 {
				str = string(char) + str
			} else if char >= 65 && char <= 90 {
				str = string(char) + str
				nums := 1
				if count == "" {
					count = "1"
				}
				atoi, _ := strconv.Atoi(count)
				if len(multiple) > 0 {
					nums = multiple[len(multiple)-1] * atoi
				} else {
					nums = atoi
				}
				maps[str] += nums
				str = ""
				count = ""
			}
		}
	}
	// 按字母排序并输出
	result := ""
	var keys []string
	for k := range maps {
		keys = append(keys, k)
	}
	sort.Strings(keys)
	for _, k := range keys {
		v := maps[k]
		result += k
		if v != 1 {
			result += strconv.Itoa(v)
		}
	}
	return result
}

func main() {
	//fmt.Println(countOfAtoms("Be32"))
	fmt.Println(countOfAtoms("K4(ON(SO3)2)2"))
}
