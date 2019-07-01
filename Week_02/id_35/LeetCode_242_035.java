package week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @ author: Suhb
 * @ date: 2019/6/24 17:19
 * @ description: 哈希表：242. 有效的字母异位词
 */
public class LeetCode_242_035 {
    /*给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    示例 1:
    输入: s = "anagram", t = "nagaram"
    输出: true
    示例 2:
    输入: s = "rat", t = "car"
    输出: false
    说明:
    你可以假设字符串只包含小写字母。*/
    private boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        int length = s.length();
        String key;
        Integer keyValue;
        // 判断每个字节的存在次数，如果次数为零，直接从map中remove,这样只要最终存在key,说明就不是异位词了
        for (int i = 0; i < length; i++) {
            // s 字节次数 + 1
            key = String.valueOf(s.charAt(i));
            keyValue = (map.get(key) == null ? 1 : map.get(key) + 1);
            if (keyValue == 0) {
                map.remove(key);
            } else {
                map.put(key, keyValue);
            }
            // t 字节次数 - 1
            key = String.valueOf(t.charAt(i));
            keyValue = (map.get(key) == null ? -1 : map.get(key) - 1);
            if (keyValue == 0) {
                map.remove(key);
            } else {
                map.put(key, keyValue);
            }
        }
        return map.keySet().size() == 0;
    }

    public static void main(String[] args) {
        LeetCode_242_035 leetCode_242_035 = new LeetCode_242_035();
        String s = "anagram", t = "nagaram";
        boolean result = leetCode_242_035.isAnagram(s, t);
        System.out.println(result);
    }
}
