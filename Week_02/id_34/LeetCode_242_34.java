import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jinjw
 * @date 2019/6/27
 * @description 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 */
public class LeetCode_242_34 {
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char h : s.toCharArray()) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        for (char h : t.toCharArray()) {
            Integer count = map.get(h);
            if (count == null || count == 0) {
                return false;
            } else if (count > 1) {
                map.put(h, count - 1);
            } else {
                map.remove(h);
            }
        }
        return map.isEmpty();
    }

    public static boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return String.valueOf(sChar).equals(String.valueOf(tChar));
    }
}
