import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: Suhb
 * @date: 2019/6/19 13:46
 * @description: 242. 判断是否字母异位词
 */
public class LeetCode_242_035 {
    /**
     * 单纯小写字母异位词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s == t) {
            return true;
        }
        int length = s.length();
        int array[] = new int[26];  // 假设字符串只包含小写字母
        for (int i = 0; i < length; i++) {
            array[s.charAt(i) - 'a']++; // 因为都是小写字母，ascii码直接从0下标开始
            array[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) {    // 如果不为0，说明两个字符串的字母出现次数不一致
                return false;
            }
        }
        return true;
    }

    /**
     * 所有字符的异位词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s == t) {
            return true;
        }
        int length = s.length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();  // 用map来存放所有字符的数量，和用数组来存放小写字母同理
        for (int i = 0; i < length; i++) {
            String key1 = s.substring(i, i+1);
            String key2 = t.substring(i, i+1);
            if (map.containsKey(key1))
                map.put(key1, map.get(key1) + 1);
            else
                map.put(key1, 1);
            if (map.containsKey(key2))
                map.put(key2, map.get(key2) - 1);
            else
                map.put(key2, -1);
            if (map.get(key1) == 0)
                map.remove(key1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 所有字符的异位词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s == t) {
            return true;
        }
        char sArray[] = s.toCharArray();
        char tArray[] = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        LeetCode_242_035 leetCode_242_035 = new LeetCode_242_035();
        boolean result = leetCode_242_035.isAnagram(s, t);
        System.out.println(result);
        s = "?anagra-m";
        t = "nagaram?-";
        result = leetCode_242_035.isAnagram2(s, t);
        System.out.println(result);
        result = leetCode_242_035.isAnagram3(s, t);
        System.out.println(result);

    }
}
