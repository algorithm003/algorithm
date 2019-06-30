package week2.validAnagram;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 */
public class Solution {
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		// init an empty array with 26 zeros in side
		int[] temp = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			// minus 'a' means: get the rank in alphabetic list 
			// 'z' - 'a' is 25 means from a to z there are 25 letters
			// fill the position of s in alphabetic +1
			temp[s.charAt(i) - 'a']++;
			// if the position already be took by letter in s
			// make the value to 0
			// else to -1, if any father letters in s will take this position
			// the value will back to 0
			temp[t.charAt(i) - 'a']--;
		}
		
		// if all the value in temp back to zero, t is an anagram of s
		for(int i : temp) {
			// the value grater than 0 means letters in s not in t
			// the value less than 0 means leeters in t not in s
			if(i != 0) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.isAnagram("anagram", "nagaram"));
		System.out.println(s.isAnagram("rat", "car"));
	}

}
