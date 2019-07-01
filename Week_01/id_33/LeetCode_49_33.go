//+build ignore

package main

import (
	"fmt"
	"sort"
)

/**
49. 字母异位词分组
*/

func groupAnagrams(strs []string) [][]string {
	var result [][]string
	maps := make(map[string][]string)
	for _, s := range strs {
		runes := []rune(s)
		sort.Slice(runes, func(i, j int) bool {
			return runes[i] < runes[j]
		})
		sNew := string(runes)
		maps[sNew] = append(maps[sNew], s)
	}
	for _, v := range maps {
		result = append(result, v)
	}
	return result
}

func main() {
	fmt.Println(groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
}
