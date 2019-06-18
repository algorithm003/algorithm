package main

import (
	"container/list"
	"fmt"
)

/**
1047. 删除字符串中的所有相邻重复项
*/

/**
栈
*/
func removeDuplicates1(S string) string {
	list := list.New()
	for _, char := range S {
		if list.Len() > 0 && list.Front().Value.(rune) == char {
			list.Remove(list.Front())
		} else {
			list.PushFront(char)
		}
	}

	var runes []rune
	for list.Back() != nil {
		runes = append(runes, list.Remove(list.Back()).(rune))
	}

	return string(runes)
}

/**
数组模拟栈
*/
func removeDuplicates2(S string) string {
	var runes []rune
	for _, char := range S {
		if len(runes) > 0 && runes[len(runes)-1] == char {
			runes = runes[:len(runes)-1]
		} else {
			runes = append(runes, char)
		}
	}
	return string(runes)
}

func removeDuplicates(S string) string {
	var stack []byte

	for i := 0; i < len(S); i++ {
		if len(stack) != 0 && stack[len(stack)-1] == S[i] {
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, S[i])
		}
	}

	return string(stack)
}

func main() {
	fmt.Println(removeDuplicates("abbaca"))
}
