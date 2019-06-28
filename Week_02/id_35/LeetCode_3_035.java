package week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @ author: Suhb
 * @ date: 2019/6/26 16:38
 * @ description: 哈希表：3. 无重复字符的最长子串
 */
public class LeetCode_3_035 {
    /*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    示例 1:
        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:
        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:
        输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/
    private int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }else if (s.length() ==  1) {
            return 1;
        }
        int length = s.length();
        int max = 0;    // 最大值
        int start = 0 ; // 最后一次重复的下标
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String key = String.valueOf(s.charAt(i));
            if (map.containsKey(key)) { // 如果当前字节在之前存在，那不重复值，就是之前重复值的下标的下一位,特别注意，因为中间有可能还会有重复值，所以，取起始点时，得取最大的起始点
                start = Math.max(start, map.get(key) + 1);
            }
            max = Math.max(max, (i - start) + 1);   // 不重复值等于当前值的下标 - 不重复值的起始点下标，自身也算，所以得 + 1
            map.put(key, i);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode_3_035 leetCode_3_035 = new LeetCode_3_035();
        String s = "abba";
        int result = leetCode_3_035.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
