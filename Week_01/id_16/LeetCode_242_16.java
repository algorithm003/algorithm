import java.util.HashMap;

public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null && t != null || s != null && t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        char[] strArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(s.length());

        for (int i = 0; i < strArray.length; i ++) {
            if (map.containsKey(strArray[i])) {
                int value = map.get(strArray[i]);
                map.put(strArray[i], value + 1);
            }
            else {
                map.put(strArray[i], 1);
            }
        }

        for (int j = 0; j < tArray.length; j ++) {
            if (map.containsKey(tArray[j])) {
                int value = map.get(tArray[j]);
                if (value > 1) {
                    map.put(tArray[j], value - 1);
                }
                else {
                    map.remove(tArray[j]);
                }
            }
            else {
                return false;
            }
        }

        return (map.size() == 0);
    }
}
