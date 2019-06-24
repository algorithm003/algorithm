//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//

class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] sArray = new int[26];
        int[] tArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 97]++;
            tArray[t.charAt(i) - 97]++;
        }

        for (int i = 0; i < 26; i++)
            if (sArray[i] != tArray[i])
                return false;

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        Solution242 solution242 = new Solution242();
        solution242.isAnagram(s, t);
    }
}