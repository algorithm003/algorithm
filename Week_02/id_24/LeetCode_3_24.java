package week2.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the <b>longest substring</b> without
 * repeating characters.
 */
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> temp = new HashMap<>();

		// result
		int length = 0;
		int subStringStart = 0;
		for (int i = 0; i < s.length(); i++) {
			if (temp.containsKey(s.charAt(i))) {
				// move start point to next sub string
				subStringStart = Math.max(subStringStart, temp.get(s.charAt(i)) + 1);
			}
			
			temp.put(s.charAt(i), i);
			length = Math.max(length, i - subStringStart + 1);
		}
		return length;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(s.lengthOfLongestSubstring("bbbbb"));
		System.out.println(s.lengthOfLongestSubstring("pwwkew"));
		System.out.println(s.lengthOfLongestSubstring("dvdf"));
		System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
	}

}
