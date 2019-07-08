//+build ignore

package main

import (
	"fmt"
	"strings"
)

/**
1021. 删除最外层的括号
*/

func removeOuterParentheses(S string) string {
	sb := strings.Builder{}
	index := 0
	// 碰见( +1， 碰见 ) -1，
	for i := 0; i < len(S); i++ {
		if S[i] == '(' {
			if index > 0 {
				sb.WriteByte(S[i])
			}
			index++
		}
		if S[i] == ')' {
			if index > 1 {
				sb.WriteByte(S[i])
			}
			index--
		}
	}
	return sb.String()
}

func main() {
	fmt.Println(removeOuterParentheses("(()())(())"))
}
