//+build ignores

package main

/**
3. 无重复字符的最长子串
*/

/**
通过map记录出现过的字符位置
设置两变量，一个存储当前最大长度，一个存储不重复起点
当重复且不在重复起点前，设置新重复起点
*/
func lengthOfLongestSubstring(s string) int {
	maps := make(map[rune]int)
	count, index := 0, 0
	for k, v := range s {
		kOld, ok := maps[v]
		if ok && kOld >= index {
			index = kOld + 1
		}
		countTemp := k - index + 1
		if countTemp > count {
			count = countTemp
		}
		maps[v] = k
	}
	return count
}

func main() {
	fmt.Println(lengthOfLongestSubstring("dvdf"))
	fmt.Println(lengthOfLongestSubstring("abcabcbb"))
	fmt.Println(lengthOfLongestSubstring("  "))
}
