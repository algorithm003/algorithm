import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Suhb
 * @date: 2019/6/19 20:23
 * @description: 49. 字母异位词分组
 */
public class LeetCode_49_035 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int length = strs.length;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < length; i++) {
            char sortArray[] = strs[i].toCharArray();
            Arrays.sort(sortArray);
            List<String> list = map.get(String.valueOf(sortArray));
            if (list == null) {
                list = new ArrayList<String>();
            }
            list.add(strs[i]);
            map.put(String.valueOf(sortArray), list);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        LeetCode_49_035 leetCode_49_035 = new LeetCode_49_035();
        String array[] = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = leetCode_49_035.groupAnagrams(array);
        System.out.println(result);
    }
}
