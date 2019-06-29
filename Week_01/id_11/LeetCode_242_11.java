/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 链接：https://leetcode-cn.com/problems/valid-anagram/
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 通过对26个字母的计数器来计算是否相等
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int j : counter) {
            if (j != 0)
                return false;
        }
        return true;
    }
}
/**
 * 思路：通过一个26个字母的计数器，s存在一个字母+1，t存在对应的字母-1，该计数器都为0说明两个字符串是字母异位词
 */