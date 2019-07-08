package algorithm.Week_02.id_50;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yu on 2019/6/29.
 * 无重复字符的最长子串
 */
public class LeetCode_3_050 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), maxSubLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0, j=0; j<n; j++){
            //如果能找到，则i跳到j+1
            if(map.containsKey(s.charAt(j)) ) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxSubLength = Math.max(maxSubLength, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return maxSubLength;
    }
}
