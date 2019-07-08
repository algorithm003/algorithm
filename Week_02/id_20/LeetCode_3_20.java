/*
 *
 *   3. 无重复字符的最长子串
 *
 *   给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 *
 *   链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 *   学号：020
 *
 * */

import java.util.HashMap;

public class LeetCode_3_20 {

    //滑动窗口，遇到重复的字符，直接跳过当前窗口
    //时间复杂度： O(n)
    //空间复杂度：O(n)
    public int lengthOfLongestSubstring(String s){
        if (s.length() == 0 ) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxCount = 0;
        for (int i = 0, j = 0; i < s.length(); i++ ){   // i ：快指针索引；  j ： 慢指针索引。
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);  //记录最后重复字符的下一个索引。
            }
            map.put(s.charAt(i),i);     //记录or更新索引
            maxCount = Math.max( maxCount, i - j + 1 );
        }
        return maxCount;
    }

}
