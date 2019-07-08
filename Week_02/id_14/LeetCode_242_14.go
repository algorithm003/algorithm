/*
 * @lc app=leetcode id=242 lang=golang
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (52.30%)
 * Likes:    719
 * Dislikes: 109
 * Total Accepted:    345.8K
 * Total Submissions: 660.6K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 *
 * Example 1:
 *
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 *
 */
func isAnagram(s string, t string) bool {

	if len(s) != len(t) {
		return false
	}

	var set [26]int

	for i := 0; i < len(s); i++ {
		set[int(s[i])-int('a')]++
		set[int(t[i])-int('a')]--

	}

	for _, v := range set {
		if v != 0 {
			return false
		}
	}

	return true

}
