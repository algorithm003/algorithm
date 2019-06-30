import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return null;
        }

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(strs.length);
        for (int i = 0; i < strs.length; i ++) {
            char[] strArray = strs[i].toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            if (!map.containsKey(sortedStr)) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(sortedStr, list);
            }
            else {
                ArrayList<String> list = map.get(sortedStr);
                list.add(strs[i]);
                map.put(sortedStr, list);
            }
        }

        ArrayList<List<String>> res = new ArrayList<List<String>>(strs.length);

        for (String sortedStr : map.keySet()) {
            res.add(map.get(sortedStr));
        }

        return res;
    }
}
