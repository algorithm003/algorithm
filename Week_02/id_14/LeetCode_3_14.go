/*
 * @lc app=leetcode id=3 lang=golang
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.45%)
 * Likes:    5697
 * Dislikes: 323
 * Total Accepted:    967.2K
 * Total Submissions: 3.4M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 *
 * Example 1:
 *
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 *
 * Example 3:
 *
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 *
 *
 *
 *
 *
 */
// map
func lengthOfLongestSubstring1(s string) int {
	n, set, max := len(s), map[byte]int{}, 0
	for i, j := 0, 0; j < n; j++ {
		if index, ok := set[s[j]]; ok {
			if index > i {
				i = index
			}
		}
		if j-i+1 > max {
			max = j - i + 1
		}
		set[s[j]] = j + 1
	}
	return max
}

func lengthOfLongestSubstring(s string) int {
	set, max, i := map[rune]int{}, 0, 0
	for k, v := range s {
		if index, ok := set[v]; ok {
			if index > i {
				i = index
			}
		}
		if k-i+1 > max {
			max = k - i + 1
		}
		set[v] = k + 1
	}
	return max
}

// set
func lengthOfLongestSubstring2(s string) int {
	n, set, max, i, j := len(s), map[byte]struct{}{}, 0, 0, 0
	for i < n && j < n {
		if _, ok := set[s[j]]; !ok {
			set[s[j]], j = struct{}{}, j+1
			if j-i > max {
				max = j - i
			}
		} else {
			delete(set, s[i])
			i++
		}
	}
	return max
}

